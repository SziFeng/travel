<template>
  <div>
    <van-swipe class="swipe-item" @change="(index)=>{count=index}" :autoplay="autoplay?'5000':''">
      <van-swipe-item v-for="(item,index) in list" :key="index"><img :src="item.img" alt=""></van-swipe-item>
      <template #indicator v-if="point">
        <div class="custom-indicator">
          {{ count + 1 }}/4
        </div>
      </template>
    </van-swipe>
  </div>
</template>

<script>
export default {
  name: 'swipe',
  props: {
    autoplay: {
      default: true,
      type: Boolean
    },
    list: {
      defaultValue: [],
      type: Array
    },
    second: {
      default: 5000,
      type: Number
    },
    point: {
      default: false,
      type: Boolean
    }
  },
  data () {
    return {
      count: 0
    }
  }
}
</script>

<style lang="scss">
  .swipe-item{
      height: 180px;
      img{
        border-radius: 15px;
        position: absolute;
        width: 100%;
        height: 100%;
        transform: scale(0.95);
      }
      .custom-indicator{
        position: absolute;
        right: 20px;
        bottom: 10px;
        color: #FFF;
      }
  }
</style>
