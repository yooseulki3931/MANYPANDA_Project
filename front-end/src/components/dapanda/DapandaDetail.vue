
<template>
  <div class="app">
    <div class="freeBoardWrite container">
      <section class="secondSection ">
        <div class="container " data-aos="fade-left" data-aos-delay="200">
          <div class="row">

            <!-- 목록 삭제 수정 버튼 시작 -->
            <div>
              <div class="">
                <div v-if="this.$store.state.auth.user">
                  <button @click="updateGood" class="editButton" style=" font-size: 12px;"><svg
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
                    </svg><a @click="deleteGoods()" style="text-decoration: none;">삭제</a></button>
                </div>
                <button class="uploadButton" style=" font-size: 12px;" onclick="location.href='/dapanda'"><svg
                    xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-list"
                    viewBox="0 0 16 16">
                    <path fill-rule="evenodd"
                      d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z" />
                  </svg>목록</button>

                <button @click="Complete" v-if="checkuser" class="complateButton">
                  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                    class="bi bi-check-lg" viewBox="0 0 16 16">
                    <path
                      d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z" />
                  </svg>판매 완료
                </button>
              </div>
            </div>
            <!-- 목록 삭제 수정 버튼 끝 -->

            <!-- 좋아요 버튼 시작 -->
            <div class="like">
              <button class="likeButton" style="  font-size: 12px;" @click="addCart"><svg
                  xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                  class="bi bi-suit-heart-fill" viewBox="0 0 16 16">
                  <path
                    d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z" />
                </svg></button>
              <span style=" font-size: 12px; color: red;"> Like {{ currentGoods.viewCount }}</span>

            </div>
            <!-- 좋아요 버튼 끝 -->

            <!-- 게시글 디테일 시작 -->
            <div class="row goods_wrapper">
              <div class="col-md-6 col-sm-12 col-xs-12 goods_thumbs_wrap">
                <div class="_carousel_count_numbering carousel-count-numbering" style="display: none;"></div>
                <div class="goods_thumbs" id="prod_image_list">
                  <div class="holder">
                    <div class="owl-carousel prod-owl-list owl-theme owl-loaded">
                      <div class="owl-stage-outer">
                        <div class="owl-stage"
                          style="transform: translate3d(0px, 0px, 0px); transition: all 0s ease 0s; width: 500px;">
                          <div class="owl-item active" style="width: 500px; margin-right: 0px;">
                            <div class="item _item"><img style="width: 500px; height: 350px; margin-left: 50px;"
                                :src="imageUrl.fileDb[currentGoods.goodsId - 1].fileUrl" alt="">

                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-sm-12 col-xs-12  goods_form_wrap">
                <div class="goods_form" id="prod_goods_form">
                  <div class="storySection" style="margin-bottom:50px">
                    <div class="storyView" style="text-align: left; font-size: 14px;">
                      <p>DAPANDA</p>
                      <tr>
                        <th scope="col" style="text-align:center ; width: 40px; margin-left: 10px; ">
                          제목 :
                        </th>
                        <td scope="col" style="text-align: ;  margin-left: 10px; ">
                          {{ currentGoods.title }}
                        </td>
                      </tr>

                      <tr>
                        <th scope="col" style="text-align: center; width: 40px; margin-left: 10px; ">
                          가격 :
                        </th>
                        <td scope="col" style="text-align: ;  margin-left: 10px; ">
                          {{ currentGoods.sellPrice }}원
                        </td>
                      </tr>

                      <tr>
                        <th scope="col" style="text-align:center ; width: 40px; margin-left: 10px; ">
                          이름 :
                        </th>
                        <td scope="col" style="text-align: ;  margin-left: 10px; ">
                          {{ currentGoods.sellerId }}
                        </td>
                      </tr>

                      <tr>
                        <th scope="col" style="text-align:center ; width: 40px; margin-left: 10px; ">
                          Tag :
                        </th>
                        <td scope="col" style="text-align: ;  margin-left: 10px; ">
                          {{ currentGoods.tag }}
                        </td>
                      </tr>

                      <tr>
                        <th scope="col" style="text-align:center ; width: 40px; margin-left: 10px; ">
                          위치 :
                        </th>
                        <td scope="col" style="text-align: ;  margin-left: 10px; ">
                          {{ currentGoods.sellingAreaId }}
                        </td>
                      </tr>

                      <tr>
                        <th scope="col" style="text-align:center ; width: 40px; margin-left: 10px; ">
                          날짜 :
                        </th>
                        <td scope="col" style="text-align: ;  margin-left: 10px; ">
                          {{ currentGoods.insertTime }}
                        </td>
                      </tr>

                      <tr>
                        <th scope="col" class="borderDapanda"
                          style="text-align:center ;  margin-left: 10px; width: 80px;">
                          내용 :
                        </th>
                        <td scope="col" class="borderDapanda" style="text-align: ;  margin-left: 10px; width: 750px;">
                          {{ currentGoods.description }}
                        </td>
                      </tr>
                    </div>
                  </div>
                  <div>
                  </div>
                </div>
              </div>
            </div>
            <!-- 게시글 디테일 끝 -->

            <!-- 댓글입력 시작 -->
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
                      <svg style="border: none;" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                        class="bi bi-x-lg" viewBox="0 0 16 16">
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
                        <svg style="width: 20%; float: left;" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                          class="bi bi-arrow-return-right" viewBox="0 0 16 16">
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
                          <svg style="float: right;" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                            class="bi bi-x-lg" viewBox="0 0 16 16">
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
import GoodsDataService from '@/services/GoodsDataService';
import FileDbDataService from '@/services/FileDbDataService';
import GoodCommentService from '@/services/GoodCommentService';
import GoodReplyService from '@/services/GoodReplyService'
import GoodCartService from '@/services/GoodCartService';
import router from '@/router';
import RandomImage from "../dapanda/RandomImage.vue";

export default {
  data() {
    return {
      currentGoods: null,
      // 좋아요 변수
      // like: []
      likecnt: 0,
      dislikecnt: 0,
      goods: [],
      imageUrl: [],
      comm: "",
      comment: null,
      showReply: false,
      id: "",
      reply: [],
      currentReply: null,
      show: false,
      goodcart: [],
      OnOff: false,
      cart: null,
      checkuser: false
    }

  },
  components: {
    RandomImage
  },

  methods: {
    // 댓글 삭제
    deleteComment(num) {
      GoodCommentService.delete(num)
        .then((response) => {
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        })
      this.retrieveGoodComment(this.$route.params.goodsId);
      this.retrieveGoodReply(this.$route.params.goodsId);

    },
    // 대댓글 삭제
    deleteReply(num) {
      GoodReplyService.delete(num)
        .then((response) => {
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        })
      this.retrieveGoodComment(this.$route.params.goodsId);
      this.retrieveGoodReply(this.$route.params.goodsId);

    },

    // 유저 확인
    UserCheck() {
      if (this.currentGoods.sellerId == this.$store.state.auth.user.nick) {
        this.checkuser = true;
      }
    },

    // 판매완료 버튼실행
    Complete() {
      if (this.currentGoods.sellerId != this.$store.state.auth.user.nick) {
        alert("본인 상품이 아닙니다");
      } else if (this.currentGoods.state == '판매완료') {
        alert("이미 판매 완료된 상품입니다.");
      } else {
        this.currentGoods.status = "판매완료";

        GoodsDataService.update(this.currentGoods.goodsId, this.currentGoods)
          .then(response => {
            console.log(response.data);
            alert("판매완료 되었습니다");
            // this.$router.push("/dapanda");
            location.href = '/dapanda'
          })
          .catch(e => {
            console.log(e);
          })
      }
    },

    // 좋아요 누르기전 조회
    retrieveCart(goodsId, userId) {
      GoodCartService.getCart(goodsId, userId)
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

    // 좋아요 등록
    addCart() {
      if (this.OnOff) {
        alert("이미 찜한 상품입니다.");
      } else if (this.$store.state.auth.user) {
        let data = {
          goodsId: this.currentGoods.goodsId,
          userId: this.$store.state.auth.user.id
        }
        GoodCartService.create(data)
          .then((response) => {
            this.goodcart.cartId = response.data.cartId;
            this.OnOff = true;
            console.log(response.data);
          })
          .catch((e) => {
            console.log(e);
          });

        this.currentGoods.viewCount = this.currentGoods.viewCount + 1;

        GoodsDataService.update(this.currentGoods.goodsId, this.currentGoods)
          .then(response => {
            console.log(response.data);
            // this.$router.push("/dapanda");
            // location.href = '/dapanda'
            this.getGood();
          })
          .catch(e => {
            console.log(e);
          })

      } else {
        alert("로그인이 필요한 서비스입니다.");
      }

    },

    // 대댓글 조회
    retrieveGoodReply(goodsId) {
      GoodReplyService.getAll(goodsId)
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
    
    // 대댓글 등록
    addReply(num) {
      if (this.$store.state.auth.user) {
        let data = {
          goodsId: this.currentGoods.goodsId,
          commentId: num,
          nick: this.$store.state.auth.user.nick,
          reply: this.reply[num]
        }

        GoodReplyService.create(data)
          .then(response => {
            this.reply.replyId = response.data.replyId;
            // 콘솔 로그 출력(response.data)
            console.log(response.data);
          })
          // 실패하면 .catch() 결과가 전송됨
          .catch(e => {
            console.log(e);
          });

        this.retrieveGoodComment(this.$route.params.goodsId);
        this.retrieveGoodReply(this.$route.params.goodsId);

      } else {
        alert("로그인이 필요한 서비스입니다.");
      }
    },

    // 상품 이미지 포함 조회
    getGood(goodsId) {
      GoodsDataService.get(goodsId)
        .then(response => {
          console.log(response.data);
          this.currentGoods = response.data;
          // this.imageUrl = "http://localhost:8000/api/goods/" + goodsId;
        })
        .catch(e => {
          console.log(e);
        });

      FileDbDataService.getFiles()
        .then((response) => {
          this.imageUrl = response.data;
          console.log(this.imageUrl);
        })
        .catch((e) => {
          console.log(e);
        })
    },

    // 상품 삭제
    deleteGoods() {
      if (this.$store.state.auth.user.nick == this.currentGoods.sellerId) {
        GoodsDataService.delete(this.currentGoods.goodsId)
        FileDbDataService.delete(this.currentGoods.goodsId)
          .then((response) => {
            console.log(response.data);
            this.$router.push("/dapanda");
            location.href = '/dapanda';
          })
          .catch((e) => {
            console.log(e);
          })
      } else {
        alert("삭제 권한이 없습니다");
      }

    },

    // 상품 정보 수정
    updateGood() {
      if (this.$store.state.auth.user.nick == this.currentGoods.sellerId) {
        location.href = `/update/${this.$route.params.goodsId}`;
      } else {
        alert("수정 권한이 없습니다.");
      }

    },

    // 댓글 등록
    addComment() {
      if (this.$store.state.auth.user) {
        let data = {
          goodsId: this.currentGoods.goodsId,
          nick: this.$store.state.auth.user.nick,
          comm: this.comm
        };

        // insert 요청 함수 호출(axios 공통함수 호출)
        GoodCommentService.create(data)
          // 성공하면 then() 결과가 전송됨
          .then(response => {
            this.comm.commentId = response.data.commentId;
            // 콘솔 로그 출력(response.data)
            console.log(response.data);
            // this.retrieveGoodComment(this.currentGoods.goodsId);
          })
          // 실패하면 .catch() 결과가 전송됨
          .catch(e => {
            console.log(e);
          });

        this.retrieveGoodComment(this.$route.params.goodsId);
        this.retrieveGoodReply(this.$route.params.goodsId);


      } else {
        alert("로그인이 필요한 서비스입니다.");
      }

    },

    // 댓글 조회
    retrieveGoodComment(goodsId) {
      GoodCommentService.getAll(goodsId)
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

    toggleShow(num) {
      "show" + num == !("show" + num);
    }

  },
  mounted() {
    this.getGood(this.$route.params.goodsId);
    this.retrieveGoodComment(this.$route.params.goodsId);
    this.retrieveGoodReply(this.$route.params.goodsId);
    this.retrieveCart(this.$route.params.goodsId, this.$store.state.auth.user.id);
    this.UserCheck();
  }

}
</script>

<style lang="scss">

.mainImage {
  justify-content: center;
}

.table {
  justify-content: center;
  margin-bottom: 50px;

}

.writeTable {
  justify-content: center;
  margin-bottom: 50px;
}

.editButton {
  height: 40px;
  background-color: rgb(255, 255, 255);
  border-radius: 2.5px;
  margin-left: 10px;
  border: none;
  width: 60px;
  margin-top: 50px;
}

.deleteButton {
  height: 40px;
  background-color: rgb(255, 255, 255);
  border-radius: 2.5px;
  margin-left: 10px;
  border: none;
  width: 60px;
}

.uploadButton {
  height: 40px;
  background-color: rgb(255, 255, 255);
  border-radius: 2.5px;
  margin-left: 10px;
  border: none;
  width: 60px;
}

.likeButton {
  margin-top: 10px;
  height: 40px;
  color: red;
  background-color: white;
  border-radius: 2.5px;
  margin-left: 0px;
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
  margin-bottom: 100px;
  height: 300px;
  border-top: solid 1px #dbdbdb !important;
  border-bottom: solid 1px #dbdbdb !important;
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

article {
  float: left;
  margin-left: 20px;
  width: 410px;
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

.complateButton {
  width: 7%;
  border: none;
  border-radius: 5px;
  background-color: white;
  font-size: 12px;
}
</style>