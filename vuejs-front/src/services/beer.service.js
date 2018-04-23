import {HTTP} from '@/services/http-common'
import config from '@/services/config.service'

const url = `${config.serverURL}/beers`

class BeerService {
  static async get () {
    return HTTP.get(url).then(response => {
      return Promise.resolve(response.data)
    }).catch(e => {
      console.log(e)
    })
  }

  static async remove (beer) {
    return HTTP.delete(url + '/' + beer.uuid).then(response => {
      console.log('item deleted')
    }).catch(e => {
      console.log(e)
    })
  }
}

export default BeerService
