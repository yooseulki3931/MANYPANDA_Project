<template>
  <div class=joinUs>
    <div class="container">
      <div class="input-form col-md-12 mx-auto" style="margin-bottom:150px;">
        <form class="validation-form" name="form" @submit.prevent="handleRegister">
          <div v-if="!successful">

            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="name">이름</label>
                <input type="text" class="form-control" id="name" placeholder="" value="" required>
                <div class="invalid-feedback" style="font-size:12px;">
                  이름을 입력해주세요.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="nickname">닉네임</label>
                <input v-model="user.nick" type="text" class="form-control" id="nickname" @blur="checkNickDup"
                  :style="myStylen" placeholder="" value="" required>
                <div v-if="submitted && errors.has('nickname')" class="alert-danger">{{ errors.first('nickname') }}
                </div>
                <div class="invalid-feedback" style="font-size:12px;">
                  닉네임을 입력해주세요.
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="id">아이디</label>
                <input v-model="user.username" v-validate="'required|min:3|max:20'" @blur="checkUsernameDup"
                  :style="myStyleu" name="username" type="text" class="form-control" id="id" placeholder="" value=""
                  required>
                <div class="invalid-feedback" style="font-size:12px;">
                  <div v-if="submitted && errors.has('username')" class="alert-danger">{{ errors.first('username') }}
                  </div>
                  아이디를 입력해주세요.
                </div>
              </div>

              <div class="col-md-6 mb-3">
                <label for="password">비밀번호</label>
                <input v-model="user.password" v-validate="'required|min:6|max:40'" name="password" type="password"
                  style="font-size:12px; height: 40px;;" class="form-control" id="password" placeholder="대문자,숫자,특수문자 조합"
                  value="" required @blur="passwordValid" :style="myStyle">
                <div class="invalid-feedback" style="font-size:12px;">
                  <div v-if="submitted && errors.has('password')" class="alert-danger">{{ errors.first('password') }}
                  </div>
                  <div v-if="!passwordValidFlag"></div>
                  비밀번호를 입력해주세요.
                </div>
              </div>
            </div>

            <div class="mb-3">
              <label for="email">이메일</label>
              <input v-model="user.email" v-validate="'required|email|max:50'" @blur="checkEmailDup" :style="myStylee"
                name="email" type="email" class="form-control" id="emailId" placeholder="manypanda@manypanda.com"
                style="font-size:12px;" required>
              <div class="invalid-feedback" style="font-size:12px;">
                이메일을 입력해주세요.
              </div>
            </div>

            <div class="mb-3">
              <label for="address">주소</label>
              <select class="search" name="count" data-title="선택"
                style="width: 20%; font-size: 12px; margin: 10px; background-color: white; height: 30px; border-radius: 5px; border-color: gray;"
                required v-model="user.address">
                <option value="중구">중구</option>
                <option value="서구">서구</option>
                <option value="동구">동구</option>
                <option value="영도구">영도구</option>
                <option value="부산진구">부산진구</option>
                <option value="동래구">동래구</option>
                <option value="남구">남구</option>
                <option value="북구">북구</option>
                <option value="해운대구">해운대구</option>
                <option value="사하구">사하구</option>
                <option value="금정구">금정구</option>
                <option value="강서구">강서구</option>
                <option value="연제구">연제구</option>
                <option value="수영구">수영구</option>
                <option value="사상구">사상구</option>
                <option value="기장군">기장군</option>
              </select>
              <div v-if="submitted && errors.has('address')" class="alert-danger">{{ errors.first('address') }}</div>
              <div class="invalid-feedback" style="font-size:12px;">
                주소를 입력해주세요.
              </div>
            </div>

            <div class="mb-3">
              <label for="address2">상세주소<span class="text-muted">&nbsp;(필수 아님)</span></label>
              <input type="text" class="form-control" id="address2" placeholder="상세주소를 입력해주세요." style="font-size:12px;">
            </div>

            <hr class="mb-4">
            <div class="custom-control custom-checkbox">
              <input type="checkbox" class="custom-control-input" id="aggrement" required>
              <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
            </div>
            <div class="mb-4"></div>
            <button class="btn btn-dark btn-lg btn-block" type="submit" style="font-size:12px">가입 완료</button>

          </div>
          <footer class="my-3 text-center text-small">
            <p class="mb-1">&copy; 2023 MANYPANDA</p>
          </footer>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
/* eslint-disable */
import UserDataService from "../../services/UserDataService";
import User from '../../models/user';
export default {
  name: 'daumMap',
  data() {
    return {
      image: '',

      zip: '',
      addr1: '',
      addr2: '',
      myStyle: {
        border: ""
      },
      myStylen: {
        border: ""
      },
      myStyleu: {
        border: ""
      },
      myStylee: {
        border: ""
      },
      
      user: new User('', '', ''),
      submitted: false,
      successful: false,
      message: '',
      passwordCheck: '',
      passwordCheckFlag: true,
      passwordValidFlag: true,
      checkEmail: false,
      checkNick: false,
      checkUsername: false,
    }

  },

  computed: {
    // 공유저장소에서 로그인 상태 정보 리턴
    // 로그인 중 : loggedIn = true
    // 로그인 아님 : loggedIn = false
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  mounted() {

    // loggedIn == true : 로그인 상태 -> /profile 페이지로 강제 이동
    if (this.loggedIn) {
      this.$router.push('/myPage');
    }
  },

  // 감시
  watch: {
    'password': function () {
      this.checkPassword()
    },
  },


  methods: {
    uploadImg() {
      console.log('들어왔다')
      var image = this.$refs['image'].files[0]

      const url = URL.createObjectURL(image)
      this.image = url
      console.log(url)
      console.log(this.image)
    },
    showApi() {
      new window.daum.Postcode({
        oncomplete: (data) => {
          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

          // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
          // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
          let fullRoadAddr = data.roadAddress; // 도로명 주소 변수
          let extraRoadAddr = ''; // 도로명 조합형 주소 변수

          // 법정동명이 있을 경우 추가한다. (법정리는 제외)
          // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
          if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
            extraRoadAddr += data.bname;
          }
          // 건물명이 있고, 공동주택일 경우 추가한다.
          if (data.buildingName !== '' && data.apartment === 'Y') {
            extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
          }
          // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
          if (extraRoadAddr !== '') {
            extraRoadAddr = ' (' + extraRoadAddr + ')';
          }
          // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
          if (fullRoadAddr !== '') {
            fullRoadAddr += extraRoadAddr;
          }

          // 우편번호와 주소 정보를 해당 필드에 넣는다.
          this.zip = data.zonecode; //5자리 새우편번호 사용
          this.addr1 = fullRoadAddr;
        }
      }).embed(this.$refs.embed)
    },

    handleRegister() {
      this.message = '';
      this.submitted = true;
      // form 유효성 체크 검사 
      // this.$validator.validate() : 유효하면 isValid = true , 아니면 isValid = false
      this.$validator.validate()
        .then(isValid => {
          if (isValid && this.passwordCheckFlag && this.passwordValidFlag) {
            //  공유 저장소의 새사용자 등록 함수 실행
            this.$store.dispatch('auth/register', this.user)
              .then(response => {
                this.message = response.message;
                alert("회원가입에 성공했습니다.");
                location.href = '/login';
                this.successful = true;
              }
              )
              .catch(error => {
                this.message =
                  (error.response && error.response.data && error.response.data.message) ||
                  error.message ||
                  error.toString();
                this.successful = false;
              })
          }
        });
    },

    // 비밀번호 유효성 체크

    passwordValid() {
      if (/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,16}$/.test(this.user.password)) {
        this.passwordValidFlag = true
        this.myStyle.border = "";
      } else {
        this.passwordValidFlag = false
        this.myStyle.border = "solid red";

      }
    },
    passwordCheckValid() {
      if (this.user.password === this.passwordCheck) {
        this.passwordCheckFlag = true
      } else {
        this.passwordCheckFlag = false
      }
    },

    checkEmailDup() {
      console.log(this.user.email)
      console.log("aaa")
      UserDataService.checkEmailDuplicate(this.user.email)
        .then((response) => {
          this.checkEmail = response.data;
          if (this.checkEmail == true) {
            alert("이미 존재하는 이메일주소입니다.");
            this.myStylee.border = "solid red";
          } else {
            this.myStylee.border = "";
          }
          console.log("checkEmailDuplicate", response.data);

        })
        .catch((e) => {
          console.log(e);
        })
    },

    checkUsernameDup() {
      console.log(this.user.username)
      console.log("bbb")
      UserDataService.checkUsernameDuplicate(this.user.username)
        .then((response) => {
          this.checkUsername = response.data;
          if (this.checkUsername == true) {
            alert("이미 존재하는 아이디입니다.");

            this.myStyleu.border = "solid red";
          } else {
            this.myStyleu.border = "";

          }

          console.log("checkUsernameDuplicate", response.data);
        })
        .catch((e) => {
          console.log(e);
        })
    },

    checkNickDup() {
      console.log(this.user.nick)
      console.log("ccc")
      UserDataService.checkNickDuplicate(this.user.nick)
        .then((response) => {
          this.checkNick = response.data;
          if (this.checkNick == true) {
            alert("이미 존재하는 닉네임입니다.");
            this.myStylen.border = "solid red";
          } else {
            this.myStylen.border = "";
          }

          console.log("checkNickDuplicate", response.data);
        })
        .catch((e) => {
          console.log(e);
        })
    },


  }
}
</script>

<style>
.joinUs {
  margin-top: 350px;
}

body {
  min-height: 100vh;
}

.input-form {
  max-width: 680px;

  margin-top: 80px;
  padding: 32px;

  background: #fff;
  -webkit-border-radius: 10px;
  -moz-border-radius: 10px;
  border-radius: 10px;
  -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
  -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
  box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
}
</style>