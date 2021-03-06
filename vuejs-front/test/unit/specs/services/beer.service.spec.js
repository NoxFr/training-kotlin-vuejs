import BeerService from '@/services/beer.service'
import axios from 'axios'
import flushPromises from 'flush-promises'

jest.mock('axios', () => ({
    get: jest.fn(),
    delete: jest.fn(),
    post: jest.fn()
}))

describe('BeerService', () => {

    beforeEach(() => {
        jest.clearAllMocks()
    })

    it('should call GET /beers', async () => {

        // given
        const response = [
            {
                name: "beer1",
                country: "country1",
                uuid: "uuid1"
            },
            {
                name: "beer2",
                country: "country2",
                uuid: "uuid2"
            }
        ]
        axios.get.mockReturnValue(Promise.resolve(response))

        // When
        let result = BeerService.get()

        expect(axios.get).toBeCalledWith('http://localhost:9000/beers')
    })

    it('should call DELETE on /beer/1234567890', () => {

        // given
        const beer = {
            uuid: '1234567890',
            name: 'guinness',
            country: 'ireland'
        }

        axios.delete.mockReturnValue({})

        // When
        let result = BeerService.remove(beer)

        expect(axios.delete).toBeCalledWith('http://localhost:9000/beers/1234567890')
    })

  it('should call POST on /beers', () => {

    // given
    const beer = {
      uuid: '1234567890',
      name: 'guinness',
      country: 'ireland'
    }

    axios.post.mockReturnValue({})

    // When
    let result = BeerService.add(beer)

    expect(axios.post).toBeCalledWith('http://localhost:9000/beers', beer)
  })
})
