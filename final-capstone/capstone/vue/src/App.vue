<template>
<v-container class="container">
       
  <v-app id="dumbWhiteBar">
<v-app-bar app color="teal lighten-3" dark> <navigation />
      <div class="picture">
      <v-img
          src="../public/logo.png"
          max-height="60"
          max-width="60"
          contain
        ></v-img> 
      </div>
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
      showAlert: false
    }
  },
methods:{
  displayAlert(){
   
    setTimeout(() => this.showAlert = true, 120000)
},
},
mounted(){
  this.displayAlert()
}
}

</script>
<style>
@import url("https://fonts.googleapis.com/css2?family=Hanken+Grotesk:wght@200&display=swap");

.application {
  font-family: "Hanken Grotesk";
}

body {
  background-color: rgba(0, 128, 128, 0.1);
}

.container {
  padding-top: 0px;
}
#dumbWhiteBar{
  background: rgba(0, 128, 128, 0);
}

</style>
