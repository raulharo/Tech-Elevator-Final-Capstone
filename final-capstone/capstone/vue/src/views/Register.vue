<template>
  <div id="register" class="text-center">
    <form @submit.prevent="register">
      <div class="create"><h1>Create Account</h1></div>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>
      <div class="bottom-div">
      <div class="submit-button"><button type="submit">Sign Up</button></div>
      <p><router-link :to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
      </div>
    </form>
    
  
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>

#register {
  display: flex;
  justify-content: center;
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
}

.submit-button {
  display: flex;
  justify-content: center;
  height: 9%;
  margin-bottom: 8%;
}

button {
  width: 85%;
  height: 100%;
  background-color: #76c4fa;
  border-radius: 4px;
}

h1 {
  margin-top: 65%;
}

@media only screen and (min-width: 768px) {
  h1 {
    margin-top: 10rem;
  }

  #register {
    background-color: lightgray;
    width: 100%;
    height: 100%;
  }
  form {
    width: 40%;
    background-color: blue;
  }

  .submit-button {
    background-color: blue;
    height: 50%;
  }

  button {
    width: 35%;
  }

  p {
    background-color: blue;
    display: flex;
    justify-content: center;
  }

  .bottom-div {
    background-color: blue;
    height: 15%;
  }

  .form-input-group {
    height: 15%;
  }

  input {
    width: 30%;
    height: 50%;
  }


}
</style>
