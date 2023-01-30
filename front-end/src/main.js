import Vue from 'vue'
import App from './App.vue'

// bootstrap 5.x npm import
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap.bundle.js'

// bootstrap-vue import
import { BootstrapVue } from 'bootstrap-vue'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import VeeValidate , { Validator } from 'vee-validate';
import KoreanValidate from 'vee-validate/dist/locale/ko'

import router from './router'
import store from './store'

// slide-carousel by dapanda
import VueGlide from 'vue-glide-js'
import 'vue-glide-js/dist/vue-glide.css'
Vue.use(VueGlide)

// bootstrap-vue 모듈 사용
Vue.use(BootstrapVue)

const attributeDictionary = {
  ko: {
    attributes: 
    {
      fbTitle: '제목'
    }
    
  }
}
Validator.localize('ko', KoreanValidate)
Vue.use(VeeValidate, { locale: KoreanValidate, dictionary: attributeDictionary })

import ko from 'vee-validate/dist/locale/ko.js'

const dictionary = {

  tbTitle: '제목',
}

const config = {

  inject: false,

  locale: ko.tbTitle,

  dictionary: {

    ko: { messages: ko.messages, attributes: dictionary }

  }

}

Vue.use(VeeValidate, config)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')