const autoprefixer = require('autoprefixer')
const pxtorem = require('postcss-pxtorem')
const pxtoviewport = require('postcss-px-to-viewport')

module.exports = {
  outputDir: 'dist',
  publicPath: process.env.NODE_ENV === 'production' ? '/vant-demo/' : '/',
  devServer: {
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
        plugins: [
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
