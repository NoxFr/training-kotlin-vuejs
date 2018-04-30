<template>
  <header class="page-header">
    <v-container>
      <v-layout>
        <v-flex>
          <img src="https://vuejs.org/images/logo.png" alt="Logo" title="Home page" class="logo"/>
          <h1>Testing Vue.js with Beers CRUD</h1>
        </v-flex>
        <v-flex>
          <v-switch
            append-icon='fas fa-moon'
            v-model="isDark"
            color="yellow"
            @click="updateTheme"
          ></v-switch>
        </v-flex>
      </v-layout>
    </v-container>
  </header>
</template>

<script>
export default {
  name: 'tkvHeader',
  data () {
    return {
      isDark: false
    }
  },
  methods: {
    updateTheme () {
      this.$emit('theme-changed', !this.isDark)
    }
  }
}
</script>

<style>

  .logo {
    width: 50px;
    float: left;
    margin-right: 15px;
  }

</style>
