import http from "../http-common";

class MbCommentService {
  /* eslint-disable */

  // 댓글 조회 함수 
  getAll(mno) {
    return http.get(`/mbcomment/${mno}`);
  }

  // 댓글 등록 함수
  create(data) {
      console.log(data);
      return http.post("/mbcomment", data);
  }

 // 댓글 삭제 함수
  delete(commentId) {
      return http.delete(`/mbcomment/deletion/${commentId}`);
  }

}

export default new MbCommentService();
