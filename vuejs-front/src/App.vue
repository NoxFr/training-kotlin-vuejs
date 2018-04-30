<template>
  <v-app id="app" :dark="isDark">
    <tkv-header @theme-changed="isDark = $event"></tkv-header>
    <v-content>
        <tkv-main></tkv-main>
    </v-content>
    <tkv-footer></tkv-footer>
  </v-app>
</template>

<script>
import TkvHeader from '@/components/Header'
import TkvFooter from '@/components/Footer'
import TkvMain from '@/components/Main'

export default {
  name: 'app',
  data () {
    return {
      isDark: false
    }
  },
  components: {
    TkvFooter,
    TkvMain,
    TkvHeader
  }
}
</script>
