<template>
  <div id="app">
    <div id="nav">
      <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <div class="router"><router-view /></div>
  </div>
</template>

<style>
<<<<<<< HEAD
#app {
  height: 2vh;
}

.router {
  height: 97vh;
}



</style>


=======


#app {
  background-color: rgb(110, 226, 228);
  height:100vh;
}
</style>
>>>>>>> 742396f974d9521be2a155ad1ce4df2db79ea048
