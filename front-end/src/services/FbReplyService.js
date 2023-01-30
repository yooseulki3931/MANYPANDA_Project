import http from "../http-common";

class FbReplyService {
  /* eslint-disable */
  
  // 대댓글 조회 함수
  getAll(fno) {
    return http.get(`/fbreply/${fno}`);
  }

  // 대댓글 등록 함수
  create(data) {
      console.log(data);
      return http.post("/fbreply", data);
  }

  // 대댓글 삭제 함수
  delete(replyId) {
      return http.delete(`/fbreply/deletion/${replyId}`);
  }

}

export default new FbReplyService();
