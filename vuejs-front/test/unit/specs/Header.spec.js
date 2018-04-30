import { mount, createLocalVue } from '@vue/test-utils'
import Header from '@/components/Header'
import Vuetify from 'vuetify';

describe('Header.vue', () => {
  let wrapper

  beforeEach(() => {
    const localVue = createLocalVue()
    localVue.use(Vuetify);

    wrapper = mount(Header, {
      localVue: localVue
    });
  });

  it('should contains basic items', () => {
    // then
    const title = wrapper.find('h1')
    expect(title.text()).toEqual("Testing Vue.js with Beers CRUD")
    expect(wrapper.find('img')).toBeDefined()

  })
})
