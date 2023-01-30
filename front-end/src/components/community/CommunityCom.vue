<template>
  <div>
    <div class="community">
      <section class="secondSection ">
        <div class="container " data-aos="fade-left" data-aos-delay="200">
          <div class="row">

            <!-- 자유게시판 목록 -->
            <table class="table" data-v-224097a6="" style="width: 45%; margin-left: 30px;">
              <thead data-v-224097a6="">
              <tr data-v-224097a6="" style="font-size: 22px;">
                <th scope="col" data-v-224097a6="">
                  <a href="/community-free-Board"><img src="../../assets/image/board/fb.jpg" alt="">
                  </a>
                </th>
              </tr>
            </thead>

            <tbody class="table-group-divider" data-v-224097a6="" style="text-align: center;">
              <tr v-for="(data, index) in fbBoardDesc" :key="index" data-v-224097a6="" style="font-size: 18px; background-color: rgb(255, 255, 255);">
                  <td data-v-224097a6="">
                    <a :href="`/fb/${data.fno}`" style="text-decoration: none;" ><font color="black" size="2px" >{{ data.fbTitle }}</font></a>
                  </td>
              </tr>
              </tbody>
            </table>
          
            <!-- 추천게시판 목록-->
            <table class="table" data-v-224097a6="" style="width: 45%; margin-left: 30px;">
              <thead data-v-224097a6="">
              <tr data-v-224097a6="" style="font-size: 22px;">
                <th scope="col" data-v-224097a6="">
                  <a href="/community-best-board"><img src="../../assets/image/board/bb.jpg" alt="">
                  </a>
                </th>
              </tr>
            </thead>

            <tbody class="table-group-divider" data-v-224097a6="" style="text-align: center;">
              <tr v-for="(data, index) in bbBoardDesc" :key="index" data-v-224097a6="" style="font-size: 18px; background-color: rgb(255, 255, 255);">
                  <td data-v-224097a6="">
                    <a :href="`/bb/${data.bno}`" style="text-decoration: none;" ><font color="black" size="2px" >{{ data.bbTitle }}</font></a>
                  </td>
              </tr>
              </tbody>
            </table>

            <!-- 모임게시판 목록 -->
            <table class="table" data-v-224097a6="" style="width: 45%; margin-left: 30px;">
              <thead data-v-224097a6="">
              <tr data-v-224097a6="" style="font-size: 22px;">
                <th scope="col" data-v-224097a6="">
                  <a href="/community-moim-board" size="2px"><img src="../../assets/image/board/mb.jpg" alt="">
                  </a>
                </th>
              </tr>
            </thead>

            <tbody class="table-group-divider" data-v-224097a6="" style="text-align: center;">
              <tr v-for="(data, index) in mbBoardDesc" :key="index" data-v-224097a6="" style="font-size: 18px; background-color: rgb(255, 255, 255);">
                  <td data-v-224097a6="">
                    <a :href="`/mb/${data.mno}`" style="text-decoration: none;" ><font color="black" size="2px" >{{ data.mbTitle }}</font></a>
                  </td>
              </tr>
              </tbody>
            </table>

            <!-- 분실게시판 목록 -->
            <table class="table" data-v-224097a6="" style="width: 45%; margin-left: 30px;">
              <thead data-v-224097a6="">
              <tr data-v-224097a6="" style="font-size: 22px;">
                <th scope="col" data-v-224097a6="">
                  <a href="/community-lost-board"><img src="../../assets/image/board/lb.jpg" alt="">
                  </a>
                </th>
              </tr>
            </thead>

            <tbody class="table-group-divider" data-v-224097a6="" style="text-align: center;">
              <tr v-for="(data, index) in lbBoardDesc" :key="index" data-v-224097a6="" style="font-size: 18px; background-color: rgb(255, 255, 255);">
                  <td data-v-224097a6="">
                    <a :href="`/lb/${data.lno}`" style="text-decoration: none;" ><font color="black" size="2px" >{{ data.lbTitle }}</font></a>
                  </td>
              </tr>
              </tbody>
            </table>
  
          </div>
        </div>
      </section>

    </div>
  </div>
</template>

<script>
/* eslint-disable */
import FbService from "../../services/FbService";
import BbService from "../../services/BbService";
import MbService from "../../services/MbService";
import LbService from "../../services/LbService";

export default {
  data() {
    return {
     fbBoardDesc:[],
     bbBoardDesc:[],
     mbBoardDesc:[],
     lbBoardDesc:[],
     fbTitle: "",
     bbTitle: "",
     mbTitle: "",
     lbTitle: "",
   };
  },
  methods: {

    // 자유게시판 최신순 조회
    retrieveFbBoardDesc() {
      FbService.getFbDesc()
         // 성공하면 .then() 결과가 전송됨
        .then((response2) => {
          this.fbBoardDesc = response2.data;
          // 디버깅 콘솔에 정보 출력
          console.log(response2.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
      },

    // 추천게시판 최신순 조회
    retrieveBbBoardDesc() {
      BbService.getBbDesc()
         // 성공하면 .then() 결과가 전송됨
        .then((response2) => {
          this.bbBoardDesc = response2.data;
          // 디버깅 콘솔에 정보 출력
          console.log(response2.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
      },

    // 모임게시판 최신순 조회
    retrieveMbBoardDesc() {
      MbService.getMbDesc()
         // 성공하면 .then() 결과가 전송됨
        .then((response2) => {
          this.mbBoardDesc = response2.data;
          // 디버깅 콘솔에 정보 출력
          console.log(response2.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
      },

    // 분실게시판 최신순 조회
    retrieveLbBoardDesc() {
      LbService.getLbDesc()
         // 성공하면 .then() 결과가 전송됨
        .then((response2) => {
          this.lbBoardDesc = response2.data;
          // 디버깅 콘솔에 정보 출력
          console.log(response2.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
      },
  },
  
  mounted() {
    this.retrieveFbBoardDesc();
    this.retrieveBbBoardDesc();
    this.retrieveMbBoardDesc();
    this.retrieveLbBoardDesc();
  }
}
</script>

<style>
.community {
  margin-top: 350px;
}
.table {
  margin-top: 40px;
  margin-bottom: 80px;
}
</style>