
/* eslint-disable */
import http from "../http-common";

class MbLikeService {
 
  // 좋아요 조회
  getLike(mno, userId) {
    return http.get(`/mblike/${mno}/${userId}`);
  }

  // 좋아요 카운트
  countLike(mno) {
    return http.get(`/mblike/${mno}`);
  }
  
  // 좋아요 등록
  create(data) {
    console.log(data);
    return http.post('/mblike', data);
  }
  
  // 좋아요 삭제
  delete(mno) {
    return http.delete(`/mblike/deletion/${mno}`);
}


}

export default new MbLikeService();
