<template>
    <div class="container">
        <header>
        <ul id="nav5" class="nav justify-content-around ">
            <li class="nav-item">
                <a class="nav-link active" href="/"><img src="../../assets/image/homelogo.png" alt="" style="width:150px;"></a>
            </li>
        </ul>
        
        <ul id="nav5" class="nav justify-content-around ">
           
            <li class="nav-item">
                <a class="nav-link" href="/dapanda">
                    <font class="fontMain"  color = "black" >MANYPANDA</font>
                </a>
            </li>
            


            <li class="dropdown">
                <a class=" dropdown-toggle" href="/community" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
                    <font class="fontMain"  color = "black">
                    COMMUNITY
                    </font>
                </a>

                <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <li style="font-size:12px"><a class="dropdown-item" href="/community">전체 게시판</a></li>
                    <li style="font-size:12px"><a class="dropdown-item" href="/community-free-Board">자유 게시판</a></li>
                    <li style="font-size:12px"><a class="dropdown-item" href="/community-best-Board">추천 게시판</a></li>
                    <li style="font-size:12px"><a class="dropdown-item" href="/community-moim-Board">모임 게시판</a></li>
                    <li style="font-size:12px"><a class="dropdown-item" href="/community-lost-Board">분실/신고 게시판</a></li>
                </ul>
            </li>

            <li class="nav-item" v-if="!currentUser">
                <a class="nav-link" href="/joinUs">
                    <font class="fontMain"  color = "black">JOIN-US</font>
                </a>
            </li>
            <li class="nav-item" v-if="!currentUser">
                <a class="nav-link" href="/login">
                    <font class="fontMain" color = "black">LOGIN</font>
                </a>
            </li>

            <li v-if="currentUser" class="nav-item" >
                <a class="nav-link" href="/myPage">
                    <font class="fontMain"  color = "black">MY-PAGE</font>
                </a>
            </li>
            
            <li v-if="currentUser" class="nav-item">
                <router-link to="/profile" class="nav-link">
                <a class="nav-link" href @click.prevent="logout" >
                    <font class="fontMain" color = "black">LOGOUT</font>
                </a>
            </router-link>
            </li>
        

        </ul>
    </header>
    </div>
</template>

<script>
export default {

    computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
    // ROLE_USER 만  보이게 만듬
    showUserBoard() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes("ROLE_USER");
      }

      return false;
    },
  },

  methods: {
    logout() {
      this.$store.dispatch("auth/logout");
      this.$router.push("/login");
    },
  },

}
</script>

<style>
header{
    position: fixed;
    width: 100%;
    top: 0px;
    left: 0px;
    z-index: 88;
    min-width: 1200px;
    padding: 5px 40px;
    box-sizing: border-box;
    background-color: #fff;
    
}
.fontMain{
    font-weight:bold;
    font-style: italic;
}
body, button, input, select, table, textarea {
    
    color: #202020;
    font-family: -apple-system,BlinkMacSystemFont,"Malgun Gothic","맑은 고딕",helvetica,"Apple SD Gothic Neo",sans-serif;
}
</style>