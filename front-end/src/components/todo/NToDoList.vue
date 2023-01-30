<template>
  <div id="todo_back">
    <h4 id="todo_logo">🧾TODOLIST🧾</h4>
    <div class="toDo">
      <div class="toDoLoist">
        <transition-group name="todo_list">
          <div v-for="(data, tno) in todos" :key="tno">
            <span id="todo_content">
              <label :id="data.tno" style="font-size:12px">
                {{ data.tcontent }}
              </label>
              <span
                v-on:click="deleteTodo(data.tno)"
                type="submit"
                id="todo_remove_btn"
                class="material-symbols-outlined"
                style="background-color: white; "
              >
              <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-square" viewBox="0 0 16 16">
                <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
              </svg>
              </span>
            </span>
          </div>
        </transition-group>
      </div>
      <br />
      <div>
        <input
          id="todo_input"
          type="text"
          v-model="todo.tcontent"
          v-on:keyup.enter="saveTodo"
          class="form-control"
          placeholder="할일을 입력해주세요."
          minlength="2"
          style=" font-size:12px; ;"
        />
        <p>
          <button
            type="button"
            @click="saveTodo"
            class="btn btn-secondary"
            id="todo_add"
            style="width:100px; font-size:12px; height: 50px; text-align: center; background-color: lavender; color: black;"
          >
            추가
          </button>
        </p>
      </div>
      <p>{{ todos.length }}건의 LIST</p>
    </div>
  </div>
</template>

<script>
import TodoDataService from "../../services/TodoDataService";

export default {
  props: ["idProps"],

  data() {
    return {
      todos: [],
      todo: {
        tcontent: "",
        tno: null,
      },
      id: this.idProps,
    };
  },

  methods: {
    // 조회
    retrieveTodo() {
      TodoDataService.getAll(this.id)
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          this.todos = response.data; 
          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },

    // 등록
    saveTodo() {
      // 임시 객체 변수 -> springboot 전송
      let data = {
        tcontent: this.todo.tcontent,
        userId: this.idProps,
      };

      // insert 요청 함수 호출(axios 공통함수 호출)
      TodoDataService.create(data)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          this.todo.tno = response.data.tno;
          // 콘솔 로그 출력(response.data)
          console.log(response.data);
          this.retrieveTodo();
        })
        // 실패하면 .catch() 결과가 전송됨
        .catch((e) => {
          console.log("실패");
          console.log(e);
        });
    },
    // 삭제
    deleteTodo(tno) {
      // alert("fdsaf")/
      // axios 공통함수 호출
      TodoDataService.delete(tno)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          this.retrieveTodo();
          // this.$router.push("/myPage");
          // location.reload();
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
          console.log("삭제실패");
        });
    },
  },
  mounted() {
    this.retrieveTodo();
    console.log(this.idProps + "abcd");
  },
};
</script>

<style>
/* @import url(@/assets/css/style.css); */
.toDo{
  margin: auto;
  text-align: center;
}
.toDoList{
  display: inline;
}
</style>