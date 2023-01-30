import http from "../http-common";

class BbReplyService {
  /* eslint-disable */

  // 대댓글 조회 함수 
  getAll(bno) {
    return http.get(`/bbreply/${bno}`);
  }

  // 대댓글 등록 함수
  create(data) {
      console.log(data);
      return http.post("/bbreply", data);
  }
  
  // 대댓글 삭제 함수
  delete(replyId) {
    return http.delete(`/bbreply/deletion/${replyId}`);
  }

}

export default new BbReplyService();
