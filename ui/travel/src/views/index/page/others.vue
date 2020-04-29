<template>
  <div class="others">
    <f-bar text="个人" :right="true"></f-bar>
    <div class="title">
      <div class="left"><div class="img"><img src="../../../assets/image/login.jpg" alt=""></div></div>
      <div class="myflex2 right">
        <div class="name">
          <div>不在飞的鱼</div>
          <div>人生如逆旅，我是行人</div>
        </div>
        <div class="btn"><f-button text="关注" radius="10" ></f-button></div>
      </div>
    </div>
    <div class="myflex3 info-content">
      <div class="info-cell" v-for="(item,index) in list" :key="index">
        <div>{{item.count}}</div>
        <div>{{item.name}}</div>
      </div>
    </div>
    <div class="passage-content">
      <div class="item-card" v-for="(item,index) in 5" :key="index">
        <div class="myflex1 img-cell">
          <div class="left">
            <div class="left-img"><img src="../../../assets/image/img1.png" alt=""></div>
          </div>
          <div class="right">
            <div class="right-img"><img src="../../../assets/image/img3.png" alt=""></div>
            <div class="right-img"><img src="../../../assets/image/img4.png" alt=""></div>
          </div>
        </div>
        <div class="txt-cell">今天开始了缘梦湛放旅游的第一天，我们来到喜来登酒店，它位于湛江市霞山区，面向海边，能看到日落日出，是一个很不错的地方</div>
        <div class="funtion-cell myflex2" >
            <div class="myflex4">
                <svg class="icon " aria-hidden="true"><use xlink:href="#icon-xin1"></use></svg>
                <span>234</span>
            </div>
            <div class="myflex4">
                <svg class="icon " aria-hidden="true"><use xlink:href="#icon-xiaoxi"></use></svg>
                <span>234</span>
            </div>
            <div class="myflex4">
                <svg class="icon " aria-hidden="true"><use xlink:href="#icon-fenxiang"></use></svg>
                <span>234</span>
            </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'others',
  data () {
    return {
      list: [
        { name: '游记', count: 23 },
        { name: '获赞', count: 28 },
        { name: '评论', count: 25 },
        { name: '粉丝', count: 65 }
      ]
    }
  }
}
</script>

<style lang="scss">
.others{
  .title{
    display: flex;
    padding: 10px;
    .left{
      width: 60px;
      .img{
        position: relative;
        width: 55px;
        height: 55px;
        overflow: hidden;
        border-radius: 50%;
        img{
          position: absolute;
          width: 100%;
          height: 100%;
        }
      }
    }
    .right{
      flex: 1;
      .name{
        flex: 8;
        div{
          &:nth-child(1){
          font-size: 18px;
          font-weight: bold;
        }
        }
      }
      .btn{
        flex: 3;
      }
    }
  }
  .info-content{
    .info-cell{
      flex: 1;
      text-align: center;
      div{
        font-size: 14px;
        color: #666666;
        &:nth-child(1){
          font-size: 22px;
          line-height: 1;
          color: #000000;
          font-weight: bold;
        }
      }
    }
  }
  .passage-content{
    .item-card{
      margin:10px;
      padding: 5px 0 10px;
      border-bottom: 1px solid #cccccc;
      .img-cell{
        .left{
          border-radius: 15px;
          .left-img{
            position: relative;
            width: 220px;
            height: 150px;
            overflow: hidden;
            border-radius: 8px;
            img{
              position: absolute;
              width: 100%;
              height: 100%;
            }
          }
        }
        .right{
          padding-left: 8px;
          div{
            &:nth-child(1){
               margin-bottom: 10px;
            }
          }
          .right-img{
            position: relative;
            width: 125px;
            height:70px;
            overflow: hidden;
            border-radius: 10px;
            img{
              position: absolute;
              width: 100%;
              height: 100%;
            }
            }
        }
      }
      .txt-cell{
        padding:5px 0;
        font-size: 13px;
        color: #777777;;
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 3;
        overflow: hidden;
        text-overflow: ellipsis;
      }
      .funtion-cell{
        div{
          flex: 1;
        }
      }
    }
  }
}
</style>
