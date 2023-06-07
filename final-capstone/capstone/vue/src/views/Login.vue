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

      <v-btn type="submit" class="button" color="cyan lighten-3" elevation="7">Sign in</v-btn>
    </form>
    
      
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

/* .login {
  display: flex;
  justify-content: center;
  height: 100vh;
}
div {
  height: 100%;
  width: 100%;
  background-color: rgb(144, 178, 179);
}
.form-input-group {
  margin-bottom: 2rem;
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 20%;
}
label {
  margin-right: 0.5rem;
  margin-bottom: 3%;
  font-size: 2rem;
}
.signin {
  display:flex;
  justify-content: center;
  background-color: rgb(144, 178, 179);
}
input {
  border: solid 1.5px, black;
  border-radius: 4px;
  height: 30%;
}
.signin {
  display: flex;
  justify-content: center;
  height: 8%;
}
button {
  width: 80%;
  height: 100%;
  background-color: #F8F9FA;
  border-radius: 4px;
}
.needanaccount {
  display: flex;
  justify-content: center;
}
h1 {
  margin: 35% 0%;
} */

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