<template>
  <div class="comment">
    <div class="myflex2 name-bar">
        <div style="font-weight:550">评论（213）</div>
        <div class="myflex2">
        <f-button
            v-for="(item,ind) in ['默认','精选']"
            :key="ind"
            radius="100"
            :text="item"
            size="small"
            :backgroundColor="type1===ind?'#000000':'#CCCCCC'"
            @click="type1=ind"
            style="padding:0 5px"></f-button>
        </div>
    </div>
    <div class="container-bar">
        <div class="content-bar" v-for="item in 5" :key="item">
            <div class="left">
                <div class="left-img"><img src="@/assets/image/1.jpg" alt=""></div>
            </div>
            <div class="right">
                <div class="myflex2">
                    <div class="name">不再飞的鱼  <span class="rang">{{6-item}}楼</span></div>
                    <div class="zan">100<svg class="icon " aria-hidden="true"><use xlink:href="#icon-zan"></use></svg></div>
                </div>
                <div>这里太好玩了吧！我下次还要来</div>
                <div>4-22 16:29</div>
            </div>
        </div>
    </div>
    <div class="funtion-bar myflex2" >
        <div class="myflex4">
            <svg class="icon " aria-hidden="true"><use xlink:href="#icon-xiaoxi"></use></svg>
            <span>消息</span>
        </div>
        <div class="myflex4">
            <svg class="icon " aria-hidden="true"><use xlink:href="#icon-edit"></use></svg>
            <span>写评论</span>
        </div>
        <div class="myflex4">
            <svg class="icon " aria-hidden="true"><use xlink:href="#icon-fenxiang"></use></svg>
            <span>分享</span>
        </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'comment',
  data () {
    return {
      type1: 0
    }
  }
}
</script>

<style lang="scss">
.comment{
    .name-bar{
    font-size: 20px;
    padding: 10px;
    }
    .container-bar{
        // padding-bottom: 55px;
    line-height: 1.8;
        .content-bar{
            padding:5px 10px;
            display: flex;
            // border-top: 1px solid #cccccc;
            .left{
                width: 55px;
                .left-img{
                    position: relative;
                    width: 45px;
                    height: 45px;
                    overflow: hidden;
                    img{
                        position: absolute;
                        height: 100%;
                        width: 100%;
                        border-radius: 50%;
                    }
                }
            }
            .right{
                flex: 1;
                .name{
                    font-size: 16px;
                    font-weight: bold;
                    .rang{
                        font-weight: normal;
                    }
                }
            }
        }
    }
    .funtion-bar{
        position: fixed;
        bottom: 0;
        width: 100%;
        height: 35px;
        padding: 10px 0;
        border-top: 1px solid #cccccc;
        background-color: #fff;
        div{
            flex: 1;
            align-items: center;
            &:nth-child(1),&:nth-child(2){
                border-right: 1px solid #cccccc;
            }
        }
    }
}
</style>
