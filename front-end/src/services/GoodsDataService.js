import http from "../http-common";

class GoodsDataService {
  /* eslint-disable */

  // 전체조회(검색기능 포함)
  getAll(category, title, page, size) {
    return http.get(
      `/goods?category=${category}&title=${title}&page=${page}&size=${size}`,
      {}
    );
  }
  
  // Carousel 조회
  getCarousel(title, page, size) {
    return http.get(
      `/goods/carousel?title=${title}&page=${page}&size=${size}`,
      {}
    );
  }
  
   // 메인페이지 목록 조회
  getMain(title, page, size) {
    return http.get(`/goods/main?title=${title}&page=${page}&size=${size}`, {});
  }

  // 상품 상세 조회
  get(goodsId) {
    return http.get(`/goods/detail/${goodsId}`);
  }

  // 가계부 한달
  getaccount(sellerId) {
    return http.get(`/goods/account1/${sellerId}`);
  }

  // 가계부 3달
  getaccount3(sellerId) {
    return http.get(`/goods/account3/${sellerId}`);
  }

  // 가계부 6달
  getaccount6(sellerId) {
    return http.get(`/goods/account6/${sellerId}`);
  }

  // 상품정보 생성(insert) 요청 함수
  create(data) {
    console.log(data);
    return http.post("/goods", data);
  }

  // 상품정보 수정(update) 요청 함수
  update(goodsId, data) {
    return http.put(`/goods/${goodsId}`, data);
  }

  // 상품정보 삭제(delete) 요청 함수
  delete(goodsId) {
    return http.delete(`/goods/deletion/${goodsId}`);
  }

}

export default new GoodsDataService();
