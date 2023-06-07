<template>
  <div>
      <div class="meal-container">
        <v-card flat class="pa-3">
            <v-layout rowclass="">
              <v-flex xs12 md6>
                <div class="caption grey--text">Date Logged</div>
                <div>{{mealRecord.mealDate}}</div>
              </v-flex>
              <v-flex xs12 md6>
                <div class="caption grey--text">Meal Type</div>
                <div>{{mealRecord.mealType}}</div>
              </v-flex>
              <v-flex xs12 md6>
                <div class="caption grey--text">Total Calories</div>
                <div>{{mealRecord.totalCalories}}</div>
              </v-flex>
            </v-layout>
        </v-card>
      </div>
  </div>
</template>

<script>
export default {
    props: ["mealRecord"],
    data() {
        return {
            date: "6/5/2023"
        }
    }
}
</script>

<style>

</style>