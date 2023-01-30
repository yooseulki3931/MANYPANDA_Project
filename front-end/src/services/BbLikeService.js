
/* eslint-disable */
import http from "../http-common";

class BbLikeService {
 
  // 좋아요 조회
  getLike(bno, userId) {
    return http.get(`/bblike/${bno}/${userId}`);
  }

  // 좋아요 카운트
  countLike(bno) {
    return http.get(`/bblike/${bno}`);
  }

  // 좋아요 등록
  create(data) {
    console.log(data);
    return http.post('/bblike', data);
  }
  
  // 좋아요 삭제
  delete(bno) {
    return http.delete(`/bblike/deletion/${bno}`);
}

}

export default new BbLikeService();
