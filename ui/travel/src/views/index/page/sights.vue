<template>
    <div class="sights" >
        <van-sticky>
        <van-nav-bar @click-left="$router.go(-1)" title="景点信息" >
            <template #left>
                <van-icon name="arrow-left" size="0.6rem" color="#1296db"/>
            </template>
        </van-nav-bar>
        </van-sticky>
        <div class="title">
            <div class="name myflex2">
                <div class="cell1 myflex1">龙门石窟<span>5A</span></div>
                <div class="cell2">导览</div>
            </div>
            <div class="price myflex1">
                <div class="cell3">门票价格：</div>
                <div class="cell4">120元/人</div>
            </div>
            <div class="time myflex1">
                <div class="cell3">开放时间：</div>
                <div class="cell4">07:00-19:00</div>
            </div>
            <div class="address myflex1">
                <div class="cell3">景点地址：</div>
                <div class="cell4">河南省开封市北大门大街210号</div>
            </div>
            <div class="information">
                <div class="cell3">景点介绍：</div>
                <div class="cell4 ">河南省开封市北大门大街210号河南省开封市北大门大街210号河南省开封市北大门大街210号河南省开封市北大门大街210号河南省开封市北大门大街210号</div>
            </div>
        </div>
        <div class="myflex2 bar">
            <div >景点美图：</div>
        </div>
        <f-swipe :list="imgList" :point="true" :autoplay="false"></f-swipe>
        <comment></comment>
    </div>
</template>

<script>
export default {
  name: 'sights',
  data () {
    return {
      imgList: [
        { id: 2, img: require('@/assets/image/img1.png') },
        { id: 3, img: require('@/assets/image/img2.png') },
        { id: 4, img: require('@/assets/image/img3.png') },
        { id: 5, img: require('@/assets/image/img4.png') }
      ]
    }
  }
}
</script>

<style lang="scss">
.sights{
    padding-bottom: 55px;
    .title{
        padding: 5px 10px;
        line-height: 1.8;
        .name{
            .cell1{
                font-size: 28px;
                color: #323233;
                span{
                    background-color: #ffd447;
                    color: #ffffff;
                    border-radius: 5px;
                    font-size: 14px;
                    margin: 5px 10px;
                    padding:1px 5px;
                    line-height: 1.3;
                }
            }
            .cell2{
                color: #ffffff;
                background-color: #1296db;
                padding:0 10px;
                border-radius: 5px;
            }
        }
        .price{
            .cell4{
                color: #ea4d4f;
            }
        }
        .information{
            .cell4{
                text-indent:32px;
                overflow: hidden;
                color: #aaaaaa;
            }
        }
    }
    .bar{
        padding:5px 10px;
        line-height: 1.4;
    }
}
</style>
