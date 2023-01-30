// LbService.js
// 목적 : Lb 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";

class LbService {
  // 전체 조회 (페이징)
  getAll(lb_ctitle, lb_title, page, size) {
    return http.get(
      `/lb?lb_ctitle=${lb_ctitle}&lb_title=${lb_title}&page=${page}&size=${size}`,
      {}
    );
  }
  
  // 조회수 best 5
  getLbBoardBest() {
    return http.get(`/lb/best`);
  }

  // 댓글수 best 5 
  getLbBoardRcntBest() {
    return http.get(`/lb/rcnt`);
  }

   // 최신순 5
   getLbDesc() {
    return http.get(`/lb/desc`);
  }

  // 상세페이지 조회
  getDetailAll() {
    return http.get(`/lb/all`);
  }

  // 게시번호로 조회
  get(lno) {
    return http.get(`/lb/${lno}`);
  }

  // 게시글 생성
  create(nick, lbCategory, lbTitle, lbContent, lbTag, blobFile, onUploadProgress) {
    let formData = new FormData();

    console.log(nick);
    console.log(lbCategory);
    console.log(lbTitle);
    console.log(lbContent);
    console.log(lbTag);

    console.log(blobFile);
    
    formData.append("nick", nick);
    formData.append("lbCategory", lbCategory);
    formData.append("lbTitle", lbTitle);
    formData.append("lbContent", lbContent);
    formData.append("lbTag", lbTag);
    formData.append("blobFile", blobFile);

    return http.post("/lb", formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
      onUploadProgress
    });
  }
  
  // 수정
  update(
    lno,
    nick,  
    lbCategory,
    lbTitle,
    lbContent,
    lbTag,
    lbCnt,
    blobFile,
    onUploadProgress
  ) {
    let formData = new FormData();

    console.log(lno);
    console.log(nick);
    console.log(lbCategory);
    console.log(lbTitle);
    console.log(lbContent);
    console.log(lbTag);
    console.log(lbCnt);

    console.log(blobFile);

    formData.append("lno", lno);
    formData.append("nick", nick);
    formData.append("lbCategory", lbCategory);
    formData.append("lbTitle", lbTitle);
    formData.append("lbContent", lbContent);
    formData.append("lbTag", lbTag);
    formData.append("lbCnt", lbCnt);
    formData.append("blobFile", blobFile);

    return http.put(`/lb/${lno}`, formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
      onUploadProgress,
    });
  }

  // 삭제
  delete(lno) {
    return http.delete(`/lb/deletion/${lno}`);
  }
}

export default new LbService();
