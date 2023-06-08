<template>
  <div>
      <div class="food-container" v-if="!switchToInputs">
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
        <div class="modify-food">
        <v-btn v-on:click="switchToInputsMethod">Modify Food</v-btn>
        </div>
      </div>

      <div class="input-container" v-if="switchToInputs">
          <div id="food-entry">
             <v-card flat class="pa-3">
               <v-layout class="input-container" rowclass="">
                <v-flex xs12 md6>
                  <v-text-field type="text" label="Food Name" id="foodName" v-model="foodObject.foodName" :placeholder="food.foodName"></v-text-field>
                </v-flex>
                <v-flex xs12 md6>
                  <v-text-field type="number" label="Calories" id="calories" min="0" v-model="foodObject.calories" :placeholder="food.calories"></v-text-field>
                </v-flex>
                <v-flex xs12 md6>
                  <v-text-field type="text" label="Serving Size" id="servingSize" min="0" v-model="foodObject.servingSize" :placeholder="food.servingSize"></v-text-field>
                </v-flex>
                <v-flex xs12 md6>
                  <v-text-field type="number" label="Number of Servings" id="numOfServings" min="0" v-model="foodObject.numOfServings" :placeholder="food.numOfServings"></v-text-field>
                </v-flex>

                <div class="btn-container">
                <v-btn id="accept-btn" class="white--text" v-on:click="modifyFood" color="#AED581">Accept</v-btn>
                <v-btn id="cancel-btn" class="white--text" v-on:click="switchToInputsMethod" color="#E57373">Cancel</v-btn>
                </div>
               </v-layout>
             </v-card>
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

<style scoped>
.food-container {
    margin-left: 20px;
}

.food-entry {
    margin-left: 10px;
}

.modify-food {
  margin: 0.2% 0% 0.5% 0%;
}

.input-container {
  margin-left: 20px;
  margin-bottom: 10px;
}

.btn-container {
    display: flex;
    flex-direction: column;
    padding-top: 7px;
}

#accept-btn {
    margin-bottom: 7px;
}

@media only screen and (max-width: 768px) {
  .v-btn {
    font-size: x-small;
    width: 30%;
  }

  .input-container {
      display: flex;
      flex-direction: row;
      flex-wrap: wrap;
  }
}
</style>