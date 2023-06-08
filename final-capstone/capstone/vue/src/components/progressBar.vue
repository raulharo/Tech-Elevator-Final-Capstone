<template>
  <div class="container">
      <h3>Weight Change</h3>
      <p>Current Weight: {{currentWeight}} lbs.</p>
      <p>Goal Weight: {{goalWeight}} lbs.</p>
      <v-progress-linear height="30" color="cyan lighten-2" background-color="cyan lighten-3" :value="calculateProgress">{{calculateProgress}}%</v-progress-linear>
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


</style>