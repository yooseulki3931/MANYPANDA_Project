<template>
  <div class="icon-bar">
    <router-link to="/"><i class="fa fa-home"></i></router-link>
  </div>
</template>

<script>
export default {

}
</script>

<style>
.icon-bar {
    margin-top: 350px;
    height: 80%;
    width: 60px;
    background-color: rgb(212, 212, 212);
    position: fixed; /* Fixed Sidebar (stay in place on scroll) */
    /*z-index: 1;*/ /* Stay on top */
    top: 0; /* Stay at the top */
    right: 0;
    overflow-x: hidden; /* Disable horizontal scroll */
    padding-top: 0;
  }

  .icon-bar a {
    display: block;
    text-align: center;
    padding: 16px;
    transition: all 0.3s ease;
    color: white;
    font-size: 36px;

  }

  .icon-bar a:hover {
    background-color: #858585;
  }

  


</style>