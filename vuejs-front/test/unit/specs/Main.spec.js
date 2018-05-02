import { mount, createLocalVue } from '@vue/test-utils'
import Main from '@/components/Main'
import Vuetify from 'vuetify';

describe('Main.vue', () => {
  let wrapper

  beforeEach(() => {
    const localVue = createLocalVue()
    localVue.use(Vuetify);

    wrapper = mount(Main, {
      localVue: localVue
    });
  });

  it('should match snapshot', () => {
    // then
    expect(wrapper.element).toBeDefined();
    expect(wrapper.element).toMatchSnapshot();
  })

  it('should refresh beers', () => {
    // when


    // then
  })
})
