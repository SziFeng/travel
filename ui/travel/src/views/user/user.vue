<template>
  <div>
    <div class="userInfo" style="background-color:skyblue;display:flex">
      <div style="padding:5px 10px"><img src="../../assets/image/boy.png" alt="" width="85px" height="85px"></div>
      <div class="userInfo" style="padding-top:10px">
        <span class="mytext">不再飞的鱼</span>
        <span class="mytext range">LV5</span>
        <span class="mytext">
          <svg class="icon icon-nan" aria-hidden="true">
              <use xlink:href="#icon-nan"></use>
          </svg>
        </span>
        <span class="mytext qian">签到</span>
      </div>
    </div>
    <div style="padding:10px 0">
      <van-grid gutter="10" column-num="3" border="flase">
        <van-grid-item  v-for="(item,index) in gridData" :key="index">
          <div>
            <svg class="icon" aria-hidden="true" style="font-size:34px">
                <use :xlink:href="'#'+item.icon"></use>
            </svg>
          </div>
          <div style="color:#2ca9b0">{{item.name}}</div>
        </van-grid-item>
      </van-grid>
    </div>
    <div>
      <van-tabs animated>
        <van-tab title="历史">内容 1</van-tab>
        <van-tab title="收藏">内容 2</van-tab>
        <van-tab title="订阅">内容 3</van-tab>
        <van-tab title="关注">内容 4</van-tab>
      </van-tabs>
    </div>
  </div>
</template>

<script>
export default {
  name: 'user',
  data () {
    return {
      gridData: [
        { name: '足迹', icon: 'icon-techreport', path: '' },
        { name: '评论', icon: 'icon-huifupingluns', path: '' },
        { name: '参与', icon: 'icon-gerencanshu', path: '' },
        { name: '消息', icon: 'icon-icon_A', path: '' },
        { name: '设置', icon: 'icon-shezhi', path: '' }
      ]
    }
  }
}
</script>
<style scoped>
.mytext{
  padding: 10px;
}
.range{
  background-color: #e9e62c;
  border-radius: 10px;
  padding: 0 10px;
  font-size: 14px;
}
.qian{
  border-radius: 10px;
  padding:5px 8px;
  font-size: 14px;
  background-color: #cccccc;
  color: #ffffff;
}
.icon-nan{
  font-size: 22px;
  border-radius: 5px;
}
</style>
