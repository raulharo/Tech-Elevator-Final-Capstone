<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
       <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
    </div>
   
    <div class="router"> <router-view /></div>
  </div>
</template>

<style>
/* #app {
  height: 2vh;
}

.router {
  height: 97vh;
} */

</style>


