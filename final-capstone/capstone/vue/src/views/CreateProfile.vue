<template>
  <div>
      <h1 id="title">Create Profile</h1>
      <img src="../../public/profile-circle-svgrepo-com.svg" alt="">
      <form action="">
          <label for="firstName">First Name</label>
          <br>
          <input type="text" name="firstName" id="firstName" v-model="user.firstName">
          <br>
          <label for="lastName">Last Name</label>
          <br>
          <input type="text" name="lastName" id="lastName" v-model="user.lastName">
          <br>
          <label for="age">Age</label>
          <br>
          <input type="number" name="age" id="age" v-model="user.age">
          <br>
          <label for="height">Height (in.)</label>
          <br>
          <input type="number" name="height" id="height" v-model="user.height">
          <br>
          <label for="currentWeight">Current Weight</label>
          <br>
          <input type="number" name="currentWeight" id="currentWeight" v-model="user.currentWeight">
          <br>
          <label for="goalWeight">Goal Weight</label>
          <br>
          <input type="number" name="goalWeight" id="goalWeight" v-model="user.goalWeight">
          <br>
          <label for="calorieLimit">Calorie Limit</label>
          <br>
          <input type="number" name="calorieLimit" id="calorieLimit" v-model="user.calorieLimit">
          <br>
          <label for="mindfulGoal">Mindfulness Goal</label>
          <br>
          <input type="number" name="mindfulGoal" id="mindfulGoal" v-model="user.mindfulGoal">
          <br>
          <button type="submit">Create Profile</button>
      </form>

  </div>
</template>

<script>
export default {
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
    }
}
</script>

<style>

</style>