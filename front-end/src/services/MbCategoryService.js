// MbCategoryService.js
// 목적 : MbCategory 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";

class MbCategoryService {

  // 카테고리 전체조회
  getAll() {
    return http.get(`/mbCategory/all`);
  }
  
   // 카테고리 목록 - 검색 - 페이징 조회
  getAllPage(searchKeyword, page, size) {
    console.log(searchKeyword)
    console.log(page)
    console.log(size)
    return http.get(`/mbCategory?searchKeyword=${searchKeyword}&page=${page}&size=${size}`);
  }
  
  // 카테고리 등록
  create(data) {
    return http.post("/mbCategory", data)
  }

  // 카테고리 아이디(mbCid)로 삭제
  delete(mbCid) {
    return http.delete(`/mbCategory/${mbCid}`);
  }
}

export default new MbCategoryService();