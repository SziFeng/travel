<template>
  <div id="app">
      <transition name="slide-right" >
        <router-view></router-view>
      </transition>
  </div>
</template>

<style lang="scss" scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #000000;
  font-size: 16px;
  overflow: hidden;
  width: 100%;
}
</style>
