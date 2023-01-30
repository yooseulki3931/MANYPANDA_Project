<template>
  <div class="dapandaMain">
    <div class="container " data-aos="fade-left" data-aos-delay="200">
      <div class="row">

        <!-- carousel 시작 -->
        <div v-if="goods" style="margin:auto; text-align:center;">
          <div style="display:inline;">

            <table class="table" data-v-224097a6="" style="width: 25%; margin-left: 0px;">
              <thead data-v-224097a6="" style="width: 25%;">
                <tr data-v-224097a6="" style="font-size: 22px;">
                  <th scope="col" data-v-224097a6="">
                    <a href="/dapnada" size="2px">
                    </a>
                  </th>
                </tr>
              </thead>

              <tbody class="table-group-divider" data-v-224097a6="" style="text-align: center; width: 25%;">
                <tr data-v-224097a6="" style="font-size: 18px; background-color: rgb(255, 255, 255);">
                  <td data-v-224097a6="">
                    <div>
                      <router-link :to="`/dapanda/detail/${random1}`">
                        <img :src="goods[random1].fileUrl" alt="" style="width:420px; height:250px;" />
                      </router-link>
                    </div>
                  </td>
                  <td data-v-224097a6="">
                    <div>
                      <router-link :to="`/dapanda/detail/${random2}`">
                        <img :src="goods[random2].fileUrl" alt="" style="width:420px; height:250px;" />
                      </router-link>
                    </div>
                  </td>
                  <td data-v-224097a6="">
                    <div>
                      <router-link :to="`/dapanda/detail/${random3}`">
                        <img :src="goods[random3].fileUrl" alt="" style="width:420px; height:250px;" />
                      </router-link>
                    </div>
                  </td>
                </tr>
                <th>

                </th>
              </tbody>
            </table>


          </div>
        </div>
        <!-- carousel 끝 -->

        <!-- 카테고리 & 글쓰기 버튼 시작 -->
        <div class="searchButton">
          <select class="search" v-model="category" name="count" data-title="선택" style="width: 8%; font-size: 12px;">
            <option value="디지털기기">디지털기기</option>
            <option value="의류">의류</option>
            <option value="뷰티/미용">뷰티/미용</option>
            <option value="인테리어">인테리어</option>
            <option value="생활가전">생활가전</option>
            <option value="기타">기타</option>
            <option value="" default>전체</option>
          </select>
          <input class="search" v-model="title" @keyup.enter="retrieveGoods();" type="text" name="search" id="searchId"
            placeholder="검색하세요..." style="width: 25%;  font-size: 12px;">
          <button class="button" style=" font-size: 12px;" @click="addGoods"><svg xmlns="http://www.w3.org/2000/svg"
              width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
              <path
                d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
              <path fill-rule="evenodd"
                d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" />
            </svg>글쓰기</button>
        </div>
        <!-- 카테고리 & 글쓰기 버튼 끝 -->

        <!-- 중고물품 리스트 시작 -->
        <table class="table" style="margin-bottom:100px">
          <thead>
            <tr style="font-size: 18px;">
              <th scope="col" style="width: 5%;">카테고리</th>
              <th scope="col" style="width: 10%;">이미지</th>
              <th scope="col" style="width: 30%;">제목 </th>
              <th scope="col" style="width: 5%;">가격 </th>
              <th scope="col" style="width: 5%;">닉네임 </th>
              <th scope="col" style="width: 5%;">위치 </th>
              <th scope="col" style="width: 5%;">판매여부 </th>
              <th scope="col" style="width: 5%;">날짜 </th>
            </tr>
          </thead>
          <tbody v-for="(data, goodsId) in goods" :key="goodsId" class="table-group-divider">
            <tr style="font-size: 14px; background-color: rgb(255, 255, 255); text-align: center;">
              <!-- <td>{{ data.goodsId }}</td> -->
              <td>{{ data.category }}</td>
              <td><img :src="data.fileUrl" style="width:100px; height: 100px;" alt=""></td>
              <td><router-link :to="'/dapanda/detail/' + data.goodsId">{{ data.title }}</router-link></td>
              <td>{{ data.sellPrice }}원</td>
              <td>{{ data.sellerId }}</td>
              <td>{{ data.sellingAreaId }}</td>
              <td>{{ data.status }}</td>
              <td>{{ data.insertTime }}</td>
            </tr>
          </tbody>
        </table>
  
        <!-- page 바 시작 -->
        <div class="rowPage">
          <div class="page">
            <b-pagination v-model="page" :total-rows="count" :per-page="pageSize" pills size="sm" prev-text="<"
              next-text=">" @change="handlePageChange"></b-pagination>
          </div>
        </div>
        <!-- page 바 끝 -->

        <!-- 중고물품 리스트 끝 -->
      </div>
    </div>
  </div>

</template>

<script>
/* eslint-disable */
import GoodsDataService from '@/services/GoodsDataService';
import { Glide, GlideSlide } from 'vue-glide-js'
import { RouterLink } from 'vue-router';

export default {
  data() {
    return {
      goods: [],
      category: "",
      title: "",
      // address: this.$route.params.address,
      // fileDb: [],
      // 페이징을 위한 변수 정의
      page: 1,
      count: 0,
      pageSize: 15, // 한페이지당 몇개를 화면에 보여줄지 결정하는 변수
      random1: "",
      random2: "",
      random3: ""
    };
  },
  methods: {

    // 상품 조회
    retrieveGoods() {
      GoodsDataService.getAll(
        this.category,
        this.title,
        // this.address,
        this.page - 1,
        this.pageSize)
        .then((response) => {
          const { goods, totalItems } = response.data; // springboot 의 전송된 맵 정보
          this.goods = goods; // 스프링부트에서 전송한 데이터
          this.count = totalItems; // 스프링부트에서 전송한 페이지정보(총 건수)
          this.random1 = Math.floor(Math.random() * this.goods.length);
          this.random2 = Math.floor(Math.random() * this.goods.length);
          this.random3 = Math.floor(Math.random() * this.goods.length);
          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },

    handlePageChange(value) {
      this.page = value; // 매개변수값으로 현재페이지 변경
      // 재조회 함수 호출
      this.retrieveGoods();
    },

    // 상품 등록
    addGoods() {
      if (this.$store.state.auth.user) {
        location.href = "/dapanda-board-write";
      } else {
        alert("로그인이 필요한 서비스입니다.");
        location.href = "login";
      }
    }
  },
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    }
  },
  mounted() {
    this.retrieveGoods(); // 화면 실행시 조회
  },
  components: {
    [Glide.name]: Glide,
    [GlideSlide.name]: GlideSlide
  }

}

</script>

<style lang="scss">
.dapandaMain {
  margin-top: 300px;
}

.search {
  height: 30px;
  background-color: #ffffff;
  border-radius: 5px;
  margin-left: 5px;
  display: inline-block;
}

.button {
  height: 40px;
  background-color: rgb(255, 255, 255);
  border-radius: 2.5px;
  margin-left: 500px;
  border: none;
}

.searchButton {
  margin-bottom: 50px;
  margin-left: 200px;

  text-align: center;
}

article {
  float: left;
  margin-left: 20px;
  width: 410px;
}

.table {
  justify-content: center;
  text-align: center;
}

td,
th {
  text-align: center;
  vertical-align: middle;
}

.carousel-inner {
  margin: 0 auto;
  overflow: hidden;
  padding-top: 10px;
  background-color: rgb(133, 133, 133);
  width: 1400px;
  height: 400px;
  margin-bottom: 100px;
}

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;

  .demo {
    .glide {
      &__slide {
        display: flex;
        border: 2px solid #ccc;
        height: 200px;
        align-items: center;
        justify-content: center;
        color: #aaa;
        font-size: 36px;
        font-weight: 600;
        border-radius: 5px;
        transition: all .3s;
        opacity: .3;

        &--active {
          border: none;
          color: #fff;
          opacity: 1;
          // background: linear-gradient(-45deg,#ed145b,#7b31f4);
          background-color: rgb(159, 226, 159);
        }
      }
    }
  }
}

.page {
  margin: auto;
  text-align: center;
  display: inline-block;
}

.rowPage {
  margin: auto;
  text-align: center;
}

.page-link {
  color: #000;
  background-color: #fff;
  border: 1px solid #ccc;
}

.page-item.active .page-link {
  z-index: 1;
  color: #555;
  font-weight: bold;
  background-color: #f1f1f1;
  border-color: #ccc;

}

.page-link:focus,
.page-link:hover {
  color: #000;
  background-color: #fafafa;
  border-color: #ccc;
}

.carousel-inner>.caoursel-item>img {
  top: 0;
  left: 0;
  max-width: 100px;
  max-height: 100%;
}
</style>