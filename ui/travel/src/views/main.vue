<template>
  <div>
    <!-- <div style="margin-bottom:50px"> -->
    <div>
      <van-search show-action  placeholder="请输入搜索关键词" background="#2ca9b0">
        <div slot="left-icon">
          <svg class="icon" aria-hidden="true" style="font-size:20px">
              <use xlink:href="#icon-shouye"></use>
          </svg>
        </div>
        <div slot="action" @click="onSearch()">登录</div>
      </van-search>
    </div>
    <div>
      <keep-alive>
        <transition :name="transitionName">
          <router-view></router-view>
        </transition>
      </keep-alive>
    </div>
    <!-- <div>
      <van-tabbar v-model="active" @change="change">
        <van-tabbar-item
          :icon="item.icon"
          v-for="(item, index) in myRouter"
          :key="index"
          >{{ item.name }}</van-tabbar-item
        >
      </van-tabbar>
    </div> -->
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
      this.$router.push({ name: this.myRouter[e].path })
    },
    onSearch () {
      // this.$router.go(-1)
      this.$router.push({ name: 'login' })
    }
  },
  mounted () {}
}
</script>
