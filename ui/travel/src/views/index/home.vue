<template>
<div>
  <div class=" myflex1 titleSeach">
    <div class="address myflex3">
      <svg class="icon" aria-hidden="true"><use xlink:href="#icon-location2"></use></svg>
      <span>广东</span>
    </div>
    <div class="t-input"><f-input :showIcon="false" backgroundColor="#f7f7f7" radius="10" size="small" placeholder="你想去哪玩？"></f-input></div>
    <div class="lin myflex3"><svg class="icon" aria-hidden="true"><use xlink:href="#icon-lingdang"></use></svg></div>
  </div>
  <f-swipe :list="imgList" :autoplay="false"></f-swipe>
  <div class="mygrid4 title-cont">
    <div v-for="(item,index) in titleList" :key="index" @click="$router.push({name:item.path})">
      <div class="cell1">
        <svg class="icon titleIcon" aria-hidden="true">
            <use :xlink:href="'#'+item.icon"></use>
        </svg>
      </div>
      <div class="cell2">{{item.name}}</div>
    </div>
  </div>
  <div class="myflex2 name-bar">
    <div style="font-weight:550">热门推荐</div>
    <div class="myflex2 more">换一组<svg class="icon rightIcon" aria-hidden="true"><use xlink:href="#icon-shuaxin2"></use></svg></div>
  </div>
  <div class="mygrid3 bar-cont">
    <div v-for="(item,index) in barList" :key="index" >
      <div class="cell1"><img :src="item.img" alt=""></div>
      <div class="cell2">{{item.name}}</div>
      <div class="cell3">{{item.details}}</div>
    </div>
  </div>
  <div class="myflex2 name-bar">
    <div style="font-weight:550">精选游记</div>
    <div class="myflex2">
      <f-button
        v-for="(item,ind) in buttonList"
        :key="ind"
        radius="100"
        :text="item.name"
        size="small"
        :backgroundColor="type1===ind?'#000000':'#CCCCCC'"
        @click="type1=ind"
        style="padding:0 5px"></f-button>
    </div>
  </div>
  <div class="item-card">
    <div class="card" v-for="(item,index) in 5" :key="index">
      <div class="item1"><img src="../../assets/image/img3.png" alt=""></div>
      <div class="myflex2 item2">
        <div class="left">
          <div class="cell1">
            像缘梦湛放这样的，集漂亮小姐姐和帅气小哥哥于一身的地方，实在不多
          </div>
          <div class="cell2 myflex1">
            <svg class="icon " aria-hidden="true"><use xlink:href="#icon-eye2"></use></svg>
            <span style="margin-right:10px">2222</span>
            <svg class="icon" aria-hidden="true"><use xlink:href="#icon-shijian"></use></svg>
            <span>2020.04.19 12:43:67</span>
          </div>
        </div>
        <div class="right">
          <ul><li><img src="../../assets/image/login.jpg" alt=""></li></ul>
        </div>
      </div>
    </div>
  </div>
</div>
</template>

<script>
export default {
  name: 'home',
  data () {
    return {
      titleList: [
        // { name: '景点', icon: 'icon-jingdian1', path: '' },
        { name: '游记', icon: 'icon-youji1', path: 'diary' },
        // { name: '美食', icon: 'icon-zhaomeishi-', path: '' },
        { name: '导览', icon: 'icon-jingqudaolan1', path: '' },
        // { name: '目的地', icon: 'icon-mudediguojia', path: '' },
        // { name: '卫生间', icon: 'icon-gonggongcesuo', path: '' },
        { name: '翻译', icon: 'icon-fanyi', path: '' },
        { name: '识花草', icon: 'icon-paizhaoshibie', path: '' }
      ],
      barList: [
        { name: '海边', details: '风景优美，身临其境', path: '', img: require('../../assets/image/img1.png') },
        { name: '校园风光', details: '风景优美，身临其境', path: '', img: require('../../assets/image/img2.png') },
        { name: '绿岛', details: '风景优美，身临其境', path: '', img: require('../../assets/image/img4.png') }
      ],
      buttonList: [
        { name: '最新' },
        { name: '最热' },
        { name: '精华' }
      ],
      imgList: [
        { id: 2, img: require('@/assets/image/img1.png') },
        { id: 3, img: require('@/assets/image/img2.png') },
        { id: 4, img: require('@/assets/image/img3.png') },
        { id: 5, img: require('@/assets/image/img4.png') }
      ],
      type1: 0
    }
  }
}
</script>

<style lang="scss">
.titleSeach{
  padding: 10px 0 5px;
  .address,.lin{
    flex: 2;
    font-size: 16px;
    line-height: 1.5;
  }
  .t-input{
    flex: 7;
  }
}
.title-cont{
  padding:0 10px;
  border-radius: 20px;
  div{
    .cell1{
      text-align: center;
      .titleIcon{
        font-size: 40px;
      }
    }
    .cell2{
      text-align: center;
      color: #666666;
    }
  }
}
.name-bar{
  font-size: 18px;
  padding: 10px;
  .more{
    font-size: 16px;
    color:#777777;
    .rightIcon{
      padding:0 5px;
      font-size: 10px;
    }
  }
}
.bar-cont{
  padding: 0 5px;
  div{
    margin:3px auto;
    .cell1{
      position: relative;
      width: 110px;
      height: 110px;
      overflow: hidden;
      border-radius: 15px;
      img{
        position: absolute;
        width: 100%;
        height: 100%;
        border-radius: 15px;
      }
    }
    .cell2{
      text-align: center;
      font-size: 15px;
      font-weight: 500;
    }
    .cell3{
      width: 110px;
      text-align: center;
      font-size: 12px;
      color: #666666;
      overflow: hidden;
      white-space: nowrap;
      text-overflow: ellipsis;
    }
  }
}
.card{
  margin:15px 10px;
  box-shadow: 1px 0 5px #aaaaaa;
  border-radius: 15px;
  .item1{
    position: relative;
    height: 200px;
    width: 100%;
    overflow: hidden;
    border-top-left-radius: 15px;
    border-top-right-radius: 15px;
    img{
      position: absolute;
      width: 100%;
      height: 100%;
      border-top-left-radius: 15px;
      border-top-right-radius: 15px;
    }
  }
  .item2{
    .left{
      flex:10;
      padding:5px 0 5px 10px;
      .cell1{
        font-size: 14px;
        font-weight: bold;
        color: #333333;
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 2;
        overflow: hidden;
      }
      .cell2{
        padding: 5px 0 2px;
        color: #8a8a8a;
        font-size: 13px;
      }
    }
    .right{
      flex:2.5;
      ul{
        padding: 0;
        margin: 0;
        height: 60px;
        width:60px;
        margin: auto;
        display: flex;
        align-items: center;
        border-radius: 50%;
        background-color: #fff;
        transform: translateY(-35px);
        li{
          position: relative;
          height: 50px;
          width: 50px;
          overflow: hidden;
          border-radius: 50%;
          margin: auto;
          img{
            position: absolute;
            width: 100%;
            height: 100%;
            border-radius: 50%;
          }
        }
      }
    }
  }
}
</style>
