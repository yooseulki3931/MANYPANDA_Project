// FbService.js
// 목적 : Fb 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";

class FbService {
  // 전체 조회 (페이징)
  getAll(fb_ctitle, fb_title, page, size) {
    return http.get(
      `/fb?fb_ctitle=${fb_ctitle}&fb_title=${fb_title}&page=${page}&size=${size}`,
      {}
    );
  }
  
  // 조회수 best 5
  getFbBoardBest() {
    return http.get(`/fb/best`);
  }

  // 댓글수 best 5 
  getFbBoardRcntBest() {
    return http.get(`/fb/rcnt`);
  }

   // 최신순 5
   getFbDesc() {
    return http.get(`/fb/desc`);
  }

  // 상세페이지 조회
  getDetailAll() {
    return http.get(`/fb/all`);
  }

  // 게시번호로 조회
  get(fno) {
    return http.get(`/fb/${fno}`);
  }

  // 게시글 생성
  create(nick, fbCategory, fbTitle, fbContent, fbTag, blobFile, onUploadProgress) {
    let formData = new FormData();

    console.log(nick);
    console.log(fbCategory);
    console.log(fbTitle);
    console.log(fbContent);
    console.log(fbTag);

    console.log(blobFile);
    
    formData.append("nick", nick);
    formData.append("fbCategory", fbCategory);
    formData.append("fbTitle", fbTitle);
    formData.append("fbContent", fbContent);
    formData.append("fbTag", fbTag);
    formData.append("blobFile", blobFile);

    return http.post("/fb", formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
      onUploadProgress
    });
  }
  
  // 수정
  update(
    fno,
    nick,  
    fbCategory,
    fbTitle,
    fbContent,
    fbTag,
    fbCnt,
    blobFile,
    onUploadProgress
  ) {
    let formData = new FormData();

    console.log(fno);
    console.log(nick);
    console.log(fbCategory);
    console.log(fbTitle);
    console.log(fbContent);
    console.log(fbTag);
    console.log(fbCnt);

    console.log(blobFile);

    formData.append("fno", fno);
    formData.append("nick", nick);
    formData.append("fbCategory", fbCategory);
    formData.append("fbTitle", fbTitle);
    formData.append("fbContent", fbContent);
    formData.append("fbTag", fbTag);
    formData.append("fbCnt", fbCnt);
    formData.append("blobFile", blobFile);

    return http.put(`/fb/${fno}`, formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
      onUploadProgress,
    });
  }

  // 삭제
  delete(fno) {
    return http.delete(`/fb/deletion/${fno}`);
  }
}

export default new FbService();
