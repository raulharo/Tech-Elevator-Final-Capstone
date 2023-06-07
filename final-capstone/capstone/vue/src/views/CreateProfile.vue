<template>
  <div class="container">
      <h1 id="title">Create Profile</h1>
      <img src="../../public/profile-circle-svgrepo-com.svg" alt="">
      <form action="">

          <div class="form-input">
          <!-- <label for="firstName">First Name</label> -->
          <v-text-field label="First Name" type="text" name="firstName" id="firstName" v-model="user.firstName"/>
          </div>

          <div class="form-input">
          <!-- <label for="lastName">Last Name</label> -->
          <v-text-field label="Last Name" name="lastName" id="lastName" v-model="user.lastName"/>
          </div>

          <div class="form-input">
          <!-- <label for="age">Age</label> -->
          <v-text-field label="Age" type="number" name="age" id="age" v-model="user.age"/>
          </div>

          <div class="form-input">
          <!-- <label for="height">Height (in.)</label> -->
          <v-text-field label="Height (in.)" type="number" name="height" id="height" v-model="user.height"/>
          </div>

          <div class="form-input">
          <!-- <label for="currentWeight">Current Weight</label> -->
          <v-text-field label="Current Weight" type="number" name="currentWeight" id="currentWeight" v-model="user.currentWeight"/>
          </div>

          <div class="form-input">
          <!-- <label for="goalWeight">Goal Weight</label> -->
          <v-text-field label="Goal Weight" type="number" name="goalWeight" id="goalWeight" v-model="user.goalWeight"/>
          </div>

          <div class="form-input">
          <!-- <label for="calorieLimit">Calorie Limit</label> -->
          <v-text-field label="Calorie Limit" type="number" name="calorieLimit" id="calorieLimit" v-model="user.calorieLimit"/>
          </div>

          <div class="form-input">
          <!-- <label for="mindfulGoal">Goal for mindfulness (minutes)</label> -->
          <v-text-field label="Goal for mindfulness" type="number" name="mindfulGoal" id="mindfulGoal" v-model="user.mindfulGoal" min="0"/>
          </div>

          <br>
          <v-btn id="submit" color="cyan lighten-3" type="submit" v-on:click="addProfile">Create Profile</v-btn>
      </form>

  </div>
</template>

<script>
import userService from "../services/UserService";
export default {
    name: "create-profile",
    components: {},
    data() {
        return {
            user: {
                firstName: "",
                lastName: "",
                age: "",
                height: "",
                currentWeight: "",
                goalWeight: "",
                calorieLimit: "",
                mindfulGoal: ""
            }
        }
    },
    methods: {
        addProfile() {
            userService.createProfile(this.user).then((response) => {
            if (response.status == 200) {
              this.$router.push({
                path: '/rules'
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
            this.$router.push('/rules');
        }
    }
}
</script>

<style scoped>

.container {
    display: flex;
    flex-direction: column;
    align-items: center;
    height: 100vh;
    width: 100vw;
}

form {
    align-items: center;
}

.form-input {
    display: flex;
    flex-direction: column;
    align-items: center;
    height: 13%;
}

input {
  border-radius: 4px;
  height: 100%;
  margin-bottom: 4%;
  width: 12rem;
  border: solid black 1.5px;
  
}

label {
    margin-bottom: 3%;
}
img {
    width: 10rem;
    margin-bottom: 1%;
}

.button-div {
    display: flex;
    justify-content: center;
    height: 9%;
    width: 100%;
    padding: 
}

button {
  width: 100%;
  height: 10%;
  background-color: #76c4fa;
  border-radius: 4px;
  margin-bottom: 10%;
}

input:hover {
    border: solid #8e8baf 1px;
}

@media only screen and (min-width: 768px) {
    .container {
        display: flex;
        align-items: center;      
        background-color: rgb(255, 255, 255);
      
        
    }
    

 
}

</style>