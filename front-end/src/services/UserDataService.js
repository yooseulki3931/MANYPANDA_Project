// UserDataService.js
/* eslint-disable */
// 목적 : Emp 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";
import authHeader from "./auth-header";

class UserDataService {
  // 모든 유저정보 조회 요청 함수
  getAll(userId, page, size) {
    return http.get(`/user?userId=${userId}&page=${page}&size=${size}`);
  }
  // ----- 내가 쓴글 조회 요청 함수
  // 자유게시판
  getWrote(nick) {
    return http.get(`/user/wrote/${nick}`);
  }
  // 모임게시판
  getMbWrote(nick) {
    return http.get(`/user/wrote/mb/${nick}`);
  }
  // 추천게시판
  getBbWrote(nick) {
    return http.get(`/user/wrote/bb/${nick}`);
  }
  // 분실게시판
  getLbWrote(nick) {
    return http.get(`/user/wrote/lb/${nick}`);
  }

  // 찜목록
  getWishList(id) {
    return http.get(`/user/wishlist/${id}`);
  }

  // 자유게시판 좋아요 
  getGoodFbList(id) {
    return http.get(`/user/goodfb/${id}`);
  }

  // 모임게시판 좋아요
  getGoodMbList(username) {
    console.log("좋아요get성공");
    return http.get(`/user/goodmb/${username}`);
  }

  // 추천게시판 좋아요
  getGoodBbList(username) {
    console.log("BB좋아요get성공");
    return http.get(`/user/goodbb/${username}`);
  }

  // 분실게시판 좋아요
  getGoodLbList(username) {
    console.log("분실 좋아요get성공");
    return http.get(`/user/goodlb/${username}`);
  }

  // id 로 조회
  get(id) {
    return http.get(`/user/${id}`);
  }

  // 유저정보 생성(insert) 요청 함수
  create(data) {
    return http.post("/user", data);
  }

  // 유저정보 수정(update) 요청 함수
  update(id, changePwd, user) {
    console.log("a");
    console.log(user);
    let userData = {
      username: user.username,
      email: user.email,
      password: user.password,
      address: user.address,
      nick: user.nick,
      role: [user.roles[0].name],
      changePwd: changePwd,
    };

    console.log(userData);
    console.log(changePwd);
    return http.put(`/user/${id}`, userData, { headers: authHeader() });
  }

  // 유저정보 삭제(delete) 요청 함수
  delete(id) {
    return http.delete(`/user/deletion/${id}`, { headers: authHeader() });
  }

  // 유저정보 전체 삭제 요청 함수
  deleteAll() {
    return http.delete("/user/all");
  }

  // 유저아이디 검색 요청 함수
  findByUsername(username) {
    return http.get(`/user?username=${username}`);
  }

  // 판매내역
  findGoodsByUsername(nick) {
    return http.get(`user/sold/${nick}`);
  }

  // 회원가입중복체크
  checkEmailDuplicate(email) {
    console.log("emaileeeee", email);
    return http.get(`/user/exists/${email}`);
  }
  checkNickDuplicate(nick) {
    return http.get(`/user/exists3/${nick}`);
  }
  checkUsernameDuplicate(username) {
    return http.get(`/user/exists2/${username}`);
  }
}

export default new UserDataService();
