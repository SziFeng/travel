<template>
  <div class="diary">
    <!-- <div class="bgc-img"><img src="../../../assets/image/img1.png" alt=""></div> -->
    <van-sticky>
      <van-nav-bar >
        <template #title>
          <van-tabs animated color="#1296db" :border="false" sticky title-active-color="#1296db">
            <van-tab v-for="(item,index) in ['关注','推荐']" :key="index" :title="item" >
            </van-tab>
          </van-tabs>
        </template>
      </van-nav-bar>
    </van-sticky>
    <div class="content">
      <div class="item-card-cell" v-for="(item,index) in 5" :key="index">
        <div class="title">
          <div class="left"><div class="img"><img src="../../../assets/image/login.jpg" alt=""></div></div>
          <div class="myflex2 right">
            <div class="name">
              <div>不在飞的鱼</div>
              <div>人生如逆旅，我是行人</div>
            </div>
            <div class="myflex1">
             <van-button type="primary" size="small" color="#1296db">关注</van-button>
            </div>
          </div>
        </div>
        <div class="passage-content">
          <div class="item-card" >
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
    </div>
    <add-btn></add-btn>
  </div>
</template>

<script>
export default {
  name: 'diary'
}
</script>

<style lang="scss">
.diary{
  .bgc-img{
    position: relative;
    width: 100%;
    height: 200px;
    overflow: hidden;
    img{
      position: absolute;
      width: 100%;
      height: 100%;
    }
  }
  .content{
    .item-card-cell{
      margin:10px 0 0;
      padding: 10px 10px 0;
      box-shadow: 1px 1px 10px 1px #ccc;
      .title{
        display: flex;
        line-height: 1.8;
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
                color: #000000;
              }
            }
          }
          .btn{
            flex: 3;
          }
        }
      }
      .passage-content{
        .item-card{
          padding: 5px 0 ;
          // border-bottom: 1px solid #cccccc;
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
              line-height: 1.8;
            }
          }
        }
      }
    }
  }
}
</style>
