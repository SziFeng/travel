const autoprefixer = require('autoprefixer')
const pxtorem = require('postcss-pxtorem')
const pxtoviewport = require('postcss-px-to-viewport')

module.exports = {
  outputDir: 'dist', // 输出文件夹
  publicPath: process.env.NODE_ENV === 'production' ? '/vant-demo/' : '/', // 生产环境的切换
  devServer: { // 启动配置和代理请求设置
    hot: true,
    host: '0.0.0.0',
    port: 8081,
    open: false,
    proxy: {
      '/': {
        ws: false,
        target: 'http://127.0.0.1:8888/',
        changeOrigin: true
      }
    }
  },
  css: {
    loaderOptions: {
      postcss: {
        plugins: [// 自适应设备配置
          autoprefixer(),
          pxtorem({
            rootValue: 37.5,
            propList: ['*']
          }),
          pxtoviewport({
            viewportWidth: 375
          })
        ]
      }
    }
  }
}
