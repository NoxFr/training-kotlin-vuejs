import axios from 'axios'
import config from '@/services/config.service'

export const HTTP = axios.create({
  baseURL: config.serverURL,
  headers: {
    'Access-Control-Allow-Origin': config.serverURL,
    'Access-Control-Request-Method': '*'
  }
})
