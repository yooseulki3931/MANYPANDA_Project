<template>
  <div class="app">
    <div class="freeBoardWrite">
      <section class="secondSection ">
        <div class="container " data-aos="fade-left" data-aos-delay="200">
          <div class="row">


            <!-- 상단 섹션 시작 -->
            <!-- 조회수 best 5 -->
            <table class="table" data-v-224097a6="" style="width: 30%; margin-left: 30px;">
              <thead data-v-224097a6="">
                <tr data-v-224097a6="" style="font-size: 22px;">
                  <th scope="col" data-v-224097a6="">
                    <a href="/community-lost-board"><img src="../../../assets/image/board/best.jpg" alt="">
                    </a>
                  </th>
                </tr>
              </thead>
              <tbody border="0" class="table-group-divider" data-v-224097a6="" style="text-align: center;">
                <tr v-for="(data, index) in lbBoardBest" :key="index" data-v-224097a6=""
                  style="font-size: 18px; background-color: rgb(255, 255, 255);">
                  <td data-v-224097a6="">
                    <a :href="`/lb/${data.lno}`" style="text-decoration: none;">
                      <font color="black" size="2px">{{ data.lbTitle }}</font>
                    </a>
                  </td>
                </tr>
              </tbody>
            </table>

            <!-- 댓글 best 5 -->
            <table class="table" data-v-224097a6="" style="width: 30%; margin-left: 30px;">
              <thead data-v-224097a6="">
                <tr data-v-224097a6="" style="font-size: 22px;">
                  <th scope="col" data-v-224097a6="">
                    <a href="/community-lost-board"><img src="../../../assets/image/board/coment.jpg" alt="">
                    </a>
                  </th>

                </tr>
              </thead>
              <tbody border="0" class="table-group-divider" data-v-224097a6="" style="text-align: center;">
                <tr v-for="(data, index) in lbBoardRcntBest" :key="index" data-v-224097a6=""
                  style="font-size: 18px; background-color: rgb(255, 255, 255);">
                  <td data-v-224097a6="">
                    <a :href="`/lb/${data.lno}`" style="text-decoration: none;">
                      <font color="black" size="2px">{{ data.lbTitle }}</font>
                    </a>
                  </td>
                </tr>
              </tbody>
            </table>

            <!-- 랜덤 배너 -->
            <table class="table" data-v-224097a6="" style="width: 30%; margin-left: 30px;">
              <thead data-v-224097a6="">
                <tr data-v-224097a6="" style="font-size: 22px;">
                  <th scope="col" data-v-224097a6="">
                    <a href="/community-lost-board" size="2px"><img src="../../../assets/image/board/showban.png"
                        alt="">
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

            <!-- 목록 삭제 수정 버튼 시작 -->
            <div style="margin:auto; text-align:center;">
              <div style="display:inline;">
                <div v-if="this.$store.state.auth.user">
                  <div class="button">
                    <button @click="update" class="editButton" style=" font-size: 12px;"><svg
                        xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen"
                        viewBox="0 0 16 16">
                        <path
                          d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z" />
                      </svg> <a style="text-decoration: none;">
                        <font color="black">수정</font>
                      </a></button>

                    <button class="deleteButton" style=" font-size: 12px;"><svg xmlns="http://www.w3.org/2000/svg"
                        width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
                        <path
                          d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z" />
                      </svg><a @click="deleteLb(lb.lno)" style="text-decoration: none;">삭제</a></button>
                  </div>
                </div>
              </div>
            </div>
            <div style="margin:auto; text-align:center;">
              <div style="display:inline;">

                <button class="uploadButton" style=" font-size: 12px;"
                  onclick="location.href='/community-lost-Board'"><svg xmlns="http://www.w3.org/2000/svg" width="16"
                    height="16" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
                    <path fill-rule="evenodd"
                      d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z" />
                  </svg>목록</button>
              </div>
            </div>
            <!-- 목록 삭제 수정 버튼 끝 -->

            <!-- 좋아요 버튼 시작 -->
            <div class="like">
              <button class="likeButton" style="  font-size: 12px;" @click="addLike"><svg
                  xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                  class="bi bi-suit-heart-fill" viewBox="0 0 16 16">
                  <path
                    d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z" />
                </svg></button>
              <span style=" font-size: 12px; color: red;"> Like{{ count.count }}</span>

            </div>
            <!-- 좋아요 버튼 끝 -->

            <!-- 게시판 디테일 뷰 시작 -->
            <div class="writeTable" style="margin-bottom:100px;   text-align: left; ">

              <table class="tableDetail" data-v-224097a6="">

                <thead data-v-224097a6="">
                  <tr data-v-224097a6="" style="font-size: 14px; width: 20%; ">
                    <th scope="col" data-v-224097a6="" style="text-align: center; width: 10%; margin: 10px;  ">
                      {{ lb.lbTitle }}
                    </th>
                  </tr>

                  <tr data-v-224097a6="" style="font-size: 14px;">
                    <th scope="col" data-v-224097a6="" style="text-align: center; width: 10%; margin: 10px; ">
                      {{ lb.nick }}
                    </th>
                  </tr>

                  <tr data-v-224097a6="" style="font-size: 14px;">
                    <th scope="col" data-v-224097a6="" style="text-align: center; width: 10%; margin: 10px;  ">
                      {{ lb.insertTime }}
                    </th>
                  </tr>
                </thead>

                <tbody class="borderDapanda">

                  <tr> <img v-if="lb.blobFile" style="width: 500px; height: 500px;" :src="lb.fileUrl" alt=""></tr>
                  <tr data-v-224097a6="" style="font-size: 14px;">
                    <td scope="col" data-v-224097a6="" style="text-align: center;  margin: 10px; ">
                      {{ lb.lbContent }}
                    </td>
                  </tr>
                </tbody>
              </table>

              <div v-if="lb.lbTag" data-v-224097a6="" style="font-size: 14px; text-align: center; margin: auto;">
                <div scope="col" data-v-224097a6="" style="text-align: center; margin: 10px;">
                  {{ lb.lbTag }}
                </div>
              </div>

            </div>
            <!-- 게시판 디테일 뷰 끝 -->

            <!-- 댓글입력 시작 -->
            <div style="margin: auto; text-align: center;">
              <div style="display: inline;">
                <div style="font-size: 14px; margin-bottom: 100px; margin-top:50px;">
                  <span scope="col" data-v-224097a6="" style="text-align: left; width: 10opx;  ">
                    Comment
                  </span>
                  <input type="text" placeholder="댓글을 입력하세요" style="font-size:14px; , 
              color:aliceblue; width: 60%; height: 40px; border-radius: 5px;" v-model="comm">

                  <button @click="addComment" style="font-size:14px; width: 60px; height: 40px; margin-left: 5px;
              border-radius: 2.5px; border: none;background-color: #dbdbdb!important;">등록</button>
                  <span>
                  </span>
                </div>

              </div>
            </div>
            <!-- 댓글입력 끝 -->

            <!-- 댓글 구현창 -->
            <div class="reply col-10 container" style="margin-bottom:50px; ">
              <div class="replyRe" v-for="(data, index) in comment" :key="index">
                <ul class="replyReList" :data-bs-target="`#div${data.commentId}`" aria-expanded="false"
                  aria-controls="collapseOne"
                  style="list-style:none; margin: auto; text-align: center; border-bottom: 1px solid gray;">
                  <li class="replyData" style="width:10%; display:inline-block; font-size: 12px;">{{ data.nick }}</li>
                  <li class="replyData" style="width:60%; display:inline-block; font-size: 12px;">{{ data.comm }}</li>
                  <li class="replyData" style="width:20%; display:inline-block; font-size: 12px;">{{ data.insertTime }}
                  </li>
                  <li style="width:10%; display:inline-block; font-size: 12px;">
                    <button style="border: none; background-color: white; color: gray;"
                      @click="deleteComment(data.commentId)" id="cart_delete">
                      <svg style="border: none;" xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                        fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16">
                        <path
                          d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z" />
                      </svg>
                    </button>
                  </li>
                </ul>

                <!-- 대댓글 입력 -->
                <div class="col-9 container" id="bu">
                  <div v-if="`show${data.commentId}`" class="row g-3">
                    <div :id="`div${data.commentId}`" class="accordion-collapse collapse show"
                      aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                      <div class="accordion-body">
                        <svg style="width: 20%; float: left;" xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                          fill="currentColor" class="bi bi-arrow-return-right" viewBox="0 0 16 16">
                          <path fill-rule="evenodd"
                            d="M1.5 1.5A.5.5 0 0 0 1 2v4.8a2.5 2.5 0 0 0 2.5 2.5h9.793l-3.347 3.346a.5.5 0 0 0 .708.708l4.2-4.2a.5.5 0 0 0 0-.708l-4-4a.5.5 0 0 0-.708.708L13.293 8.3H3.5A1.5 1.5 0 0 1 2 6.8V2a.5.5 0 0 0-.5-.5z" />
                        </svg>
                        <input type="text" placeholder="답글을 입력하세요" style="font-size:12px; border: 0; , 
                                  color:aliceblue; width: 60%; height: 30px; " v-model="reply[data.commentId]">
                        <button @click="addReply(data.commentId)" style="font-size:12px; width: 60px; height: 20px; margin-left: 5px;
                                  border-radius: 2.5px; border: none; background-color: #dbdbdb!important;">등록</button>
                      </div>
                    </div>
                  </div>
                  <!-- 더보기 버튼 -->
                </div>

                <!-- 대댓글 구현창 -->
                <div>
                  <div v-for="(reply, replyId) in currentReply" :key="replyId">
                    <div class="col-9 container" v-if="data.commentId == reply.commentId">
                      <li class="replyData" style="width:20%; float: left; display:inline-block; font-size: 12px;"><svg
                          xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                          class="bi bi-arrow-return-right" viewBox="0 0 16 16">
                          <path fill-rule="evenodd"
                            d="M1.5 1.5A.5.5 0 0 0 1 2v4.8a2.5 2.5 0 0 0 2.5 2.5h9.793l-3.347 3.346a.5.5 0 0 0 .708.708l4.2-4.2a.5.5 0 0 0 0-.708l-4-4a.5.5 0 0 0-.708.708L13.293 8.3H3.5A1.5 1.5 0 0 1 2 6.8V2a.5.5 0 0 0-.5-.5z" />
                        </svg></li>
                      <li class="replyData" style="width:20%; display:inline-block; font-size: 12px;">{{ data.nick }}님의
                        댓글의 답글</li>
                      <li class="replyData" style="width:10%; display:inline-block; font-size: 12px;">{{ reply.nick }}
                      </li>
                      <li class="replyData" style="width:40%; display:inline-block; font-size: 12px;">{{ reply.reply }}
                      </li>
                      <li style="width:10%; display:inline-block; font-size: 12px;">
                        <button style="border: none; background-color: white; color: gray;"
                          @click="deleteReply(reply.replyId)" id="cart_delete">
                          <svg style="float: right;" xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                            fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16">
                            <path
                              d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z" />
                          </svg>
                        </button>
                      </li>

                    </div>
                  </div>
                </div>


              </div>
            </div>


          </div>
        </div>
      </section>

    </div>
  </div>

</template>

<script>
/* eslint-disable */
import LbService from "../../../services/LbService";
import LbLikeService from "@/services/LbLikeService";
import LbCommentService from '@/services/LbCommentService';
import LbReplyService from '@/services/LbReplyService'

export default {

  data() {
    return {
      lb: [],
      lbBoardBest: [],
      lbLike: [],
      currentLb: null,
      currentIndex: -1,
      name: "",
      lbBoardBest: [],
      lbBoardRcntBest: [],

      comm: "",
      comment: null,
      showReply: false,
      id: "",
      reply: [],
      currentReply: null,
      show: false,

      OnOff: false,

      // 좋아요 변수
      // like: []
      likecnt: 0,
      dislikecnt: 0,
      order: {
        rePle: "",
      },

      // 이미지 랜덤 배너
      nickname: "",
      desc: "",
      randomProfile: {
        name: require("../../../assets/image/communityBn/monstar.jpg"),
      },
      imgList: [
        { name: require("../../../assets/image/communityBn/monstar.jpg") },
        { name: require("../../../assets/image/communityBn/seventeen.jpg") },
        { name: require("../../../assets/image/communityBn/wisdom.jpg") },
        { name: require("../../../assets/image/communityBn/jd.png") },
        { name: require("../../../assets/image/communityBn/joy.png") }
      ],
      count: ""

    }
  },

  methods: {

    // 조회수 best 조회
    retrieveLbBoardBest() {
      LbService.getLbBoardBest()
        // 성공하면 .then() 결과가 전송됨
        .then((response2) => {
          this.lbBoardBest = response2.data;
          // 디버깅 콘솔에 정보 출력
          console.log(response2.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },

    // 댓글수 best 조회
    retrieveLbBoardRcntBest() {
      LbService.getLbBoardRcntBest()

        // 성공하면 .then() 결과가 전송됨
        .then((response3) => {
          this.lbBoardRcntBest = response3.data;
          // 디버깅 콘솔에 정보 출력

          console.log(response3.data);

        })

        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },

    // like 조회 함수
    retrieveLike(lno, userId) {
      LbLikeService.getLike(lno, userId)
        .then((response) => {
          console.log(response.data);
          if (response.data) {
            this.OnOff = true;
          }
        })
        .catch((e) => {
          console.log(e);
        })
    },

    // TODO : lblike
    CountLike() {
      LbLikeService.countLike(this.$route.params.lno)
        .then((response) => {
          this.count = response.data;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        })
    },

    // like 등록 함수
    addLike() {
      if (this.OnOff) {
        alert("이미 추천한 글입니다.");
      } else if (this.$store.state.auth.user) {
        let data = {
          lno: this.$route.params.lno,
          userId: this.$store.state.auth.user.id
        }
        LbLikeService.create(data)
          .then((response) => {
            this.lbLike.lbLikeId = response.data.lbLikeId;
            console.log(response.data);
            this.OnOff = true;
            this.CountLike();
          })
          .catch((e) => {
            console.log(e);
          })
      } else {
        alert("로그인이 필요한 서비스입니다.");
      }
    },

    // 게시판 번호로 상세 조회
    retrieveLbById(lno) {
      LbService.get(lno)
        .then((response) => {
          this.lb = response.data;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    // 삭제 버튼으로 게시글 삭제      
    deleteLb(lno) {
      if (this.$store.state.auth.user.nick == this.lb.nick) {
        LbService.delete(lno)
          .then((response) => {
            console.log(response);
            this.$router.push("/community-lost-Board");
          })
          .catch((e) => {
            console.log(e);

            this.message = "삭제 시 에러가 발생했습니다. " + e.message;
            // toast 알림창 호출
            // toast 알림창 호출
            // 1. 알림창 위치
            this.$toastr.options.positionClass = "toast-top-center";
            // 2. 알램창 호출
            this.$toastr.e("에러", this.message, { timeOut: 1000 });
          });

      } else {
        alert("삭제권한이 없습니다");
      }

    },

    // 이미지 랜덤
    randomImage() {
      let randomNumber = Math.floor(Math.random() * this.imgList.length);
      this.randomProfile = this.imgList[randomNumber];
      console.log(this.randomProfile);
    },

    // 댓글 조회
    retrieveLbComment(lno) {

      LbCommentService.getAll(lno)
        .then((response) => {
          this.comment = response.data; // 스프링부트에서 전송한 데이터
          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },

    // 댓글 삭제
    deleteComment(num) {
      LbCommentService.delete(num)
        .then((response) => {
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        })
      this.retrieveLbComment(this.$route.params.lno);
      this.retrieveLbReply(this.$route.params.lno);
    },

    // 대댓글 조회
    retrieveLbReply(lno) {
      retrieveLbReply.getAll(lno)
        .then((response) => {
          this.currentReply = response.data; // 스프링부트에서 전송한 데이터
          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },

    // 댓글 생성
    addComment() {
      if (!this.$store.state.auth.user) {
        alert("로그인이 필요한 서비스입니다")
      }
      else {
        let data = {
          lno: this.lb.lno,
          nick: this.$store.state.auth.user.nick,
          comm: this.comm
        };

        // insert 요청 함수 호출(axios 공통함수 호출)
        LbCommentService.create(data)
          // 성공하면 then() 결과가 전송됨
          .then(response => {
            this.comment.commentId = response.data.commentId;
            // 콘솔 로그 출력(response.data)
            console.log(response.data);
            this.retrieveMbComment(this.$route.params.mno);
            this.retrieveMbReply(this.$route.params.mno);
          })
          // 실패하면 .catch() 결과가 전송됨
          .catch(e => {
            console.log(e);
          });

        this.retrieveLbComment(this.$route.params.lno);
        this.retrieveLbReply(this.$route.params.lno);

      }
    },

    // 대댓글 조회
    retrieveLbReply(lno) {
      LbReplyService.getAll(lno)
        .then((response) => {
          this.currentReply = response.data; // 스프링부트에서 전송한 데이터
          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },

    // 대댓글 생성
    addReply(num) {
      if (!this.$store.state.auth.user) {
        alert("로그인이 필요한 서비스입니다")
      }
      else {
        let data = {
          lno: this.lb.lno,
          commentId: num,
          nick: this.$store.state.auth.user.nick,
          reply: this.reply[num]
        }

        LbReplyService.create(data)
          .then(response => {
            this.reply.replyId = response.data.replyId;
            // 콘솔 로그 출력(response.data)
            console.log(response.data);
            this.retrieveMbComment(this.$route.params.mno);
            this.retrieveMbReply(this.$route.params.mno);

          })
          // 실패하면 .catch() 결과가 전송됨
          .catch(e => {
            console.log(e);
          });

        this.retrieveLbComment(this.$route.params.lno);
        this.retrieveLbReply(this.$route.params.lno);

      }
    },

    // 대댓글 삭제
    deleteReply(num) {
      LbReplyService.delete(num)
        .then((response) => {
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        })
      this.retrieveLbComment(this.$route.params.lno);
      this.retrieveLbReply(this.$route.params.lno);
    },

    toggleShow(num) {
      "show" + num == !("show" + num);
    },

    update() {
      if (this.$store.state.auth.user.nick == this.lb.nick) {
        location.href = `/lost-Board-Edit/${this.lb.lno}`;
      } else {
        alert("수정 권한이 없습니다");
      }
    }

  },

  mounted() {
    this.retrieveLbBoardRcntBest();
    this.retrieveLbBoardBest();
    this.retrieveLbById(this.$route.params.lno);
    this.retrieveLbComment(this.$route.params.lno);
    this.retrieveLbReply(this.$route.params.lno);
    this.retrieveLike(this.$route.params.lno, this.$store.state.auth.user.id);
    // console.log(this.$store.state.auth.user.id);
    this.CountLike();

  },


};

</script>

<style>
.freeBoardWrite {
  margin-top: 350px;
}

.table {
  justify-content: center;
  margin-bottom: 50px;

}

.writeTable {
  justify-content: center;
  margin-bottom: 50px;
}

.tableDetail {
  justify-content: center;
  margin: auto;
}

.search {
  height: 30px;
  background-color: rgb(101, 190, 145);
  border-radius: 2.5px;
  border: none;
}

/* .cancleButton {
  height: 40px;
  background-color: rgba(255, 255, 255);
  border-radius: 2.5px;
  margin-left: 700px;
  border: none;
  width: 60px;
} */

.editButton {
  height: 40px;
  background-color: rgba(255, 255, 255);
  border-radius: 2.5px;
  border: none;
  width: 60px;
}

.deleteButton {
  height: 40px;
  background-color: rgba(255, 255, 255);
  border-radius: 2.5px;
  margin-left: 10px;
  border: none;
  width: 60px;
}

.uploadButton {
  height: 40px;
  background-color: rgba(255, 255, 255);
  border-radius: 2.5px;
  margin-left: 10px;
  border: none;
  width: 60px;
}

.likeButton {
  height: 40px;
  color: red;
  background-color: white;
  border-radius: 2.5px;
  margin-left: 580px;
  border: none;
  width: 80px;
  margin-bottom: 30px;
}

.button {
  margin-bottom: 10px;
}

.category {
  border-radius: 5px;
}

.borderDapanda {
  margin-top: 20px;
  margin-bottom: 20px;
  height: 500px;
  border-top: solid 1px #dbdbdb !important;
  border-bottom: solid 1px #dbdbdb !important;
}

.nextBu {
  border-radius: 5px;
  background-color: white;
  font-size: 12px;
  margin: auto;
  display: block;
  margin-top: 20px;
  border: solid 1px gray;
  width: 20%;
}

.reply {
  margin: auto;
  text-align: center;
}
</style>