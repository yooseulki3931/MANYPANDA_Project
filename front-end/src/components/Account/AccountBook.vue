<template>
  <!-- AccountBook.vue -->
  <div class="col-10">
  <div id="account_back">
    <h4 id="account_logo">🧾Account Book🧾</h4>
    <div id="account_content">
    <div class="accordion accordion-flush" id="accordionFlushExample">
      <!-- 1개월 -->
      <div class="accordion-item">
        <h2 class="accordion-header" id="flush-headingOne">
          <button
            id="account_title"
            class="accordion-button collapsed"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#flush-collapseOne"
            aria-expanded="false"
            aria-controls="flush-collapseOne"
          >
            1개월
          </button>
        </h2>
        <div
          id="flush-collapseOne"
          class="accordion-collapse collapse"
          aria-labelledby="flush-headingOne"
          data-bs-parent="#accordionFlushExample"
        >
          <div class="accordion-body">
            판매액 : {{ getaccount[0].sellPrice }}원
            <br>판매수 : {{ getaccount[0].status }}건
          </div>
        </div>
      </div>
      <!-- 3개월 -->
      <div class="accordion-item">
        <h2 class="accordion-header" id="flush-headingTwo">
          <button
            id="account_title"
            class="accordion-button collapsed"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#flush-collapseTwo"
            aria-expanded="false"
            aria-controls="flush-collapseTwo"
          >
            3개월
          </button>
        </h2>
        <div
          id="flush-collapseTwo"
          class="accordion-collapse collapse"
          aria-labelledby="flush-headingTwo"
          data-bs-parent="#accordionFlushExample"
        >
          <div class="accordion-body">
            판매액 : {{ getaccount3[0].sellPrice }}원 
            <br>판매수 :
            {{ getaccount3[0].status }}건
          </div>
        </div>
      </div>
      <!-- 6개월 -->
      <div class="accordion-item">
        <h2 class="accordion-header" id="flush-headingThree">
          <button
            id="account_title"
            class="accordion-button collapsed"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#flush-collapseThree"
            aria-expanded="false"
            aria-controls="flush-collapseThree"
          >
            6개월
          </button>
        </h2>
        <div
          id="flush-collapseThree"
          class="accordion-collapse collapse"
          aria-labelledby="flush-headingThree"
          data-bs-parent="#accordionFlushExample"
        >
          <div class="accordion-body">
            판매액 : {{ getaccount6[0].sellPrice }}원 
            <br>판매수 :
            {{ getaccount6[0].status }}건
          </div>
        </div>
      </div>
      <!-- 숨기기 -->
      <div class="accordion-item">
        <h2 class="accordion-header" id="flush-headingFour">
          <button
            id="account_title"
            class="btn btn-outline-secondary"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#flush-collapseFour"
            aria-expanded="false"
            aria-controls="flush-collapseFour"
            style="margin-top:20px"
          >
            닫기
          </button>
        </h2>
        <div
          id="flush-collapseFour"
          class="accordion-collapse collapse"
          aria-labelledby="flush-headingThree"
          data-bs-parent="#accordionFlushExample"
        >
        
          <div class="accordion-body">
          </div>
        </div>
      </div>

    </div>
    </div>
  </div>
  </div>
</template>

<script>
/* eslint-disable */
// axios 공통함수 import
import GoodsDataService from "../../services/GoodsDataService";

export default {
  props: ["AccountProps"],
  data() {
    return {
      getaccount: null,
      getaccount3: "",
      getaccount6: "",
      currentUser: null,
      userNick: this.AccountProps

    };
  },

  methods: {
    // 1개월 판매내역 조회
    getaccountone() {
      GoodsDataService.getaccount(this.userNick) // spring 요청
        //  성공/실패 모르겠지만
        //  성공하면 then안에 있는것이 실행
        .then((response) => {
          this.getaccount = response.data;
          console.log(response.data);
        })
        //  실패하면 catch안에 있는것이 실행
        .catch((e) => {
          console.log(e);
        });
    },
    // 3개월 판매내역 조회
    getaccountthree() {
      GoodsDataService.getaccount3(this.userNick) // spring 요청
        //  성공/실패 모르겠지만
        //  성공하면 then안에 있는것이 실행
        .then((response) => {
          this.getaccount3 = response.data;
          console.log(response.data);
        })
        //  실패하면 catch안에 있는것이 실행
        .catch((e) => {
          console.log(e);
        });
    },
    // 6개월 판매내역 조회
    getaccountsix() {
      GoodsDataService.getaccount6(this.userNick) // spring 요청
        //  성공/실패 모르겠지만
        //  성공하면 then안에 있는것이 실행
        .then((response) => {
          this.getaccount6 = response.data;
          console.log(response.data);
        })
        //  실패하면 catch안에 있는것이 실행
        .catch((e) => {
          console.log(e);
        });
    },
  },
    mounted() {
    this.getaccountone();
    this.getaccountthree();
    this.getaccountsix();
  }

};
</script>

<style>
@import url(@/assets/css/style.css);
</style>

