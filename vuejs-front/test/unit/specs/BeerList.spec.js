import { mount, createLocalVue } from '@vue/test-utils'
import BeerService from '@/services/beer.service'
import flushPromises from 'flush-promises'
import BeerList from '@/components/BeerList'
import Vuetify from 'vuetify';

jest.mock('@/services/beer.service', () => ({
  get: jest.fn(),
  remove : jest.fn()
 }))

describe('BeerList.vue', () => {
  let wrapper;

  beforeEach(() => {
    const localVue = createLocalVue()
    localVue.use(Vuetify); 

    jest.clearAllMocks()

    wrapper = mount(BeerList, { 
      localVue: localVue
    });
  });


  it('should render with no result msg', async  () => {
    // given 
    BeerService.get.mockReturnValue([])

    // then
    await flushPromises()

    expect(BeerService.get).toHaveBeenCalled()
    expect(wrapper.find(".alert > div").text()).toContain("No more beers :(")
  })


  it('should render with two rows', () => {
    // given 
    const response = [
      {
        name :"beer1",
        country : "country1",
        uuid : "uuid1"
      },
      {
        name :"beer2",
        country : "country2",
        uuid : "uuid2"
      }
    ];
    BeerService.get.mockReturnValue(Promise.resolve(response))

    // then
    flushPromises().then(() => {
      expect(BeerService.get).toHaveBeenCalled()
      console.log(wrapper.find("tbody").html())
      expect(wrapper.findAll("tbody > tr").length).toEqual(2)
    })   
  })

  it('should delete beer', async () => {
    // given 
    const response = [
      {
        name :"beer1",
        country : "country1",
        uuid : "uuid1"
      },
      {
        name :"beer2",
        country : "country2",
        uuid : "uuid2"
      }
    ];
    BeerService.get.mockReturnValue(Promise.resolve(response))

    await flushPromises()

    wrapper.find('button').trigger('click')

    await flushPromises()

    expect(BeerService.remove).toHaveBeenCalled()
    expect(wrapper.findAll("tbody > tr").length).toEqual(1)
  })
})
