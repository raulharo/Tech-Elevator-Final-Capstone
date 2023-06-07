<template>
  <div class="container">
    <div id="title">
      <h3>My Friends</h3>
    </div>
    <v-row id="avatars" justify="space-around">
      <v-avatar color="indigo">
        <span class="white--text text-h5">WG</span>
      </v-avatar>

      <v-avatar>
        <img src="https://cdn.vuetifyjs.com/images/john.jpg" alt="John" />
      </v-avatar>

      <v-avatar color="red">
        <span class="white--text text-h5">CJ</span>
      </v-avatar>
    </v-row>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.container{
  padding: 30px;
}
.title{
  text-align: center;
}
@media only screen and (max-width: 768px){
 
}
</style>