<template>
  <div class="container">
      <h3>Weight Change</h3>
      <p>This month</p>
      <v-progress-linear height="30" color="cyan lighten-2" background-color="cyan lighten-3" value="15">2 pounds</v-progress-linear>
       <p>This year</p>
       <v-progress-linear height="30" color="indigo lighten-2" background-color="indigo lighten-3" value="40">15 pounds</v-progress-linear>
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
        font-size: 70%;
        width: 80%;
    }


</style>