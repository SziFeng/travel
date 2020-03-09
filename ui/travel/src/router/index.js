import Vue from 'vue'
import VueRouter from 'vue-router'
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push (location) {
  return originalPush.call(this, location).catch(err => err)
}

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'main',
    redirect: '/home',
    component: () => import('../views/main'),
    children: [
      {
        path: '/home',
        name: 'home',
        component: () => import('../views/home/home')
      },
      {
        path: '/strategy',
        name: 'strategy',
        component: () => import('../views/strategy/strategy')
      },
      {
        path: '/user',
        name: 'user',
        component: () => import('../views/user/user')
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/login.vue')
  }
]

const router = new VueRouter({
  routes
})
router.beforeEach((to, from, next) => {
  next()
})
export default router
