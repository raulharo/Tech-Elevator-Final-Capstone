<template>
  <div>
      <v-progress-circular  :rotate= "360" :size="200" :width="10" :value="dayGoalPercent" color="teal">Calories</v-progress-circular>
       <v-progress-circular :rotate= "360" :size="200" :width="10" :value="65" color="teal">Mindfullness</v-progress-circular>
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
        dayGoalPercent: 0,



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
    created() {
      userService.getCalorieGoal().then(
        (response) => {
          if(response.status == 200) {
            this.calorieGoal = response.data;
            console.log(this.calorieGoal);
          }
        }
      );
    
      userService.getDayCalories().then(
        (response) => {
          if(response.status == 200) {
            this.dayCalories = response.data;
            console.log(this.dayCalories);
          }
        }
      );
    if(this.dayCalories === 0) {
      this.dayGoalPercent = 0;
    } else {
      this.dayGoalPercent = this.dayCalories/this.calorieGoal;
    }
    
    console.log(this.dayGoalPercent);
    
    }
    

}
</script>

<style scoped>
.v-progress-circular {
  margin: 1rem;
  font-size: 150%;
}
</style>
