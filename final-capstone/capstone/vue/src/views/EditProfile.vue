<template>
  <div class="container">
      <h1 id="title">Edit Profile</h1>
      <img src="../../public/profile-circle-svgrepo-com.svg" alt="">
      <form action="">

          <div class="form-input">
          <label for="firstName">First Name</label>
          <input type="text" name="firstName" id="firstName" v-model="user.firstName">
          </div>

          <div class="form-input">
          <label for="lastName">Last Name</label>
          <input type="text" name="lastName" id="lastName" v-model="user.lastName">
          </div>

          <div class="form-input">
          <label for="age">Age</label>
          <input type="number" name="age" id="age" v-model="user.age">
          </div>

          <div class="form-input">
          <label for="height">Height (in.)</label>
          <input type="number" name="height" id="height" v-model="user.height">
          </div>

          <div class="form-input">
          <label for="currentWeight">Current Weight</label>
          <input type="number" name="currentWeight" id="currentWeight" v-model="user.currentWeight">
          </div>

          <div class="form-input">
          <label for="goalWeight">Goal Weight</label>
          <input type="number" name="goalWeight" id="goalWeight" v-model="user.goalWeight">
          </div>

          <div class="form-input">
          <label for="calorieLimit">Calorie Limit</label>
          <input type="number" name="calorieLimit" id="calorieLimit" v-model="user.calorieLimit">
          </div>

          <div class="form-input">
          <label for="mindfulGoal">Mindfulness Goal</label>
          <input type="number" name="mindfulGoal" id="mindfulGoal" v-model="user.mindfulGoal" min="0">
          </div>

          <br>
          <div class="button-div"><button type="submit" v-on:click="editProfile">Save Changes</button></div>
      </form>

  </div>
</template>

<script>
import userService from "../services/UserService";
export default {
    name: "edit-profile",
    components: {},
    data() {
        return {
            user: {
            }
        }
    },
    created() {
        userService.getProfile().then(
            (response) => {
                if(response.status === 200) {
                    this.user = response.data;
                    console.log(response);
                }
            }
        );
    },
    methods: {
        editProfile() {
            userService.editProfile(this.user);
        }
    }
}
</script>

<style scoped>
h1 {
    margin-top: 5%;
}

.container {
    display: flex;
    flex-direction: column;
    align-items: center;
    height: 100vh;
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
    margin-bottom: 4%;
}

.button-div {
    display: flex;
    justify-content: center;
    height: 9%;
    width: 100%;
}

button {
  width: 100%;
  height: 100%;
  background-color: #76c4fa;
  border-radius: 4px;
}

input:hover {
    border: solid #8e8baf 1px;
}

@media only screen and (min-width: 768px) {
    .container {
        display: flex;
        align-items: center;      
        background-color: antiquewhite;
        width: 100%;
        
    }
    

 
}

</style>