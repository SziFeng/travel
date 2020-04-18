<template>
    <div class="f-input myflex1" :style="{backgroundColor:backgroundColor}">
        <div class="icon-item" v-if="showIcon">
            <!--
                user-----用户
                location------地址
                phone-----电话
                mail------邮箱
                lock-----锁
             -->
            <svg class="icon" aria-hidden="true">
                <use :xlink:href="'#icon-'+type"></use>
            </svg>
        </div>
        <div class="input-item">
          <input
            :style="{backgroundColor:backgroundColor}"
            :type="type==='lock'?'password':'text'"
            :placeholder="placeholder"
            :value="currentValue"
            @input="handleInput">
        </div>
    </div>
</template>

<script>
export default {
  name: 'flied',
  props: {
    type: {
      default: 'user',
      type: String
    },
    placeholder: {
      default: '请输入',
      type: String
    },
    showIcon: {
      default: true,
      type: Boolean
    },
    username: {
      default: '',
      type: String
    },
    backgroundColor: {
      default: '#e6e6e6',
      type: String
    },
    value: String || Number
  },
  data () {
    return {
    }
  },
  computed: {
    currentValue () {
      return this.value
    }
  },
  methods: {
    handleInput (event) {
      let value = event.target.value
      this.$emit('input', value) // 触发 input 事件，并传入新值
    }
  }
}
</script>
