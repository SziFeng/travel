import Vue from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import store from './store'
import 'amfe-flexible'
import '@/assets/main.scss'
import fetch from '@/utils/index.js'
import api from '@/utils/api.js'
import components from '@/utils/components.js'

Vue.use(fetch, { domaintest: 'http://127.0.0.1:8080' })
Vue.use(components)

Vue.config.productionTip = false
Vue.prototype.$api = api

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
