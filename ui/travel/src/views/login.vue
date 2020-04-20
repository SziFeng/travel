<template>
  <div class="container">
    <div class="img-cell">
      <img src="../assets/image/leaf.png" alt="">
    </div>
    <div style="padding:10px 20px">
      <f-input placeholder="请输入账号" type="phone" v-model="username"></f-input>
    </div>
    <div style="padding:10px 20px">
      <f-input  placeholder="请输入通行密码" type="lock" v-model="password"></f-input>
    </div>
    <f-button radius="100" width="60%" style="padding-top:30px" text="登录" @click="login"></f-button>
    <div class="others">
      <div class="myflex4">
        <svg class="icon xian1" aria-hidden="true">
            <use xlink:href="#icon-xian1"></use>
        </svg>
        <div class="OR">OR</div>
        <svg class="icon xian1" aria-hidden="true">
            <use xlink:href="#icon-xian1"></use>
        </svg>
      </div>
      <div class="myflex4">
        <svg class="icon lain" aria-hidden="true">
            <use xlink:href="#icon-weixin"></use>
        </svg>
        <svg class="icon lain" aria-hidden="true">
            <use xlink:href="#icon-qq"></use>
        </svg>
        <svg class="icon lain" aria-hidden="true">
            <use xlink:href="#icon-weibo"></use>
        </svg>
      </div>
      <div style="text-align:center;padding-top:10px">还没有账号？<span style="color:#ea4d4f" @click="$router.push({name:'regist'})">注册</span></div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'login',
  data () {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    login () {
      this.$api.login({ username: this.username, password: this.password }).then(res => {
        if (res.data) {
          this.$router.push({ name: 'home' })
        }
      })
    }
  }
}
</script>
<style scoped>
.container{
  /* background-image: url('../assets/image/login.jpg');
  background-size: 100% 100%;
  position: absolute;
  width: 100%;
  height: 100%; */
}
.img-cell{
  position: relative;
  width: 75px;
  height: 75px;
  /* overflow: hidden; */
  background-color: skyblue;
  margin:20% auto 15px;
  border-radius: 10px;
  box-shadow: 0px 5px 10px #c4c4c4;
}
.img-cell img{
  position: absolute;
  width: 100%;
  height: 100%;
}
.xian1{
  width: 100px;
  color:#c4c4c4
}
.others{
  padding-top:20%;
}
.OR{
  font-size: 18px;
  line-height: 18px;
  padding: 3px 0 0;
}
.lain{
  font-size: 30px;
  padding:15px
}
</style>
