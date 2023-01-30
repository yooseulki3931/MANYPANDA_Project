import http from "../http-common";

class BbCommentService {
  /* eslint-disable */

  // 댓글 조회 함수 
  getAll(bno) {
    return http.get(`/bbcomment/${bno}`);
  }

  // 댓글 등록 함수
  create(data) {
      console.log(data);
      return http.post("/bbcomment", data);
  }
  
  // 댓글 삭제 함수
  delete(commentId) {
    return http.delete(`/bbcomment/deletion/${commentId}`);
}

}

export default new BbCommentService();
