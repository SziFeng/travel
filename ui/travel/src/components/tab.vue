<template>
  <div class="myflex3 f-bar">
    <div v-for="(item,index) in list" :key="index" style="flex:1;text-align:center;" @click="goTo(item,index)">
      <div style="text-align:center">
        <svg class="icon" aria-hidden="true">
          <use :xlink:href="type===index?item.sicon:item.icon"></use>
        </svg>
      </div>
      <div :style="{color:type===index?'#1296db':'#000000'}">{{item.name}}</div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'tab',
  props: {
    list: {
      type: Array,
      default: () => {
        return [
          { name: '首页', icon: '#icon-shouye-2', sicon: '#icon-shouye', path: 'home', center: false },
          { name: '目的地', icon: '#icon-b2', sicon: '#icon-bendihua', path: 'destination', center: false },
          { name: '消息', icon: '#icon-huifupingluns-2', sicon: '#icon-huifupingluns', path: 'notes', center: false },
          { name: '我的', icon: '#icon-gerencanshu-2', sicon: '#icon-gerencanshu', path: 'person', center: false }
        ]
      }
    }
  },
  data () {
    return {
      type: 0
    }
  },
  methods: {
    goTo (data, index) {
      this.type = index
      this.$router.push({ name: data.path })
      this.$emit('change', index)
    }
  }
}
</script>
