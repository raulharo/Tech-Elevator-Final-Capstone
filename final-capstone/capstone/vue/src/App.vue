<template>
  <v-container class="container">
    <mindful-alert v-show="showAlert" @close-alert="showAlert = false" />
    <v-app>
      <v-app-bar app color="teal lighten-3" dark> </v-app-bar>

      <main>
        <router-view />
      </main>
    </v-app>
  </v-container>
</template>

<script>
import MindfulAlert from "./components/MindfulAlert.vue";

export default {
  components: { MindfulAlert },
  name: "App",

  data() {
    return {
      showAlert: false,
    };
  },
};
</script>
<style>
@import url("https://fonts.googleapis.com/css2?family=Hanken+Grotesk:wght@200&display=swap");

body {
  background-color: rgba(0, 128, 128, 0.1);
}

main {
  padding-top: 60px;
}
</style>