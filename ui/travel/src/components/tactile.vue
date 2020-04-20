<template>
   <div style="margin:0 auto" :style="{width:width}" >
      <div :class="{'f-button':size==='large','f-button-small':size==='small'}" >
        <button :style="{'borderRadius':radius+'px',backgroundColor:backgroundColor,color:color}" @click="$emit('click')">{{text}}</button>
      </div>
    </div>
</template>

<script>
export default {
  name: 'tactile',
  props: {
    text: {
      default: '按钮',
      type: String
    },
    width: {
      default: '100%',
      type: String
    },
    radius: {
      default: '',
      type: String || Number
    },
    backgroundColor: {
      default: '',
      type: String
    },
    color: {
      default: '',
      type: String
    },
    size: {
      default: 'large',
      type: String
    }
  },
  methods: {
  }
}
</script>
