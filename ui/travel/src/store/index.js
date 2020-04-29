import Vue from 'vue'
import Vuex from 'vuex'
import VuexPersistence from 'vuex-persist'
const vuexLocal = new VuexPersistence({
  storage: window.localStorage
})

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    loginStatus: false,
    address: ''
  },
  mutations: {
    setAddress (state, data) {
      state.address = data
    },
    setLoginStatus (state, data) {
      state.loginStatus = data
    }
  },
  actions: {},
  modules: {},
  plugins: [vuexLocal.plugin]
})
