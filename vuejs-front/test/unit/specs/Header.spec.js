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

  it('should contains title', () => {
    // then
    const title = wrapper.find('h1')
    expect(title.text()).toEqual("Testing Vue.js with Beers CRUD")
  })

  it('should contains logo img', () => {
    // then
    expect(wrapper.find('img')).toBeDefined()
  })
})
