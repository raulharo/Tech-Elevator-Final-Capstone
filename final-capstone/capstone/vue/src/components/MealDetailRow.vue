<template>
  <div>
      <div class="food-container" v-if="!switchToInputs">
        <v-simple-table>
            <tr>
                <td>{{food.foodName}}</td>
                <td>{{food.calories}}</td>
                <td>{{food.servingSize}}</td>
                <td>{{food.numOfServings}}</td>
            </tr>
        </v-simple-table>
        <v-btn v-on:click="switchToInputsMethod">Modify Food</v-btn>
      </div>

      <div class="input-container" v-if="switchToInputs">
          <div id="food-entry">
            <div>
                <label for="foodName">Food Name:</label>
                <input type="text" name="foodName" id="foodName" v-model="foodObject.foodName" :placeholder="food.foodName">
            </div>
            <div>
                <label for="calories">Calories:</label>
                <input type="number" name="calories" id="calories" min="0" v-model="foodObject.calories" :placeholder="food.calories">
            </div>
            <div>
                <label for="servingSize">Serving Size:</label>
                <input type="text" name="servingSize" id="servingSize" min="0" v-model="foodObject.servingSize" :placeholder="food.servingSize">
            </div>
            <div>
                <label for="numOfServings">Number of Servings</label>
                <input type="number" name="numOfServings" id="numOfServings" min="0" v-model="foodObject.numOfServings" :placeholder="food.numOfServings">
            </div>
            <v-btn v-on:click="modifyFood">Accept</v-btn>
            <v-btn v-on:click="switchToInputsMethod">Cancel</v-btn>
        </div>
      </div>
  </div>
</template>

<script>
import foodService from '../services/FoodService.js'

export default {
    props: ["food", "mealRecord"],
    data() {
        return {
            foodObject: {
                foodId: this.food.foodId,
                foodName: "",
                calories: "",
                servingSize: "",
                numOfServings: ""
            },
            mealObject: {
                mealId: this.mealRecord.mealId,
                mealDate: this.mealRecord.mealDate,
                mealType: this.mealRecord.mealType,
                totalCalories: 0
            },
            switchToInputs: false
        }
    },
    methods: {
        switchToInputsMethod() {
            this.switchToInputs = !this.switchToInputs;
        },
        modifyFood() {
            if(this.foodObject.foodName === "") {
                this.foodObject.foodName = this.food.foodName;
            }

            if(this.foodObject.calories === "") {
                this.foodObject.calories = this.food.calories;
            }

            if(this.foodObject.servingSize === "") {
                this.foodObject.servingSize = this.food.servingSize;
            }

            if(this.foodObject.numOfServings === "") {
                this.foodObject.numOfServings = this.food.numOfServings;
            }

            foodService.updateFood(this.foodObject);

            this.mealRecord.foods.forEach(element => {
                if(element.foodId === this.foodObject.foodId) {
                    element.calories = this.foodObject.calories;
                }

                this.mealObject.totalCalories += parseInt(element.calories);
            });

            foodService.updateMeal(this.mealObject).then(this.$router.go());
        }
    }

    
}
</script>

<style>

</style>