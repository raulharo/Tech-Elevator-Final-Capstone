<template>
  <div class="root">
      <h1>Meal Log</h1>
      <h3>Choose Meal Type:</h3>
      <select name="mealType" id="mealType" v-model="meal.mealType">
          <option value="breakfast">Breakfast</option>
          <option value="lunch">Lunch</option>
          <option value="dinner">Dinner</option>
          <option value="snack">Snack</option>
      </select>
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
          <input type="number" name="servingSize" id="servingSize" min="0" v-model="food.servingSize">
          <select name="measureUnit" id="measureUnit" v-model="food.measureUnit">
              <option value="g">g</option>
              <option value="fl oz">fl oz</option>
              <option value="cup(s)">cup(s)</option>
              <option value="tsp">tsp</option>
              <option value="tbsp">tbsp</option>
              <option value="slice">slice</option>
              <option value="oz">oz</option>
          </select>
      </div>
      <div>
          <label for="numOfServings">Number of Servings</label>
          <input type="number" name="numOfServings" id="numOfServings" min="0" v-model="food.numOfServings">
      </div>

      <button v-on:click="addFoodToMeal">+Add Food</button>

      <div>
          <meal-item-row
          v-for="food in meal.foods"
          v-bind:key="food.foodName"
          v-bind:food="food"/>
      </div>

      <button>Save Meal</button>
  </div>
</template>

<script>
import mealItemRow from '../components/MealItemRow.vue'

export default {
    data() {
        return {

            food: {
                foodName: "",
                calories: "",
                servingSize: "",
                measureUnit: "",
                numOfServings: "",
            },
            meal: {
                mealType: "",
                foods: [],
                totalCalories: ""
            }
        }
    },
    components: {
        mealItemRow
    },
    methods: {
        addFoodToMeal() {
            //this.food.sizeAndUnit = this.sizeAndUnit();
            this.meal.foods.push(this.food);
            this.food = {};
        },

        saveMeal() {
            
        }
    },
    computed: {
        sizeAndUnit() {
            return this.food.servingSize + " " + this.food.measureUnit
        }
    }
}
</script>

<style>

</style>