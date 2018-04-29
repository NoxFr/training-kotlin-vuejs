<template>
  <v-footer height="auto">
      <v-layout row wrap justify-center class="grey darken-3">
          <v-btn
            v-for="icon in icons"
            :key="icon"
            icon
            v-bind:href="icon.link"
          >
            <v-icon size="24px">{{ icon.class }}</v-icon>
          </v-btn>
        <v-flex xs12 py-3 text-xs-center white--text>
            &copy;2018 — <strong>Beers</strong>
        </v-flex>
      </v-layout>
  </v-footer>
</template>

<script>
export default {
  name: 'tkvFooter',
  data: () => ({
    icons: [ {
      class: 'fab fa-github',
      link: 'https://github.com/NoxFr/training-kotlin-vuejs'
    },
    {
      class: 'fab fa-twitter',
      link: 'http://twitter.com/NoxFr'
    },
    {
      class: 'fab fa-linkedin',
      link: 'https://www.linkedin.com/in/mathieu-durand-260104137/'
    }]
  })
}
</script>
