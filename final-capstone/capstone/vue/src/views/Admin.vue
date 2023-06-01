<template>
  <div class="container">
    <h1>Administrator Dashboard</h1>
    <admin-nav/>
    <div id="user-info">
        <img src="../../public/profile-circle-svgrepo-com.svg" alt="">
        <h3>UserName</h3>
    </div>
    <span><button id="edit">Edit profile</button></span>
    <div>
      
    </div>    
</div>
</template>

<script>
import AdminNav from '../components/AdminNav.vue'
export default {
  components: { AdminNav, },

}
</script>

<style scoped>


.container{
  background-color: white;
}
.user-info{
  display: flex;
  justify-content: center;
}

@media only screen and (min-width: 768px) {
}



</style>