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
      Mindfulness and meditation is important. Some examples of mindfulness activities could be: breath-work, meditation, physical activity, going outdoors, yoga, limiting social media, bedtime routines, or anything that makes you feel happy! Track your mindfulness activities and reach your goal below.
    </v-alert>
          </h1> 
          <h2>
<template>
  <div>
    <navigation/>
  </div>
  <v-form>
    
    <v-container>
      <v-row>
        <v-col
          cols="12"
          sm="6"
        >
          <v-text-field
            placeholder="Placeholder"
            v-model="activity"
            label="Mindfulness Activity"
            filled
            
          > </v-text-field>
        </v-col>

        <v-col
          cols="12"
          sm="6"
        >
          <v-text-field
            v-model="minutes"
            label="Desired Minutes"
            filled
          ></v-text-field>
        </v-col>
      </v-row>
    </v-container>
  </v-form>

<div class="container">
<v-flex justify="center">
  <v-btn v-on:click='addActivity' class="button"
  color="light-blue"
  elevation="7"
>Submit Activity</v-btn>  </v-flex>
</div>

</template>

          </h2>
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
import MindfulnessService from '../services/MindfulnessService.js'
import Navigation from '../components/Navigation.vue'
// import MindfulnessForm from '../components/MindfulnessForm.vue'
// export default {
//     name: 'Mindfulness',
//     components: {
//         MindfulnessForm
//     },
//     data() {
//    return {
//       showForm: false
//    }
// }
// }

export default {
  name: 'mindfulness-tracker',
  data() {
    return {
      activity: "", 
      minutes: 0,
    }
  },
  components: {
    Navigation
  },
  methods: {
    addActivity() {
      MindfulnessService.logActivity(this.activity)
      .then((response) => {
       if( response.status === 201 ) {
         alert("Activity Saved.")
       }
      })
      .catch((error) => {
      // @Todo add error checks
        alert("Activity Not Saved" + error)
      }
      )
    }
  }
}
</script>
<style scoped>

.container {
  align-items: center;
  justify-items: center;
}
</style>