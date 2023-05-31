<template>
 <div>
   <div class="collapsible-menu">
    <div class="menu-content">
        <ul>
          <li @click="$router.push('home')"><a href="#"></a>Home</li>
            <li><a href="#"></a>My Progress</li>
            <li><a href="#"></a>Track Food</li>
            <li><a href="#"></a>My Friends</li>
            <li><a href="#"></a>Mindfullness</li>
            <li><a href="#"></a>Edit Profile</li>
            <li @click="$router.push('logout')"><a href='#'></a>Logout</li>
         </ul>
     </div>
</div>
   
 </div>
</template>

<script>
export default {

}
</script>

<style scoped>
ul{
  background-color: plum;
}
li {
  display: inline;
  color: #000;
  padding: 8px 16px;
  text-decoration: none;
}

</style>