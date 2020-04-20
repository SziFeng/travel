<template>
  <div>
      <div class="swipe">
        <div class="swipe-item"
          :style="{transform:'translateX('+width+'px)',transition:time+'s'}"
          v-tap="vueTap"
          v-swipeleft="vueTouchLeft"
          v-swiperight="vueTouchRight"
        >
          <div v-for="(item,index) in imgList" :key="index"><img :src="item.img" alt=""></div>
        </div>
      </div>
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
      default: true,
      type: Boolean
    }
  },
  data () {
    return {
      width: 0,
      boxWidth: 0,
      timer: null,
      transitionName: 'all',
      time: 1,
      imgList: []
    }
  },
  methods: {
    vueTap () {
      console.log('sss')
    },
    vueTouchRight () {
      // console.log('右滑')
      if (this.width === 0) {
        // this.time = 0
        this.width = -(this.imgList.length - 2) * this.boxWidth
      }
      setTimeout(() => {
        this.time = 1
        this.width = this.width + this.boxWidth
      }, 50)
    },
    vueTouchLeft () {
      // console.log('左滑')
      if (this.width === -(this.imgList.length - 1) * this.boxWidth) {
        this.time = 0
        this.width = -this.boxWidth
      }
      setTimeout(() => {
        this.time = 1
        this.width = this.width - this.boxWidth
      }, 100)
    },
    autoPlay () {
      if (this.autoplay) {
        this.timer = setInterval(() => {
          this.vueTouchLeft()
        }, this.second)
      }
    },
    getImgList () {
      let one = this.list[0]
      let last = this.list[this.list.length - 1]
      this.imgList = this.list
      this.imgList.push(one)
      this.imgList.unshift(last)
    }
  },
  mounted () {
    let obj = document.getElementsByClassName('swipe')
    this.boxWidth = obj[0].clientWidth
    this.width = -obj[0].clientWidth
    console.log('sss', obj, this.boxWidth)
    this.autoPlay()
    this.getImgList()
  },
  destroyed () {
    clearInterval(this.timer)
  }
}
</script>

<style lang="scss">
.swipe{
  .swipe-item{
    // transition: 1s;
    white-space: nowrap;
    div{
      display: inline-block;
      position: relative;
      width: 375px;
      height: 180px;
      img{
        border-radius: 15px;
        position: absolute;
        width: 100%;
        height: 100%;
        transform: scale(0.95);
      }
    }
  }
}
</style>
