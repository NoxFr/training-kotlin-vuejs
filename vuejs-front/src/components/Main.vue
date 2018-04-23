<template>
    <div id="container">
        <tkv-search-form></tkv-search-form>
        <tkv-beer-list></tkv-beer-list>
    </div>
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

<style>
  #container {
    width: 750px;
    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
  }
</style>
