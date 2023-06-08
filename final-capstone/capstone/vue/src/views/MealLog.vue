<template>
  <div class="root">
    <v-app-bar
      app
      color="teal lighten-3"
      dark
    > <navigation />
    <div class="picture">
      <v-img
          src="../../public/logo.png"
          max-height="60"
          max-width="60"
          contain
        ></v-img>
        </div>
    </v-app-bar>

      <h1>Meal Log</h1>
      <h3>Choose Meal Type:</h3>
      <v-select id="mealType" v-model="meal.mealType" :items="mealTypes"></v-select>
      <div id="food-entry">
        <div>
            <v-text-field label="Food Name" id="foodName" v-model="food.foodName" required></v-text-field>
        </div>
        <div>
            <v-text-field type="number" label="Calories" id="calories" min="0" v-model="food.calories"></v-text-field>
        </div>
        <div>
            <v-text-field label="Serving Size" id="servingSize" v-model="food.servingSize"></v-text-field>
        </div>
        <div>
            <v-text-field type="number" label="Number of Servings" id="numOfServings" min="0" v-model="food.numOfServings"></v-text-field>
        </div>
      </div>
      
      <div class="btn-group">
        <v-btn v-on:click="addFoodToMeal" class="button" color="cyan lighten-3" elevation="7">Add Food</v-btn>
        <v-btn v-on:click="saveMeal" class="button" color="cyan lighten-3" elevation="7">Save Meal</v-btn>
      </div>
      <div id="food-list">
          <meal-item-row
          v-for="food in meal.foods"
          v-bind:key="food.foodName"
          v-bind:food="food"/>
      </div>

      <div class="calendar">
          <v-date-picker v-model="dates" range></v-date-picker>
      </div>

      <v-toolbar
          dark
          color="teal"
          class="mb-1"
        >
          <v-text-field
            v-model="search"
            clearable
            flat
            solo-inverted
            hide-details
            prepend-inner-icon="mdi-magnify"
            label="Search"
          ></v-text-field>
          <template v-if="$vuetify.breakpoint.mdAndUp">
              <v-spacer></v-spacer>
              <v-select
                v-model="sortBy"
                flat
                solo-inverted
                hide-details
                :items="keys"
                prepend-inner-icon="mdi-magnify"
                label="Sort by"
              ></v-select>
              <v-spacer></v-spacer>
              <v-btn-toggle
                v-model="sortDesc"
                mandatory
              >
                <v-btn
                  large
                  depressed
                  color="teal-darken-4"
                  :value="false"
                >
                  <v-icon>mdi-arrow-up</v-icon>
                </v-btn>
                <v-btn
                  large
                  depressed
                  color="teal-darken-4"
                  :value="true"
                >
                  <v-icon>mdi-arrow-down</v-icon>
                </v-btn>
              </v-btn-toggle>
          </template>
        </v-toolbar>

      <div v-if="forceRerenderList">
        <div v-for="mealRecord in filteredList" v-bind:key="mealRecord.mealId">
          <meal-history-row
          v-bind:mealRecord="mealRecord"/>
          <v-btn v-on:click="showFoodList(mealRecord)">Show Foods</v-btn>
          <v-btn v-on:click="deleteMealRecord(mealRecord.mealId)">Delete Meal</v-btn>
          <div v-if="mealRecord.showFoods">
            <meal-detail-row
            v-for="food in mealRecord.foods"
            v-bind:key="food.foodId"
            v-bind:food="food"
            v-bind:mealRecord="mealRecord"/>
          </div>
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
                calories: "",
                servingSize: "",
                numOfServings: "",
            },
            meal: {
                mealType: "Breakfast",
                foods: [],
                totalCalories: 0
            },
            mealRecordList: [],
            forceRerenderList: true,
            mealTypes: ["Breakfast", "Lunch", "Dinner", "Snack"],
            dates: [],
            placeholderDate: ""
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
            foodService.createMeal(this.meal).then(this.updateMealList());
        },
        updateMealList() {
          foodService.getMeals().then(response => {
                response.data.forEach(element => {
                    this.mealRecordList.push(element);
                });
            });
          
          this.forceRerenderList = false;

          this.forceRerenderList = true;
        },
        showFoodList(meal) {
            meal.showFoods = !meal.showFoods;
        },
        deleteMealRecord(mealId) {
            foodService.deleteMeal(mealId).then(this.updateMealList());
        },
        sortDates(dates) {
            if(Date.parse(dates[0]) > Date.parse(dates[1])) {
                this.placeholderDate = dates[0];
                dates.shift();
                dates.push(this.placeholderDate);
                this.dates = dates;
            }
        }
    },
    computed: {
        filteredList() {
            let filteredMeals = this.mealRecordList.filter(item => {
                if(this.dates.length == 2) {
                    this.sortDates(this.dates);
                }

                return item.mealDate >= this.dates[0] && item.mealDate <= this.dates[1];
            });


            return filteredMeals;
        }
    },
    created() {
        foodService.getMeals().then(response => {
                response.data.forEach(element => {
                    this.mealRecordList.push(element);
                });
            });
    }
}
</script>

<style scoped>
.picture {
  display: flex;
  justify-content: flex-end;
  width: 100%;
}

.root {
    padding: 10px;
}

h1, h3, #mealType {
    text-align: center;
    font-family: "Hanken Grotesk";
}

#mealType {
    align-items: center;
    display: block;
    margin: 0 auto;
}

.calendar {
  display: flex;
  justify-content: center;
}

#food-entry {
    display: flex;
    flex-direction: column;
}

#food-list {
  margin-top: 5px;
  margin-bottom: 5px;
}

.btn-group {
    display: flex;
    justify-content: center;
}

.btn-group > .v-btn {
    margin: 15px 10px 20px 10px;
}

@media only screen and (min-width: 768px) {
    #food-entry {
        display: flex;
        flex-direction: row;
        justify-content: space-evenly;
    }

    .v-select__selection {
        widows: 100%;
        justify-content: center;
    }

    .btn-group > .v-btn {
        margin: 0px 10px 10px 5px;
    }
}

</style>