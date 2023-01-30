// LbCategoryService.js
// 목적 : LbCategory 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";

class LbCategoryService {

  // 카테고리 전체조회
  getAll() {
    return http.get(`/lbCategory/all`);
  }
  
   // 카테고리 목록 - 검색 - 페이징 조회
  getAllPage(searchKeyword, page, size) {
    console.log(searchKeyword)
    console.log(page)
    console.log(size)
    return http.get(`/lbCategory?searchKeyword=${searchKeyword}&page=${page}&size=${size}`);
  }
  
  // 카테고리 등록
  create(data) {
    return http.post("/lbCategory", data)
  }

  // 카테고리 아이디(lbCid)로 삭제
  delete(lbCid) {
    return http.delete(`/lbCategory/${lbCid}`);
  }
}

export default new LbCategoryService();