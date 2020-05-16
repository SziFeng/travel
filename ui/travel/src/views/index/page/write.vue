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
    <van-dialog v-model="show" title="文章标题" @confirm="sendData" show-cancel-button>
      <div class="title-inp">
        <input type="text" v-model="paramsData.title" placeholder="请输入对应名字">
      </div>
    </van-dialog>
  </div>
</template>

<script>
import { mapState, mapMutations } from 'vuex'
export default {
  name: 'write',
  data () {
    return {
      fileList: [],
      show: false,
      list: [
        { name: '所在地点', icon: 'icon-location2', path: '', fun: 'getAddress' },
        { name: '添加标签', icon: 'icon-weitianjiabiaoqian', path: '' }
      ],
      paramsData: {
        title: '',
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
      this.addEssay()
    },
    getAddress () {
      this.$router.push({ name: 'sightsInfo' })
      console.log('getAddress')
    },
    addEssay () {
      // console.log('data', new FormData())
      this.show = true
    },
    sendData () {
      if (this.fileList.length < 3 && this.paramsData.content !== '') {
        this.$toast.fail('内容不能为空')
      } else {
        let data = new FormData()
        data.append('file1', this.fileList[0].file)
        data.append('file2', this.fileList[1].file)
        data.append('file3', this.fileList[2].file)
        data.append('title', this.paramsData.title)
        data.append('content', this.paramsData.content)
        data.append('location', this.paramsData.location)
        data.append('tags', this.paramsData.tags)
        this.$api.addEssay(data).then(res => {
          if (res.data) {
            this.$toast.success('发布成功')
          }
        })
      }
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
  .title-inp{
    padding: 20px 0;
    display: flex;
    justify-content: center;
    input{
      border: 1px solid #666666;
      border-radius: 10px;
      padding: 5px;
    }
  }
}
</style>
