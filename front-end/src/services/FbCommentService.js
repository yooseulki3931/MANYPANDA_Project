import http from "../http-common";

class FbCommentService {
  /* eslint-disable */

  // 댓글 조회 함수 
  getAll(fno) {
    return http.get(`/fbcomment/${fno}`);
  }

  // 댓글 등록 함수
  create(data) {
      console.log(data);
      return http.post("/fbcomment", data);
  }
  
  // 댓글 삭제 함수
  delete(commentId) {
      return http.delete(`/fbcomment/deletion/${commentId}`);
  }

}

export default new FbCommentService();
