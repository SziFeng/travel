import axios from 'axios'
import QS from 'qs'
// import { router } from '@/router/index'
// import myStore from '@/store/index'
const fetch = {}
axios.defaults.withCredentials = true
let pending = []
let removePending = (config) => {
  for (let p in pending) {
    if (pending[p].u === config.url) {
      pending[p].f()
      pending.splice(p, 1)
    }
  }
}
// http request(请求拦截)
axios.interceptors.request.use(
  config => {
    // console.log('请求拦截', config)
    // 设置vuex属性加载中
    // myStore.commit('tab/setSearchState', false)
    removePending(config)
    config.cancelToken = new axios.CancelToken((c) => {
      pending.push({ u: config.url, f: c })
    })
    return config
  },
  error => {
    return Promise.reject(error)
  }
)
// http response请求拦截
axios.interceptors.response.use(
  response => { // 成功请求到数据
    // 这里根据后端提供的数据进行对应的处理
    if (response.data) {
      return Promise.resolve(response)
    }
  },
  error => { // 响应错误处理
    return Promise.reject(error)
  }
)
fetch.install = (Vue, options) => {
  let host = process.env.NODE_ENV === 'development' ? options.domaintest : window.location.origin
  console.log(host)
  // axios.defaults.baseURL = host
  // post请求(From Data)
  Vue.$post_from = (url, params) => {
    return new Promise((resolve, reject) => {
      axios.post(url, QS.stringify(params), { headers: { 'Content-Type': 'application/x-www-form-urlencoded' } })
        .then(response => {
          resolve(response.data)
        }).catch((error) => {
          reject(error)
        })
    })
  }
  // post请求(Request Payload)
  Vue.$my_post = (url, params) => {
    return new Promise((resolve, reject) => {
      axios.post(url, params)
        .then(response => {
          resolve(response.data)
        })
        .catch(err => {
          reject(err)
        })
    })
  }
  // get请求(Request Payload)
  Vue.$my_get = (url, params = {}) => {
    return new Promise((resolve, reject) => {
      axios.get(url, {
        params: params
      })
        .then(response => {
          resolve(response.data)
        })
        .catch(err => {
          reject(err)
        })
    })
  }
  // put请求(Request Payload)
  Vue.$my_put = (url, params) => {
    return new Promise((resolve, reject) => {
      axios.put(url, params)
        .then(response => {
          resolve(response.data)
        })
        .catch(err => {
          reject(err.data)
        })
    })
  }
  // delete请求(From Data)
  Vue.$delete_from = (url, params) => {
    return new Promise((resolve, reject) => {
      axios.delete(url, QS.stringify(params), { headers: { 'Content-Type': 'application/x-www-form-urlencoded' } })
        .then(response => {
          resolve(response.data)
        }).catch((error) => {
          reject(error)
        })
    })
  }
}
export default fetch
