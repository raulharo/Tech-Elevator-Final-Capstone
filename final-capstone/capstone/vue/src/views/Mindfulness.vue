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
          <div  class="submit-activity">
            <v-btn id="button"
              v-on:click="addActivity"
    
              class="button"
              color="cyan lighten-3"
              elevation="7" 
              >Submit Activity</v-btn>
          </div>
        </div>

        <div class="log-view">
          <div class="show-log-btn">
            <v-btn id="button" v-on:click="showLogMethod" color="cyan lighten-3"  elevation="7">Show/Hide Activity Log</v-btn>
          </div>
         

          <div class="activity-log" v-if="showLog">
            
            <div class="calendar">
              <v-date-picker v-model="chosenDate"></v-date-picker>
            </div>

            <div>
              <div class="individual-entry" v-for="mindful in filteredLog" :key="mindful.mindfulId">
                <v-card flat class="pa-3">
                <v-layout rowclass="">
                  <v-flex xs12 md6>
                    <div class="caption grey--text">Date Logged</div>
                    <div>{{mindful.mindfulDate}}</div>
                  </v-flex>
                  <v-flex xs12 md6>
                    <div class="caption grey--text">Activity</div>
                    <div>{{mindful.activity}}</div>
                  </v-flex>
                  <v-flex xs12 md6>
                    <div class="caption grey--text">Minutes</div>
                    <div>{{mindful.minutes}}</div>
                  </v-flex>
                </v-layout>
                </v-card>
              </div>
             </div>
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
      showLog: false,
      chosenDate: "",
      mindfulLog: []
    };
  },
  components: {
    Navigation,
  },
  methods: {
    addActivity() {
      MindfulnessService.logActivity(this.mindfulness)
        .then((response) => {
          console.log(response.data);
          console.log(response.status);
          if (response.status === 200 && response.data !== -1) {
            MindfulnessService.getMindful(response.data).then(response => {
              this.mindfulLog.unshift(response.data);
            });
          }
        })
        .catch((error) => {
          // @Todo add error checks
          alert("Activity Not Saved" + error);
        });
    },
    showLogMethod() {
      this.showLog = !this.showLog;
    }
  },
  computed: {
    filteredLog() {
      let filteredLog = this.mindfulLog.filter(item => {
        return item.mindfulDate == this.chosenDate;
      })

      return filteredLog;
    }
  },
  created() {
    MindfulnessService.getActivity().then(response => {
      response.data.forEach(element => {
        this.mindfulLog.push(element);
      });
    })
  }
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
  font-family: "Hanken Grotesk";
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
  font-family: "Hanken Grotesk";
  font-weight: bold;
}

.activity-log {
  display: flex;
  flex-direction: row;
  margin-top: 4%;
}

.individual-entry {
  margin-left: 2%;
  margin-bottom: 2%;
}

v-alert {
  margin: 0;
}

.log-view {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.calendar {
  align-content: center;
}

#button{
  font-weight: 1000;
  /* font-weight: bold; */
}

.grey--text {
  width: 8rem;
  margin-right: 3rem;
}

@media only screen and (max-width: 600px) {
  #mindfulnessdiv {
  background: none;
  background-color: #D1C4E9;
  margin-right: -4%;
  width: 100%;
  height: 120%;
  }
}


</style>