<template>
<v-container class="container">
       <mindful-alert v-show="showAlert" @close-alert="showAlert = false" />
  <v-app>

    <v-app-bar
      app
      color="primary"
      dark
    >
     
    </v-app-bar>
   
    <v-main>
      <router-view/>
    </v-main>
  </v-app>
  
     </v-container>
</template>

<script>
import MindfulAlert from './components/MindfulAlert.vue';

export default {
  components: { MindfulAlert },
  name: 'App',

  data(){
    return {
      showAlert: false
    }
  },
};
</script>
<style lang="scss">
body {
  background-color: rgba(0, 128, 128, 0.2);
}

</style>