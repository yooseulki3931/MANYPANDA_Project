<template>
  <div class="myPage">
    <!-- 프로필 디테일 시작 -->
    <div class="row goods_wrapper" style="margin-bottom:100px">
      <div class="col-md-6 col-sm-12 col-xs-12 goods_thumbs_wrap">
        <div class="_carousel_count_numbering carousel-count-numbering" style="display: none;"></div>
        <div class="goods_thumbs" id="prod_image_list">
          <div class="holder">
            <div class="owl-carousel prod-owl-list owl-theme owl-loaded">
              <div class="owl-stage-outer">
                <div class="owl-stage"
                  style="transform: translate3d(0px, 0px, 0px); transition: all 0s ease 0s; width: 500px;">
                  <div class="owl-item active" style="width: 200px; margin-right: 0px;">
                    <div class="item _item"><img style="width: 200px; height: 200px; margin-left: 600px;"
                        src="../../assets/image/profile2.jpeg" alt=""></div>
                  </div>
                  <div style=" text-align: center;">
                    <a href="">
                      <button @click="updateprofile" class="w-btn w-btn-gray" type="button"
                        style="font-size: 12px; display: inline-block; margin-left: 600px; width: 200px;">프로필 사진
                        수정</button></a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-6 col-sm-12 col-xs-12  myPageMember">
        <div class="pageMember" id="memberForm">
          <div class="storySection">
            <div class="storyView" style="text-align: left; font-size: 14px;  ">
              <h4>
                <p>MANYPANDA MEMBERSHIP</p>
              </h4>
              <br>
              <tr>
                <th scope="col" style="text-align: ; width: 80px; margin-left: 10px; ">
                  ID :
                </th>
                <td scope="col" style="text-align: ;  margin-left: 10px; ">
                  {{ currentUser.username }}
                </td>
              </tr>
              <br>
              <tr>
                <th scope="col" style="text-align: ; width: 80px; margin-left: 10px; ">
                  Place :
                </th>
                <td scope="col" style="text-align: ;  margin-left: 10px; ">
                  {{ currentUser.address }}
                </td>
              </tr>
              <br>
              <tr>
                <th scope="col" style="text-align: ; width: 80px; margin-left: 10px; ">
                  NickName :
                </th>
                <td scope="col" style="text-align: ;  margin-left: 10px; ">
                  {{ currentUser.nick }}
                </td>
              </tr>
              <br>
              <br>
              <p><a href="/memberEdit"><button class="w-btn w-btn-gray" type="button">회원정보수정</button></a></p>
            </div>
          </div>
          <div>
          </div>
        </div>
      </div>
    </div>
    <!-- 프로필 디테일 끝 -->

    <!-- 탭메뉴 시작 -->
    <div class="d-flex align-items-start">
      <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
        <button
          style="color:black; font-size:14px; width: 100px; height: 40px; margin-left: 300px; margin-bottom: 60px;"
          class="nav-link active" id="v-pills-home-tab" data-bs-toggle="pill" data-bs-target="#v-pills-sale"
          type="button" role="tab" aria-controls="v-pills-" aria-selected="true">판매내역</button><br>
        <button
          style="color:black; font-size:14px; width: 100px; height: 40px; margin-left: 300px; margin-bottom: 60px;"
          class="nav-link" id="v-pills-home-tab" data-bs-toggle="pill" data-bs-target="#v-pills-myWrite" type="button"
          role="tab" aria-controls="v-pills-myWrite" aria-selected="false">내가쓴글</button><br>
        <button
          style="color:black; font-size:14px; width: 100px; height: 40px; margin-left: 300px; margin-bottom: 60px;"
          class="nav-link" id="v-pills-messages-tab" data-bs-toggle="pill" data-bs-target="#v-pills-cart" type="button"
          role="tab" aria-controls="v-pills-cart" aria-selected="false">찜</button><br>
        <button
          style="color:black; font-size:14px; width: 100px; height: 40px; margin-left: 300px; margin-bottom: 60px;"
          class="nav-link" id="v-pills-messages-tab" data-bs-toggle="pill" data-bs-target="#v-pills-like" type="button"
          role="tab" aria-controls="v-pills-like" aria-selected="false">좋아요(♥)</button><br>
        <button
          style="color:black; font-size:14px; width: 100px; height: 40px; margin-left: 300px; margin-bottom: 60px;"
          class="nav-link" id="v-pills-profile-tab" data-bs-toggle="pill" data-bs-target="#v-pills-diary" type="button"
          role="tab" aria-controls="v-pills-profile" aria-selected="false">다이어리</button><br>
        <button
          style="color:black; font-size:14px; width: 100px; height: 40px; margin-left: 300px; margin-bottom: 60px;"
          class="nav-link" id="v-pills-messages-tab" data-bs-toggle="pill" data-bs-target="#v-pills-toDo" type="button"
          role="tab" aria-controls="v-pills-messages" aria-selected="false">To do</button><br>
        <button
          style="color:black; font-size:14px; width: 100px; height: 40px; margin-left: 300px; margin-bottom: 60px;"
          class="nav-link" id="v-pills-settings-tab" data-bs-toggle="pill" data-bs-target="#v-pills-account"
          type="button" role="tab" aria-controls="v-pills-settings" aria-selected="false">가계부</button>
      </div>

      <div class="tab-content" id="v-pills-tabContent">
        <div class="tab-pane fade show active" id="v-pills-sale" role="tabpanel" aria-labelledby="v-pills-home-tab">
          <MyPageSold :soldProps="userNick"></MyPageSold>
        </div>
        <div class="tab-pane fade" id="v-pills-myWrite" role="tabpanel" aria-labelledby="v-pills-home-tab">
          <MyPageWrote :wroteProps="userNick"></MyPageWrote>
        </div>
        <div class="tab-pane fade" id="v-pills-cart" role="tabpanel" aria-labelledby="v-pills-messages-tab">
          <MyPageCart :idProps="userId"></MyPageCart>
        </div>
        <div class="tab-pane fade" id="v-pills-like" role="tabpanel" aria-labelledby="v-pills-messages-tab">
          <MyPageLike :likeProps="userId"></MyPageLike>
        </div>
        <div class="tab-pane fade" id="v-pills-tag" role="tabpanel" aria-labelledby="v-pills-settings-tab">태그 리스트
        </div>
        <div class="tab-pane fade" id="v-pills-diary" role="tabpanel" aria-labelledby="v-pills-profile-tab">
          <MyPageDiary :idProps="userId"></MyPageDiary>
        </div>
        <div class="tab-pane fade" id="v-pills-toDo" role="tabpanel" aria-labelledby="v-pills-messages-tab">
          <MyPageTodo :idProps="userId"></MyPageTodo>
        </div>
        <div class="tab-pane fade" id="v-pills-account" role="tabpanel" aria-labelledby="v-pills-settings-tab">
          <MyPageAccount :AccountProps="userNick"></MyPageAccount>
        </div>
      </div>
    </div>
    <!-- 탭메뉴 끝 -->

    <div class="menuBottom container" style="margin-bottom:100px; margin-top:100px; margin: auto;">
      <div class="row align-items-center" style="font-size:14px;  ">
        <div class="col">
          <button class="bottomButton"
            style="text-decoration:none; height: 30px; margin-bottom:50px; margin-left: 100px; margin-top:50px; font-size:12px;">
            <a href="/logOut">
              <font color="black">로그아웃</font>
            </a>
          </button>
        </div>
        <div class="col">
          <button class="bottomButton"
            style="text-decoration:none; height: 30px; margin-bottom:50px; margin-left: 100px; margin-top:50px; font-size:12px;">
            <a href="#">
              <font color="black">개인정보처리방침</font>
            </a>
          </button>
        </div>
        <div class="col">
          <button class="bottomButton"
            style="text-decoration:none; height: 30px; margin-bottom:50px; margin-left: 100px; margin-top:50px; font-size:12px;">
            <a href="#">
              <font color="black">이용약관</font>
            </a>
          </button>
        </div>
        <div class="col">
          <button class="bottomButton" @click="deleteUser"
            style="text-decoration:none; height: 30px; margin-bottom:50px; margin-left: 100px; margin-top:50px; font-size:12px;">
            <a href="#">
              <font color="black">회원탈퇴</font>
            </a>
          </button>
        </div>
      </div>

    </div>
  </div>
</template>


<script>
/* eslint-disable */
import MyPageDiary from "../diary/DiaryList.vue";
import MyPageSold from "../sold/SoldCom.vue";
import MyPageTodo from "../todo/NToDoList.vue";
import MyPageAccount from "../Account/AccountBook.vue";
import MyPageWrote from "../wrote/WroteCom.vue";
import MyPageLike from "../like/LikeCom.vue";
import MyPageCart from "../mycart/CartCom.vue";
import UserDataService from "../../services/UserDataService";
import ProfileService from "@/services/ProfileService";
/* eslint-disable */
export default {


  data() {
    return {
      userId: this.$store.state.auth.user.id,
      username: this.$store.state.auth.user.username,
      userNick: this.$store.state.auth.user.nick,
      imageUrl: null,
      profile: null,
      message: "",

    };
  },
  components: {
    MyPageDiary, // 다이어리
    MyPageSold, // 판매목록
    MyPageTodo, // 투두리스트
    MyPageAccount, // 가계부
    MyPageWrote, // 내가 쓴 글
    MyPageLike, // 좋아요 목록
    MyPageCart, // 찜 목록
  },

  methods: {
    // 유저 탈퇴
    deleteUser() {
      UserDataService.delete(this.$store.state.auth.user.id)
        .then((response) => {
          console.log(response.data);
          console.log("aaa");
          alert("정상적으로 탈퇴되었습니다.");
          location.href = '/login';
          this.$store.dispatch("auth/logout");
          this.$router.push("/login");
          this.message = "성공적으로 회원탈퇴되었습니다.";
        })
        .catch((e) => {
          console.log(e);
        });
    },
    // 프로필 수정
    updateprofile() {
      alert("준비중입니다.");
    }
  },

  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    }
  },
  mounted() {
    if (!this.currentUser) {
      this.$router.push('/login');
    }
  }

};
</script>

<style>
.myPage {
  margin-top: 350px;
}

.tab-pane {
  color: black;
  font-size: 14px;
  height: 800px;
  width: 1100px;
}

.w-btn-gray {
  background-color: #a3a1a1;
  color: #e3dede;

}

.w-btn {
  border: none;
  border-radius: 5px;
  box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
  text-decoration: none;
  transition: 0.25s;
}

.w-btn-outline {
  border-radius: 5px;
  box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
  text-decoration: none;
  transition: 0.25s;
}

.bottomButton {
  background-color: #dbdbdb;
  color: #e3dede;
  border: none;
  border-radius: 5px;
}
</style>