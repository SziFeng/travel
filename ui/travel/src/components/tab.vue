<template>
  <div class="myflex3 f-bar">
    <div v-for="(item,index) in list" :key="index" style="flex:1;text-align:center;" @click="goTo(item,index)">
      <div style="text-align:center">
        <svg class="icon" aria-hidden="true">
          <use :xlink:href="type===index?item.sicon:item.icon"></use>
        </svg>
      </div>
      <div class="name" :style="{color:type===index?'#1296db':'#000000'}">{{item.name}}</div>
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
        return []
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
  },
  mounted () {
    this.type = this.list.findIndex(res => res.path === this.$route.name)
  }
}
</script>
