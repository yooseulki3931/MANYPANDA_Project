<template>
  <div class="col-10">
    <div class="sold_back">
      <h4 id="sold_sale_logo">🤍 My like list 🤍</h4>

      <!-- 자유게시판 -->
      <div class="col-5" id="wrote_fb">
        <p id="wrote_title">자유 게시판</p>
        <table class="table table-borderless" id="wrote_table">
          <thead>
            <tr id="cart_tr">
              <th scope="col" colspan="3">제목</th>
              <th scope="col">작성자</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody v-for="(data, index) in goods" :key="index" id="sold_tbody">
            <tr id="cart_tr">
              <td colspan="3" id="cart_td">
                <router-link :to="'/fb/' + data.fno">
                  {{ data.fbTitle }}
                </router-link>
              </td>
              <td id="cart_td">{{ data.nick }}</td>
              <button style="border: none; width: 16px;" @click="deleteLikeFb(goods[index].fno)" id="cart_delete">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-lg"
                  viewBox="0 0 16 16">
                  <path
                    d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z" />
                </svg>
              </button>
            </tr>
          </tbody>
        </table>
      </div>

      <!-- 추천게시판 -->
      <div class="col-5" id="wrote_fb">
        <p id="wrote_title">추천 게시판</p>
        <table class="table table-borderless" id="wrote_table">
          <thead>
            <tr id="cart_tr">
              <th scope="col" colspan="3">제목</th>
              <th scope="col">작성자</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody v-for="(data, index) in bb" :key="index" id="sold_tbody">
            <tr id="cart_tr">
              <td colspan="3" id="cart_td">
                <router-link :to="'/bb/' + data.bno">
                  {{ data.bbTitle }}
                </router-link>
              </td>
              <td id="cart_td">{{ data.nick }}</td>
              <button style="border: none; width: 16px;" @click="deleteLikeBb(bb[index].bno)" id="cart_delete">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-lg"
                  viewBox="0 0 16 16">
                  <path
                    d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z" />
                </svg>
              </button>
            </tr>
          </tbody>
        </table>
      </div>

      <!-- 모임게시판 -->
      <div class="col-5" id="wrote_fb">
        <p id="wrote_title">모임 게시판</p>
        <table class="table table-borderless" id="wrote_table">
          <thead>
            <tr id="cart_tr">
              <th scope="col" colspan="3">제목</th>
              <th scope="col">작성자</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody v-for="(data, index) in mb" :key="index" id="sold_tbody">
            <tr id="cart_tr">
              <td colspan="3" id="cart_td">
                <router-link :to="'/mb/' + data.mno">
                  {{ data.mbTitle }}
                </router-link>
              </td>
              <td id="cart_td">{{ data.nick }}</td>
              <button style="border: none; width: 16px;" @click="deleteLikeMb(mb[index].mno)" id="cart_delete">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-lg"
                  viewBox="0 0 16 16">
                  <path
                    d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z" />
                </svg>
              </button>
            </tr>
          </tbody>
        </table>
      </div>

      <!-- 분실게시판 -->
      <div class="col-5" id="wrote_fb">
        <p id="wrote_title">분실/신고 게시판</p>
        <table class="table table-borderless" id="wrote_table">
          <thead>
            <tr id="cart_tr">
              <th scope="col" colspan="3">제목</th>
              <th scope="col">작성자</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody v-for="(data, index) in lb" :key="index" id="sold_tbody">
            <tr id="cart_tr">
              <td colspan="3" id="cart_td">
                <router-link :to="'/lb/' + data.lno">
                  {{ data.lbTitle }}
                </router-link>
              </td>
              <td id="cart_td">{{ data.nick }}</td>
              <button style="border: none; width: 16px;" @click="deleteLikeLb(lb[index].lno)" id="cart_delete">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-lg"
                  viewBox="0 0 16 16">
                  <path
                    d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z" />
                </svg>
              </button>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
/* eslint-disable */
import UserDataService from "../../services/UserDataService";
import FbService from "../../services/FbService";
import BbService from "../../services/BbService";
import MbService from "../../services/MbService";
import LbService from "../../services/LbService";
import FbLikeService from "@/services/FbLikeService";
import MbLikeService from "@/services/MbLikeService";
import LbLikeService from "@/services/LbLikeService";
import BbLikeService from "@/services/BbLikeService";

export default {
  props: ["likeProps"],
  data() {
    return {
      goods: [],
      mb: [],
      bb: [],
      lb: [],
      currentUser: null,
      id: this.likeProps,
      deletefbid: null,
      deletelbid: null,
      deletembid: null,
      deletebbid: null,

    };
  },
  methods: {
    deleteLikeFb(num) {
      FbLikeService.getLike(num, this.$store.state.auth.user.id)
        .then((response) => {
          this.deletefbid = response.data.fbLikeId;
          FbLikeService.delete(this.deletefbid)
            .then((response) => {
              console.log(response.data);
              alert("좋아요가 취소되었습니다.")
              location.href = `/myPage`
            })
            .catch((e) => {
              console.log(e);
            })

        })
        .catch((e) => {
          console.log(e);
        });

      this.getLike();
      this.retrieveFb();
      this.retrieveMb();
      this.retrieveBb();
      this.retrieveLb();
    },
    deleteLikeMb(num) {
      MbLikeService.getLike(num, this.$store.state.auth.user.id)
        .then((response) => {
          this.deletembid = response.data.mbLikeId;
          MbLikeService.delete(this.deletembid)
            .then((response) => {
              console.log(response.data);
              alert("좋아요가 취소되었습니다.")
              location.href = `/myPage`
            })
            .catch((e) => {
              console.log(e);
            })

        })
        .catch((e) => {
          console.log(e);
        });

      this.getLike();
      this.retrieveFb();
      this.retrieveMb();
      this.retrieveBb();
      this.retrieveLb();
    },
    deleteLikeLb(num) {
      LbLikeService.getLike(num, this.$store.state.auth.user.id)
        .then((response) => {
          this.deletelbid = response.data.lbLikeId;
          LbLikeService.delete(this.deletelbid)
            .then((response) => {
              console.log(response.data);
              alert("좋아요가 취소되었습니다.")
              location.href = `/myPage`
            })
            .catch((e) => {
              console.log(e);
            })

        })
        .catch((e) => {
          console.log(e);
        });

      this.getLike();
      this.retrieveFb();
      this.retrieveMb();
      this.retrieveBb();
      this.retrieveLb();
    },
    deleteLikeBb(num) {
      BbLikeService.getLike(num, this.$store.state.auth.user.id)
        .then((response) => {
          this.deletebbid = response.data.bbLikeId;
          BbLikeService.delete(this.deletebbid)
            .then((response) => {
              console.log(response.data);
              alert("좋아요가 취소되었습니다.")
              location.href = `/myPage`
            })
            .catch((e) => {
              console.log(e);
            })

        })
        .catch((e) => {
          console.log(e);
        });

      this.getLike();
      this.retrieveFb();
      this.retrieveMb();
      this.retrieveBb();
      this.retrieveLb();
    },

    getLike() {
      UserDataService.getGoodFbList(this.id) // spring 요청
        //  성공/실패 모르겠지만/l
        //  성공하면 then안에 있는것이 실행
        .then((response) => {
          console.log("fb성공");
          this.goods = response.data;
          console.log(response.data);
        })
        //  실패하면 catch안에 있는것이 실행
        .catch((e) => {
          console.log("fb실패");
          console.log(e);
        });
      UserDataService.getGoodLbList(this.id) // spring 요청
        //  성공/실패 모르겠지만/l
        //  성공하면 then안에 있는것이 실행
        .then((response1) => {
          this.lb = response1.data;
          console.log(response1.data);
        })
        //  실패하면 catch안에 있는것이 실행
        .catch((e) => {
          console.log(e);
        });
      UserDataService.getGoodMbList(this.id) // spring 요청
        //  성공/실패 모르겠지만/l
        //  성공하면 then안에 있는것이 실행
        .then((response2) => {
          this.mb = response2.data;
          console.log(response2.data);
        })
        //  실패하면 catch안에 있는것이 실행
        .catch((e) => {
          console.log(e);
        });
      UserDataService.getGoodBbList(this.id) // spring 요청
        //  성공/실패 모르겠지만/l
        //  성공하면 then안에 있는것이 실행
        .then((response3) => {
          this.bb = response3.data;
          console.log(response3.data);
        })
        //  실패하면 catch안에 있는것이 실행
        .catch((e) => {
          console.log(e);
        });
    },

    // 조회
    retrieveFb() {
      FbService.getAll(
        // this.fb_ctitle, // select box 선택된 값
        // this.fb_title, // 제목 검색
        this.page - 1,
        this.pageSize
      )
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          console.log("fb 좋아요 성공");
          const { goods, totalItems } = response.data; // springboot 의 전송된 맵 정보
          this.goods = goods; // 스프링부트에서 전송한 데이터
          this.count = totalItems; // 스프링부트에서 전송한 페이지정보(총 건수)

          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    retrieveBb() {
      BbService.getAll(
        this.page - 1,
        this.pageSize
      )
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          console.log("bb 좋아요 성공");
          const { bb, totalItems } = response.data; // springboot 의 전송된 맵 정보
          this.bb = bb; // 스프링부트에서 전송한 데이터
          this.count = totalItems; // 스프링부트에서 전송한 페이지정보(총 건수)

          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    retrieveMb() {
      MbService.getAll(
        this.page - 1,
        this.pageSize
      )
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          console.log("mb 좋아요 성공");
          const { mb, totalItems } = response.data; // springboot 의 전송된 맵 정보
          this.mb = mb; // 스프링부트에서 전송한 데이터
          this.count = totalItems; // 스프링부트에서 전송한 페이지정보(총 건수)

          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    retrieveLb() {
      LbService.getAll(
        this.page - 1,
        this.pageSize
      )
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          console.log("lb 좋아요 성공");
          const { lb, totalItems } = response.data; // springboot 의 전송된 맵 정보
          this.lb = lb; // 스프링부트에서 전송한 데이터
          this.count = totalItems; // 스프링부트에서 전송한 페이지정보(총 건수)

          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
  },

  mounted() {
    this.getLike();
  },
};
</script>

<style>
@import url(@/assets/css/style.css);
</style>