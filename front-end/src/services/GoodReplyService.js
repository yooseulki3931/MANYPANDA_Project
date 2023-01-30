import http from "../http-common";

class GoodReplyService {
  /* eslint-disable */
  
  // 대댓글 조회 함수
  getAll(goodsId) {
    return http.get(`/goodreply/${goodsId}`);
  }

  // 대댓글 등록 함수
  create(data) {
      console.log(data);
      return http.post("/goodreply", data);
  }

  // 대댓글 삭제 함수                    
  delete(replyId) {
      return http.delete(`/goodreply/deletion/${replyId}`);
  }

}

export default new GoodReplyService();
