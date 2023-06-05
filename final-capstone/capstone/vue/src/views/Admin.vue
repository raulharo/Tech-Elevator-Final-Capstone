<template>
  <div class="container">
    <div id="header">
      <h1>Administrator Dashboard</h1>
      <admin-nav />
    </div>
    <br />
    <v-row justify="center">
      <v-avatar id="profile-pic" size="200"
        ><img src="../../public/profile-circle-svgrepo-com.svg" />
      </v-avatar>
    </v-row>
  </div>
</template>

<script>
import AdminNav from "../components/AdminNav.vue";
export default {
  components: { AdminNav },
};
</script>

<style scoped>
.container {
  background-color: white;
  display: grid;
  grid-template-columns: 1fr;
}
#header {
  text-align: center;
}
img {
  display: flex;
  justify-content: center;
}

@media only screen and (min-width: 768px) {
  .container {
    background-color: white;
    display: grid;
    grid-template-columns: 1fr;
  }
  #header {
    text-align: center;
  }
  img {
    display: flex;
    justify-content: center;
  }
}
</style>