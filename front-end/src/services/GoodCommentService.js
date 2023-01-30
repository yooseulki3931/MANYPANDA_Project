import http from "../http-common";

class GoodCommentService {
  /* eslint-disable */
  
  // 댓글 조회 함수
  getAll(goodsId) {
    return http.get(`/goodcomment/${goodsId}`);
  }

  // 댓글 등록 함수
  create(data) {
      console.log(data);
      return http.post("/goodcomment", data);
  }
 
  // 댓글 삭제 함수
  delete(commentId) {
      return http.delete(`/goodcomment/deletion/${commentId}`);
  }

}

export default new GoodCommentService();
