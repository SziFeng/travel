<template>
  <div>
    <f-bar backgroundColor="#eeeeee" :right="true"></f-bar>
    <div class="person-cont">
      <div class="img-cont">
        <img src="@/assets/image/1.jpg">
      </div>
      <div class="name">Mr.小糕</div>
      <div class="detail">不曾到过的地方，有无限的向往</div>
      <div class="info myflex2">
        <div>
          <div>23</div>
          <div>粉丝</div>
        </div>
        <div>
          <div>23</div>
          <div>我的游记</div>
        </div>
        <div>
          <div>450</div>
          <div>关注</div>
        </div>
      </div>
      <div class="button"><f-button text="我的订单" width="40%" radius="100"></f-button></div>
    </div>
    <f-list :icon="item.icon" :name="item.name" :to="item.path" v-for="(item,index) in list" :key="index" class="list"></f-list>
  </div>
</template>

<script>
export default {
  name: 'person',
  data () {
    return {
      list: [
        { name: '我的足迹', icon: 'icon-zuji', path: '' },
        { name: '联系我们', icon: 'icon-tel', path: '' },
        { name: '设置', icon: 'icon-shezhi1', path: '' }
      ]
    }
  }
}
</script>

<style lang="scss" scoped>
.person-cont{
  margin-bottom: 30px;
  background-color: #eeeeee;
  border-bottom-left-radius: 50%;
  border-bottom-right-radius: 50%;
  .img-cont{
    position:relative;
    width:65px;
    height:65px;
    margin:auto;
    img{
      position: absolute;
      height: 100%;
      width: 100%;
      border-radius: 50%;
    }
  }
  .name{
    font-size: 18px;
    font-weight: bold;
    color: #666666;
    padding: 5px;
    text-align: center;
  }
  .detail{
    font-size: 14px;
    color: #666666;
    text-align: center;
    padding-bottom: 10px;
    width: 53%;
    margin: auto;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
  }
  .info{
    width: 52%;
    margin: auto;
    div{
      text-align: center;
      color: #666666;
      font-size: 14px;
      div:nth-child(1){
        font-weight: bold;
        color: #555555;
        font-size: 18px;
      }
    }
  }
  .button{
    transform: translateY(10px);
  }
}
.list:active{
  background-color: #f7f7f7;
}
</style>
