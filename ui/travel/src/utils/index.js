import axios from 'axios'
import QS from 'qs'
// import { router } from '@/router/index'
// import myStore from '@/store/index'
const fetch = {}
axios.defaults.withCredentials = true
// http request(请求拦截)
axios.interceptors.request.use(
  config => {
    // console.log('请求拦截', config)
    // 设置vuex属性加载中
    // myStore.commit('tab/setSearchState', false)
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
  Vue.$post = (url, params) => {
    return new Promise((resolve, reject) => {
      axios.post(url, QS.stringify(params), { headers: { 'Content-Type': 'application/x-www-form-urlencoded' } })
        .then(response => {
          resolve(response.data)
        }).catch((error) => {
          reject(error)
        })
    })
  }
  // get请求(Request Payload)
  Vue.$get = (url, params = {}) => {
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

  Vue.$from = (url, params) => {
    return new Promise((resolve, reject) => {
      axios.post(url, params, { headers: { 'Content-Type': 'multipart/form-data' } })
        .then(response => {
          resolve(response.data)
        }).catch((error) => {
          reject(error)
        })
    })
  }
  // put请求(Request Payload)
  Vue.$put = (url, params) => {
    return new Promise((resolve, reject) => {
      axios.put(url, params, { headers: { 'Content-Type': 'application/json' } })
        .then(response => {
          resolve(response.data)
        })
        .catch(err => {
          reject(err.data)
        })
    })
  }
  // delete请求(From Data)
  Vue.$delete = (url, params) => {
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
