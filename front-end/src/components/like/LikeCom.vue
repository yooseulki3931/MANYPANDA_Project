<template>
  <div class="col-10">
    <div class="sold_back">
      <h4 id="sold_sale_logo">π€ My like list π€</h4>

      <!-- μμ κ²μν -->
      <div class="col-5" id="wrote_fb">
        <p id="wrote_title">μμ  κ²μν</p>
        <table class="table table-borderless" id="wrote_table">
          <thead>
            <tr id="cart_tr">
              <th scope="col" colspan="3">μ λͺ©</th>
              <th scope="col">μμ±μ</th>
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

      <!-- μΆμ²κ²μν -->
      <div class="col-5" id="wrote_fb">
        <p id="wrote_title">μΆμ² κ²μν</p>
        <table class="table table-borderless" id="wrote_table">
          <thead>
            <tr id="cart_tr">
              <th scope="col" colspan="3">μ λͺ©</th>
              <th scope="col">μμ±μ</th>
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

      <!-- λͺ¨μκ²μν -->
      <div class="col-5" id="wrote_fb">
        <p id="wrote_title">λͺ¨μ κ²μν</p>
        <table class="table table-borderless" id="wrote_table">
          <thead>
            <tr id="cart_tr">
              <th scope="col" colspan="3">μ λͺ©</th>
              <th scope="col">μμ±μ</th>
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

      <!-- λΆμ€κ²μν -->
      <div class="col-5" id="wrote_fb">
        <p id="wrote_title">λΆμ€/μ κ³  κ²μν</p>
        <table class="table table-borderless" id="wrote_table">
          <thead>
            <tr id="cart_tr">
              <th scope="col" colspan="3">μ λͺ©</th>
              <th scope="col">μμ±μ</th>
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
              alert("μ’μμκ° μ·¨μλμμ΅λλ€.")
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
              alert("μ’μμκ° μ·¨μλμμ΅λλ€.")
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
              alert("μ’μμκ° μ·¨μλμμ΅λλ€.")
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
              alert("μ’μμκ° μ·¨μλμμ΅λλ€.")
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
      UserDataService.getGoodFbList(this.id) // spring μμ²­
        //  μ±κ³΅/μ€ν¨ λͺ¨λ₯΄κ² μ§λ§/l
        //  μ±κ³΅νλ©΄ thenμμ μλκ²μ΄ μ€ν
        .then((response) => {
          console.log("fbμ±κ³΅");
          this.goods = response.data;
          console.log(response.data);
        })
        //  μ€ν¨νλ©΄ catchμμ μλκ²μ΄ μ€ν
        .catch((e) => {
          console.log("fbμ€ν¨");
          console.log(e);
        });
      UserDataService.getGoodLbList(this.id) // spring μμ²­
        //  μ±κ³΅/μ€ν¨ λͺ¨λ₯΄κ² μ§λ§/l
        //  μ±κ³΅νλ©΄ thenμμ μλκ²μ΄ μ€ν
        .then((response1) => {
          this.lb = response1.data;
          console.log(response1.data);
        })
        //  μ€ν¨νλ©΄ catchμμ μλκ²μ΄ μ€ν
        .catch((e) => {
          console.log(e);
        });
      UserDataService.getGoodMbList(this.id) // spring μμ²­
        //  μ±κ³΅/μ€ν¨ λͺ¨λ₯΄κ² μ§λ§/l
        //  μ±κ³΅νλ©΄ thenμμ μλκ²μ΄ μ€ν
        .then((response2) => {
          this.mb = response2.data;
          console.log(response2.data);
        })
        //  μ€ν¨νλ©΄ catchμμ μλκ²μ΄ μ€ν
        .catch((e) => {
          console.log(e);
        });
      UserDataService.getGoodBbList(this.id) // spring μμ²­
        //  μ±κ³΅/μ€ν¨ λͺ¨λ₯΄κ² μ§λ§/l
        //  μ±κ³΅νλ©΄ thenμμ μλκ²μ΄ μ€ν
        .then((response3) => {
          this.bb = response3.data;
          console.log(response3.data);
        })
        //  μ€ν¨νλ©΄ catchμμ μλκ²μ΄ μ€ν
        .catch((e) => {
          console.log(e);
        });
    },

    // μ‘°ν
    retrieveFb() {
      FbService.getAll(
        // this.fb_ctitle, // select box μ νλ κ°
        // this.fb_title, // μ λͺ© κ²μ
        this.page - 1,
        this.pageSize
      )
        // μ±κ³΅νλ©΄ .then() κ²°κ³Όκ° μ μ‘λ¨
        .then((response) => {
          console.log("fb μ’μμ μ±κ³΅");
          const { goods, totalItems } = response.data; // springboot μ μ μ‘λ λ§΅ μ λ³΄
          this.goods = goods; // μ€νλ§λΆνΈμμ μ μ‘ν λ°μ΄ν°
          this.count = totalItems; // μ€νλ§λΆνΈμμ μ μ‘ν νμ΄μ§μ λ³΄(μ΄ κ±΄μ)

          // λλ²κΉ μ½μμ μ λ³΄ μΆλ ₯
          console.log(response.data);
        })
        // μ€ν¨νλ©΄ .catch() μ μλ¬κ° μ μ‘λ¨
        .catch((e) => {
          console.log(e);
        });
    },
    retrieveBb() {
      BbService.getAll(
        this.page - 1,
        this.pageSize
      )
        // μ±κ³΅νλ©΄ .then() κ²°κ³Όκ° μ μ‘λ¨
        .then((response) => {
          console.log("bb μ’μμ μ±κ³΅");
          const { bb, totalItems } = response.data; // springboot μ μ μ‘λ λ§΅ μ λ³΄
          this.bb = bb; // μ€νλ§λΆνΈμμ μ μ‘ν λ°μ΄ν°
          this.count = totalItems; // μ€νλ§λΆνΈμμ μ μ‘ν νμ΄μ§μ λ³΄(μ΄ κ±΄μ)

          // λλ²κΉ μ½μμ μ λ³΄ μΆλ ₯
          console.log(response.data);
        })
        // μ€ν¨νλ©΄ .catch() μ μλ¬κ° μ μ‘λ¨
        .catch((e) => {
          console.log(e);
        });
    },
    retrieveMb() {
      MbService.getAll(
        this.page - 1,
        this.pageSize
      )
        // μ±κ³΅νλ©΄ .then() κ²°κ³Όκ° μ μ‘λ¨
        .then((response) => {
          console.log("mb μ’μμ μ±κ³΅");
          const { mb, totalItems } = response.data; // springboot μ μ μ‘λ λ§΅ μ λ³΄
          this.mb = mb; // μ€νλ§λΆνΈμμ μ μ‘ν λ°μ΄ν°
          this.count = totalItems; // μ€νλ§λΆνΈμμ μ μ‘ν νμ΄μ§μ λ³΄(μ΄ κ±΄μ)

          // λλ²κΉ μ½μμ μ λ³΄ μΆλ ₯
          console.log(response.data);
        })
        // μ€ν¨νλ©΄ .catch() μ μλ¬κ° μ μ‘λ¨
        .catch((e) => {
          console.log(e);
        });
    },
    retrieveLb() {
      LbService.getAll(
        this.page - 1,
        this.pageSize
      )
        // μ±κ³΅νλ©΄ .then() κ²°κ³Όκ° μ μ‘λ¨
        .then((response) => {
          console.log("lb μ’μμ μ±κ³΅");
          const { lb, totalItems } = response.data; // springboot μ μ μ‘λ λ§΅ μ λ³΄
          this.lb = lb; // μ€νλ§λΆνΈμμ μ μ‘ν λ°μ΄ν°
          this.count = totalItems; // μ€νλ§λΆνΈμμ μ μ‘ν νμ΄μ§μ λ³΄(μ΄ κ±΄μ)

          // λλ²κΉ μ½μμ μ λ³΄ μΆλ ₯
          console.log(response.data);
        })
        // μ€ν¨νλ©΄ .catch() μ μλ¬κ° μ μ‘λ¨
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