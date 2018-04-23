<template>
  <div id="app">
    <tkv-header></tkv-header>
    <tkv-main></tkv-main>
    <tkv-footer></tkv-footer>
  </div>
</template>

<script>
import TkvHeader from '@/components/Header'
import TkvFooter from '@/components/Footer'
import TkvMain from '@/components/Main'

export default {
  name: 'app',
  components: {
    TkvFooter,
    TkvMain,
    TkvHeader
  }
}
</script>
