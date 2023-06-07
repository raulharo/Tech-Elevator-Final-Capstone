<template>
  
    <div id="mindfulnessdiv">
      <v-app-bar app color="teal lighten-3" dark> <navigation />
      <div class="picture">
      <v-img
          src="../../public/logo.png"
          max-height="60"
          max-width="60"
          contain
        ></v-img> 
      </div>
      </v-app-bar>

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
  
</template>



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
.picture {
  display: flex;
  justify-content: flex-end;
  width: 100%;
}

#mindfulnessdiv {
  background: url("../../public/mountain.jpg");
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  margin-left: -4%;
  margin-top: -64px;

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

@media only screen and (max-width: 600px) {
  #mindfulnessdiv {
  background: none;
  background-color: #D1C4E9;
  width: 100%;
  height: 120%;
  }
}


</style>