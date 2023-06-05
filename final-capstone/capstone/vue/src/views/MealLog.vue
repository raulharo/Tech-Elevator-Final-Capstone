<template>
  <div class="root">
      <navigation/>
      <h1>Meal Log</h1>
      <h3>Choose Meal Type:</h3>
      <select name="mealType" id="mealType" v-model="meal.mealType">
          <option value="breakfast">Breakfast</option>
          <option value="lunch" selected>Lunch</option>
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
            <input type="number" name="servingSize" id="servingSize" min="0" v-model="servingSizeAndUnit.servingSize">
            <select name="measureUnit" id="measureUnit" v-model="servingSizeAndUnit.measureUnit">
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

      <div v-for="mealRecord in mealRecordList"
          v-bind:key="mealRecord.type"
          v-bind:mealRecord="mealRecord">
          <meal-history-row
          
          />
      </div>
  </div>
</template>

<script>
import mealItemRow from '../components/MealItemRow.vue'
import mealHistoryRow from '../components/MealHistoryRow.vue'
import Navigation from '../components/Navigation.vue'
import foodService from '../services/FoodService.js'

export default {
    data() {
        return {
            food: {
                foodName: "",
                calories: 0,
                sizeAndUnit: "",
                numOfServings: "",
            },
            meal: {
                mealType: "",
                foods: [],
                totalCalories: 0
            },
            servingSizeAndUnit: {
                servingSize: "",
                measureUnit: "",
            },
            mealRecordList: [
                {
                    type: "Breakfast",
                    totalCalories: 550,
                    numOfServings: 2
                },
                {
                    type: "Lunch",
                    totalCalories: 623,
                    numOfServings: 1
                }
            ]
        }
    },
    components: {
        mealItemRow,
        Navigation,
        mealHistoryRow
    },
    methods: {
        addFoodToMeal() {
            if(this.meal.foods.length >= 10) {
                window.alert("Meal Limit Reached.");
            }
            else {
                this.meal.totalCalories += parseInt(this.food.calories);
                this.food.sizeAndUnit = this.servingSizeAndUnit.servingSize + " " + this.servingSizeAndUnit.measureUnit;
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
            return console.log(foodService.getMeals());
        }
    },
    computed: {
        sizeAndUnit() {
            return this.food.servingSize + " " + this.food.measureUnit
        }
    },
    created() {
        foodService.getMeals().then(response => {response.json()}).then(data => {
            this.mealRecordList = JSON.parse(data);
        });
    }
}
</script>

<style>
h1, h3, #mealType {
    text-align: center;
}

#mealType {
    border: 1px solid black;
}

#food-entry {

}
</style>