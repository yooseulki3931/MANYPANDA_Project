<template>
  <div class="col-md-12">
    <p>리다이렉트 페이지 입니다.</p>
    {{ userData }}
  </div>
</template>

<script>
export default {
  data() {
    return {
      userData: {},
    };
  },
  mounted() {
    let url = new URL(window.location.href);
    console.log(url);

    const urlParams = url.searchParams;
    const accessToken = urlParams.get("accessToken");
    const id = urlParams.get("id")
    const username = urlParams.get("username");
    const email = urlParams.get("email");
    const nick = urlParams.get("nick");
    const address = urlParams.get("address");
    console.log(accessToken);
    console.log(username);

    // 임시 객체 생성
    this.userData = {
      accessToken: accessToken,
      id: id,
      username: username,
      email: email,
      nick: nick,
      address: address,
      password: "",
      tokenType: "Bearer",
      roles: ["ROLE_USER"],
    };

    localStorage.setItem("user", JSON.stringify(this.userData));

    this.$store.commit('auth/loginSuccess', this.userData);

    this.$router.push("/myPage");
  },
};
</script>
