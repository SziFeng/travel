<template>
  <div>
    <f-bar text="消息" :left="false"></f-bar>
    <div class="myflex4">
      <div class="swipe-tab ">
        <div class="item" :class="[type===item.id?'select':'']" v-for="item in nameList" :key="item.id" @click="type=item.id">{{item.name}}</div>
      </div>
    </div>
    <div class="empty-notes">
      <svg class="icon" aria-hidden="true"><use xlink:href="#icon-kongbaiye-muyoushoucang"></use></svg>
      <div>暂无消息</div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'notes',
  data () {
    return {

      type: 0,
      nameList: [
        { id: 0, name: '通知', code: '' },
        { id: 1, name: '评论', code: '' },
        { id: 2, name: '推荐', code: '' },
        { id: 3, name: '私信', code: '' },
        { id: 4, name: '其他', code: '' }
      ]
    }
  }
}
</script>

<style lang="scss">
.empty-notes{
  font-size: 180px;
  text-align: center;
  div{
    font-size: 28px;
    color: #999999;
  }
}
</style>
