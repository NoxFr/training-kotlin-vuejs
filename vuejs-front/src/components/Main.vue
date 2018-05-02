<template>
    <v-container grid-list-xl>
        <tkv-actions @beers-update="refreshBeerList()"></tkv-actions>
        <tkv-beer-list ref="beerList"></tkv-beer-list>
    </v-container>
</template>

<script>
import TkvActions from '@/components/Actions'
import TkvBeerList from '@/components/BeerList'

export default {
  name: 'tkvMain',
  components: {
    TkvActions,
    TkvBeerList
  },
  methods: {
    refreshBeerList () {
      this.$refs.beerList.getBeers()
    }
  }
}
</script>
