<template>
  <div class="myflex2" style="margin:10px" @click="to?$router.push({name:to}):''">
      <div class="myflex1">
          <div style="padding:0 5px">
            <svg class="icon" aria-hidden="true">
                <use :xlink:href="'#'+icon"></use>
            </svg>
          </div>
          <div style="font-size:18px;color:#666666;lineHeight:1.8;padding-left:15px">{{name}}</div>
      </div>
      <div>
        <svg class="icon" aria-hidden="true">
            <use xlink:href="#icon-youjian"></use>
        </svg>
      </div>
  </div>
</template>

<script>
export default {
  name: 'list',
  props: {
    icon: String,
    name: String,
    to: {
      default: '',
      type: String
    }
  },
  data () {
    return {
    }
  }
}
</script>
