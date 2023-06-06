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
import MindfulAlert from './components/MindfulAlert.vue';



export default {
  components: { MindfulAlert},
  name: 'App',

  data(){
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


</style>