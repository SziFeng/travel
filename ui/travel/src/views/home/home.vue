<template>
  <div class="home" style="width:100%">
    <div>
      <van-search show-action placeholder="请输入搜索关键词">
        <div slot="left">
          <svg class="icon" aria-hidden="true">
              <use xlink:href="#icon-icon9"></use>
          </svg>
        </div>
        <div slot="action" @click="onSearch()">登录</div>
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
    <div class="nav">
      <van-grid column-num="3">
        <van-grid-item :icon="item.icon" :text="item.text" v-for="(item,index) in navData" :key="index" @click="goTo(item.path)"/>
      </van-grid>
    </div>
    <div class="botContent">
      <div class="conTitle myflex1">
        <div class="Tline"></div>
        <div class="Tname">推荐攻略</div>
      </div>
      <div class="conCard" v-for="item in 10" :key="item">
        <div class="Cname">
          1998年，夏  在网络还没有贯通家家户户的年代，书本和电视是我的最爱，也是我了解世界的原动力。喜爱动漫的我从画中了解 东京 ，那时候我对 东京 的印象并不深刻，只知道这里是柯南，小樱与美少女战士生活的地方，对于城市的印象，可以“繁华街头”四个字来概括。
        </div>
        <div class="myflex1">
          <div class="img"><img src="@/assets/image/1.jpg" width="140px" height="80px" style="padding:10px"></div>
          <div class="text" >
            <div class="detail">
              看最美的春天——西藏林芝桃花及拉萨、雅鲁藏布大峡谷、波密、然乌湖7日游）
            </div>
            <div class="info myflex2">
              <div>58浏览</div>
              <div><span>不再飞的鱼</span><img src="" alt=""></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'home',
  data () {
    return {
      activeNames: [''],
      navData: [
        { text: '攻略', icon: 'eye-o', path: 'strategy' },
        { text: '当地', icon: 'location-o', path: '' },
        { text: '目的地', icon: 'upgrade', path: '' },
        { text: '游记', icon: 'flower-o', path: '' },
        { text: '推荐', icon: 'good-job-o', path: '' },
        { text: '个人', icon: 'exchange', path: 'user' }
      ]
    }
  },
  methods: {
    goTo (val) {
      this.$router.push({ name: val })
      console.log('要去', val)
    }
  }
}
</script>

<style lang="scss">
.conTitle{
  padding: 10px;
  .Tline{
    width: 4px;
    height: 26px;
    margin-right: 10px;
    background-color: skyblue;
  }
  .conCard{
    width: 100%;
  }
}
.Cname{
  margin: 5px 60px 0 10px;
  font-size: 18px;
  color: #333333;
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
}
.detail{
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical;
}
.text{
  padding: 0 10px 5px 0;
  font-size: 14px;
  color: #999999;
}
</style>
