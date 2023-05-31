<template>
  <div class="home">
    <div id="header">
      <h1>My Dashboard</h1>
      <navigation id="navigation"/>
    </div>

    <div id="content">
      <progress-component id="progress-component"/>
      <friend-activity id="friend-activity"/>
    </div>
  </div>
</template>

<script>
import FriendActivity from "../components/FriendActivity.vue";
import Navigation from '../components/Navigation.vue';
import ProgressComponent from '../components/ProgressComponent.vue';
export default {
  components: {FriendActivity, Navigation, ProgressComponent},
  name: "home",
};
</script>

<style scoped>


@media only screen and (min-width: 768px) {
  .home {
    display: grid;
    grid-template-columns: 1fr;
  }

  #header {
    text-align: center;
  }

  #navigation {
    display: flex;
    justify-content: left;
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
