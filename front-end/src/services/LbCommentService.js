import http from "../http-common";

class LbCommentService {
  /* eslint-disable */
  
  // 댓글 조회 함수 
  getAll(lno) {
    return http.get(`/lbcomment/${lno}`);
  }

  // 댓글 등록 함수
  create(data) {
      console.log(data);
      return http.post("/lbcomment", data);
  }

   // 댓글 삭제 함수      
  delete(commentId) {
      return http.delete(`/lbcomment/deletion/${commentId}`);
  }

}

export default new LbCommentService();
