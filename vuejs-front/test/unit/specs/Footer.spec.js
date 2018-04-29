import { shallow } from '@vue/test-utils'
import Footer from '@/components/Footer'
import Vue from 'vue'
import Vuetify from 'vuetify';
Vue.use(Vuetify);

describe('Footer.vue', () => {
  it('should match snapshot', () => {
    // when
    const wrapper = shallow(Footer)

    // then
    expect(wrapper.element).toBeDefined();
    expect(wrapper.element).toMatchSnapshot();
  })
})
