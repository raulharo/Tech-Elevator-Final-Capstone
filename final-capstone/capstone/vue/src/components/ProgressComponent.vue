<template>
  <div class="progress">
    <div class="today">
      <h1>Today's Progress</h1>
      <h2>Daily Goal: {{dailyGoal}}</h2>
      <h2> Calories Consumed: {{dayCalories}}</h2>
      <h2>Calories Remaining: {{(dailyGoal - dayCalories)}}</h2> 
      <h2>Mindfulness Goal: {{mindfulnessGoal}}</h2>
      <!-- <h2>Mindful Activity: </h2> -->
      <progress-ring />
      </div>
      <div class="overall">
        <h1>Overall Progress</h1>
        <progress-bar :currentWeight="currentWeight" :goalWeight="goalWeight"/>
        <v-text-field label="New Current Weight" type="number" v-model="newCurrentWeight"/>
        <v-btn v-on:click="updateWeight">Update Weight</v-btn>
      </div>
  </div>
</template>

<script>
import ProgressBar from './progressBar.vue'
import ProgressRing from './ProgressRing.vue'
import userService from '../services/UserService.js'
export default {
  components: { ProgressRing, ProgressBar },
  name: 'progress',
  data() {
    return {
      dailyGoal: 0,
      mindfulnessGoal: 0,
      dayCalories: 0,
      goalWeight: "",
      currentWeight: "",
      newCurrentWeight: ""
    }
  },
  methods: {
    updateWeight() {
      userService.updateCurrentWeight(this.newCurrentWeight).then(response => {
        if(response.status === 201 || response.status === 200) {
          this.currentWeight = this.newCurrentWeight;
          this.newCurrentWeight = "";
        }
      });
    }
  },
  created() {
    userService.getCalorieGoal().then(
      (response) => {
        if(response.status === 200) {
          this.dailyGoal = response.data;
        }
      }
    );
    userService.getMindfulGoal().then(
      (response) => {
        if(response.status === 200) {
          this.mindfulnessGoal = response.data;
        }
      }
    );
    userService.getDayCalories().then(
      (response) => {
        if(response.status === 200) {
          this.dayCalories = response.data;
        }
      }
    );
    userService.getWeights().then(response => {
      if(response.status === 200) {
        console.log(response.data)
        this.currentWeight = response.data.currentWeight;
        this.goalWeight = response.data.goalWeight;
      }
    })
  },

}
</script>

<style scoped>

.progress {
  display: flex;
  flex-direction: column;
}

.today {
    border: 1px solid gray;
    margin-bottom: 20px;
    padding: 10px;
}

.today > h2 {
  font-size: 1em;
}

.overall {
    border: 1px solid gray;
    margin-bottom: 20px;
    padding: 10px;
}

@media only screen and (min-width: 768px) {
  .progress{
    display: flex;
    flex-direction: row;
  }

  .today {
    border: 1px solid gray;
    margin-right: 10px;
    margin-bottom: 20px;
    padding: 10px;
  }

  .overall {
    border: 1px solid gray;
    margin-left: 10px;
    margin-bottom: 20px;
    padding: 10px;
  }

  .today > h2{
   font-size: 1em;
  }
}
</style>