// const components = {}
export default (Vue) => {
  Vue.component('fTab', () => import('@/components/tab'))
  Vue.component('fButton', () => import('@/components/tactile'))
  Vue.component('fInput', () => import('@/components/flied'))
  Vue.component('fBar', () => import('@/components/top'))
  Vue.component('fList', () => import('@/components/list'))
  Vue.component('fSwipe', () => import('@/components/swipe'))
}
