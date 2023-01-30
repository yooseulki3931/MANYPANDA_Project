<template>
  <!-- AddDiary.vue -->
  <div class="submit-form">
    <!-- 새 양식 폼 시작 -->
    <div v-if="!submitted" div class="col-md-6" id="diary_add">
      <!-- 제목 -->
      <div class="form-group">
        <label for="dtitle">제목</label>
        <input
          type="text"
          class="form-control"
          id="dtitle"
          required
          v-model="diary.dtitle"
          name="dtitle"
        />
      </div>
      <br />
      <!-- 내용 -->
      <div class="form-group">
        <label for="dcontent">내용</label>
        <textarea
          class="form-control"
          id="dcontent"
          required
          v-model="diary.dcontent"
          name="dcontent"
          style="
            display: inline;
            height: 300px;
            white-space: normal;
            text-align: start;
          "
        />
      </div>
      
      <button
        type="button"
        @click="saveDiary"
        class="btn btn-secondary"
        id="diary_modal_edit"
      >
        등록   
      </button>
    </div>
    <!-- 새 양식 폼 끝 -->

    <div v-else>
      <h4>글이 등록됐습니다!</h4>
      <br />
      <span class="badge bg-dark" @click="newDiary">글쓰기</span>
    </div>
  </div>
</template>

<script>
// axios 공통함수 import
import DiaryDataService from "../../services/DiaryDataService";

export default {
  data() {
    return {
      diary: {
        dno: null,
        dtitle: "",
        dcontent: "",
        userId: ""
      },
      // submit 버튼을 클릭하면 true 가 되고, You submitted successfully! 화면에 출력됨
      submitted: false,
    };
  },
  methods: {
    // 다이어리 등록
    saveDiary() {
      let data = {
        dtitle: this.diary.dtitle,
        dcontent: this.diary.dcontent,
        userId: this.$store.state.auth.user.id
      };

      // insert 요청 함수 호출(axios 공통함수 호출)
      DiaryDataService.create(data)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          this.diary.dno = response.data.dno;
          // 콘솔 로그 출력(response.data)
          console.log(response.data);
          // 변수 submitted
          this.submitted = true;
          location.reload();
        })
        // 실패하면 .catch() 결과가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },

    // 다이어리 새양식 보여주기
    newDiary() {
      this.submitted = false;
      this.diary = {};
    },
  },
};
</script>

<style>
@import url(@/assets/css/style.css);
</style>
