<template>

  <div class="home">
    <v-app-bar
      app
      color="teal lighten-3"
      dark
    > <navigation />
    <div class="picture">
    <v-img
          src="../../public/logo.png"
          max-height="60"
          max-width="60"
          contain
        ></v-img>
      </div>
    </v-app-bar>
    <div id="header">
      <h1>My Dashboard</h1>
     <br>
    </div>
 
    <div id="content">
      <progress-component id="progress-component"/>
      <friend-activity id="friend-activity"/>
    </div>
    
  </div>
</template>

<script>
import FriendActivity from "../components/FriendActivity.vue";
import ProgressComponent from '../components/ProgressComponent.vue';
import Navigation from '../components/Navigation.vue'


export default {
  components: {FriendActivity, ProgressComponent, Navigation },
  name: "home",
  
};
</script>

<style scoped>

.picture {
  display: flex;
  justify-content: flex-end;
  width: 100%;
}
@media only screen and (mmax-width: 768px) {
  .home {
    display: grid;
    grid-template-columns: 1fr;
  }
  #header {
    text-align: center;
  }
  #content {
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-areas:
    "progress-component progress-component"
    "friend-activity friend-activity";
  }
  #progress-component {
    grid-area: progress-component;
    display: flex;
    justify-content: space;
  }
  #friend-activity {
    grid-area: friend-activity;
    display: flex;
    justify-content: center;
    border: 1px solid gray;
  }
  body{
  background: url(../../public/rays.jpg);
}
}
.content {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas:
  "progress-component"
  "friend-activity";
}
#progress-component {
    display: flex;
    justify-content: center;
    margin-bottom: 10px;
}
#friend-activity {
    grid-area: friend-activity;
    display: flex;
    justify-content: center;
    border: 1px solid gray;
}

</style>
