<template>
  <div>
      <h1>
          <v-alert
      color="light-blue"
      dark
      dense
      icon="mdi-leaf"
      prominent
    >
      Choose what will help you reach your wellness and mindfullness goals.
    </v-alert>
          </h1> 
  <v-card flat>
    <v-card-text>
      <v-container fluid>
        <v-row>
          <v-col
            cols="2"
            sm="4"
            md="4"
          >
            <v-checkbox
              v-on:click="updateForm"
              v-model="ex4"
              label="Daily Meditation"
              color="indigo"
              value="indigo"
              hide-details
            ></v-checkbox>
            <v-checkbox
              v-on:click="updateForm"
              v-model="ex4"
              label="Physical Activity"
              color="indigo"
              value="indigo"
              hide-details
            ></v-checkbox>
          </v-col>
          <v-col
            cols="12"
            sm="4"
            md="4"
          >
            <v-checkbox
              v-on:click="updateForm"
              v-model="ex4"
              label="Bedtime Ritual"
              color="indigo"
              value="indigo"
              hide-details
            ></v-checkbox>
            <v-checkbox
              v-on:click="updateForm"
              v-model="ex4"
              label="Play Sleep Sounds"
              color="indigo"
              value="indigo"
              hide-details
            ></v-checkbox>
          </v-col>
        </v-row>
      </v-container>
    </v-card-text>
  </v-card>
  </div>
</template>

<script>
//import MindfulnessForm from '../components/MindfulnessForm.vue'
export default {
    name: 'Mindfulness',
    components: {
        //MindfulnessForm
    },
    data() {
   return {
      showForm: false
   }
}
}
</script>
<style>
</style>