export default function authHeader() {
  // localStorage 의 user 정보를(json 형태 문자열) 객체로 변환  
  let user = JSON.parse(localStorage.getItem('user'));

  // 유저 객체가 있다면 http 헤더에 아래 정보 저장
  // { Authorization: 'Bearer ' + user.accessToken }
  if (user && user.accessToken) {
    return { Authorization: 'Bearer ' + user.accessToken }; // for Spring Boot back-end
    // return { 'x-access-token': user.accessToken };       // for Node.js Express back-end
  } else {
    return {};
  }
}
