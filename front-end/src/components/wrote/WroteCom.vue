<template>
  <div class="col-10">
    <div class="wrote_back">
      <h4 id="sold_sale_logo">📝 My post list 📝</h4>

      <!-- 자유게시판 -->
      <div class="col-5" id="wrote_fb">
        <p id="wrote_title">자유게시판</p>

        <table class="table table-borderless" id="wrote_table">
          <thead>
            <tr id="wrote_tr">
              <th scope="col">NO</th>
              <th scope="col" colspan="2">제목</th>
              <th scope="col">날짜</th>
            </tr>
          </thead>

          <tbody v-for="(data, index) in users" :key="index" id="sold_tbody">
            <tr>
              <td>{{ data.fno }}</td>
              <td colspan="2" id="cart_td">
                <router-link :to="'/fb/' + data.fno">
                  {{ data.fbTitle }}
                </router-link>
              </td>
              <td>{{ data.insertTime }}</td>
            </tr>
          </tbody>
        </table>
      </div>

      <!-- 추천게시판 -->
      <div class="col-5" id="wrote_fb">
        <p id="wrote_title">추천게시판</p>
        <table class="table table-borderless" id="wrote_table">
          <thead>
            <tr id="wrote_tr">
              <th scope="col">NO</th>
              <th scope="col" colspan="2">제목</th>
              <th scope="col">날짜</th>
            </tr>
          </thead>
          <tbody v-for="(data, index) in bb" :key="index" id="sold_tbody">
            <tr>
              <td>{{ data.bno }}</td>
              <td colspan="2" id="cart_td">
              <router-link :to="'/bb/' + data.bno">                 
              {{ data.bbTitle }}
              </router-link></td>
              <td>{{ data.insertTime }}</td>
            </tr>
          </tbody>
        </table>
      </div>

      <!-- 모임게시판 -->
      <div class="col-5" id="wrote_fb">
        <p id="wrote_title">모임게시판</p>
        <table class="table table-borderless" id="wrote_table">
          <thead>
            <tr id="wrote_tr">
              <th scope="col">NO</th>
              <th scope="col" colspan="2" id="cart_td">제목</th>
              <th scope="col">날짜</th>
            </tr>
          </thead>
          <tbody v-for="(data, index) in mb" :key="index" id="sold_tbody">
            <tr>
              <td>{{ data.mno }}</td>
              <td colspan="2" id="cart_td">
              <router-link :to="'/mb/' + data.mno">                 
                {{ data.mbTitle }}
              </router-link></td>
              <td>{{ data.insertTime }}</td>
            </tr>
          </tbody>
        </table>
      </div>

      <!-- 분실게시판 -->
      <div class="col-5" id="wrote_fb">
        <p id="wrote_title">분실/신고 게시판</p>
        <table class="table table-borderless" id="wrote_table">
          <thead>
            <tr id="wrote_tr">
              <th scope="col" colspan="2" id="cart_td">제목</th>
              <th scope="col">날짜</th>
            </tr>
          </thead>
          <tbody v-for="(data, index) in lb" :key="index" id="sold_tbody">
            <tr>
              <td colspan="2" id="cart_td">
              <router-link :to="'/lb/' + data.lno">                 
              {{ data.lbTitle }}
              </router-link></td>
              <td>{{ data.insertTime }}</td>
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

export default {
  props: ["wroteProps"],
  data() {
    return {
      users: [],
      mb: [],
      bb: [],
      lb: [],
      nick: this.wroteProps,
    };
  },
  methods: {
    // 내가 쓴글 조회
    getWrite() {
      UserDataService.getWrote(this.nick)
        //  성공/실패 모르겠지만
        //  성공하면 then안에 있는것이 실행
        .then((response) => {
          this.users = response.data;
          console.log(response.data);
          // console.log(this.nick + "자유성공");
        })
        //  실패하면 catch안에 있는것이 실행
        .catch((e) => {
          console.log(e);
        });

      UserDataService.getLbWrote(this.nick) // spring 요청
        //  성공/실패 모르겠지만
        //  성공하면 then안에 있는것이 실행
        .then((response3) => {
          this.lb = response3.data;
          console.log(response3.data);
          // console.log(this.nick + "분실성공");
        })
        //  실패하면 catch안에 있는것이 실행
        .catch((e) => {
          console.log(e);
        });

      UserDataService.getBbWrote(this.nick) // spring 요청
        //  성공/실패 모르겠지만
        //  성공하면 then안에 있는것이 실행
        .then((response1) => {
          this.bb = response1.data;
          console.log(response1.data);
          // console.log(this.nick + "추천성공");
        })
        //  실패하면 catch안에 있는것이 실행
        .catch((e) => {
          console.log(e);
        });

      UserDataService.getMbWrote(this.nick) // spring 요청
        //  성공/실패 모르겠지만
        //  성공하면 then안에 있는것이 실행
        .then((response2) => {
          this.mb = response2.data;
          console.log(response2.data);
          // console.log(this.nick + "모임성공");
        })
        //  실패하면 catch안에 있는것이 실행
        .catch((e) => {
          console.log(e);
        });
    },

    //  조회
    retrieveFb() {
      FbService.getAll(
        // console.log("내가쓴글 링크"),
        this.fb_ctitle, // select box 선택된 값
        this.fb_title, // 제목 검색
        this.page - 1,
        this.pageSize
      )
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          console.log("내가쓴글 fb 링크 성공");
          const { users, totalItems } = response.data; // springboot 의 전송된 맵 정보
          this.users = users; // 스프링부트에서 전송한 데이터
          this.count = totalItems; // 스프링부트에서 전송한 페이지정보(총 건수)

          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
          console.log("내가쓴글 fb링크 실패");
        });
    },
    retrieveBb() {
      BbService.getAll(
        this.bb_ctitle, // select box 선택된 값
        this.bb_title, // 제목 검색
        this.page - 1,
        this.pageSize
      )
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          console.log("내가쓴글 bb 링크 성공");
          const { bb, totalItems } = response.data; // springboot 의 전송된 맵 정보
          this.bb = bb; // 스프링부트에서 전송한 데이터
          this.count = totalItems; // 스프링부트에서 전송한 페이지정보(총 건수)

          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
          console.log("내가쓴글 bb링크 실패");
        });
    },
    retrieveMb() {
      MbService.getAll(
        // console.log("내가쓴글 링크"),
        this.mb_ctitle, // select box 선택된 값
        this.mb_title, // 제목 검색
        this.page - 1,
        this.pageSize
      )
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          console.log("내가쓴글 mb링크 성공");
          const { mb, totalItems } = response.data; // springboot 의 전송된 맵 정보
          this.mb = mb; // 스프링부트에서 전송한 데이터
          this.count = totalItems; // 스프링부트에서 전송한 페이지정보(총 건수)

          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
          console.log("내가쓴글 mb링크 실패");
        });
    },
    retrieveLb() {
      LbService.getAll(
        // console.log("내가쓴글 링크"),
        this.lb_ctitle, // select box 선택된 값
        this.lb_title, // 제목 검색
        this.page - 1,
        this.pageSize
      )
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          console.log("내가쓴글 lb링크 성공");
          const { lb, totalItems } = response.data; // springboot 의 전송된 맵 정보
          this.lb = lb; // 스프링부트에서 전송한 데이터
          this.count = totalItems; // 스프링부트에서 전송한 페이지정보(총 건수)

          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
          console.log("내가쓴글 lb링크 실패");
        });
    },
  },
  mounted() {
    this.getWrite();
  },
};
</script>

<style>
@import url(@/assets/css/style.css);
</style>
