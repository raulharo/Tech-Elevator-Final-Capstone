<template>
  <div class="container">
    <div id="title">
      <h3>Recent Friend Activity</h3>
    </div>
    <v-row id="avatars" justify="space-around">
      <v-banner id="yoga">
      <v-avatar color="indigo">
        <span class="white--text text-h5">WG</span>
      </v-avatar>
      <p>Yoga, 45 mins</p>
      </v-banner>
      <v-banner id="forest">
      <v-avatar>
        <img src="https://cdn.vuetifyjs.com/images/john.jpg" alt="John" />
      </v-avatar>
      <p>Forest Bathing, 15 mins</p>
    </v-banner>
    <v-banner id="chakra">
      <v-avatar color="red">
        <span class="white--text text-h5">CJ</span>
      </v-avatar>
      <p>Aligning Chakras, 120 mins</p>
    </v-banner>
    </v-row>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
#avatars{
  text-align: center;
}
h3{
  margin-top: 25%;
}
p{
  padding: 9px;
}
.container{
  
  padding: 30px;
}
.title{
  text-align: center;
}

@media only screen and (max-width: 768px){
 
}
</style>