<template>
  <div id="app">
    <!-- <SideBarVue></SideBarVue> -->
    <NavCom/>
    <router-view/>
    <UpButtonVue/>
    <FooterComVue/>
  </div>
</template>

<script>
import NavCom from './components/common/NavCom.vue';
import FooterComVue from './components/common/FooterCom.vue';
// import SideBarVue from './views/SideBar.vue';
import UpButtonVue from './components/common/UpButton.vue';


export default{
  components:{
    NavCom,
    FooterComVue,
    // SideBarVue,
    UpButtonVue
  }
}

</script>

<style lang="scss">
 ::-webkit-scrollbar{width: 16px;}
::-webkit-scrollbar-track{background-color: #f6e3e9;}
::-webkit-scrollbar-thumb{background-color: #e09092; border-radius: 10px;}
::-webkit-scrollbar-button:start:decrement,::-webkit-scrollbar-button:end:increment {
    width: 10px; 
}
</style>
