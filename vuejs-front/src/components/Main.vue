<template>
    <v-container grid-list-xl>
        <tkv-search-form></tkv-search-form>
        <tkv-beer-list></tkv-beer-list>
    </v-container>
</template>

<script>
import TkvSearchForm from '@/components/SearchForm'
import TkvBeerList from '@/components/BeerList'

export default {
  name: 'tkvMain',
  components: {
    TkvSearchForm,
    TkvBeerList
  }
}
</script>
