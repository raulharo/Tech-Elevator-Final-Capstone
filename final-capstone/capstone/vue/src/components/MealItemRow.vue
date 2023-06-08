<template>
  <div>
      <div class="food-container">
        <v-card flat class="pa-3">
            <v-layout rowclass="">
              <v-flex xs12 md6>
                <div class="caption grey--text">Food Name</div>
                <div>{{food.foodName}}</div>
              </v-flex>
              <v-flex xs12 md6>
                <div class="caption grey--text">Calories</div>
                <div>{{food.calories}}</div>
              </v-flex>
              <v-flex xs12 md6>
                <div class="caption grey--text">Serving Size</div>
                <div>{{food.servingSize}}</div>
              </v-flex>
              <v-flex xs12 md6>
                <div class="caption grey--text">Number of Servings</div>
                <div>{{food.numOfServings}}</div>
              </v-flex>
            </v-layout>
        </v-card>
      </div>
  </div>
</template>

<script>
export default {
    props: ["food"],
    methods: {
    }

    
}
</script>

<style scoped>
.food-container {
  margin-bottom: 7px;
}
</style>