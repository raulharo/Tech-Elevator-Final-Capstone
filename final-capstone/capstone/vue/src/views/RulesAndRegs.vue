<template>
  <div class="container">
      <h1>Rules and Regulations</h1>
      <p>User agrees that Head and Health Sidekick is not responsible for essentially anything that could possibly go wrong. 
        User will not hold head and health sidekick responsible for anything at all, ever, no matter what.</p>
      <br>
      <v-btn @click="$router.push('/')">I agree</v-btn> 
      <scoped><v-btn v-on:click="deleteUser(user.id)">I don't agree</v-btn></scoped>
  </div>
</template>

<script>
import UserService from "../services/UserService"

export default {
  methods: {
    deleteUser(id){   //need help here
      UserService.delete(id)
      .then( response => {
        if (response === 200) {
          this.$router.push(`/login/`)
        }
      })
      .catch(error => {
        if (error.response.status === 400) {
          this.$router.push("/404");
        } else {
          console.error(error);
        }
      });
    }
  }

}
</script>

<style>
.container{
  display: block;
  margin-top: 5px;
  padding: 5px;
  
}

</style>