<template>
  <div id="container">
    <table v-if="filteredBeers.length > 0" class="table b-table">
        <thead>
            <tr>
                <th>Name</th>
                <th>From</th>
                <th class="col-sm-2">Actions</th>
            </tr>
        </thead>
        <tbody>
             <tr v-for="beer in filteredBeers" :key="beer.uuid">
                 <td>{{beer.name}}</td>
                 <td>{{beer.country}}</td>
                 <td><button class="btn btn-danger btn-xs" @click="removeItem(beer)">Delete</button></td>
             </tr>
        </tbody>
    </table>
  <div class="msgInfo" v-else>
    <span>{{msgInfo}}</span>
  </div>
  </div>
</template>

<script>
import BeerService from '@/services/beer.service'

export default {
  name: 'tkvBeerList',
  data () {
    return {
      filteredBeers: [],
      msgInfo: 'Loading...'
    }
  },
  async created () {
    this.filteredBeers = await BeerService.get()
    if (this.filteredBeers || this.filteredBeers.length > 0) {
      this.msgInfo = 'No more beers :('
    }
  },
  methods: {
    removeItem (beer) {
      BeerService.remove(beer)
      this.filteredBeers.splice(this.filteredBeers.findIndex(it => it.uuid === beer.uuid), 1)
    }
  }
}
</script>

<style>
  .msgInfo{
    padding-top: 10px;
    padding-bottom: 10px;
    height: 70px;
    font-size: 15pt;
    text-align: center;
  }
</style>
