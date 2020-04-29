// const components = {}
export default (Vue) => {
  // 自定义ui组件
  Vue.component('fTab', () => import('@/components/tab'))
  Vue.component('fButton', () => import('@/components/tactile'))
  Vue.component('fInput', () => import('@/components/flied'))
  Vue.component('fBar', () => import('@/components/top'))
  Vue.component('fList', () => import('@/components/list'))
  Vue.component('fSwipe', () => import('@/components/swipe'))
  // 自定义的普通组件
  Vue.component('comment', () => import('@/components/comment'))
  Vue.component('addBtn', () => import('@/components/addBtn'))
}
