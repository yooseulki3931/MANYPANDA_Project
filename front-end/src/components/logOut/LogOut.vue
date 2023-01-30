<template>
    <div class="LogOut">
        <a class="nav-link" href @click.prevent="logout" >
        <button @click="logOut" > 로그아웃 </button>
    </a>


    </div>
  </template>
  
  <script>
  export default {
    name: 'LogOut',
    data() {},
    methods: {
        logOut() {
            
            alert("로그아웃이 정상적으로 되었습니다.")
        }
    }
  }
  </script>
 
  <style>
  .LogOut{
      margin-top: 350px;
  }
  </style>