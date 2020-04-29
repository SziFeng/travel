<template>
  <div class="passage">
    <van-nav-bar @click-left="$router.go(-1)"  title="游记">
        <template #left>
            <van-icon name="arrow-left" size="0.6rem" color="#1296db"/>
        </template>
    </van-nav-bar>
    <div class="myflex2 passage-title">
      <div class="details">
        <div class="cell1">感受美丽的鼓浪屿</div>
        <div class="cell2 myflex1">
          <svg class="icon " aria-hidden="true"><use xlink:href="#icon-eye2"></use></svg>
          <span style="margin-right:10px">2222</span>
          <svg class="icon" aria-hidden="true"><use xlink:href="#icon-shijian"></use></svg>
          <span>2020.04.22 12:43:67</span>
        </div>
      </div>
      <div class="btn"><van-button type="primary" size="small" color="#1296db">关注</van-button></div>
    </div>
    <div class="title">
      <div class="left"><div class="img"><img src="../../../assets/image/login.jpg" alt=""></div></div>
      <div class="myflex2 right">
        <div class="name">
          <div>不在飞的鱼</div>
          <div>人生如逆旅，我是行人</div>
        </div>
        <div class="myflex1">
          <svg class="icon " aria-hidden="true"><use xlink:href="#icon-xin1"></use></svg>
          <span>234</span>
        </div>
      </div>
    </div>
    <div class="context">
      <p>
        孔子读《易》“韦编三绝”，编竹简的牛筋断了次。杜甫“读书破万卷”，这才“下笔如有神”。韩愈“口不绝吟于六艺之文，手不停披于百家编”，“处若忘，行若思”。阅读对于写作的基础和前提的作用是必不可少的。阅读能够开阔思路，积累材料，掌握写作规律，丰富语言词汇。但是，这种作用是在潜移默化中进行的。一般来说，阅读越多对于写作的作用越大。多是无限的，但是以写为目的。
阅读的内容，一是阅读哲学、政治、经济、文学等方面的社会科学书籍。二是阅读社会科学和自然科学的书籍，文理兼通，尤其是阅读自己专业以外的书。三是阅读写作方面的书籍，揣摩名家的方法技巧
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'passage',
  data () {
    return {
    }
  }
}
</script>

<style lang="scss">
.passage{
  .passage-title{
    padding: 5px 15px;
    .details{
      flex: 10;
      .cell1{
        font-size: 24px;
        line-height: 1.8;
      }
      .cell2{
        text-align: center;
        color: #666666;
        font-size: 14px;
      }
    }
    .btn{
      flex: 3;
    }
  }
  .title{
    display: flex;
    padding: 10px;
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
  .context{
    padding: 0 5px 0 15px;
    p{
      margin-top: 0;
      text-indent:32px;
    }
  }
}
</style>
