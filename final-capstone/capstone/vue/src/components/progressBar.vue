<template>
  <div class="container">
      <h3>Weight Change</h3>
      <p>Current Weight: {{currentWeight}} lbs.</p>
      <p>Goal Weight: {{goalWeight}} lbs.</p>
      <div class="weight-bar">
      <v-progress-linear height="30" color="cyan-lighten-1" background-color="cyan lighten-1" :value="calculateProgress">{{calculateProgress}}%</v-progress-linear>
      </div>
  </div>
</template>

<script>
export default {
    props: ["currentWeight", "goalWeight", "initialWeight"],
    progressValue: "",
    computed: {
        calculateProgress() {
            return parseInt(((this.initialWeight - this.currentWeight) / (this.initialWeight - this.goalWeight)) * 100);
        }
    }
}
</script>

<style scoped>
.container{
    text-align: center;
}

.v-progress-linear{
    margin: 1rem;
    font-size: 70%;
    width: 80%;
}

@media only screen and (max-width: 768px) {
    .weight-bar {
    margin-left: 10px;
    }
  
}


</style>