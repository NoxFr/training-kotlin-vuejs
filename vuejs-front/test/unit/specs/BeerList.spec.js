import { shallow } from '@vue/test-utils'
import BeerService from '@/services/beer.service'
import BeerList from '@/components/BeerList'

jest.mock('@/services/beer.service', () => ({
  get: jest.fn(),
  remove : jest.fn()
 }))

describe('BeerList.vue', () => {

  beforeEach(() => {
    BeerService.get.mockReset()
    BeerService.get.mockReturnValue(Promise.resolve({}))
  });

  it('should render', () => {
    // when
    const wrapper = shallow(BeerList)

    // then
    expect(wrapper.element).toBeDefined()
  })

  it('should render with no result msg', () => {
    // given 
    const response = {};
    BeerService.get.mockReturnValue(Promise.resolve(response))

    // when
    const wrapper = shallow(BeerList)

    // then
    wrapper.vm.$nextTick(() => {
      expect(BeerService.get).toHaveBeenCalled()
      expect(wrapper.vm.msgInfo).toContain("No more beers :(")
    })
    
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

    // when
    const wrapper = shallow(BeerList)

    // then
    wrapper.vm.$nextTick(() => {
      expect(BeerService.get).toHaveBeenCalled()
      expect(wrapper.findAll("tr").length).toEqual(3)

    })
  })

  it('should delete beer', () => {
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

    // when
    const wrapper = shallow(BeerList)

    wrapper.vm.$nextTick(() => {
      wrapper.find('button').trigger('click')

      // then
      expect(BeerService.remove).toHaveBeenCalled()
      expect(wrapper.findAll("tr").length).toEqual(2)
    })
  })

})
