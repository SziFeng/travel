<template>
  <div>
    <div class="container">
      <div class="conyent" style="border-bottom:1px solid #ccc;margin:0 0 15px" v-for="(item,index) in 4" :key="index">
        <div class="title" style="padding:20px;text-align:center;background-image: linear-gradient(to right, skyblue , Greenyellow);">
          <div>热门目的地</div>
          <div>最受大家喜欢的目的地推荐</div>
        </div>
        <div class="name" style="border-top:1px #ccc solid">
          <van-tabs animated>
            <van-tab title="国内">
              <div style="display:flex">
                <div v-for="(item,index) in 2" :key="index" >
                  <div style="padding:7px 7px 3px;flex:1">
                    <img src="@/assets/image/img1.png" alt=""  width="100%">
                  </div>
                  <div style="text-align:center">广州</div>
                </div>
              </div>
            </van-tab>
            <van-tab title="港澳台">内容 2</van-tab>
            <van-tab title="日韩">内容 3</van-tab>
            <van-tab title="东南亚">内容 4</van-tab>
            <van-tab title="东南亚">内容 4</van-tab>
            <van-tab title="东南亚">内容 4</van-tab>
            <van-tab title="东南亚">内容 4</van-tab>
          </van-tabs>
        </div>
        <div style="padding:20px 80px;text-align:center">
          <div style="border:1px solid skyblue;padding:10px 0">加载更多</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script scoped>
export default {
  name: 'strategy'
}
</script>
