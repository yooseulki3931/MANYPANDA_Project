// FileDbDataService.js
import http from "../http-common";

class ProfileService {
    /* eslint-disable */

    // 프로필 등록
    upload(userId, fileDb) {
        // json 객체 사용하지 않음 (x)
        // form 태그로 전송하는 방식을 이용함
        // html <form></form> == js FormData 객체로 사용가능
        //                       .append("속성명", 값) 함수 : 데이터를 저장
        // axios 함수 : .post()
        // 헤더 : "Content-Type" : "multipart/form-data" 
        let formData = new FormData(); // 폼(form) 객체 생성

        formData.append("userId", userId);
        formData.append("profile", fileDb);

        return http.post("/profile/upload", formData, {
            headers: {
                "Content-Type" : "multipart/form-data"
            }
        })
    }
    
    // 프로필 수정
    update(pid, userId, fileDb) {
        // json 객체 사용하지 않음 (x)
        // form 태그로 전송하는 방식을 이용함
        // html <form></form> == js FormData 객체로 사용가능
        //                       .append("속성명", 값) 함수 : 데이터를 저장
        // axios 함수 : .post()
        // 헤더 : "Content-Type" : "multipart/form-data" 
        let formData = new FormData(); // 폼(form) 객체 생성

        formData.append("pid", pid);
        formData.append("userId", userId);
        formData.append("fileDb", fileDb);

        return http.post(`/profile/update/${pid}`, formData, {
            headers: {
                "Content-Type" : "multipart/form-data"
            }
        })
    }

    // 프로필 조회
    getFiles() {
        return http.get(`/profile`)
    }
    
    // 프로필 이미지포함 삭제 요청 함수
    delete(pid) {
        return http.delete(`/profile/deletion/${pid}`);
    }

}

export default new ProfileService();