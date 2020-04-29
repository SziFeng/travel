<template>
  <div class="addBtn">
      <div class="container" @click="$router.push({name:'write'})">
         <svg class="icon jia" aria-hidden="true"><use xlink:href="#icon-jia"></use></svg>
      </div>
  </div>
</template>

<script>
export default {
  name: 'addBtn'
}
</script>

<style lang="scss">
.addBtn{
    position: fixed;
    bottom: 80px;
    right: 20px;
    border-radius: 50%;
    box-shadow: 0 0 20px #cccccc;
    .container{
        .jia{
            font-size: 32px;
        }
    }
}
</style>
