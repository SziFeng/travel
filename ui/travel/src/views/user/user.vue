<template>
  <div>
    <div class="userInfo" style="background-color:skyblue;display:flex">
      <div style="padding:5px 10px">
        <img
          src="../../assets/image/boy.png"
          alt=""
          width="85px"
          height="85px"
        />
      </div>
      <div class="userInfo" style="padding-top:10px">
        <span class="mytext">不再飞的鱼</span>
        <van-tag type="primary" size="medium">LV5</van-tag>
        <span class="mytext">
          <svg class="icon icon-nan" aria-hidden="true">
            <use xlink:href="#icon-nan"></use>
          </svg>
        </span>
        <span class="mytext qian">签到</span>
        <div class="desc">添加个人描述，可以让大家更好的认识你</div>
      </div>
    </div>
    <div class="activity">
      <div v-for="(item, index) in activeList" :key="index">
        <div class="num">{{ item.num }}</div>
        <div class="name">{{ item.name }}</div>
      </div>
    </div>
    <div>
      <van-tabs animated>
        <van-tab title="草稿">
          <div class="context">
            <div class="card-item" v-for="item in 8" :key="item">
              <div class="item-cell">
                <div class="container1"><img  src="../../assets/image/img3.png" alt=""></div>
                <div class="card-text">"各美其美,美人之美,美美与共,天下大同。"</div>
                <div class="myflex2 card-bar">
                  <div class=" myflex1">
                    <div class="container2"><img src="../../assets/image/1.jpg" alt=""></div>
                    <div class="card-info">不再飞的鱼</div>
                  </div>
                  <div class="myflex1">
                    <i></i>
                    <span class="nums">20</span>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </van-tab>
        <van-tab title="笔记">内容 笔记</van-tab>
      </van-tabs>
      <van-tabs animated>
        <van-tab title="收藏">内容 2</van-tab>
        <van-tab title="标签">内容 3</van-tab>
        <van-tab title="专辑">内容 4</van-tab>
        <van-tab title="赞过">内容 赞过</van-tab>
      </van-tabs>
    </div>
  </div>
</template>

<script>
export default {
  name: 'user',
  data () {
    return {
      activeList: [
        { name: '我的粉丝', num: '15' },
        { name: '关注', num: '6' },
        { name: '获赞与收藏', num: '7' }
      ]
    }
  }
}
</script>
<style scoped>
.mytext {
  padding: 10px;
}
.range {
  background-color: #e9e62c;
  border-radius: 10px;
  padding: 0 10px;
  font-size: 14px;
}
.qian {
  border-radius: 10px;
  padding: 5px 8px;
  font-size: 14px;
  background-color: #cccccc;
  color: #ffffff;
}
.icon-nan {
  font-size: 22px;
  border-radius: 5px;
}
.activity {
  padding: 15px 50px;
  border-top: 1px solid #cccccc;
  border-bottom: 1px solid #cccccc;
  display: flex;
  justify-content: space-between;
}
.activity .num {
  font-size: 28px;
  text-align: center;
}
.activity .name {
  font-size: 16px;
  line-height: 1.5;
  text-align: center;
  color: #666666;
}
.desc {
  margin-top: 10px;
  font-size: 13px;
  color: #666666;
}
/*草稿下样式  */
.context{
  display: flex;
  /* overflow: hidden; */
  overflow-x: scroll;
}
.card-item{
  padding: 10px;
}
.item-cell{
  width: 150px;
  box-shadow: 3px 3px 10px #cccccc;
  border-radius: 10px;
}
.container1{
  width: 150px;
  height:150px;
  position: relative;
  overflow: hidden;
}
.container1 img{
  position: absolute;
  width: 100%;
  height: 100%;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}
.container2{
  width: 23px;
  height:23px;
  position: relative;
  overflow: hidden;
  border-radius: 50%;
}
.container1 img{
  position: absolute;
  width: 100%;
  height: 100%;
}
.card-bar{
  padding: 5px;
}
.card-text{
  font-size: 14px;
  padding: 5px;
}
.card-info{
  font-size: 12px;
}
.nums{
  font-size: 12px;
}
</style>
