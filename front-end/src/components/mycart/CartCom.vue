<template>
  <div class="col-10">
    <div class="sold_back">
      <h4 id="sold_sale_logo">🖤 My cart list 🖤</h4>

      <div id="sold_fb">
        <table class="table table-borderless" id="cart_table">
          <thead>
            <tr id="cart_tr">
              <th scope="col" id="cart_td">카테고리</th>
              <th scope="col" colspan="3" id="cart_td">제목</th>
              <th scope="col" id="cart_td">날짜</th>
              <th scope="col" id="cart_td">판매상태</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody v-for="(data, index) in goods" :key="index" id="sold_tbody">
            <tr id="cart_tr">
              <td id="cart_td">{{ data.category }}</td>
              <td colspan="3" id="cart_td">
                <router-link :to="'/dapanda/detail/' + data.goodsId">
                  {{ data.title }}
                </router-link>
              </td>
              <td id="cart_td">{{ data.insertTime }}</td>
              <td id="cart_td">{{ data.status }}</td>
              <button style="border: none; width: 16px;" @click="deleteCart(goods[index].goodsId)" id="cart_delete">
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
import GoodsDataService from '@/services/GoodsDataService';
import GoodCartService from "@/services/GoodCartService";


export default {
  props: ["idProps"],
  data() {
    return {
      goods: [],
      currentUser: null,
      id: this.idProps,
      deleteid: null
    };
  },
  methods: {
    // 찜 삭제
    deleteCart(num) {
      GoodCartService.getCart(num, this.$store.state.auth.user.id)
        .then((response) => {
          this.deleteid = response.data.cartId;
          console.log(response.data.cartId);
          GoodCartService.delete(this.deleteid)
            .then((response) => {
              console.log(response.data);
              alert("찜목록에서 삭제되었습니다.")
              location.href=`/myPage`
            })
            .catch((e) => {
              console.log(e);
            })

        })
        .catch((e) => {
          console.log(e);
        });
      
      this.getWish();
      this.retrieveGoods(); // 화면 실행시 조회
    },

    // 찜 선택
    getWish() {
      UserDataService.getWishList(this.id) // spring 요청
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
    this.getWish();
    this.retrieveGoods(); // 화면 실행시 조회

    // this.getUser(this.$route.params.username);
  },
};
</script>

<style>
@import url(@/assets/css/style.css);
</style>
