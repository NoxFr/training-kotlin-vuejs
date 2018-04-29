import { shallow } from '@vue/test-utils'
import App from '@/App'
import Vue from 'vue'
import Vuetify from 'vuetify';
Vue.use(Vuetify);

describe('App.vue', () => {
  it('should match snapshot', () => {
    // when
    const wrapper = shallow(App)

    // then
    expect(wrapper.element).toBeDefined();
    expect(wrapper.element).toMatchSnapshot();
  })
})
