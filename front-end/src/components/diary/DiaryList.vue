<template>
  <!-- DiaryList.vue -->

  <div id="diary_back">
    <!-- 전체 목록 조회 시작 -->
    <div>
      <div>
        <h4 id="diary_logo">💌 DIARY 💌</h4>
      </div>

      <div class="diaryList">
        <ul class="list-group">
          <li
            id="diary_title"
            class="list-group-item"
            :class="{ active: index == currentIndex }"
            v-for="(data, index) in diary"
            :key="index"
            @click="setActiveDiary(data, index)"
          >
            {{ data.dtitle }}
          </li>
        </ul>
      </div>
    </div>
    <!-- 전체 목록 조회 끝 -->
    <div></div>
    <!-- 간략 상세 목록 시작 -->
    <div class="editDiary">
      <div v-if="currentDiary" id="diary_content">
        <div>
          <label>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="16"
              height="16"
              fill="currentColor"
              class="bi bi-chat-square-quote"
              viewBox="0 0 16 16"
            >
              <path
                d="M14 1a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1h-2.5a2 2 0 0 0-1.6.8L8 14.333 6.1 11.8a2 2 0 0 0-1.6-.8H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h2.5a1 1 0 0 1 .8.4l1.9 2.533a1 1 0 0 0 1.6 0l1.9-2.533a1 1 0 0 1 .8-.4H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"
              />
              <path
                d="M7.066 4.76A1.665 1.665 0 0 0 4 5.668a1.667 1.667 0 0 0 2.561 1.406c-.131.389-.375.804-.777 1.22a.417.417 0 1 0 .6.58c1.486-1.54 1.293-3.214.682-4.112zm4 0A1.665 1.665 0 0 0 8 5.668a1.667 1.667 0 0 0 2.561 1.406c-.131.389-.375.804-.777 1.22a.417.417 0 1 0 .6.58c1.486-1.54 1.293-3.214.682-4.112z"
              />
            </svg>
            <h4 id="diary_pen">{{ currentDiary.dtitle }}</h4></label
          >
        </div>
        <div id="diary_textarea">
          <label><strong></strong></label>
          {{ currentDiary.dcontent }}
        </div>
        <div>
          <label><strong></strong></label>
          {{ currentDiary.insertTime }}
        </div>

        <button
          id="diary_modal_edit"
          type="button"
          class="btn btn-outline-secondary"
          data-bs-toggle="modal"
          data-bs-target="#exampleModala"
          style="
            width: 100px;
            font-size: 12px;
            height: 50px;
            text-align: center;
            background-color: lavender;
          "
        >
          수정
        </button>

        <div
          class="modal fade"
          id="exampleModala"
          tabindex="-1"
          aria-labelledby="exampleModalLabel"
          aria-hidden="true"
        >
          <div class="modal-dialog modal-lg">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">EDIT</h5>
                <button
                  type="button"
                  class="btn-close"
                  data-bs-dismiss="modal"
                  aria-label="Close"
                ></button>
              </div>
              <div class="modal-body">
                <!-- DiaryDetail.vue -->
                <div>
                  <!-- 수정 양식 폼 시작 -->
                  <div v-if="currentDiary" class="edit-form" id="diary_add">
                    <div>
                      <form>
                        <div class="form-group">
                          <label for="dtitle">제목</label>
                          <input
                            type="text"
                            class="form-control"
                            id="dtitle"
                            v-model="currentDiary.dtitle"
                          />
                        </div>
                        <div class="mt-3 form-group">
                          <label for="dcontent">내용</label>
                          <textarea
                            type="text"
                            class="form-control"
                            id="dcontent"
                            v-model="currentDiary.dcontent"
                            style="
                              display: inline;
                              height: 300px;
                              white-space: normal;
                              text-align: start;
                            "
                          />
                        </div>
                      </form>

                      <div>
                        <button
                          class="btn"
                          @click="updateDiary"
                          id="diary_Detail_badge"
                          style="
                            width: 100px;
                            font-size: 12px;
                            height: 50px;
                            text-align: center;
                            background-color: gray;
                          "
                        >
                          수정
                        </button>
                        <button
                          class="btn"
                          type="submit"
                          @click="deleteDiary"
                          id="diary_Detail_badge"
                          style="
                            width: 100px;
                            font-size: 12px;
                            height: 50px;
                            text-align: center;
                            background-color: gray;
                          "
                        >
                          삭제
                        </button>
                      </div>
                    </div>
                    <!-- 수정 양식 폼 끝 -->
                  </div>
                  <div v-else>
                    <br />
                    <p>다이어리를 눌러주세요!</p>
                  </div>
                </div>

                <!-- =========================== -->
              </div>
              <div class="modal-footer">
                <button
                  type="button"
                  class="btn btn-outline-secondary"
                  data-bs-dismiss="modal"
                >
                  닫기
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div v-else>
        <br />
        <p>제목을 눌러주세요!</p>
      </div>

      <button
        type="button"
        class="btn"
        data-bs-toggle="modal"
        data-bs-target="#exampleModal"
        style="
          width: 100px;
          font-size: 12px;
          height: 50px;
          text-align: center;
          background-color: lavenderblush;
        "
      >
        글쓰기
      </button>

      <!-- 글쓰기모달 -->
      <div
        class="modal fade"
        id="exampleModal"
        tabindex="-1"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true"
      >
        <div class="modal-dialog modal-lg">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">WRITE</h5>
              <button
                type="button"
                class="btn-close"
                data-bs-dismiss="modal"
                aria-label="Close"
              ></button>
            </div>
            <div class="modal-body">
              <AddDiary></AddDiary>
            </div>
            <div class="modal-footer">
              <button
                type="button"
                class="btn btn-outline-secondary"
                data-bs-dismiss="modal"
              >
                닫기
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- 간략 상세 목록 끝 -->
  </div>
</template>

<script>
// axios 공통함수 import
import DiaryDataService from "../../services/DiaryDataService";
import AddDiary from "./AddDiary.vue";

export default {
  // 변수 정의하는 곳 : data(), 초기화
  props: ["idProps"],
  data() {
    return {
      diary: [],
      currentDiary: null,
      currentIndex: -1,
      dtitle: "",
      id: this.idProps,
    };
  },
  components: {
    AddDiary,
  },
  // 함수 정의하는 곳 : methods:
  methods: {
    // axios , 모든 다이어리 정보 조회 요청 함수
    retrieveDiary() {
      DiaryDataService.getAll(this.id)
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          this.diary = response.data; // springboot 의 전송된 다이어리 정보
          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 목록을 클릭했을때 현재 다이어리 객체, 인덱스번호를 저장하는 함수
    setActiveDiary(data, index) {
      this.currentDiary = data;
      this.currentIndex = index;
    },
    // ===================

    // 다이어리 번호(dno)로 조회 요청하는 함수
    getDiary() {
      // axios 공통함수 호출
      DiaryDataService.get(this.id)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함
          this.currentDiary = response.data;
          // 콘솔 로그 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 다이어리 정보를 수정 요청하는 함수
    updateDiary() {
      // axios 공통함수 호출
      DiaryDataService.update(this.currentDiary.dno, this.currentDiary)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /diary
          // this.$router.push("/myPage");
          // location.reload();
          this.retrieveDiary(); // 화면 로딩시 전체 조회함수 실
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 다이어리 정보를 삭제 요청하는 함수
    deleteDiary() {
      // axios 공통함수 호출
      DiaryDataService.delete(this.currentDiary.dno, this.currentDiary)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /diary
          // this.$router.push("/myPage");
          // location.reload();
          this.retrieveDiary(); // 화면 로딩시 전체 조회함수 실
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
  },

  // 화면이 뜨자마자 실행되는 이벤트(라이프 사이클 함수) : mounted(), created()
  mounted() {
    this.retrieveDiary(); // 화면 로딩시 전체 조회함수 \

    this.message = "";
    //  this.$route.params.no : 이전페이지에서 전송한 매개변수는 $route.params 안에 있음
    // $route 객체 : 주로 url 매개변수 정보들이 있음
    // router/index.js 상세페이지 url의 매개변수명 : :no
    this.getDiary(this.$route.params.dno);
  },
};
</script>

<style>
@import url(@/assets/css/style.css);
.diaryList {
  width: 800px;
  margin: auto;
}
.editDiary {
  width: 900px;
  margin: auto;
}
</style>
