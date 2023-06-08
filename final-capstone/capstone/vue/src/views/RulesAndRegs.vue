<template>
  <div class="container">
    <div>
      <h1>Rules and Regulations</h1>
      <p>User agrees that Head and Health Sidekick is not responsible for essentially anything that could possibly go wrong. 
        User will not hold head and health sidekick responsible for anything at all, ever, no matter what.</p>
      </div>
      <div id="buttons">
      <v-btn  color="cyan lighten-3" @click="$router.push('/')">I agree</v-btn> 
      <v-btn color="cyan lighten-3" v-on:click="deleteUser()">I don't agree</v-btn>
      </div>
      <img id="logo" src="../../public/logo.png" alt="">
  </div>
</template>

<script>
import UserService from "../services/UserService"

export default {
  methods: {
    deleteUser(){   
     let id= this.$store.state.user.id;
      UserService.deleteUser(id)
      .then( response => {
        if (response.status === 200) {
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

<style scoped>
#buttons{
  display: flex;
  justify-content: space-evenly;
  margin: 5px;
}
p{
  text-align: center;
}
.container{
  display: block;
  align-items: center;
  margin-top: 5px;
  padding: 5px;
}
img{
   display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
}
@media only screen and (max-width: 768px) {
  #buttons{
  display: flex;
  justify-content: space-evenly;
  margin: 5px;
}
p{
  text-align: center;
  padding: 30px;
}
.container{
  display: block;
  align-items: center;
  margin-top: 50px;
  padding: 5px;
}
img{
   display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
}
}
</style>