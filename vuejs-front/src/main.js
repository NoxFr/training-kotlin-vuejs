import Vue from 'vue'
import App from '@/App.vue'
import Vuetify from 'vuetify'
import '@fortawesome/fontawesome'
import '@fortawesome/fontawesome-free-brands'
import '@fortawesome/fontawesome-free-solid'

// css resources
import 'vuetify/dist/vuetify.min.css'
import 'material-design-icons-iconfont/dist/material-design-icons.css'

Vue.use(Vuetify)

new Vue({ // eslint-disable-line no-new
  el: '#app',
  render: h => h(App)
})
