import { shallow } from '@vue/test-utils'
import Header from '@/components/Header'

describe('Header.vue', () => {
  it('should contains title', () => {
    // when
    const wrapper = shallow(Header)

    // then
    const title = wrapper.find('h1')
    expect(title.text()).toEqual("Testing Vue.js with Beers CRUD")
  })

  it('should contains logo img', () => {
    // when
    const wrapper = shallow(Header)

    // then
    expect(wrapper.find('img')).toBeDefined()
  })
})
