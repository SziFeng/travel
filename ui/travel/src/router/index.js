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
    name: 'index',
    redirect: '/login',
    component: () => import('../views/index'),
    children: [
      {
        path: '/home',
        name: 'home',
        meta: { index: 0 },
        component: () => import('@/views/index/home')
      },
      {
        path: '/destination',
        name: 'destination',
        meta: { index: 1 },
        component: () => import('@/views/index/destination')
      },
      {
        path: '/person',
        name: 'person',
        meta: { index: 2 },
        component: () => import('@/views/index/person')
      },
      {
        path: '/notes',
        name: 'notes',
        meta: { index: 3 },
        component: () => import('@/views/index/notes')
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/login')
  },
  {
    path: '/regist',
    name: 'regist',
    component: () => import('../views/regist')
  }
]

const router = new VueRouter({
  routes
})
router.beforeEach((to, from, next) => {
  next()
})
export default router
