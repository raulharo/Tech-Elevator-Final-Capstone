<template>
  <div class="dropdown">
        <span><button>Menu</button></span>
        <div class="dropdown-content">
   
        <p @click="$router.push('admin-home')">Home</p>
        <p>View Users</p>
        <p>Block Users</p>
        <p>Change User Status</p>
        <p @click="$router.push('logout')">Logout</p>
   
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

</style>