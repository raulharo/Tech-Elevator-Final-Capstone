<template>
  <div class="login">
    <a id="logo"><img src="../../public/logo.png" alt="" /></a>
    <h1>Please Sign In</h1>
    <form @submit.prevent="login">
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="formsNStuff">
      <div class="form-input-group">
        <!-- <label for="username">Username</label> -->
        <v-text-field
          type="text"
          label="Username"
          id="username"
          v-model="user.username"
          required
          autofocus
        />
      </div>
      <div class="form-input-group">
        <!-- <label for="password">Password</label> -->
        <v-text-field
          type="password"
          label="Password"
          id="password"
          v-model="user.password"
          required
        />
      </div>
      </div>
    </form>
    
      <v-btn type="submit" class="button" color="cyan lighten-3" elevation="7"
        >Sign in</v-btn
      >
      <br/>
      <p class="needanaccount">
        <v-btn
          color="cyan lighten-3"
          elevation="7"
          @click="$router.push('register')"
          >Register</v-btn
        >
      </p>
   
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>
.login {
  background-color: rgb(144, 178, 179);
  display: block;
}

#logo {
  display: flex;
  justify-content: center;
  max-width: 100%;
  height: 30%;
}
.form-input-group {
  padding: 6px;
}
.formsNStuff{
  display: flex;
  justify-content: center;
}



@media only screen and (max-width: 768px) {
  #login {
    background-color: rgb(144, 178, 179);
  }
  .login {
    display: inline-block;
  }
  #logo {
    display: flex;
    justify-content: center;
    max-width: 100%;
    height: 30%;
  }
  .form-input-group {
    padding: 6px;
    margin-top: -50px;
  }
}
</style>