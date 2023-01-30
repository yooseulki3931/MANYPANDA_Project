<template>
  <div class="homeMain">
    <div class="lg:w-full w-full bg-blue-0">
      <div class="xxx_imgWrap flex flex-col my-auto items-center mx-3">
        <div class="flex h-screen">
          <div class="m-auto">
            <main>

              <section class="firstSection ">
                <div>
                  <a href="/"><img class="mainImage" src="../assets/image/mainPanda.gif" alt=""></a>
                </div>
              </section>

              <section class="secondOneSection ">
                  <div class="container " data-aos="fade-left" data-aos-delay="200">
                    <div class="row">
                      <div class="container px-md-6 mt-10 mb-5">
                          <div class="row justify-content-center">

                      <table class="col-lg-2 col-sm-4 col-12" style="margin-left:30px;">
                        <thead data-v-224097a6="">
                        <tr data-v-224097a6="" style="font-size: 18px;">
                          <th scope="col" data-v-224097a6="">
                            <a href="/community-free-Board"><img src="../assets/image/board/fb.jpg" style="width:250px" alt="">
                            </a>
                          </th>
                        </tr>
                      </thead>
                      <tbody class="table-group-divider" data-v-224097a6="" style="text-align: center;">
                        <tr v-for="(data, index) in fbBoardDesc" :key="index" data-v-224097a6="" 
                        style="font-size: 14px; background-color: rgb(255, 255, 255);">
                            <td data-v-224097a6="">
                              <a :href="`/fb/${data.fno}`" style="text-decoration: none;" >
                                <font color="black" size="2px" >{{ data.fbTitle }}</font></a>
                            </td>
                        </tr>

                        </tbody>
                      </table>

                      <table class="col-lg-2 col-sm-4 col-12" style="margin-left:30px;">
                        <thead data-v-224097a6="">
                        <tr data-v-224097a6="" style="font-size: 22px;">
                          <th scope="col" data-v-224097a6="">
                            <a href="/community-best-board"><img src="../assets/image/board/bb.jpg" style="width:250px" alt="">
                            </a>
                          </th>
                          
                        </tr>
                      </thead>
                      <tbody class="table-group-divider" data-v-224097a6="" style="text-align: center;">
                        <tr v-for="(data, index) in bbBoardDesc" :key="index" data-v-224097a6="" style="font-size: 14px; background-color: rgb(255, 255, 255);">
                          <td data-v-224097a6="">
                            <a :href="`/bb/${data.bno}`" style="text-decoration: none;" ><font color="black" size="2px" >{{ data.bbTitle }}</font></a>
                          </td>
                        </tr>

                        </tbody>
                      </table>

                      <table class="col-lg-2 col-sm-4 col-12" style="margin-left:30px;" >
                        <thead data-v-224097a6="">
                        <tr data-v-224097a6="" style="font-size: 22px;">
                          <th scope="col" data-v-224097a6="">
                            <a href="/community-moim-board" size="2px"><img src="../assets/image/board/mb.jpg" style="width:250px" alt="">
                            </a>
                          </th>
                          
                        </tr>
                      </thead>
                      <tbody class="table-group-divider" data-v-224097a6="" style="text-align: center;">
                        <tr v-for="(data, index) in mbBoardDesc" :key="index" data-v-224097a6="" style="font-size: 14px; background-color: rgb(255, 255, 255);">
                          <td data-v-224097a6="">
                            <a :href="`/mb/${data.mno}`" style="text-decoration: none;" ><font color="black" size="2px" >{{ data.mbTitle }}</font></a>
                          </td>
                        </tr>
                        </tbody>
                      </table>

                      <table class="col-lg-2 col-sm-4 col-12" style="margin-left:30px;">
                        <thead data-v-224097a6="">
                        <tr data-v-224097a6="" style="font-size: 22px;">
                          <th scope="col" data-v-224097a6="">
                            <a href="/community-lost-board"><img src="../assets/image/board/lb.jpg" style="width:250px" alt="">
                            </a>
                          </th>
                          
                        </tr>
                      </thead>
                      <tbody class="table-group-divider " data-v-224097a6="" style="text-align: center;">
                        <tr v-for="(data, index) in lbBoardDesc" :key="index" data-v-224097a6="" style="font-size: 14px; background-color: rgb(255, 255, 255);">
                          <td data-v-224097a6="">
                            <a :href="`/lb/${data.lno}`" style="text-decoration: none;" ><font color="black" size="2px" >{{ data.lbTitle }}</font></a>
                          </td>
                        </tr>

                        </tbody>
                      </table>

                      </div>
                      </div>
                      
                    </div>
                  </div>
                </section>

              <section class="secondTwoSection ">
                <div class="container " data-aos="fade-left" data-aos-delay="200">
                  <div class="row">


                    <div class="container px-md-6 mt-10 mb-5">
                      <div class="row justify-content-center">
                        <!-- 사진 블럭 사이즈 조절 -->
                        <div class="col-12">
                          <div class="row justify-content-center">

                            <!-- part.2 start -->
                            <div class="container px-md-5 mt-5 mb-10">
                              <div class="position-md-absolute start-0 ms-2 mt-3 mb-4">
                              </div>
                              <div class="row g-3">


                                <!-- #1 -->
                                <div class="col-lg-3 col-sm-6 col-12 professional gallery-item isotope-item"
                                  v-for="(data, goodsId) in goods" :key="goodsId">
                                  <router-link :to="'/dapanda/detail/' + data.goodsId">
                                    <img class="img-fluid w-100" :src="data.fileUrl" style="border-radius:20px; width: 300px; height: 300px;"
                                      data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                      </router-link>
                                </div>


                                <!-- #2 -->
                                <div class="col-lg-3 col-sm-6 col-12 professional gallery-item isotope-item">
                                  <a href="https://ticket.melon.com/performance/index.htm?prodId=207523"
                                    target="_blank">
                                    <img class="img-fluid w-100" src="../assets/image/mainList/2.jpg"
                                      style="border-radius:20px;"
                                      data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                  </a>
                                </div>

                                <!-- #3 -->
                                <div class="col-lg-3 col-sm-6 col-12 commercial gallery-item isotope-item">
                                  <a href="https://ticket.melon.com/performance/index.htm?prodId=207548"
                                    target="_blank">
                                    <img class="img-fluid w-100" src="../assets/image/mainList/3.jpg"
                                      style="border-radius:20px;"
                                      data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                  </a>
                                </div>

                                <!-- #4 -->
                                <!-- #5 -->
                                <div class="col-lg-3 col-sm-6 col-12 shortfilms gallery-item isotope-item">
                                  <a href="https://tickets.interpark.com/goods/22016439" target="_blank">
                                    <img class="img-fluid w-100" src="../assets/image/mainList/1.jpg"
                                      style="border-radius:20px;"
                                      data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                  </a>
                                </div>

                                <!-- #6 -->
                                <div class="col-lg-3 col-sm-6 col-12 commercial gallery-item isotope-item">
                                  <a href="http://ticket.yes24.com/Perf/44166" target="_blank">
                                    <img class="img-fluid w-100" src="../assets/image/mainList/2.jpg"
                                      style="border-radius:20px;"
                                      data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                  </a>
                                </div>

                                <!-- #7 -->
                                <div class="col-lg-3 col-sm-6 col-12 professional gallery-item isotope-item">
                                  <a href="https://tickets.interpark.com/goods/22014517" target="_blank">
                                    <img class="img-fluid w-100" src="../assets/image/mainList/3.jpg"
                                      style="border-radius:20px;"
                                      data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                  </a>
                                </div>

                                <!-- #8 -->
                                <div class="col-lg-3 col-sm-6 col-12 commercial gallery-item isotope-item">
                                  <a href="http://ticket.yes24.com/Perf/44040?Gcode=009_303" target="_blank">
                                    <img class="img-fluid w-100" src="../assets/image/mainList/4.jpg"
                                      style="border-radius:20px;"
                                      data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                  </a>
                                </div>

                                <!-- #9 -->
                                <div class="col-lg-3 col-sm-6 col-12shortfilms gallery-item isotope-item">
                                  <a href="https://ticket.melon.com/performance/index.htm?prodId=207517"
                                    target="_blank">
                                    <img class="img-fluid w-100" src="../assets/image/mainList/1.jpg"
                                      style="border-radius:20px;"
                                      data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                  </a>
                                </div>

                                <!-- #10 -->
                                <div class="col-lg-3 col-sm-6 col-12 shortfilms gallery-item isotope-item">
                                  <a href="http://ticket.yes24.com/Special/44037" target="_blank">
                                    <img class="img-fluid w-100" src="../assets/image/mainList/1.jpg"
                                      style="border-radius:20px;"
                                      data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                  </a>
                                </div>

                                <!-- #11 -->
                                <div class="col-lg-3 col-sm-6 col-12 professional gallery-item isotope-item">
                                  <a href="https://ticket.melon.com/performance/index.htm?prodId=207523"
                                    target="_blank">
                                    <img class="img-fluid w-100" src="../assets/image/mainList/2.jpg"
                                      style="border-radius:20px;"
                                      data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                  </a>
                                </div>

                                <!-- #12 -->
                                <div class="col-lg-3 col-sm-6 col-12 commercial gallery-item isotope-item">
                                  <a href="https://ticket.melon.com/performance/index.htm?prodId=207548"
                                    target="_blank">
                                    <img class="img-fluid w-100" src="../assets/image/mainList/3.jpg"
                                      style="border-radius:20px;"
                                      data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                  </a>
                                </div>

                                <!-- 더보기 div -->
                                <div id="bu">
                                  <div v-if="show" class="row g-3">

                                    <!-- #1 -->
                                    <div class="col-lg-3 col-sm-6 col-12 professional gallery-item isotope-item">
                                      <a href="https://ticket.melon.com/performance/index.htm?prodId=207511"
                                        target="_blank">
                                        <img class="img-fluid w-100" src="../assets/image/mainList/4.jpg"
                                          style="border-radius:20px;"
                                          data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                      </a>
                                    </div>

                                    <!-- #2 -->
                                    <div class="col-lg-3 col-sm-6 col-12 shortfilms gallery-item isotope-item">
                                      <a href="https://tickets.interpark.com/goods/22016439" target="_blank">
                                        <img class="img-fluid w-100" src="../assets/image/mainList/1.jpg"
                                          style="border-radius:20px;"
                                          data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                      </a>
                                    </div>

                                    <!-- #3-->
                                    <div class="col-lg-3 col-sm-6 col-12 commercial gallery-item isotope-item">
                                      <a href="http://ticket.yes24.com/Perf/44166" target="_blank">
                                        <img class="img-fluid w-100" src="../assets/image/mainList/2.jpg"
                                          style="border-radius:20px;"
                                          data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                      </a>
                                    </div>

                                    <!-- #4-->
                                    <div class="col-lg-3 col-sm-6 col-12 professional gallery-item isotope-item">
                                      <a href="https://tickets.interpark.com/goods/22014517" target="_blank">
                                        <img class="img-fluid w-100" src="../assets/image/mainList/3.jpg"
                                          style="border-radius:20px;"
                                          data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                      </a>
                                    </div>

                                    <!-- #5 -->
                                    <div class="col-lg-3 col-sm-6 col-12 commercial gallery-item isotope-item">
                                      <a href="http://ticket.yes24.com/Perf/44040?Gcode=009_303" target="_blank">
                                        <img class="img-fluid w-100" src="../assets/image/mainList/4.jpg"
                                          style="border-radius:20px;"
                                          data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                      </a>
                                    </div>

                                    <!-- #6 -->
                                    <div class="col-lg-3 col-sm-6 col-12shortfilms gallery-item isotope-item">
                                      <a href="https://ticket.melon.com/performance/index.htm?prodId=207517"
                                        target="_blank">
                                        <img class="img-fluid w-100" src="../assets/image/mainList/1.jpg"
                                          style="border-radius:20px;"
                                          data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                      </a>
                                    </div>

                                    <!-- #7  -->
                                    <div class="col-lg-3 col-sm-6 col-12 shortfilms gallery-item isotope-item">
                                      <a href="http://ticket.yes24.com/Special/44037" target="_blank">
                                        <img class="img-fluid w-100" src="../assets/image/mainList/1.jpg"
                                          style="border-radius:20px;"
                                          data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                      </a>
                                    </div>

                                    <!-- #8-->
                                    <div class="col-lg-3 col-sm-6 col-12 professional gallery-item isotope-item">
                                      <a href="https://ticket.melon.com/performance/index.htm?prodId=207523"
                                        target="_blank">
                                        <img class="img-fluid w-100" src="../assets/image/mainList/2.jpg"
                                          style="border-radius:20px;"
                                          data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                      </a>
                                    </div>

                                    <!-- #9 -->
                                    <div class="col-lg-3 col-sm-6 col-12 commercial gallery-item isotope-item">
                                      <a href="https://ticket.melon.com/performance/index.htm?prodId=207548"
                                        target="_blank">
                                        <img class="img-fluid w-100" src="../assets/image/mainList/3.jpg"
                                          style="border-radius:20px;"
                                          data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                      </a>
                                    </div>

                                    <!-- #10 -->
                                    <div class="col-lg-3 col-sm-6 col-12 professional gallery-item isotope-item">
                                      <a href="https://ticket.melon.com/performance/index.htm?prodId=207511"
                                        target="_blank">
                                        <img class="img-fluid w-100" src="../assets/image/mainList/4.jpg"
                                          style="border-radius:20px;"
                                          data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                      </a>
                                    </div>

                                    <!-- #11 -->
                                    <div class="col-lg-3 col-sm-6 col-12 shortfilms gallery-item isotope-item">
                                      <a href="https://tickets.interpark.com/goods/22016439" target="_blank">
                                        <img class="img-fluid w-100" src="../assets/image/mainList/1.jpg"
                                          style="border-radius:20px;"
                                          data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                      </a>
                                    </div>

                                    <!-- #12 -->
                                    <div class="col-lg-3 col-sm-6 col-12 commercial gallery-item isotope-item">
                                      <a href="http://ticket.yes24.com/Perf/44166" target="_blank">
                                        <img class="img-fluid w-100" src="../assets/image/mainList/2.jpg"
                                          style="border-radius:20px;"
                                          data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                      </a>
                                    </div>

                                    <!-- #13 -->
                                    <div class="col-lg-3 col-sm-6 col-12 professional gallery-item isotope-item">
                                      <a href="https://tickets.interpark.com/goods/22014517" target="_blank">
                                        <img class="img-fluid w-100" src="../assets/image/mainList/3.jpg"
                                          style="border-radius:20px;"
                                          data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                      </a>
                                    </div>

                                    <!-- #14 -->
                                    <div class="col-lg-3 col-sm-6 col-12 commercial gallery-item isotope-item">
                                      <a href="http://ticket.yes24.com/Perf/44040?Gcode=009_303" target="_blank">
                                        <img class="img-fluid w-100" src="../assets/image/mainList/4.jpg"
                                          style="border-radius:20px;"
                                          data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                      </a>
                                    </div>

                                    <!-- #15 -->
                                    <div class="col-lg-3 col-sm-6 col-12shortfilms gallery-item isotope-item">
                                      <a href="https://ticket.melon.com/performance/index.htm?prodId=207517"
                                        target="_blank">
                                        <img class="img-fluid w-100" src="../assets/image/mainList/1.jpg"
                                          style="border-radius:20px;"
                                          data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                      </a>
                                    </div>

                                    <!-- #16 -->
                                    <div class="col-lg-3 col-sm-6 col-12shortfilms gallery-item isotope-item">
                                      <a href="https://ticket.melon.com/performance/index.htm?prodId=207517"
                                        target="_blank">
                                        <img class="img-fluid w-100" src="../assets/image/mainList/1.jpg"
                                          style="border-radius:20px;"
                                          data-glightbox="title: To infinity and beyond; description: Iching biching chiching" />
                                      </a>
                                    </div>


                                  </div>
                                  <!-- 더보기 버튼 -->
                                  <button @click="toggleShow" class="row justify-content-center" id="nextBu"> 더보기
                                  </button>
                                </div>



                              </div>
                            </div>
                            <!-- part.2 end -->

                          </div>

                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </section>



            </main>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
/* eslint-disable */
// import isotopeInit from "../assets/script/isotope"
import GoodsDataService from '@/services/GoodsDataService';
import FbService from "@/services/FbService";
import BbService from "@/services/BbService";
import MbService from "@/services/MbService";
import LbService from "@/services/LbService";

export default {
  // el: '#bu',
  data() {
    return {
      show: false,
      goods: [],
      searchGoodsTitle: "",
      // fileDb: [],
      // 페이징을 위한 변수 정의
      page: 1,
      count: 0,
      pageSize: 40, // 한페이지당 몇개를 화면에 보여줄지 결정하는 변수
      fbBoardDesc:[],
     bbBoardDesc:[],
     mbBoardDesc:[],
     lbBoardDesc:[],
     fbTitle: "",
     bbTitle: "",
     mbTitle: "",
     lbTitle: "",

    }
  },
  methods: {
    toggleShow() {
      this.show = !this.show;
    },
    retrieveGoods() {
      GoodsDataService.getMain(this.searchGoodsTitle, this.page - 1, this.pageSize)
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
    this.retrieveGoods(); // 화면 실행시 조회
    // this.retrieveFileDb();
    this.retrieveFbBoardDesc();
    this.retrieveBbBoardDesc();
    this.retrieveMbBoardDesc();
    this.retrieveLbBoardDesc();
  }
}

</script>

<style>
.homeMain {
  margin-top: 300px;
}

* {
  box-sizing: border-box;
}

#nextBu {
  border-radius: 5px;
  background-color: white;
  font-size: 12px;
  margin: auto;
  display: block;
  margin-top: 20px;
  border: solid 1px gray;
  width: 20%;
}


/* @import url("../assets/css/home.css"); */
</style>