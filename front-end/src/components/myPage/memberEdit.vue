<template>
  <div class="joinUs">
    <div class="container" v-if="currentUser">
      <div class="input-form-backgroud row">
        <div class="input-form col-md-12 mx-auto" style="margin-bottom:150px;">
          <h4 class="mb-3">회원정보 수정</h4>
          <div class="validation-form" novalidate>
            <div v-if="!successful">

            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="nickname" style="font-size:12px;">닉네임</label>
                <input type="text" v-model="currentUser.nick" class="form-control" id="nickname" placeholder="" value=""
                  required>
                <div class="invalid-feedback" style="font-size:12px;">
                  변경할 닉네임을 입력해주세요.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="password" style="font-size:12px;">비밀번호</label>
                <input type="password" v-model="currentUser.password" :disabled="!changePwd" class="form-control"
                  id="password" placeholder="" value="" required>
                <div class="invalid-feedback" style="font-size:12px;">
                  변경할 비밀번호를 입력해주세요.
                </div>
                <button class="mt-3 btn btn-warning btn-sm" @click="changePassword" style="font-size:12px; margin: auto; text-align: center;">패스워드 변경</button>
              </div>
            </div>

            <div class="mb-3">
              <label for="place" style="font-size:12px;">위치설정</label>
              <select class="search" name="count" data-title="선택"
                style="width: 40%; font-size: 12px; margin: 10px; background-color: white; height: 30px; border-radius: 5px; border-color: gray;" required
                v-model="currentUser.address">
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

            </div>

            <div class="mb-3">
              <label for="address2" style="font-size:12px;">상세주소<span class="text-muted">&nbsp;(필수 아님)</span></label>
              <input type="text" class="form-control" id="address2" placeholder="상세주소를 입력해주세요." style="font-size:12px;">
            </div>


            <hr class="mb-4">
            <div class="custom-control custom-checkbox">
              <input type="checkbox" class="custom-control-input" id="aggrement" required>
              <label class="custom-control-label" for="aggrement" style="font-size:12px;">개인정보 수집 및 이용에 동의합니다.</label>
            </div>
            <div class="mb-4"></div>
            <button class="btn btn-dark btn-lg btn-block" type="submit" style="font-size:12px"
              @click="updateUser(currentUser.id, changePwd, currentUser)">정보 변경 완료</button>
            </div>
            <footer class="my-3 text-center text-small">
              <p class="mb-1" style="font-size:12px;">&copy; 2022 DAPANDA</p>
            </footer>
          </div>
        </div>
      </div>

    </div>
  </div>
</template>

<script>
import UserDataService from "../../services/UserDataService";
import joinUs from "@/assets/script/joinUs"
export default {
  name: 'daumMap',
  data() {
    return {
      currentUser: null,
      changePwd: false,
      message: '',
    }
  },
  methods: {
    // 유저 조회
    getUser(id) {
      UserDataService.get(id) // spring 요청
        //  성공/실패 모르겠지만
        //  성공하면 then안에 있는것이 실행
        .then((response) => {
          this.currentUser = response.data;
          console.log(response.data);
        })
        //  실패하면 catch안에 있는것이 실행
        .catch((e) => {
          console.log(e);
        });
    },

    // 유저 정보 수정
    updateUser(id, changePwd, user) {
      this.message = "";
      this.submitted = true;
      // form 유효성 체크 검사
      // this.$validator.validate() : 유효하면 isValid = true , 아니면 isValid = false
      this.$validator.validate().then((isValid) => {
        if (isValid) {
          // user 값 초기화
          // this.user = new User("", "", "", this.role);
          //  공유 저장소의 새사용자 등록 함수 실행
          UserDataService.update(id, changePwd, user)
            .then((response) => {
              console.log(response.data);
              alert("회원정보수정 완료 다시 로그인해주세요.");
              location.href='/login';
              this.$store.dispatch("auth/logout");
              this.$router.push("/login");
              this.message = "The User was updated successfully!";
            })
            .catch((e) => {
              console.log(e);
            });
        }
      });
    },
    
    // 비밀번호 변경
    changePassword() {
      this.currentUser.password = "";
      this.changePwd = true;
    },
    

  },


  mounted() {
    joinUs();
    this.getUser(this.$store.state.auth.user.id);
    console.log(this.currentUser);
  },
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