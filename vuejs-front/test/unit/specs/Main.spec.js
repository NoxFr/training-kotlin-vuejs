import { shallow } from '@vue/test-utils'
import Main from '@/components/Main'
import Vue from 'vue'
import Vuetify from 'vuetify';
Vue.use(Vuetify);

describe('Main.vue', () => {
  it('should match snapshot', () => {
    // when
    const wrapper = shallow(Main)

    // then
    expect(wrapper.element).toBeDefined();
    expect(wrapper.element).toMatchSnapshot();
  })
})
