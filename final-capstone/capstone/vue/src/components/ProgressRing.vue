<template>
  <div class="progress-rings">
      <v-progress-circular  :rotate= "360" :size="200" :width="10" :value="dayGoalPercent" color="teal">Calories</v-progress-circular>
       <v-progress-circular :rotate= "360" :size="200" :width="10" :value="dayMindfulPercent" color="teal">Mindfulness</v-progress-circular>
  </div>
</template>

<script>
import userService from '../services/UserService.js';
export default {
  data () {
      return {
        interval: {},
        value: 0,
        dayCalories: 0,
        calorieGoal: 0,
        dayMindfulGoal: 0,
        dayMindfulMins: 0,
      }
    },
    methods: {
      getMindfulGoal(){
       // let completed = this.$store.state.user.ca
      }
    },

    beforeDestroy () {
      clearInterval(this.interval)
    },
    mounted () {
      this.interval = setInterval(() => {
        if (this.value === 100) {
          return (this.value = 0)
        }
        this.value += 10
      }, 1000)
    },
    computed: {
      dayGoalPercent() {
        if(this.dayCalories === 0) {
      return 0;
    } else {
      return (this.dayCalories/this.calorieGoal) * 100;
    }
      },
      dayMindfulPercent() {
        if(this.dayMindfulMins === 0) {
      return 0;
    } else {
      return (this.dayMindfulMins/this.dayMindfulGoal) * 100;
    }
      } 
    },
  
    created() {
      userService.getCalorieGoal().then(
        (response) => {
          if(response.status == 200) {
            this.calorieGoal = response.data;
          }
        }
      );    
      userService.getDayCalories().then(
        (response) => {
          if(response.status == 200) {
            this.dayCalories = response.data;
          }
        }
      );
      
    
    userService.getMindfulGoal().then(
        (response) => {
          if(response.status == 200) {
            this.dayMindfulGoal = response.data;
          }
        }
      );    
      userService.getDayMindful().then(
        (response) => {
          if(response.status == 200) {
            this.dayMindfulMins = response.data;
          }
        }
      );
      
      if(this.dayCalories === 0) {
      this.dayMindfulPercent = 0;
      } else {
      this.dayMindfulPercent = (this.dayCalories/this.calorieGoal) * 100;
      }
    }
    
    
}
</script>

<style scoped>
.v-progress-circular {
  margin: 1rem;
  font-size: 150%;
}

.progress-rings {
  display: flex;
  flex-direction: column;
  align-items: center;
}

@media only screen and (min-width: 768px) {
  .progress-rings {
    display: flex;
    flex-direction: row;
  }
}
</style>
