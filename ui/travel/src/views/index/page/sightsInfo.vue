<template>
  <div class="f-map">
    <div class="icon-youjiantou" @click="$router.go(-1)"> <svg class="icon" aria-hidden="true"><use xlink:href="#icon-zuojiantou"></use></svg></div>
    <div id="container"></div>
    <div class="list" v-if="listdata">
        <div v-for="(item,index) in listdata" :key="index" @click="select(item)">{{item.name}}</div>
    </div>
  </div>
</template>

<script>
import { mapMutations } from 'vuex'
export default {
  name: 'sightInfo',
  data () {
    return {
      text: '11',
      listdata: []
    }
  },
  methods: {
    ...mapMutations(['setAddress']),
    init () {
      /* eslint-disable */
      let that=this
      var map = new AMap.Map('container');
      map.plugin(['AMap.ToolBar','AMap.Geolocation'],function(){//异步同时加载多个插件
      var toolbar = new AMap.ToolBar();
      map.addControl(toolbar)
      let geolocation = new AMap.Geolocation({
        enableHighAccuracy: true,//是否使用高精度定位，默认:true
        timeout: 2000,          //超过10秒后停止定位，默认：无穷大
        maximumAge: 0,           //定位结果缓存0毫秒，默认：0
        convert: true,           //自动偏移坐标，偏移后的坐标为高德坐标，默认：true
        showButton: true,        //显示定位按钮，默认：true
        buttonPosition: 'LB',    //定位按钮停靠位置，默认：'LB'，左下角
        buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
        showMarker: true,        //定位成功后在定位到的位置显示点标记，默认：true
        showCircle: true,        //定位成功后用圆圈表示定位精度范围，默认：true
        panToLocation: true,     //定位成功后将定位到的位置作为地图中心点，默认：true
        zoomToAccuracy:true,      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
        extensions:'all'
      });
      map.addControl(geolocation)
       geolocation.getCurrentPosition();
      geolocation.getCurrentPosition((status,data)=>{
        if (status==='complete') {
          
          // data是具体的定位信息
          console.log('定位成功信息：', data);
          that.listdata=data.pois
        }
      })
            // AMap.event.addListener(geolocation, 'complete', onComplete);
            // AMap.event.addListener(geolocation, 'error', onError);

            // function onComplete(data) {
            //     // data是具体的定位信息
            //     console.log('定位成功信息：', data);
            //     that.listdata=data.pois
            //     // that.$set(this.listdata,data.pois)
            //     console.log('sss',that.listdata)
            // }

            // function onError(data) {
            //     // 定位出错
            //     console.log('定位失败错误：', data);
            //     // 调用ip定位
            //     that.getLngLatLocation();
            // }
      });
    },
    getLngLatLocation() {
        AMap.plugin('AMap.CitySearch', function () {
            var citySearch = new AMap.CitySearch();
            citySearch.getLocalCity(function (status, result) {
                if (status === 'complete' && result.info === 'OK') {
                    // 查询成功，result即为当前所在城市信息
                    console.log('通过ip获取当前城市：', result)
                    //逆向地理编码
                    AMap.plugin('AMap.Geocoder', function () {
                        var geocoder = new AMap.Geocoder({
                            // city 指定进行编码查询的城市，支持传入城市名、adcode 和 citycode
                            city: result.adcode
                        })

                        var lnglat = result.rectangle.split(';')[0].split(',');
                        geocoder.getAddress(lnglat, function (status, data) {
                            if (status === 'complete' && data.info === 'OK') {
                                // result为对应的地理位置详细信息
                                console.log(data)
                            }
                        })
                    })
                }
            })
        })
    },
    select(data){
      this.setAddress(data)
      this.$router.go(-1)
    }
  },
  mounted(){
    this.init()
    this.getLngLatLocation()
  },
  activated () {
    this.init()
    this.getLngLatLocation()
  }
}
</script>

<style lang="scss">
.f-map{
  .icon-youjiantou{
    position: absolute;
    left: 10px;
    top:20px;
    z-index: 99;
    font-size: 20px;
  }
#container {
  position: absolute;
  width: 100%;
  height: 50%;
}
.list{
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 50%;
  overflow: hidden;
  overflow-y: scroll;
  background-color: #f7f7f7;
  div{
    padding:10px;
    border-bottom: 1px solid #f9f9ff;
  }
}
}
</style>
