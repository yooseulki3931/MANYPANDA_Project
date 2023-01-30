import http from "../http-common";

class LbReplyService {
  /* eslint-disable */
  
  // 대댓글 조회 함수
  getAll(lno) {
    return http.get(`/lbreply/${lno}`);
  }

  // 대댓글 등록 함수
  create(data) {
      console.log(data);
      return http.post("/lbreply", data);
  }

  // 대댓글 삭제 함수
  delete(replyId) {
      return http.delete(`/lbreply/deletion/${replyId}`);
  }

}

export default new LbReplyService();
