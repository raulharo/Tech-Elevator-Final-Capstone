<template>
<v-container class="container">
       
  <v-app>
 <v-app-bar
      app
      color="teal lighten-3"
      dark
    > 
    </v-app-bar>
   
   
    <v-main>
      
      <router-view/>
    </v-main>
  </v-app>
  <mindful-alert v-show="showAlert" @close-alert="showAlert = false" />
     </v-container>
</template>

<script>
import MindfulAlert from "./components/MindfulAlert.vue";

export default {
  components: { MindfulAlert },
  name: "App",

  data() {
    return {
      showAlert: true
    }
  },
// methods:{
//   displayAlert(){
//     setInterval(() => {

//     }
// },
};
</script>
<style>
@import url("https://fonts.googleapis.com/css2?family=Hanken+Grotesk:wght@200&display=swap");

body {
  background-color: rgba(0, 128, 128, 0.1);
}

.container {
  padding-top: 0px;
}
</style>
