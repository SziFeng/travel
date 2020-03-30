<template>
<div class="login">
  <!-- <div class="title">
    <svg class="icon icon-marry-active" aria-hidden="true" >
      <use xlink:href="#icon-marry-active"></use>
    </svg>
    <span style="font-size:40px;font-family:">枫游记</span>
  </div> -->
  <div class="yun-group">
    <svg class="icon yun-" aria-hidden="true">
      <use xlink:href="#icon-yun-"></use>
    </svg>
    <svg class="icon yunpan" aria-hidden="true">
      <use xlink:href="#icon-yunpan"></use>
    </svg>
    <div style="color:grey">
      <p>要学会</p>
      <p style="padding-left:20px">把悲伤忘在昨天；</p>
      <p style="padding-left:40px">把快乐存在今天</p></div>
  </div>
  <div class="viewCon">
    <div class="tou-icon">
      <svg class="icon" aria-hidden="true" style="font-size:45px">
        <use xlink:href="#icon-touxiang"></use>
      </svg>
    </div>
    <van-field class="input1" v-model="username" type="text" size="large"   placeholder="输入账户名"/>
    <van-field class="input2" v-model="password" type="password" size="large"   placeholder="输入账户密码"/>
    <div class="login-icon">
      <svg class="icon" aria-hidden="true" style="font-size:35px" @click="login">
        <use xlink:href="#icon-youjiantou"></use>
      </svg>
    </div>
  </div>
</div>
</template>
<script>
export default {
  name: 'login',
  data () {
    return {
      username: '',
      password: '',
      show: false,
      move: false
    }
  },
  methods: {
    login () {
      this.$api.login({ userName: this.username, password: this.password }).then(res => {
        console.log('sss', res)
        if (res.data) {
          this.$router.push({ name: 'home' })
        }
      })
    }
  }
}
</script>
<style scoped>
.login{
  position: absolute;
  width: 100%;
  height:100%;
  overflow: hidden;
  background: linear-gradient(to bottom, skyblue , #ffffff);
  display: flex;
  justify-content: center;
}
.title{
  position: absolute;
  top:100px;
}
.icon-marry-active{
  font-size: 60px;
}
.viewCon{
  position: absolute;
  width: 80%;
  top: 25%;
}
.viewCon >>> .van-cell {
  padding: 10px 20px;
  font-size: 18px;
  line-height: 1.8;
}
@keyframes login {
  0%{
    opacity: 0.5;
    transform: translateX(250px);
  }
  100%{
    opacity: 0.5;
    transform: translateX(-400px);
  }
}
.yun{
  animation: login 10s infinite linear ;
}
.yun-,.yunpan{
  padding: 10px 20px 0;
  font-size:55px;
  opacity: 0.5;
}
@keyframes left {
  0%{
    opacity: 0;
    transform: translateX(-100px);
  }
  100%{
    opacity: 1;
    transform: translateX(0);
  }
}
@keyframes right {
  0%{
    opacity: 0;
    transform: translateX(100px);
  }
  100%{
    opacity: 1;
    transform: translateX(0);
  }
}
@keyframes bot {
  0%{
    opacity: 0;
    transform: translateY(-100px);
  }
  100%{
    opacity: 1;
    transform: translateY(0);
  }
}
@keyframes top {
  0%{
    opacity: 0;
    transform: translateY(100px);
  }
  100%{
    opacity: 1;
    transform: translateY(0);
  }
}
.tou-icon{
  text-align: center;
  padding: 20px;
  animation: bot 1.5s;
}
.login-icon{
  text-align: center;
  margin: 40px;
  animation: top 1.5s;
}
.input1{
  border-radius: 50px;
  margin:10px 0;
  background-color: rgb(232, 240, 254);
  text-align: center;
/* -webkit-animation: animatename 0.5s; */
  animation: left 1.5s;
}
.input2{
  border-radius: 50px;
  margin:10px 0;
  background-color: rgb(232, 240, 254);
  text-align: center;
/* -webkit-animation: animatename 0.5s; */
  animation: right 1.5s;
}
</style>
