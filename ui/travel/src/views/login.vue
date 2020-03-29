<template>
  <div class="login">
    <div class="viewCon">
      <div class="tou-icon">
        <svg class="icon" aria-hidden="true" style="font-size:45px">
            <use xlink:href="#icon-touxiang"></use>
        </svg>
      </div>
      <van-field v-model="username" type="text" size="large"  left-icon="contact" placeholder="输入账户名"/>
      <van-field v-model="password" type="password" size="large"  left-icon="other-pay" placeholder="输入账户密码"/>
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
      password: ''
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
  background: linear-gradient(to bottom, skyblue , #ffffff);
  display: flex;
  justify-content: center;
}
.viewCon{
  position: absolute;
  width: 80%;
  top: 20%;
}
.tou-icon{
  text-align: center;
  padding: 20px;
}
.login-icon{
  text-align: center;
  padding: 40px;
}
</style>
