import http from "../http-common";

class MbReplyService {
  /* eslint-disable */

  // 대댓글 조회 함수 
  getAll(mno) {
    return http.get(`/mbreply/${mno}`);
  }

  // 대댓글 등록 함수
  create(data) {
      console.log(data);
      return http.post("/mbreply", data);
  }

  // 대댓글 삭제 함수
  delete(replyId) {
      return http.delete(`/mbreply/deletion/${replyId}`);
  }

}

export default new MbReplyService();
