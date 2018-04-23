import Vue from 'vue'
import BootstrapVue from 'bootstrap-vue'
import App from './App.vue'

Vue.use(BootstrapVue)

new Vue({ // eslint-disable-line no-new
  el: '#app',
  render: h => h(App)
})
