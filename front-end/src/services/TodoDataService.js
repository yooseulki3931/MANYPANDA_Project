// TodoDataService.js
// 목적 : Todo 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
// import http from "../services/TodoDataService";
import http from "../http-common";

class TodoDataService {

    // id 로 TODOLIST 목록 조회 함수
    getAll(id) {
        return http.get(`/todo/all/${id}`); 
    }
    
    // 번호(tno)로 TODOLIST 조회 함수
    get(tno) {
        return http.get(`/todo/${tno}`)
    }
    
    // TODOLIST 등록 함수
    create(data) {
        console.log(data);
        return http.post("/todo", data);
    }
   
     // 번호(tno)로 TODOLIST 수정 함수
    update(tno, data) {
        alert("성공적으로 수정되었습니다.");
        return http.put(`/todo/${tno}`, data);
    }
    
     // 번호(tno)로 TODOLIST 삭제 함수
    delete(tno) {
        return http.delete(`/todo/deletion/${tno}`);
    }
    
    // 전체 삭제 함수
    deleteAll() {
        return http.delete("/todo/all")
    }

}

export default new TodoDataService();