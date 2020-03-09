<template>
  <div class="home">
    <div>
      <van-search show-action placeholder="请输入搜索关键词">
        <div slot="action" @click="onSearch()">Go</div>
      </van-search>
    </div>
    <van-swipe
      style="height: 200px;background-color:skyblue"
      :autoplay="3000"
      :show-indicators="false"
      vertical
    >
      <van-swipe-item>1</van-swipe-item>
      <van-swipe-item>2</van-swipe-item>
      <van-swipe-item>3</van-swipe-item>
      <van-swipe-item>4</van-swipe-item>
    </van-swipe>
  </div>
</template>
<script>
export default {
  name: 'home',
  data () {
    return {
      activeNames: ['']
    }
  },
  methods: {
    test () {
      let a = 1
      console.log('sd', a)
    }
  }
}
</script>

<style lang="sass"></style>
