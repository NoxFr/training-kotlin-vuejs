import { mount, createLocalVue } from '@vue/test-utils'
import App from '@/App'
import Vuetify from 'vuetify';

describe('App.vue', () => {
  let wrapper;

  beforeEach(() => {
    const localVue = createLocalVue()
    localVue.use(Vuetify); 
  
    wrapper = mount(App, { 
      localVue: localVue
    });
  });


  it('should match snapshot', () => {
    // then
    expect(wrapper.element).toBeDefined();
    expect(wrapper.element).toMatchSnapshot();
  })
})
