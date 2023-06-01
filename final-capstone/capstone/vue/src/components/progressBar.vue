<template>
  <div class="container">
      <h3>Weight Goal</h3>
      <p>This month</p>
      <v-progress-linear color="pink lighten-1" background-color="pink lighten-3" value="15">{{}}</v-progress-linear>
       <p>This year</p>
       <v-progress-linear value="40">{{}}</v-progress-linear>
       <h3>Mindfulness Goal</h3>
       <p>This Month</p>
        <v-progress-linear color="pink lighten-1" background-color="pink lighten-3" value="25">{{}}</v-progress-linear>
         <p>This year</p>
         <v-progress-linear value="70">{{}}</v-progress-linear>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.container{
    text-align: center;
}
h3{

}
    .v-progress-linear{
        margin: 1rem;
        font-size: 50%;
        width: 80%;
    }
</style>