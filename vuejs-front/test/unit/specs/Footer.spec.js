import { mount, createLocalVue } from '@vue/test-utils'
import Footer from '@/components/Footer'
import Vuetify from 'vuetify';

describe('Footer.vue', () => {
  let wrapper
  beforeEach(() => {
    const localVue = createLocalVue()
    localVue.use(Vuetify); 
  
    wrapper = mount(Footer, { 
      localVue: localVue
    });
  });

  it('should match snapshot', () => {
    // then
    expect(wrapper.element).toBeDefined();
    expect(wrapper.element).toMatchSnapshot();
  })
})
