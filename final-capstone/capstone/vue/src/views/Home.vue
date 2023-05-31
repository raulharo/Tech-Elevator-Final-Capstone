<template>
  <div class="home">
    <h1>My Dashboard</h1>
   <navigation/>
   <progress/>
    <friend-activity />

  </div>
</template>

<script>
import FriendActivity from "../components/FriendActivity.vue";
import Navigation from '../components/Navigation.vue';
import Progress from '../components/Progress.vue';
export default {
  components: {FriendActivity, Navigation, Progress },
  name: "home",
};
</script>
<style>

.home {
  display: grid;
}
.menu-content{
  display: flex;
  justify-content: center;
}




</style>
