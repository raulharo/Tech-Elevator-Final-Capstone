<template>
  <div class="home">
    <h1>My Dashboard</h1>
   <navigation/>
  <progress-component />
    <friend-activity />

  </div>
</template>

<script>
import FriendActivity from "../components/FriendActivity.vue";
import Navigation from '../components/Navigation.vue';
import ProgressComponent from '../components/ProgressComponent.vue';

export default {
  components: {FriendActivity, Navigation, ProgressComponent, },
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
