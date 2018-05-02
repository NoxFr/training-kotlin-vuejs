<template>
  <div id="container">
    <v-data-table
      :items="items"
      :headers="headers"
      class="elevation-5">
        <template slot="items" slot-scope="props">
          <td>{{props.item.name}}</td>
          <td>{{props.item.country}}</td>
          <td class="text-xs-center"><v-btn flat small color="error" @click="removeItem(props.item)">Delete</v-btn></td>
      </template>
       <template slot="no-data">
        <v-alert :value="true" color="error" icon="warning">
          No more beers :(
        </v-alert>
      </template>
  </v-data-table>
  </div>
</template>

<script>
import BeerService from '@/services/beer.service'

export default {
  name: 'tkvBeerList',
  data () {
    return {
      headers: [
        { text: 'Name', value: 'name' },
        { text: 'From', value: 'country' }
      ],
      items: []
    }
  },
  async created () {
    this.getBeers()
  },
  methods: {
    removeItem (beer) {
      BeerService.remove(beer).then(() => {
        this.getBeers()
      })
    },
    getBeers () {
      BeerService.get().then(result => {
        this.items = result.data
      })
    }
  }
}
</script>
