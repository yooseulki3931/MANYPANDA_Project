// 유저  클래스 정의
export default class User {
  constructor(username, email, password, nick, address, mobileNumber) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.nick = nick;
    this.address = address;
    this.mobileNumber = mobileNumber;
  }
}
