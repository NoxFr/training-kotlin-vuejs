import axios from 'axios'
import config from '@/services/config.service'

const url = `${config.serverURL}/beers`

class BeerService {
  static async get () {
    return axios.get(url)
  }

  static async remove (beer) {
    return axios.delete(url + '/' + beer.uuid)
  }

  static async add (beer) {
    return axios.post(url, beer)
  }
}

export default BeerService
