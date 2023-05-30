<template>
  <div class="home">
    <h1>My Dashboard</h1>
   <navigation/>
    <todays-progress />
    <overall-progress />
    <friend-activity />

  </div>
</template>

<script>
import FriendActivity from "../components/FriendActivity.vue";
import Navigation from '../components/Navigation.vue';
import OverallProgress from '../components/OverallProgress.vue';
import TodaysProgress from '../components/TodaysProgress.vue';
export default {
  components: {FriendActivity, OverallProgress, TodaysProgress, Navigation },
  name: "home",
};
</script>
