import axios from 'axios'
import config from '@/services/config.service'

const url = `${config.serverURL}/beers`

class BeerService {
  static async get () {
    return axios.get(url)
      .then(response => {
        return Promise.resolve(response.data)
      })
      .catch(e => {
        console.log(e)
      })
  }

  static async remove (beer) {
    return axios.delete(url + '/' + beer.uuid)
  }
}

export default BeerService
