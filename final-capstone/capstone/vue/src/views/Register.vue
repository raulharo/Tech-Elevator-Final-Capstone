<template>
  <div id="register" class="text-center">
    <form @submit.prevent="register">
      <div class="create"><h1>Create Account</h1></div>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <!-- <label for="username">Username</label> -->
        <v-text-field
          label="Username"
          type="text"
          id="username"
          v-model="user.username"
          required
          autofocus
        />
      </div>
      <div class="form-input-group">
        <!-- <label for="password">Password</label> -->
        <v-text-field
          label="Password"
          type="password"
          id="password"
          v-model="user.password"
          required
        />
      </div>
      <div class="form-input-group">
        <!-- <label for="confirmPassword">Confirm Password</label> -->
        <v-text-field
          label="Confirm password"
          input
          type="password"
          id="confirmPassword"
          v-model="user.confirmPassword"
          required
        />
      </div>
      <div class="bottom-div">
        <div class="submit-button">
          <v-btn size="small" color="cyan lighten-3" @click="register">Sign Up</v-btn>
        </div>
        <div>
          <v-btn
            size="small"
            color="cyan lighten-3"
            @click="$router.push('login')"
            >Already have an account?</v-btn
          >
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.login();
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push({
              path: "/rules",
              query: { registration: "success" },
            });
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>
#register {
  display: flex;
  justify-content: center;
  height: 100vh;
}
.text-center {
  background-color: rgba(0, 128, 128, 0.1);
}

.create {
  display: flex;
  justify-content: center;
}
.form-input-group {
  margin-bottom: 1rem;
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 15%;
}
label {
  margin-right: 0.5rem;
  margin-bottom: 6%;
  font-size: 1.2rem;
}

input {
  border: solid 1.5px black;
  border-radius: 4px;
  height: 30%;
  width: 80%;
  font-size: 140%;
}
.bottom-div {
  display: inline-block;
  padding: 5px;
}

.submit-button {
  display: flex;
  justify-content: center;
  height: 9%;
  margin-bottom: 8%;
}

button {
  height: 100%;
  background-color: lightblue;
  border-radius: 4px;
}

h1 {
  margin-top: 65%;
}
/* .v-main {
  background-color: #E0F2F1;
} */
@media only screen and (max-width: 768px) {
  h1 {
    margin-top: 10rem;
  }

  #register {
    background-color: rgba(0, 128, 128, 0.1);
    width: 100%;
    height: 100%;
  }
  form {
    width: 100%;
    background-color: rgba(0, 128, 128, 0.1);
  }

  .submit-button {
    background-color: rgba(0, 128, 128, 0);
    height: 40%;
    margin-top: 4%;
  }

  p {
    background-color: rgba(0, 128, 128, 0.1);
    display: flex;
    justify-content: center;
  }

  .form-input-group {
    height: 12%;
  }

 .bottom-div{
   display: block;
   align-items: center;
   width: 100%;
   padding: 10px;
 }
}
</style>
