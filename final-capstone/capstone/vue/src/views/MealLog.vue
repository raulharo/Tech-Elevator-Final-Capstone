<template>
  <div class="root">
      <v-app-bar
      app
      color="teal lighten-3"
      dark
    > <navigation />
    </v-app-bar>
      <h1>Meal Log</h1>
      <h3>Choose Meal Type:</h3>
      <select name="mealType" id="mealType" v-model="meal.mealType">
          <option value="breakfast">Breakfast</option>
          <option value="lunch">Lunch</option>
          <option value="dinner">Dinner</option>
          <option value="snack">Snack</option>
      </select>
      <div id="food-entry">
        <div>
            <label for="foodName">Food Name:</label>
            <input type="text" name="foodName" id="foodName" v-model="food.foodName">
        </div>
        <div>
            <label for="calories">Calories:</label>
            <input type="number" name="calories" id="calories" min="0" v-model="food.calories">
        </div>
        <div>
            <label for="servingSize">Serving Size:</label>
            <input type="text" name="servingSize" id="servingSize" min="0" v-model="food.servingSize">
        </div>
        <div>
            <label for="numOfServings">Number of Servings</label>
            <input type="number" name="numOfServings" id="numOfServings" min="0" v-model="food.numOfServings">
        </div>

        <v-btn v-on:click="addFoodToMeal">Add Food</v-btn>
      </div>
      <div>
          <meal-item-row
          v-for="food in meal.foods"
          v-bind:key="food.foodName"
          v-bind:food="food"/>
      </div>
      <v-btn v-on:click="saveMeal">Save Meal</v-btn>
      <v-btn v-on:click="getMeals">Test Button to get this users meals in console</v-btn>

      <div v-for="mealRecord in mealRecordList" v-bind:key="mealRecord.mealId">
          <meal-history-row
          v-bind:mealRecord="mealRecord" :key="componentKey"/>
          <v-btn v-on:click="showFoodList(mealRecord)">Show Foods</v-btn>
          <div v-if="mealRecord.showFoods">
              <meal-detail-row
              v-for="food in mealRecord.foods"
              v-bind:key="food.foodId"
              v-bind:food="food"
              v-bind:mealRecord="mealRecord"/>
          </div>
      </div>
  </div>
</template>

<script>
import mealItemRow from '../components/MealItemRow.vue'
import mealHistoryRow from '../components/MealHistoryRow.vue'
import foodService from '../services/FoodService.js'
import mealDetailRow from '../components/MealDetailRow.vue'
import Navigation from '../components/Navigation.vue'

export default {
    data() {
        return {
            food: {
                foodName: "",
                calories: 0,
                servingSize: "",
                numOfServings: "",
            },
            meal: {
                mealType: "",
                foods: [],
                totalCalories: 0
            },
            mealRecordList: [],
            componentKey: 0
        }
    },
    components: {
        mealItemRow,
        mealHistoryRow,
        mealDetailRow,
        Navigation
    },
    methods: {
        addFoodToMeal() {
            if(this.meal.foods.length >= 10) {
                window.alert("Meal Limit Reached.");
            }
            else {
                this.meal.totalCalories += parseInt(this.food.calories);
                this.meal.foods.push(this.food);
                this.food = {};
                
            }
        },

        saveMeal() {
            console.log(this.meal.foods);
            console.log(this.meal.mealType);
            foodService.createMeal(this.meal);
        },

        getMeals() {
            console.log(foodService.getMeals());
        },

        showFoodList(meal) {
            meal.showFoods = !meal.showFoods;
        },
        forceRerender() {
            this.componentKey += 1;
        }
    },
    created() {
        foodService.getMeals().then(response => {
                response.data.forEach(element => {
                    this.mealRecordList.push(element);
                });
            });
    },
    
}
</script>

<style>
h1, h3, #mealType {
    text-align: center;
}

#mealType {
    border: 1px solid black;
}


</style>