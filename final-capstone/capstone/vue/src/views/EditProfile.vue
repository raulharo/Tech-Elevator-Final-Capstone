<template>
  <div class="container">
    <v-app-bar app color="teal lighten-3" dark>
      <navigation />
      <div class="picture">
        <v-img
          src="../../public/logo.png"
          max-height="60"
          max-width="60"
          contain
        ></v-img>
      </div>
    </v-app-bar>
    <div class="content">
      <h1 id="title">Edit Profile</h1>
      <div class="pfp-div">
        <div class="profile-picture">
          <img :src="user.profilePicture" alt="" />
        </div>
        <v-text-field label="Image URL" type="text" v-model="usersPfp" />
        <v-btn class="update"
          v-on:click="updateProfilePic"
          color="cyan lighten-3"
          elevation="5"
          >Upload Picture</v-btn
        >
      </div>
      <form action="">
        <div class="form-input">
          <!-- <label for="firstName">First Name</label> -->
          <v-text-field
            label="First Name"
            type="text"
            name="firstName"
            id="firstName"
            v-model="user.firstName"
          />
        </div>
        <div class="form-input">
          <!-- <label for="lastName">Last Name</label> -->
          <v-text-field
            label="Last Name"
            type="text"
            name="lastName"
            id="lastName"
            v-model="user.lastName"
          />
        </div>
        <div class="form-input">
          <!-- <label for="age">Age</label> -->
          <v-text-field
            label="Age"
            type="number"
            name="age"
            id="age"
            v-model="user.age"
          />
        </div>
        <div class="form-input">
          <!-- <label for="height">Height (in.)</label> -->
          <v-text-field
            label="Height"
            input
            type="number"
            name="height"
            id="height"
            v-model="user.height"
          />
        </div>
        <div class="form-input">
          <!-- <label for="initialWeight">Age</label> -->
          <v-text-field
            label="Starting Weight"
            type="number"
            name="initialWeight"
            id="initialWeight"
            v-model="user.initialWeight"
          />
        </div>
        <div class="form-input">
          <!-- <label for="currentWeight">Current Weight</label> -->
          <v-text-field
            label="Current Weight"
            type="number"
            name="currentWeight"
            id="currentWeight"
            v-model="user.currentWeight"
          />
        </div>
        <div class="form-input">
          <!-- <label for="goalWeight">Goal Weight</label> -->
          <v-text-field
            label="Goal Weight"
            type="number"
            name="goalWeight"
            id="goalWeight"
            v-model="user.goalWeight"
          />
        </div>
        <div class="form-input">
          <!-- <label for="calorieLimit">Calorie Limit</label> -->
          <v-text-field
            label="Calorie Limit"
            type="number"
            name="calorieLimit"
            id="calorieLimit"
            v-model="user.calorieLimit"
          />
        </div>
        <div class="form-input">
          <!-- <label for="mindfulGoal">Mindfulness Goal</label> -->
          <v-text-field
            label="Mindfulness Goal"
            type="number"
            name="mindfulGoal"
            id="mindfulGoal"
            v-model="user.mindfulGoal"
            min="0"
          />
        </div>
        <br />
        <div class="button-div">
          <v-btn
            color="cyan lighten-3"
            elevation="5"
            type="submit"
            v-on:click="editProfile"
            >Save Changes</v-btn
          >
        </div>
      </form>
    </div>
  </div>
</template>
<script>
import Navigation from "../components/Navigation.vue";
import userService from "../services/UserService";
export default {
  name: "edit-profile",
  components: { Navigation },
  data() {
    return {
      user: {
        firstName: "",
        lastName: "",
        age: "",
        height: "",
        initialWeight: "",
        currentWeight: "",
        goalWeight: "",
        calorieLimit: "",
        mindfulGoal: "",
        profilePicture: "",
      },
      usersPfp: "",
    };
  },
  created() {
    userService.getProfile().then((response) => {
      if (response.status === 200) {
        this.user = response.data;
        console.log(response);
      }
    });
  },
  methods: {
    editProfile() {
      userService.editProfile(this.user);
    },
    updateProfilePic() {
      this.user.profilePicture = this.usersPfp;
      this.usersPfp = "";
    },
  },
};
</script>
<style scoped>
.profile-picture > img {
    border-radius: 50%;
    border-color: black;
    border-style: solid;
    height: 100px;
    width: 130px;
    object-fit: cover;
}
.profile-picture {
  display: flex;
  justify-content: center;
}
#updateBtn {
  margin-bottom: 10px;
}
.picture {
  display: flex;
  justify-content: flex-end;
  width: 100%;
}
.content {
  display: flex;
  flex-direction: column;
  align-items: center;
}
h1 {
  margin-top: 5%;
}
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100;
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
.profile-picture > img {
  border-radius: 50%;
  border-color: black;
  border-style: solid;
  height: 130px;
  width: 100x;
  object-fit: cover;
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
  margin-top: -20px;
}
button {
  width: 100%;
  height: 100%;
  background-color: #76C4FA;
  border-radius: 4px;
}
.update {
    margin-bottom: 15%;
}
input:hover {
  border: solid #8E8BAF 1px;
}
@media only screen and (min-width: 768px) {
  .container {
    display: flex;
    align-items: center;
    width: 100%;
  }
}
</style>