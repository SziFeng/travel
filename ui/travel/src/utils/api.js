import Vue from 'vue'
export default {
  // 后台登录接口
  login (p) {
    return Vue.$post('/travel/api/user/login', p)
  },
  getUserInfo (p) {
    return Vue.$get('/travel/api/user/getCurrentUser', p)
  },
  getImg (p) {
    return Vue.$from('/travel/api/essay/addEssay', p)
  }
}
