<template>
  <!-- AccountBook.vue -->
  <div class="col-10">
  <div id="account_back">
    <h4 id="account_logo">๐งพAccount Book๐งพ</h4>
    <div id="account_content">
    <div class="accordion accordion-flush" id="accordionFlushExample">
      <!-- 1๊ฐ์ -->
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
            1๊ฐ์
          </button>
        </h2>
        <div
          id="flush-collapseOne"
          class="accordion-collapse collapse"
          aria-labelledby="flush-headingOne"
          data-bs-parent="#accordionFlushExample"
        >
          <div class="accordion-body">
            ํ๋งค์ก : {{ getaccount[0].sellPrice }}์
            <br>ํ๋งค์ : {{ getaccount[0].status }}๊ฑด
          </div>
        </div>
      </div>
      <!-- 3๊ฐ์ -->
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
            3๊ฐ์
          </button>
        </h2>
        <div
          id="flush-collapseTwo"
          class="accordion-collapse collapse"
          aria-labelledby="flush-headingTwo"
          data-bs-parent="#accordionFlushExample"
        >
          <div class="accordion-body">
            ํ๋งค์ก : {{ getaccount3[0].sellPrice }}์ 
            <br>ํ๋งค์ :
            {{ getaccount3[0].status }}๊ฑด
          </div>
        </div>
      </div>
      <!-- 6๊ฐ์ -->
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
            6๊ฐ์
          </button>
        </h2>
        <div
          id="flush-collapseThree"
          class="accordion-collapse collapse"
          aria-labelledby="flush-headingThree"
          data-bs-parent="#accordionFlushExample"
        >
          <div class="accordion-body">
            ํ๋งค์ก : {{ getaccount6[0].sellPrice }}์ 
            <br>ํ๋งค์ :
            {{ getaccount6[0].status }}๊ฑด
          </div>
        </div>
      </div>
      <!-- ์จ๊ธฐ๊ธฐ -->
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
            ๋ซ๊ธฐ
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
// axios ๊ณตํตํจ์ import
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
    // 1๊ฐ์ ํ๋งค๋ด์ญ ์กฐํ
    getaccountone() {
      GoodsDataService.getaccount(this.userNick) // spring ์์ฒญ
        //  ์ฑ๊ณต/์คํจ ๋ชจ๋ฅด๊ฒ?์ง๋ง
        //  ์ฑ๊ณตํ๋ฉด then์์ ์๋๊ฒ์ด ์คํ
        .then((response) => {
          this.getaccount = response.data;
          console.log(response.data);
        })
        //  ์คํจํ๋ฉด catch์์ ์๋๊ฒ์ด ์คํ
        .catch((e) => {
          console.log(e);
        });
    },
    // 3๊ฐ์ ํ๋งค๋ด์ญ ์กฐํ
    getaccountthree() {
      GoodsDataService.getaccount3(this.userNick) // spring ์์ฒญ
        //  ์ฑ๊ณต/์คํจ ๋ชจ๋ฅด๊ฒ?์ง๋ง
        //  ์ฑ๊ณตํ๋ฉด then์์ ์๋๊ฒ์ด ์คํ
        .then((response) => {
          this.getaccount3 = response.data;
          console.log(response.data);
        })
        //  ์คํจํ๋ฉด catch์์ ์๋๊ฒ์ด ์คํ
        .catch((e) => {
          console.log(e);
        });
    },
    // 6๊ฐ์ ํ๋งค๋ด์ญ ์กฐํ
    getaccountsix() {
      GoodsDataService.getaccount6(this.userNick) // spring ์์ฒญ
        //  ์ฑ๊ณต/์คํจ ๋ชจ๋ฅด๊ฒ?์ง๋ง
        //  ์ฑ๊ณตํ๋ฉด then์์ ์๋๊ฒ์ด ์คํ
        .then((response) => {
          this.getaccount6 = response.data;
          console.log(response.data);
        })
        //  ์คํจํ๋ฉด catch์์ ์๋๊ฒ์ด ์คํ
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

