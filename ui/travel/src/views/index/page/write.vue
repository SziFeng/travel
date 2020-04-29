<template>
  <div class="write">
    <van-nav-bar @click-left="$router.go(-1)" title="写游记" >
      <template #left>
        <van-icon name="arrow-left" size="0.6rem" color="#1296db"/>
      </template>
      <template #right>
        <van-button type="info" size="small" color="#1296db" @click="send">发布</van-button>
      </template>
    </van-nav-bar>
    <div class="text">
      <textarea class="textarea" name="" id="" placeholder="说说你的想法和感受经历" v-model="paramsData.content"></textarea>
    </div>
    <div class="img">
      <van-uploader v-model="fileList" multiple :max-count="3" preview-size="2.93rem"/>
    </div>
    <van-cell :title="item.name"  size="large" v-for="(item,index) in list" :key="index" is-link title-class="title-class" @click="getAddress">
      <!-- 使用 right-icon 插槽来自定义右侧图标 -->
      <template #icon>
        <svg class="icon" aria-hidden="true">
            <use :xlink:href="'#'+item.icon"></use>
        </svg>
      </template>
    </van-cell>
  </div>
</template>

<script>
import { mapState, mapMutations } from 'vuex'
export default {
  name: 'write',
  data () {
    return {
      fileList: [],
      list: [
        { name: '所在地点', icon: 'icon-location2', path: '', fun: 'getAddress' },
        { name: '添加标签', icon: 'icon-weitianjiabiaoqian', path: '' }
      ],
      paramsData: {
        title: 'dd',
        content: '',
        location: 'aa',
        tags: 'sd',
        pic: []
      }
    }
  },
  computed: {
    ...mapState(['address'])
  },
  methods: {
    ...mapMutations(['setAddress']),
    send () {
      console.log('paramsData', this.paramsData)
      this.getImg()
    },
    getAddress () {
      this.$router.push({ name: 'sightsInfo' })
      console.log('getAddress')
    },
    getImg () {
      // console.log('data', new FormData())
      let data = new FormData()
      data.append('file1', this.fileList[0].file)
      data.append('file2', this.fileList[1].file)
      data.append('file3', this.fileList[2].file)
      data.append('title', this.paramsData.title)
      data.append('content', this.paramsData.content)
      data.append('location', this.paramsData.location)
      data.append('tags', this.paramsData.tags)
      this.$api.getImg(data).then(res => {
        if (res.data) {
          console.log('sss')
        }
      })
    }
  },
  mounted () {
    this.list[0].name = this.address.name
  }
}
</script>

<style lang="scss">
.write{
  .text{
    position: relative;
    min-height: 200px;
    max-height: 700px;
    border-radius: 8px;
    overflow: hidden;
    .textarea{
      position: absolute;
      width: 335px;
      height: 85%;
      border-radius: 8px;
      padding: 10px;
      margin: 10px;
      background-color: #f7f7f7;
      font-size: 16px;
      color: #666666;
      border:none;
    }
    .textarea:focus{
      border:5px !important;
      outline: none;
    }
  }
  .img{
      padding: 10px;
  }
}
</style>
