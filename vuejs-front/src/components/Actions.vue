<template>
  <v-layout row justify-center mb-5>
    <v-dialog v-model="dialog" persistent max-width="500px">
      <v-btn raised small color="beer" slot="activator">{{btnLabel}}</v-btn>
      <v-form lazy-validation ref="form">
        <v-card>
          <v-card-title>
            <span class="headline">My awesome beer</span>
            <v-card-text>
              <v-container grid-list-md>
                <v-layout wrap>
                  <v-flex xs12 sm6 md4>
                    <v-text-field v-model="newBeer.name" :rules="nameRules" label="Name" required></v-text-field>
                  </v-flex>
                  <v-flex xs12 sm6 md4>
                    <v-text-field v-model="newBeer.country" label="Country"></v-text-field>
                  </v-flex>
                </v-layout>
              </v-container>
              <small>*indicates required field</small>
            </v-card-text>
          </v-card-title>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" flat @click.native="dialog = false">Close</v-btn>
            <v-btn color="blue darken-1" flat @click="submit">Save</v-btn>
          </v-card-actions>
        </v-card>
      </v-form>
    </v-dialog>
  </v-layout>
</template>

<script>
import BeerService from '@/services/beer.service'

export default {
  name: 'tkvActions',
  data: () => ({
    dialog: false,
    btnLabel: 'Add a beer',
    nameRules: [
      v => !!v || 'Name is required'
    ],
    newBeer: {
      name: '',
      country: ''
    }
  }),
  methods: {
    submit() {
      if (this.$refs.form.validate()) {
        this.addBeer()
      }
    },
    addBeer () {
      this.dialog = false
      BeerService.add(this.newBeer).then(() => {
        this.$refs.form.reset()
        this.$emit('beers-update')
      })
    }
  }
}
</script>
