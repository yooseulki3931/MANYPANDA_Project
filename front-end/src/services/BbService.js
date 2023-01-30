// BbService.js
// 목적 : b 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";

class BbService {
  // 전체 조회 (페이징)
  getAll(bb_ctitle, bb_title, page, size) {
    return http.get(
      `/bb?bb_ctitle=${bb_ctitle}&bb_title=${bb_title}&page=${page}&size=${size}`,
      {}
    );
  }
  
  // 조회수 best 5
  getBbBoardBest() {
    return http.get(`/bb/best`);
  }

  // 댓글수 best 5 
  getBbBoardRcntBest() {
    return http.get(`/bb/rcnt`);
  }

   // 최신순 5
   getBbDesc() {
    return http.get(`/bb/desc`);
  }

  // 상세페이지 조회
  getDetailAll() {
    return http.get(`/bb/all`);
  }

  // 게시번호로 조회
  get(bno) {
    return http.get(`/bb/${bno}`);
  }

  // 게시글 생성
  create(nick, bbCategory, bbTitle, bbContent, bbTag, blobFile, onUploadProgress) {
    let formData = new FormData();

    console.log(nick);
    console.log(bbCategory);
    console.log(bbTitle);
    console.log(bbContent);
    console.log(bbTag);

    console.log(blobFile);
    
    formData.append("nick", nick);
    formData.append("bbCategory", bbCategory);
    formData.append("bbTitle", bbTitle);
    formData.append("bbContent", bbContent);
    formData.append("bbTag", bbTag);
    formData.append("blobFile", blobFile);

    return http.post("/bb", formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
      onUploadProgress
    });
  }
  
  // 수정
  update(
    bno,
    nick,  
    bbCategory,
    bbTitle,
    bbContent,
    bbTag,
    bbCnt,
    blobFile,
    onUploadProgress
  ) {
    let formData = new FormData();

    console.log(bno);
    console.log(nick);
    console.log(bbCategory);
    console.log(bbTitle);
    console.log(bbContent);
    console.log(bbTag);
    console.log(bbCnt);

    console.log(blobFile);

    formData.append("bno", bno);
    formData.append("nick", nick);
    formData.append("bbCategory", bbCategory);
    formData.append("bbTitle", bbTitle);
    formData.append("bbContent", bbContent);
    formData.append("bbTag", bbTag);
    formData.append("bbCnt", bbCnt);
    formData.append("blobFile", blobFile);

    return http.put(`/bb/${bno}`, formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
      onUploadProgress,
    });
  }

  // 삭제
  delete(bno) {
    return http.delete(`/bb/deletion/${bno}`);
  }
}

export default new BbService();
