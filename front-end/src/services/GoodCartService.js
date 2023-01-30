// FbDataService.js
// 목적 : Fb 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";

class FbLikeService {
 
  // 좋아요 상세페이지 - 유저아이디로 조회 함수
  getCart(goodsId, userId) {
    return http.get(`/goodcart/${goodsId}/${userId}`);
  }
  
  // 좋아요 cartId 로 삭제 함수
  delete(cartId) {
    return http.delete(`/goodcart/deletion/${cartId}`);
  }

  // 좋아요 클릭 함수
  create(data) {
    console.log(data);
    return http.post('/goodcart', data);
  }

}

export default new FbLikeService();
