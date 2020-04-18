<template>
<div class="myflex2 f-top" :style="{backgroundColor:backgroundColor}">
    <div class="left myflex4" @click="$router.go(-1)" v-if="left">
        <svg class="icon xian1" aria-hidden="true">
            <use xlink:href="#icon-ArtboardCopy"></use>
        </svg>
    </div>
    <div class="center" :style="{color:color}">{{text}}</div>
    <div class="right " ><span v-if="right" class="myflex4">
      <svg class="icon xian1" aria-hidden="true">
            <use xlink:href="#icon-moreread"></use>
        </svg>
    </span></div>
</div>
</template>

<script>
export default {
  name: 'top',
  props: {
    left: {
      default: true,
      type: Boolean
    },
    right: {
      default: false,
      type: Boolean
    },
    text: {
      default: '',
      type: String
    },
    backgroundColor: {
      default: 'skyblue',
      type: String
    },
    color: {
      default: '#555555',
      type: String
    }
  }
}
</script>
