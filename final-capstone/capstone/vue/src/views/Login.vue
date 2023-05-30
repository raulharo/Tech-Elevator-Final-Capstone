<template>
  <div id="login">
    <form @submit.prevent="login">
      <h1 >Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="signin" ><button type="submit">Sign in</button></div>
      <p class="needanaccount" >
      <router-link :to="{ name: 'register' }">Need an account? Sign up.</router-link> </p>
    </form>
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
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
#login {
  display: flex;
  justify-content: center;
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
  background-color: #76c4fa;
  border-radius: 4px;
}
.needanaccount {
  display: flex;
  justify-content: center;
}
h1 {
  margin: 35% 0%;
}

</style>