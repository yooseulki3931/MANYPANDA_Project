// import axios from 'axios';
import http from '../http-common'
import authHeader from './auth-header';

// const API_URL = 'http://localhost:8080/api/test/';

class UserService {
  getPublicContent() {
    // return axios.get(API_URL + 'all');
    return http.get('/test/all');
  }

  getUserBoard() {
    // axios.get(url, 헤더정보)
    // 헤더정보 : 토큰과 함께 요청
    // return axios.get(API_URL + 'user', { headers: authHeader() });
    return http.get('/test/user', { headers: authHeader() });
  }

  // getModeratorBoard() {
  //   return axios.get(API_URL + 'mod', { headers: authHeader() });
  // }

  getAdminBoard() {
    // axios.get(url, 헤더정보)
    // 헤더정보 : 토큰과 함께 요청
    // return axios.get(API_URL + 'admin', { headers: authHeader() });
    return http.get('/test/admin', { headers: authHeader() });
  }
}

export default new UserService();
