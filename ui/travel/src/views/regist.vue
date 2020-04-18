<template>
  <div>
    <f-bar text="注册"></f-bar>
    <div style="padding:30px 0">
        <div style="padding:10px 20px" v-for="(item,index) in list" :key="index">
            <f-input :placeholder="item.text" :type="item.name" v-model="item.value"></f-input>
        </div>
    </div>
    <f-button radius="100" width="60%" style="padding-top:30px" text="注册" @click="regist"></f-button>
          <div style="text-align:center;padding-top:10px">已有账号？<span style="color:#ea4d4f" @click="$router.push({name:'login'})">登录</span></div>
  </div>
</template>

<script>
export default {
  name: 'regist',
  data () {
    return {
      list: [
        { name: 'user', text: '名字', value: '' },
        { name: 'mail', text: '邮箱', value: '' },
        { name: 'lock', text: '密码', value: '' },
        { name: 'phone', text: '手机号', value: '' },
        { name: 'location', text: '地址', value: '' }
      ]
    }
  },
  methods: {
    regist () {
      console.log('sss', this.list)
    }
  }
}
</script>

<style>

</style>
