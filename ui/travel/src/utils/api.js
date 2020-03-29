import Vue from 'vue'
export default {
  // 后台登录接口
  login (p) {
    return Vue.$post_from('/travel/api/user/login', p)
  }
}
