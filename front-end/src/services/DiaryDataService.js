// DiaryDataService.js
// 목적 : Diary 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
// import http from "../services/DiaryDataService";
import http from "../http-common";

class DiaryDataService {

    // 마이페이지 다이어리 id 로 리스트 조회
    getAll(id) {
        return http.get(`/diary/all/${id}`); 
    }

   // 마이페이지 다이어리 번호(dno) 로 조회
    get(dno) {
        return http.get(`/diary/${dno}`)
    }

    // 마이페이지 다이어리 등록
    create(data) {
        console.log(data);
        return http.post("/diary", data);
    }

    // 마이페이지 다이어리 번호(dno) 로 수정
    update(dno, data) {
        alert("성공적으로 수정되었습니다.");
        return http.put(`/diary/${dno}`, data);
    }

    // 마이페이지 다이어리 번호(dno) 로 삭제
    delete(dno) {
        alert("성공적으로 삭제되었습니다.");
        return http.delete(`/diary/deletion/${dno}`);
    }

    // 마이페이지 다이어리 전체 삭제
    deleteAll() {
        return http.delete("/diary/all")
    }


}

export default new DiaryDataService();