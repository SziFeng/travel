import Vue from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import store from './store'
import 'amfe-flexible'
import Vant from 'vant'
import 'vant/lib/index.css'
import '@/assets/main.css'
import fetch from '@/utils/index.js'
import api from '@/utils/api.js'

Vue.use(Vant)
Vue.use(fetch, { domaintest: 'http://127.0.0.1:8888' })

Vue.config.productionTip = false
Vue.prototype.$api = api

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
