<template>
  <div>
    <div class="freeBoard">
      <section class="secondSection ">
        <div class="container " data-aos="fade-left" data-aos-delay="200">
          <div class="row">

            <!-- 상단 섹션 시작 -->
            <!-- 조회수 best 5 -->
            <table class="table" data-v-224097a6="" style="width: 30%; margin-left: 30px;">
              <thead data-v-224097a6="">
                <tr data-v-224097a6="" style="font-size: 22px;">
                  <th scope="col" data-v-224097a6="">
                    <a href="/community-moim-board"><img src="../../../assets/image/board/best.jpg" alt="">
                    </a>
                  </th>
                </tr>
              </thead>
              <tbody border="0" class="table-group-divider" data-v-224097a6="" style="text-align: center;"  
              >
                <tr v-for="(data, index) in mbBoardBest" :key="index" data-v-224097a6="" style="font-size: 18px; background-color: rgb(255, 255, 255);">
                  <td data-v-224097a6="">
                    <a :href="`/mb/${data.mno}`" style="text-decoration: none;" ><font color="black" size="2px" >{{ data.mbTitle }}</font></a>
                  </td>
                </tr>
              </tbody>
            </table>

             <!-- 댓글 best 5 -->
             <table class="table" data-v-224097a6="" style="width: 30%; margin-left: 30px;">
              <thead data-v-224097a6="">
                <tr data-v-224097a6="" style="font-size: 22px;">
                  <th scope="col" data-v-224097a6="">
                    <a href="/community-moim-board"><img src="../../../assets/image/board/coment.jpg" alt="">
                    </a>
                  </th>

                </tr>
              </thead>
              <tbody border="0" class="table-group-divider" data-v-224097a6="" style="text-align: center;"  
              >
                <tr v-for="(data, index) in mbBoardRcntBest" :key="index" data-v-224097a6="" style="font-size: 18px; background-color: rgb(255, 255, 255);">
                  <td data-v-224097a6="">
                    <a :href="`/mb/${data.mno}`" style="text-decoration: none;" ><font color="black" size="2px" >{{ data.mbTitle }}</font></a>
                  </td>
                </tr>
              </tbody>
            </table>

            <!-- 랜덤 배너 -->
            <table class="table" data-v-224097a6="" style="width: 30%; margin-left: 30px;">
              <thead data-v-224097a6="">
                <tr data-v-224097a6="" style="font-size: 22px;">
                  <th scope="col" data-v-224097a6="">
                    <a href="/community-moim-board" size="2px"><img src="../../../assets/image/board/showban.png" alt="">
                    </a>
                  </th>

                </tr>
              </thead>
              <tbody class="table-group-divider" data-v-224097a6="" style="text-align: center;">
                <tr data-v-224097a6="" style="font-size: 18px; background-color: rgb(255, 255, 255);">
                  <td data-v-224097a6="">
                      <div class="profile_img">
                        <img :src="randomProfile.name" />
                        <button @click="randomImage" style="background-color:white; border:none; font-size:10px">
                          <img src="" class="randomBtn" />
                          next
                        </button>
                      </div>
                  </td>
                </tr>


              </tbody>
            </table>
            <!-- 상단 섹션 끝 -->

            <div class="searchButton">
              <!-- 검색 카테고리 시작 -->
              <select class="search" 
              v-model="mb_ctitle"
              name="count" 
              data-title="선택" 
              style="width: 8%; font-size: 12px;">
                <option>스터디</option>
                <option>취미</option>
                <option value="" default>전체</option>
              </select>
              <!-- 검색 카테고리 끝 -->

              <!-- 검색 창 시작 -->
              <input class="search" 
                     v-model="mb_title" @keyup.enter="retrieveMb();"
                     type="text" name="search" id="searchId" placeholder="검색하세요..."
                style="width: 25%; font-size: 12px;">
              <!-- 검색 창 끝 -->  
              
              <!-- 글쓰기 버튼 시작 -->
              <button class="button" style=" font-size: 12px;" @click="write"><svg
                  xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                  class="bi bi-pencil-square" viewBox="0 0 16 16">
                  <path
                    d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
                  <path fill-rule="evenodd"
                    d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" />
                </svg>글쓰기</button>
                <!-- 글쓰기 버튼 시작 -->
            </div>

            <!-- 모임게시판 목록 조회 시작 -->
            <table class="table" data-v-224097a6="">
              <thead data-v-224097a6="">
                <tr data-v-224097a6="" style="font-size: 18px; text-align: center;">
                  <th scope="col" data-v-224097a6="" style="width: 15%;">카테고리</th>
                  <th scope="col" data-v-224097a6="" style="width: 50%;">제목</th>
                  <th scope="col" data-v-224097a6="" style="width: 15%;">이름</th>
                  <th scope="col" data-v-224097a6="" style="width: 15%;">조회수</th>
                  <th scope="col" data-v-224097a6="" style="width: 15%;">날짜</th>
                </tr>
              </thead>

              <tbody class="table-group-divider" 
                     v-for="(data, index) in mb" :key="index"
                      data-v-224097a6="" style="text-align: center;">
                <tr data-v-224097a6="" style="font-size: 14px; background-color: rgb(255, 255, 255);">
                  <td data-v-224097a6="">{{ data.mbCtitle }}</td>
                  <td data-v-224097a6="" ><a :href="`/mb/${data.mno}`" style="text-decoration: none;" ><font color="black" >{{ data.mbTitle }}</font></a></td>
                  <td data-v-224097a6="">{{ data.nick }}</td>
                  <td data-v-224097a6="">{{ data.mbCnt }}</td>
                  <td data-v-224097a6="">{{ data.insertTime }}</td>
                </tr>
              </tbody>

            </table>
            <!-- 모임게시판 목록 조회 시작 -->

            <!-- page 바 시작 -->
            <div class="rowPage">
              <div class="page">
                <b-pagination v-model="page" :total-rows="count" :per-page="pageSize" pills size="sm" prev-text="<" next-text=">"
                  @change="handlePageChange"></b-pagination>
              </div>
            </div>
            <!-- page 바 끝 -->

            </div>
        </div>
      </section>

    </div>
  </div>
</template>

<script>
import MbService from "../../../services/MbService";

export default {
  data() {
    return {
      mb: [],
      mb_title: "",
      mb_ctitle: "",
      mbBoardBest:[],
      mbBoardRcntBest:[],

      // 페이징 처리 변수
      page: 1,
      count: 0,
      pageSize: 15,

      // 이미지 랜덤 배너
      nickname: "",
      desc: "",
      randomProfile: {
        name: require("../../../assets/image/communityBn/monstar.jpg"),
      },
      imgList:[
        {name:require("../../../assets/image/communityBn/monstar.jpg")},
        {name:require("../../../assets/image/communityBn/seventeen.jpg")},
        {name:require("../../../assets/image/communityBn/wisdom.jpg")},
        {name:require("../../../assets/image/communityBn/jd.png")},
        {name:require("../../../assets/image/communityBn/joy.png")}

      ]

    };
  },
  methods: {

    // 조회수 best 조회
    retrieveMbBoardBest() {
      MbService.getMbBoardBest()
         // 성공하면 .then() 결과가 전송됨
        .then((response2) => {
          this.mbBoardBest = response2.data;
          // 디버깅 콘솔에 정보 출력
          console.log(response2.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
      },

    // 댓글수 best 조회
    retrieveMbBoardRcntBest() {
      MbService.getMbBoardRcntBest()
      
         // 성공하면 .then() 결과가 전송됨
        .then((response3) => {
          this.mbBoardRcntBest = response3.data;
          // 디버깅 콘솔에 정보 출력

          console.log(response3.data);
          
        })
        
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
      },
      
      // 게시판 목록 조회 (카테고리 선택 - 제목 검색)
      retrieveMb() {
      MbService.getAll(
        this.mb_ctitle, // select box 선택된 값
        this.mb_title, // 제목 검색
        this.page - 1, 
        this.pageSize)
         // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          const { mb, totalItems } = response.data; // springboot 의 전송된 맵 정보
          this.mb = mb;        // 스프링부트에서 전송한 데이터
          this.count = totalItems; // 스프링부트에서 전송한 페이지정보(총 건수)

          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
      },

    // Todo : handlePageChange, handlePageSizeChange
    handlePageChange(value) {
      this.page = value;
      this.retrieveMb();
    },

    // 이미지 랜덤
    randomImage(){
      let randomNumber = Math.floor(Math.random()*this.imgList.length);
      this.randomProfile = this.imgList[randomNumber];
      console.log(this.randomProfile);
    },

    // 글쓰기
    write() {
      if(this.$store.state.auth.user) {
        location.href='/moim-Board-Write';
      } else {
        alert("로그인이 필요한 서비스입니다.");
        location.href='/login';
      }

    }

  },
  mounted() {
    this.retrieveMbBoardBest();
    this.retrieveMbBoardRcntBest();
    this.retrieveMb();
  },
}
</script>

<style>
.freeBoard {
  margin-top: 350px;
}

.table {
  justify-content: center;
  margin-bottom: 70px;
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
  background-color: #ffffff;
  border-radius: 2.5px;
  margin-left: 350px;
  border: none;
  display: inline-block;
}

.searchButton {
  margin-bottom: 50px;
  margin-left: 200px;
  
   text-align: center;
}

.page{
  margin: auto;
  text-align: center;
  display: inline-block;
}

.rowPage{
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
 font-weight:bold;
 background-color: #f1f1f1;
 border-color: #ccc;
 
}

.page-link:focus, .page-link:hover {
  color: #000;
  background-color: #fafafa; 
  border-color: #ccc;
}
</style>