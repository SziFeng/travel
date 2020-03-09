<template>
  <div>
    <div style="margin-bottom:50px">
      <keep-alive>
        <transition :name="transitionName">
          <router-view></router-view>
        </transition>
      </keep-alive>
    </div>
    <div>
      <van-tabbar v-model="active" @change="change">
        <van-tabbar-item
          :icon="item.icon"
          v-for="(item, index) in myRouter"
          :key="index"
          >{{ item.name }}</van-tabbar-item
        >
        <!-- <van-tabbar-item icon="home-o">首页</van-tabbar-item>
        <van-tabbar-item icon="records" dot>攻略</van-tabbar-item>
        <van-tabbar-item icon="friends-o">我的</van-tabbar-item> -->
      </van-tabbar>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      transitionName: '',
      active: 0,
      myRouter: [
        { name: '首页', icon: 'home-o', path: 'home' },
        { name: '攻略', icon: 'records', path: 'strategy' },
        { name: '我的', icon: 'friends-o', path: 'user' }
      ]
    }
  },
  computed: {},
  watch: {
    $route (to, from) {
      const toDepth = to.path.split('/').length
      const fromDepth = from.path.split('/').length
      this.transitionName = toDepth < fromDepth ? 'slide-right' : 'slide-left'
    }
  },
  methods: {
    change (e) {
      console.log('sss', e)
      this.$router.push({ name: this.myRouter[e] })
    }
  },
  mounted () {}
}
</script>
