import Vue from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import Vuex from 'vuex'
import store from './store'
import 'amfe-flexible'
import '@/assets/main.scss'
import fetch from '@/utils/index.js'
import api from '@/utils/api.js'
import components from '@/utils/components.js'
import touch from '@/utils/swipe.js'
import Vant from 'vant'
import 'vant/lib/index.css'

Vue.use(Vant)
Vue.use(Vuex)
Vue.use(fetch, { domaintest: 'http://127.0.0.1:8080' })
Vue.use(components)
Vue.use(touch)

Vue.config.productionTip = false
Vue.prototype.$api = api

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
