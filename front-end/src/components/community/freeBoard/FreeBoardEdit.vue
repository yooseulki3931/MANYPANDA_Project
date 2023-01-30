<template>
  <div class="app">
    <div class="freeBoardWrite">
      <section class="secondSection ">
        <div class="container " data-aos="fade-left" data-aos-delay="200">
          <div class="row">

            <!-- 상단 섹션 1 시작 -->
            <!-- 조회수 best 5 -->
            <table class="table" data-v-224097a6="" style="width: 30%; margin-left: 30px;">
              <thead data-v-224097a6="">
                <tr data-v-224097a6="" style="font-size: 22px;">
                  <th scope="col" data-v-224097a6="">
                    <a href="/community-free-board"><img src="../../../assets/image/board/best.jpg" alt="">
                    </a>
                  </th>
                </tr>
              </thead>
              <tbody border="0" class="table-group-divider" data-v-224097a6="" style="text-align: center;">
                <tr v-for="(data, index) in fbBoardBest" :key="index" data-v-224097a6=""
                  style="font-size: 18px; background-color: rgb(255, 255, 255);">
                  <td data-v-224097a6="">
                    <a :href="`/fb/${data.fno}`" style="text-decoration: none;">
                      <font color="black" size="2px">{{ data.fbTitle }}</font>
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
                    <a href="/community-free-board"><img src="../../../assets/image/board/coment.jpg" alt="">
                    </a>
                  </th>

                </tr>
              </thead>
              <tbody border="0" class="table-group-divider" data-v-224097a6="" style="text-align: center;">
                <tr v-for="(data, index) in fbBoardRcntBest" :key="index" data-v-224097a6=""
                  style="font-size: 18px; background-color: rgb(255, 255, 255);">
                  <td data-v-224097a6="">
                    <a :href="`/fb/${data.fno}`" style="text-decoration: none;">
                      <font color="black" size="2px">{{ data.fbTitle }}</font>
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
                    <a href="/community-free-board" size="2px"><img src="../../../assets/image/board/showban.png"
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
            <!-- 상단 섹션 1 끝 -->

            <!-- 글쓰기 게시판 시작 -->
            <div class="writeTable" style="margin-bottom:20px; margin-top:20px; margin-left: 150px;  text-align: left">

              <table class="tableWrite" v-if="currentFb">
                <thead>
                  <!-- 카테고리 셀렉트 박스 선택 -->
                  <tr style="font-size: 14px;  ">
                    <th scope="col" style="text-align: right; width: 200px; margin: 10px;  ">
                      Category
                    </th>
                    <td>
                      <select class="search" aria-label="Default select example" v-model="currentFb.fbCategory"
                        name="count" data-title="선택"
                        style="width: 80%; font-size: 10px; margin: 10px; background-color: white;">
                        <option :key="index" :value="fbCategory.fbCid" v-for="(fbCategory, index) in fbCategories">
                          {{ fbCategory.fbCtitle }}
                        </option>
                      </select>
                    </td>
                  </tr>

                  <!-- 자유게시판 제목 -->
                  <tr data-v-224097a6="" style="font-size: 14px;">
                    <th scope="col" data-v-224097a6="" style="text-align: right; width: 20%; margin: 10px; ">
                      Title
                    </th>
                    <td>
                      <input type="text" placeholder="제목을 입력하세요" id="fbTitle" required name="fbTitle"
                        v-model="currentFb.fbTitle" class="category"
                        style=" font-size: 12px; width: 80%; margin: 10px; ">
                    </td>
                  </tr>

                  <!-- 자유게시판 내용 -->
                  <tr data-v-224097a6="" style="font-size: 14px;">
                    <th scope="col" data-v-224097a6="" style="text-align: right; width: 20%; margin: 10px; ">
                      Content
                    </th>
                    <td style="width: 80%;">
                      <input type="text" placeholder="내용을 입력하세요" id="fbContent" required name="fbContent"
                        v-model="currentFb.fbContent" class="category"
                        style="font-size: 12px; height: 400px; width: 80%; margin: 10px;  ">
                    </td>
                  </tr>

                  <tr data-v-224097a6="" style="font-size: 14px;">
                    <th scope="col" data-v-224097a6="" style="text-align: right; width: 20%; margin: 10px; ">
                      Tag
                    </th>
                    <td>
                      <input type="text" placeholder="#태그를 입력하세요" class="category" v-model="currentFb.fbTag"
                        style=" font-size: 12px; width: 80%; margin: 10px; ">
                    </td>
                  </tr>

                </thead>
              </table>

            </div>
            <!-- 글쓰기 게시판 끝 -->

            <div class="mb-6">

              <label class="btn btn-default p-0" style="margin-left:360px;">

                <!-- 파일 선택상자 -->
                <input type="file" accept="image/*" ref="file" style="font-size:12px;" @change="selectImage" />
              </label>
              <p style="font-size:10px; color:red; margin-left: 360px; margin-top: 10px; ">* 게시글 작성시 선택된 이미지는 게시글 수정시 재
                선택하여 업로드 하세요.</p>
            </div>
            
            <!-- 업로드/취소 버튼 시작 -->
            <div class="button">
              <button class="cancleButton" style=" font-size: 12px;" @click="cancel">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                  class="bi bi-x-square" viewBox="0 0 16 16">
                  <path
                    d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z" />
                  <path
                    d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z" />
                </svg>취소</button>

              <button class="uploadButton" style=" font-size: 12px;" @click="uploadEdition"><svg
                  xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-upload"
                  viewBox="0 0 16 16">
                  <path
                    d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5z" />
                  <path
                    d="M7.646 1.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 2.707V11.5a.5.5 0 0 1-1 0V2.707L5.354 4.854a.5.5 0 1 1-.708-.708l3-3z" />
                </svg>등록</button>
            </div>
            <!-- 업로드/취소 버튼 끝 -->

            <!-- 프로그래스 바 시작-->
            <div v-if="currentImage" class="progress">
              <div class="progress-bar progress-bar-info" role="progressbar" :style="{ width: progress + '%' }"
                :aria-valuenow="progress" aria-valuemin="0" aria-valuemax="100">
                {{ progress }}%
              </div>
            </div>
            <!-- 프로그래스 바 끝-->

            <!-- 미리보기 이미지 시작-->
            <div v-if="previewImage">
              <div>
                <img v-if="currentFb.blobFile" class="preview img-fluid" style="width: 250px; height: 250px;"
                  :src="previewImage" alt="..." />
              </div>
            </div>
            <!--  미리보기 이미지 끝 -->

            <!-- 서버 에러 메세지가 있을경우 아래 출력 -->
            <div v-if="message" class="alert alert-secondary" role="alert">
              {{ message }}
            </div>

          </div>
        </div>
      </section>

    </div>
  </div>

</template>

<script>
/* eslint-disable */
import FbCategoryService from "../../../services/FbCategoryService"
import FbService from "../../../services/FbService";

export default {
  data() {
    return {
      currentImage: undefined, // 현재이미지
      previewImage: undefined, // 미리보기 이미지
      progress: 0, // 프로그래스바를 위한 변수
      // todo: 이미지와 변수 같이 보내기
      currentFb: null,
      message: "",
      fbCategories: [],
      fbBoardBest: [],
      fbBoardRcntBest: [],

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
      ]
    };
  },
  methods: {

    // 셀렉트 카테고리 조회 (db에서 코드 가져오기)
    retrieveFbCategory() {
      FbCategoryService.getAll()
        .then((response) => {
          console.log(response.data);
          this.fbCategories = response.data;
        })
        .catch((err) => {
          this.message = "DB에서 코드를 가져올 수 없습니다. " + err;
        });
    },

    // 조회수 best 조회
    retrieveFbBoardBest() {
      FbService.getFbBoardBest()
        // 성공하면 .then() 결과가 전송됨
        .then((response2) => {
          this.fbBoardBest = response2.data;
          // 디버깅 콘솔에 정보 출력
          console.log(response2.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },

    // 댓글수 best 조회
    retrieveFbBoardRcntBest() {
      FbService.getFbBoardRcntBest()

        // 성공하면 .then() 결과가 전송됨
        .then((response3) => {
          this.fbBoardRcntBest = response3.data;
          // 디버깅 콘솔에 정보 출력

          console.log(response3.data);

        })

        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },

    // 게시번호로 조회
    getFb(fno) {
      FbService.get(fno) // spring 요청
        .then((response) => {
          this.currentFb = response.data;

          // 미리보기 이미지 변수와 현재 이미지 변수를 DB 이미지로 저장
          this.currentImage = this.currentFb.blobFile;
          this.previewImage = this.currentFb.fileUrl;

          console.log(response.data);
        })
        //  실패하면 catch안에 있는것이 실행
        .catch((e) => {
          console.log(e);
        });
    },

    // 이미지를 선택하면 변수에 저장하는 메소드
    selectImage() {
      // 파일선택상자에서 첫번째로 선택한 이미지가 저장됨
      this.currentImage = this.$refs.file.files.item(0);
      // 아래는 미리보기 이미지를 위한 주소가 저장됨
      this.previewImage = URL.createObjectURL(this.currentImage);
      this.progress = 0;
      this.message = "";
    },

    // 파일 업로드를 위한 메소드
    uploadEdition() {
      if (this.$store.state.auth.user.nick != this.currentFb.nick) {
        alert("수정권한이 없습니다");
        location.href = '/community-free-Board';
      }

      this.progress = 0;

      if (!this.currentFb.fbTag) {
        this.currentFb.fbTag = "";
      }

      // 서버에 이미지 업로드 요청(insert 문 실행)
      FbService.update(
        this.currentFb.fno,
        this.currentFb.nick,
        this.currentFb.fbCategory,
        this.currentFb.fbTitle,
        this.currentFb.fbContent,
        this.currentFb.fbTag,
        this.currentFb.fbCnt,
        this.currentImage,
        (eve) => {
          // 파일이 업로드될때 진척상황이 저장됨(%)
          this.progress = Math.round((100 * eve.loaded) / eve.total);
        }
      )
        // 성공하면 then 으로 들어옴(서버에서 응답한 객체)
        .then((response) => {
          // 서버쪽 응답 메시지 저장
          console.log(response.data);
          this.message = response.data;
          location.href = '/community-free-Board'
        })
        // 실패하면 catch으로 들어옴 : 화면에 실패메세지 출력
        .catch((err) => {
          this.progress = 0;
          this.message = "Could not upload the image! " + err;
          this.currentImage = undefined;
        });
    },

    // 이미지 랜덤
    randomImage() {
      let randomNumber = Math.floor(Math.random() * this.imgList.length);
      this.randomProfile = this.imgList[randomNumber];
      console.log(this.randomProfile);
    },

    // 취소 버튼 누를시 리셋
    cancel() {
      location.href = `/fb/${this.currentFb.fno}`;
    },
    check() {
      if (!this.$store.state.auth.user) {
        alert("수정권한이 없습니다");
        location.href = '/community-free-Board';
      }
      // if (this.$store.state.auth.user != this.$route.params.nick) {
      //   alert("수정권한이 없습니다");
      //   location.href = '/community-free-Board';
      // }

    }

  },


  mounted() {
    this.getFb(this.$route.params.fno);
    this.retrieveFbBoardBest()
    this.retrieveFbCategory();
    this.retrieveFbBoardRcntBest();
    this.check();
  },

}
</script>

<style>
.freeBoardWrite {
  margin-top: 350px;
}

.table {
  justify-content: center;
  margin-top: 20px;
}

.search {
  height: 30px;
  background-color: rgb(255, 255, 255);
  border-radius: 2.5px;
  border: none;
}

.cancleButton {
  height: 40px;
  background-color: rgb(255, 255, 255);
  border-radius: 2.5px;
  margin: auto;
  margin-bottom: 50px;
  border: none;
  width: 60px;
  margin-left: 600px;
}


.uploadButton {
  height: 40px;
  background-color: rgb(255, 255, 255);
  border-radius: 2.5px;
  margin-left: 10px;
  border: none;
  width: 60px;
}

.button {
  margin-bottom: 50px;
}

.category {
  border-radius: 5px;
}
</style>