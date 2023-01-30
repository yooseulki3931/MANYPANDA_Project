// MbService.js
// 목적 : Mb 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";

class MbService {
  // 전체 조회 (페이징)
  getAll(mb_ctitle, mb_title, page, size) {
    return http.get(
      `/mb?mb_ctitle=${mb_ctitle}&mb_title=${mb_title}&page=${page}&size=${size}`,
      {}
    );
  }
  
  // 조회수 best 5
  getMbBoardBest() {
    return http.get(`/mb/best`);
  }

  // 댓글수 best 5 
  getMbBoardRcntBest() {
    return http.get(`/mb/rcnt`);
  }

   // 최신순 5
   getMbDesc() {
    return http.get(`/mb/desc`);
  }

  // 상세페이지 조회
  getDetailAll() {
    return http.get(`/mb/all`);
  }

  // 게시번호로 조회
  get(mno) {
    return http.get(`/mb/${mno}`);
  }

  // 게시글 생성
  create(nick, mbCategory, mbTitle, mbContent, mbTag, blobFile, onUploadProgress) {
    let formData = new FormData();

    console.log(nick);
    console.log(mbCategory);
    console.log(mbTitle);
    console.log(mbContent);
    console.log(mbTag);

    console.log(blobFile);
    
    formData.append("nick", nick);
    formData.append("mbCategory", mbCategory);
    formData.append("mbTitle", mbTitle);
    formData.append("mbContent", mbContent);
    formData.append("mbTag", mbTag);
    formData.append("blobFile", blobFile);

    return http.post("/mb", formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
      onUploadProgress
    });
  }
  
  // 수정
  update(
    mno,
    nick,  
    mbCategory,
    mbTitle,
    mbContent,
    mbTag,
    mbCnt,
    blobFile,
    onUploadProgress
  ) {
    let formData = new FormData();

    console.log(mno);
    console.log(nick);
    console.log(mbCategory);
    console.log(mbTitle);
    console.log(mbContent);
    console.log(mbTag);
    console.log(mbCnt);

    console.log(blobFile);

    formData.append("mno", mno);
    formData.append("nick", nick);
    formData.append("mbCategory", mbCategory);
    formData.append("mbTitle", mbTitle);
    formData.append("mbContent", mbContent);
    formData.append("mbTag", mbTag);
    formData.append("mbCnt", mbCnt);
    formData.append("blobFile", blobFile);

    return http.put(`/mb/${mno}`, formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
      onUploadProgress,
    });
  }

  // 삭제
  delete(mno) {
    return http.delete(`/mb/deletion/${mno}`);
  }
}

export default new MbService();
