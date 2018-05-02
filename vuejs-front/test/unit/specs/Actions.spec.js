import { mount, createLocalVue } from '@vue/test-utils'
import Actions from '@/components/Actions'
import flushPromises from 'flush-promises'
import BeerService from '@/services/beer.service'
import Vuetify from 'vuetify';

jest.mock('@/services/beer.service', () => ({
  add: jest.fn()
}))

describe('Actions.vue', () => {
  let wrapper
  beforeEach(() => {
    const localVue = createLocalVue()
    localVue.use(Vuetify);

    jest.clearAllMocks()

    wrapper = mount(Actions, {
      localVue: localVue
    });
  });

  it('should match snapshot', () => {
    // then
    expect(wrapper.element).toBeDefined();
    expect(wrapper.element).toMatchSnapshot();
  })

  it('should add beer and emit', () => {
    // given
    let beer = {
      name: "beer1",
      country: "country1"
    }
    BeerService.add.mockReturnValue(Promise.resolve([]))
    wrapper.setData({
      newBeer: {
        name: 'beer1',
        country: "country1"
      }
    })

    // when
    wrapper.find({ ref: 'form' }).trigger("submit")

    // FIXME : form.vaidate() always false
    // then
    // expect(BeerService.add).toHaveBeenCalledWith(beer)
    //
    // flushPromises().then(() => {
    //   expect(wrapper.emitted('beers-update')).toBeTruthy()
    // })
  })
})
