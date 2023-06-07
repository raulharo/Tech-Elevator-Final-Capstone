<template>
  <body>
    <div>
      <v-app-bar app color="teal lighten-3" dark> <navigation /> </v-app-bar>

      <h1>
        <v-alert color="light-blue" dark dense icon="mdi-leaf" prominent>
          Mindfulness and meditation is important. Some examples of mindfulness
          activities could be: breath-work, meditation, physical activity, going
          outdoors, yoga, limiting social media, bedtime routines, or anything
          that makes you feel happy! Track your mindfulness activities and reach
          your goal below.
        </v-alert>
      </h1>
      <h2>
        <v-form>
          <v-container>
            <v-row>
              <v-col cols="12" sm="6">
                <v-text-field
                  placeholder="Mindfulness Activity"
                  v-model="mindfulness.activity"
                  label="Mindfulness Activity"
                  filled
                >
                </v-text-field>
              </v-col>
              <v-col cols="12" sm="6">
                <v-text-field
                  v-model="mindfulness.minutes"
                  label="Minutes Spent on Activity"
                  filled
                ></v-text-field>
              </v-col>
            </v-row>
          </v-container>
        </v-form>
        <div class="container">
          <div class="submit-activity">
            <v-btn
              v-on:click="addActivity"
              class="button"
              color="cyan lighten-3"
              elevation="7"
              >Submit Activity</v-btn>
          </div>
        </div>
      </h2>
    </div>
  </body>
</template>



      <!-- <h1>
        <v-alert color="light-blue" dark dense icon="mdi-leaf" prominent>
          Mindfulness and meditation is important. Some examples of mindfulness
          activities could be: breath-work, meditation, physical activity, going
          outdoors, yoga, limiting social media, bedtime routines, or anything
          that makes you feel happy! Track your mindfulness activities and reach
          your goal below.
        </v-alert>
      </h1>
      <h2>
        <v-form>
          <v-container class="container">
            <v-row>
              <v-col cols="12" sm="6">
                <v-text-field
                  placeholder="Mindfulness Activity"
                  v-model="mindfulness.activity"
                  label="Mindfulness Activity"
                  filled
                >
                </v-text-field>
              </v-col>
              <v-col cols="12" sm="6">
                <v-text-field
                  placeholder="Mindfulness Minutes"
                  v-model="mindfulness.minutes"
                  label="Mindfulness Minutes"
                  filled
                >
                </v-text-field>
              </v-col>
            
            <div class="container">
              <v-flex justify="center">
                <v-btn
                  v-on:click="addActivity"
                  class="button"
                  color="light-blue"
                  elevation="7"
                  >Submit Activity</v-btn
                >
              </v-flex>
            </div>
          </v-container>
        </v-form>
      </h2>
    </div>
  </body>
</template> -->

<script>
import MindfulnessService from "../services/MindfulnessService.js";
import Navigation from "../components/Navigation.vue";
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
  name: "mindfulness-tracker",
  data() {
    return {
      mindfulness: {
        activity: "",
        minutes: 0,
      },
    };
  },
  components: {
    Navigation,
  },
  methods: {
    addActivity() {
      MindfulnessService.logActivity(this.mindfulness)
        .then((response) => {
          if (response.status === 201) {
            alert("Activity Saved.");
          }
        })
        .catch((error) => {
          // @Todo add error checks
          alert("Activity Not Saved" + error);
        });
    },
  },
};
</script>

<style scoped>
body {
  background: url("../../public/mountain.jpg");
  margin-left: -4%;
  margin-top: -3.7%;

  height: 100vh;
  width: 100vw;
  background-size: 100%;
}

.container {
  align-items: center;
  justify-items: center;
}

.submit-activity {
  display: flex;
  justify-content: center;
}

v-alert {
  margin: 0;
}
</style>