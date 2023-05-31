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
@media only screen and (min-width: 768px) {
  #app {
    height: 2vh;
    display: flex;
    justify-content: center;
    align-self: right;
  }

  .router {
    height: 98vh;
    width: 45%;
  }
}
</style>


