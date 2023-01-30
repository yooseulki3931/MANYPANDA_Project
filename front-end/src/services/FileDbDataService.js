// FileDbDataService.js
import http from "../http-common";

class FileDbDataService {
    /* eslint-disable */

    // 모든 이미지 정보 가져오기
    getFiles() {
        return http.get(`/fileDb`)
    }

    // 함수명   : upload() 함수 ( DB 저장 함수 )
    // 매개변수 title : 제목
    //          content : 내용
    //          fileDb : 업로드 대상 이미지
    // 이미지 등록
    upload(fileDb) {
        // json 객체 사용하지 않음 (x)
        // form 태그로 전송하는 방식을 이용함
        // html <form></form> == js FormData 객체로 사용가능
        //                       .append("속성명", 값) 함수 : 데이터를 저장
        // axios 함수 : .post()
        // 헤더 : "Content-Type" : "multipart/form-data" 
        let formData = new FormData(); // 폼(form) 객체 생성

        formData.append("fileDb", fileDb);

        return http.post("/fileDb/upload", formData, {
            headers: {
                "Content-Type" : "multipart/form-data"
            }
        })
    }
    
    // 이미지 수정
    update(fid, fileDb) {
        // json 객체 사용하지 않음 (x)
        // form 태그로 전송하는 방식을 이용함
        // html <form></form> == js FormData 객체로 사용가능
        //                       .append("속성명", 값) 함수 : 데이터를 저장
        // axios 함수 : .post()
        // 헤더 : "Content-Type" : "multipart/form-data" 
        let formData = new FormData(); // 폼(form) 객체 생성

        formData.append("fid", fid);
        formData.append("fileDb", fileDb);

        return http.post(`/fileDb/update/${fid}`, formData, {
            headers: {
                "Content-Type" : "multipart/form-data"
            }
        })
    }

    // 아이디fid)로 이미지 조회
    get(fid) {
        return http.get(`/fileDb/${fid}`);
    }
    
    // 이미지 삭제 요청 함수
    delete(fid) {
        return http.delete(`/fileDb/deletion/${fid}`);
    }

}

export default new FileDbDataService();