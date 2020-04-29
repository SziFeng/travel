<template>
  <div>
    <f-bar :left="false" :right="true"></f-bar>
    <div class="person-cont">
      <div v-if="loginStatus">
        <div class="img-cont">
          <img :src="userInfo.pic">
        </div>
        <div class="name">Mr.{{userInfo.userName}}</div>
        <div class="detail">不曾到过的地方，有无限的向往</div>
        <div class="info myflex2">
          <div>
            <div>2</div>
            <div>粉丝</div>
          </div>
          <div>
            <div>13</div>
            <div>我的游记</div>
          </div>
          <div>
            <div>0</div>
            <div>关注</div>
          </div>
        </div>
     </div>
      <div v-else>
        <div class="img-cont">
          <img src="@/assets/image/boy.png">
        </div>
        <div class="name2" @click="$router.push({name:'login'})">登录/注册</div>
        <div class="info myflex2">
          <div>
            <div>0</div>
            <div>粉丝</div>
          </div>
          <div>
            <div>0</div>
            <div>我的游记</div>
          </div>
          <div>
            <div>0</div>
            <div>关注</div>
          </div>
        </div>
     </div>
      <div class="button"><f-button text="游记" width="40%" radius="100"></f-button></div>
    </div>
    <van-cell :title="item.name"  size="large" v-for="(item,index) in list" :key="index" is-link title-class="title-class">
      <!-- 使用 right-icon 插槽来自定义右侧图标 -->
      <template #icon>
        <svg class="icon" aria-hidden="true">
            <use :xlink:href="'#'+item.icon"></use>
        </svg>
      </template>
    </van-cell>
  </div>
</template>

<script>
import { mapState, mapMutations } from 'vuex'
export default {
  name: 'person',
  data () {
    return {
      list: [
        { name: '我的足迹', icon: 'icon-zuji', path: '' },
        { name: '联系我们', icon: 'icon-tel', path: '' },
        { name: '设置', icon: 'icon-shezhi1', path: '' }
      ],
      userInfo: {}
    }
  },
  computed: {
    ...mapState(['loginStatus'])
  },
  methods: {
    ...mapMutations(['setLoginStatus']),
    getUserInfo () {
      this.$api.getUserInfo().then(res => {
        if (res.success) {
          this.setLoginStatus(true)
          console.log('sss', res.data)
          this.userInfo = res.data
        } else {
          this.setLoginStatus(false)
        }
      })
    }
  },
  mounted () {
    this.getUserInfo()
  }
}
</script>

<style lang="scss" >
.person-cont{
  margin-bottom: 30px;
  background-image: repeating-linear-gradient(to bottom,#1296db,#f2f2f2);
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
    padding: 5px;
    text-align: center;
  }
  .name2{
    font-size: 24px;
    font-weight: bold;
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
.title-class{
  padding-left: 8px;;
}
</style>
