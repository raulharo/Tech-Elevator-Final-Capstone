<template>
  <div class="container">
    <h1>Administrator Dashboard</h1>
    <div class="dropdown">
        <span>Menu</span>
        <div class="dropdown-content">
   
        <p @click="$router.push('admin-home')">Home</p>
        <p>View Users</p>
        <p>Block Users</p>
        <p>Change User Status</p>
        <p @click="$router.push('logout')">Logout</p>
   
    </div>
    </div>
    <div id="user-info">
        <img src="../../public/profile-circle-svgrepo-com.svg" alt="">
        <h3>UserName</h3>
    </div>    
</div>
</template>

<script>
export default {

}
</script>

<style scoped>
.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #615a8b;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  padding: 12px 16px;
  z-index: 1;
  overflow: hidden;
}
p{
    color: white;
}

.dropdown:hover .dropdown-content {
  display: block;
}
h3{
    display: flex;
    justify-content: center;
}


</style>