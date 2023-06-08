<template>
  <v-container class="container">
        
    <v-app id="dumbWhiteBar">
      <v-app-bar app color="teal lighten-3" dark>
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
    <mindful-alert v-show="$store.state.showAlert" @close-alert="hideAlert()" />
    
  </v-container>
     
</template>

<script>
import MindfulAlert from "./components/MindfulAlert.vue";

export default {
  components: { MindfulAlert },
  name: "App",

methods:{
  displayAlert(){
   
    setTimeout(() => this.$store.commit("SET_ALERT", true), 240000 )
},
hideAlert(){
  this.$store.commit("SET_ALERT", false)
}
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

h1, h2, h3, h4, p {
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
