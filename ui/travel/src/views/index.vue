<template>
 <div>
    <div class="item-content">
      <transition :name="transitionName" >
        <router-view></router-view>
      </transition>
    </div>
    <div>
      <f-tab :list="list"></f-tab>
    </div>
 </div>
</template>

<script>
export default {
  name: 'index',
  data () {
    return {
      transitionName: 'slide-left',
      list: [
        { name: '首页', icon: '#icon-shouye-2', sicon: '#icon-shouye', path: 'home', center: false },
        { name: '游记', icon: '#icon-techreport2', sicon: '#icon-techreport', path: 'diary', center: false },
        // { name: '消息', icon: '#icon-huifupingluns-2', sicon: '#icon-huifupingluns', path: 'notes', center: false },
        { name: '我的', icon: '#icon-gerencanshu-2', sicon: '#icon-gerencanshu', path: 'person', center: false }
      ]
    }
  },
  watch: {
    // 使用watch 监听$router的变化
    $route (to, from) {
      // 如果to索引大于from索引,判断为前进状态,反之则为后退状态
      console.log('sss', to, from)
      if (to.meta.index > from.meta.index) {
        // 设置动画名称
        this.transitionName = 'slide-left'
      } else {
        this.transitionName = 'slide-right'
      }
    }
  }
}
</script>

<style >
.item-content{
  position: absolute;
  width: 100%;
  top: 0;
  bottom: 55px;
  overflow: hidden;
  overflow-y: scroll;
}
</style>
