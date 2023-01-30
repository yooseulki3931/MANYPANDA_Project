<template>
  <div class="col-10">
    <div class="sold_back">
      <h4 id="sold_sale_logo">🛒 My sales list 🛒</h4>
      <div id="sold_fb">
        <table class="table table-borderless" id="wrote_table">
          <thead>
            <tr id="wrote_tr">
              <th scope="col">카테고리</th>
              <th scope="col" colspan="2">제목</th>
              <th scope="col">날짜</th>
              <th scope="col">판매상태</th>
            </tr>
          </thead>
          <tbody v-for="(data, index) in goods" :key="index" id="sold_tbody">
            <tr>
              <td>{{ data.category }}</td>
              <td colspan="2" id="cart_td">
              <router-link :to="'/dapanda/detail/' + data.goodsId"> {{ data.title }}
              </router-link></td>
              <td>{{ data.insertTime }}</td>
              <td>{{ data.status }}</td>
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
import GoodsDataService from '@/services/GoodsDataService';

export default {
  props: ["soldProps"],
  data() {
    return {
      goods: [],
      currentUser: null,
      nick: this.soldProps,
    };
  },
  methods: {
    // 판매완료 정보 불러오기
    getsold() {
      UserDataService.findGoodsByUsername(this.nick) // spring 요청
        //  성공/실패 모르겠지만/l
        //  성공하면 then안에 있는것이 실행
        .then((response) => {
          this.goods = response.data;
          console.log(response.data);
        })
        //  실패하면 catch안에 있는것이 실행
        .catch((e) => {
          console.log(e);
        });
    },

    // 조회
        retrieveGoods() {
      GoodsDataService.getAll(
        this.category,
        this.title, 
        this.page - 1, 
        this.pageSize)
        .then((response) => {
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

  },

  mounted() {
    this.getsold();
    this.retrieveGoods();
    // this.getUser(this.$route.params.username);
  },
};
</script>

<style>
@import url(@/assets/css/style.css);
</style>
