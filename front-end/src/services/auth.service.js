// import axios from 'axios';
import http from '../http-common'

// const API_URL = 'http://localhost:8080/api/auth/';

class AuthService {

  login(user) {

    // user 객체의 정보를 임시 객체에 저장
    let userData = {
      username: user.username,
      password: user.password,
      address: user.address,
      nick: user.nick,
      mobileNumber: user.mobileNumber
    }

    return http
      // .post(API_URL + 'signin', userData)
      .post('/auth/signin', userData)
      .then(response => {
        if (response.data.accessToken) {
          // 서버에서 날려준 정보중에 JWT 이 있으면
          // 객체 데이터를 문자열로 바꾸어서 localStorage 저장
          localStorage.setItem('user', JSON.stringify(response.data));
        }

        return response.data;
      });
  }

  logout() {
    // localStorage 값을 삭제
    localStorage.removeItem('user');
  }

  register(user) {

    let userData = {
      username: user.username,
      email: user.email,
      password: user.password,
      nick: user.nick,
      address: user.address,
      mobileNumber: user.mobileNumber
    }

    // return axios.post(API_URL + 'signup', userData);
    return http.post('/auth/signup', userData);
  }
}

export default new AuthService();
