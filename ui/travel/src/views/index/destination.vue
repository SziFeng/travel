<template>
  <div class="destination">
    <van-nav-bar @click-left="$router.go(-1)" title="选择目的地" >
      <template #left>
        <van-icon name="arrow-left" size="0.6rem" color="#1296db"/>
      </template>
      <template #right>
        <van-icon name="search" size="0.6rem" color="#1296db"/>
      </template>
    </van-nav-bar>
    <van-tabs animated color="#1296db" sticky title-active-color="#1296db">
      <van-tab v-for="(item,index) in nameList" :key="index" :title="item.name" >
      </van-tab>
    </van-tabs>
    <div class="j-container ">
      <div class="mygrid2">
        <div class="j-item" v-for="item in dataList" :key="item.id" @click="$router.push({name:'sights'})">
          <div class="j-content"  >
            <img :src="item.img" alt="">
            <div class="j-name">{{item.name}}</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'destination',
  data () {
    return {
      type: 0,
      nameList: [
        { id: 0, name: '最热门', code: '' },
        { id: 1, name: '广州', code: '' },
        { id: 2, name: '深圳', code: '' },
        { id: 3, name: '珠海', code: '' },
        { id: 4, name: '江门', code: '' },
        { id: 5, name: '佛山', code: '' },
        { id: 6, name: '东莞', code: '' },
        { id: 7, name: '清远', code: '' },
        { id: 8, name: '中山', code: '' },
        { id: 9, name: '香港', code: '' },
        { id: 10, name: '澳门', code: '' }
      ],
      dataList: [
        { id: 1, name: '小蛮腰', path: '', img: require('../../assets/image/1.jpg') },
        { id: 2, name: '海洋世界', path: '', img: require('../../assets/image/img1.png') },
        { id: 3, name: '白云山', path: '', img: require('../../assets/image/img2.png') },
        { id: 4, name: '漂流', path: '', img: require('../../assets/image/img3.png') },
        { id: 5, name: '世界之窗', path: '', img: require('../../assets/image/img4.png') }
      ]
    }
  }
}
</script>

<style lang="scss" >
.destination{
  .select-item{
    font-weight: bold;
    height: 45px;
    padding: 0 20px;
    div{
      &:nth-child(1){
        line-height: 45px;
        .name1{
          font-size: 22px;
        }
        .name2{
          font-size: 18px;
        }
      }
    }
  }
  .j-container{
    position: absolute;
    width: 100%;
    top: 90px;
    bottom: 0;
    padding: 10px 0;
    background-color: #f7f7f7;
    overflow: hidden;
    overflow-y: scroll;
    .j-item{
      padding: 5px;
      .j-content{
        position: relative;
        overflow: hidden;
        width: 100%;
        height: 130px;
        margin:0 auto;
        border-radius: 15px;
        img{
          position: absolute;
          width: 100%;
          height: 100%;
          border-radius: 15px;
        }
        .j-name{
          position: absolute;
          font-size: 24px;
          width: 100%;
          height: 100%;
          color: #ffffff;
          background-color: rgba($color: #000000, $alpha: 0.3);
          margin: 0;
          display: flex;
          justify-content: center;
          align-items: center;
        }
      }
    }
}
}
</style>
