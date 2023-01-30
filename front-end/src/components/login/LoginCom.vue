<template>
  <div class="loginForm">

    <div class="loginMenu">
      <div class="vue-tempalte">
        <form name="form" @submit.prevent="handleLogin">


          <h3>LOGIN</h3>
          <div class="form-group">

            <!-- 아이디  -->
            <label>Id </label>
            <input v-model="user.username" v-validate="'required'" type="text" class="form-control form-control-lg"
              name="username" id="loginId" placeholder="아이디를 입력하세요."
              style="width:400px; text-align:center; display:block; margin: 0  auto; font-size:12px; margin-bottom:20px" />
            <div v-if="errors.has('username')" class="alert alert-danger" role="alert">
              Username is required!
            </div>
          </div>

          <!-- 패스워드 -->
          <div class="form-group">
            <label>Password</label>
            <input v-model="user.password" v-validate="'required'" type="password" class="form-control form-control-lg"
              name="password" id="passwordId" placeholder="비밀번호를 입력하세요"
              style="width:400px; text-align:center; display:block; margin: 0 auto; font-size:12px;" />
            <div v-if="errors.has('password')" class="alert alert-danger" role="alert">
              Password is required!
            </div>
          </div>

          <!-- 체크박스 -->
          <div class="form-check">
            <label class="form-check-label" for="flexCheckChecked" style="font-size:12px;">
              <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>로그인 상태 유지
            </label>
            <label style="font-size:12px;"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                fill="currentColor" class="bi bi-lock" viewBox="0 0 16 16">
                <path
                  d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2zM5 8h6a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V9a1 1 0 0 1 1-1z" />
              </svg> 보안접속</label>
          </div>
          <button type="submit" class="loginButton" style=" margin-bottom: 20px; font-size:12px;">로그인</button>
          <div class="form-group">
            <div v-if="message" class="alert alert-danger" role="alert">
              {{ message }}
            </div>
          </div>
          <p class="forgot-password text-right mt-2 mb-4" style="text-align:center; display:block; margin: 0 auto;">
            <router-link to="/forgot-password">Forgot password ?</router-link>
          </p>
          <div class="social-icons" style="margin:20px 0;">
            <ul>
              <h4>SNS LOGIN</h4>
              
              <li><a href="http://localhost:8000/oauth2/authorization/naver" role="button"><img
                    src="@/assets/image/icon/naver.png" style="width:100%"></a></li>
              <li><a href="http://localhost:8000/oauth2/authorization/kakao" role="button"><img
                    src="@/assets/image/icon/kakao.png"></a></li>
              <li><a href="http://localhost:8000/oauth2/authorization/google" role="button"><img
                    src="@/assets/image/icon/google.png"></a></li>
            </ul>
          </div>
          <br>
          <br>
          <br>
          <label class="form-check-label" for="flexCheckChecked" style="font-size:12px;">
            아직도 회원이 아니세요?<br>
            회원이 되어 마니판다에서 혜택을 즐겨보세요<br>
          </label>

          <p><a href="/joinUs"><button class="joinButton" style=" margin-bottom: 100px; font-size:12px;">회원가입</button>
            </a></p>
        </form>
      </div>
    </div>

  </div>
</template>

<script>
import User from "../../models/user";

export default {

  data() {
    return {
      user: new User("", ""),
      loading: false,
      message: "",
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  created() {
    if (this.loggedIn) {
      this.$router.push("/myPage");
    }
  },
  methods: {
    handleLogin() {
      this.loading = true;
      // vee-balidator 실행
      this.$validator.validateAll().then((isValid) => {
        // 유효성 체크가 유효하지 않으면 그냥 리턴
        if (!isValid) {
          this.loading = false;
          return;
        }

        // 유저이름과 패스워드가 모두 있으면 공유함수 실행
        if (this.user.username && this.user.password) {
          this.$store
            .dispatch("auth/login", this.user)
            .then(() => {
              this.$router.push("/myPage");
            })
            .catch((error) => {
              this.loading = false;
              this.message =
                (error.response &&
                  error.response.data &&
                  error.response.data.message) ||
                error.message ||
                error.toString();
            });
        }
      });
    },
  },

}
</script>

<style>
.loginMenu {
    margin-top: 350px;
}

.inner-block {
  width: 450px;
  margin: auto;
  background: #ffffff;
  box-shadow: 0px 14px 80px rgba(34, 35, 58, 0.2);
  padding: 40px 55px 45px 55px;
  border-radius: 15px;
  transition: all .3s;
}
.vertical-center .form-control:focus {
  /* border-color: #2554FF; */
  box-shadow: none;
}
.vertical-center h3 {
  text-align: center;
  margin: 0;
  line-height: 1;
  padding-bottom: 20px;
}
label {
  font-weight: 500;
}
.forgot-password,
.forgot-password a {
  text-align: right;
  font-size: 13px;
  padding-top: 10px;
  color: #7a7a7a;
  margin: 0;
}

.social-icons ul li {
  display: inline-block;
  zoom: 1;
  width: 65px;
  vertical-align: middle;
  /* border: 1px solid #e3e8f9; */
  font-size: 15px;
  height: 40px;
  line-height: 40px;
  margin-right: 5px;
  /* background: #f4f6ff; */
}
.social-icons ul li a {
  display: block;
  /* font-size: 1.4em; */
  margin: 0 5px;
  text-decoration: none;
}
.social-icons ul li a i {
  -webkit-transition: all 0.2s ease-in;
  -moz-transition: all 0.2s ease-in;
  -o-transition: all 0.2s ease-in;
  -ms-transition: all 0.2s ease-in;
  transition: all 0.2s ease-in;
}
.social-icons ul li a:focus i,
.social-icons ul li a:active i {
  transition: none;
  color: #222222;
}
.joinButton {
  height: 30px;
  border-radius: 5px;
  background-color: black;
  color: aliceblue;
  margin: 5px 0;
  width: 150px;
}
.loginButton{
    height: 30px;
  border-radius: 5px;
  background-color: black;
  color: aliceblue;
  margin: 5px 0;
  width: 150px;
}
.loginForm{
  margin: auto;
  display:block;
  text-align: center;  
}
</style>