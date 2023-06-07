<template>
  <div class="root">
    <v-app-bar
      app
      color="teal lighten-3"
      dark
    > <navigation /><v-img
          src="../../public/logo.png"
          max-height="60"
          max-width="60"
          contain
        ></v-img>
    </v-app-bar>
      <h1>Meal Log</h1>
      <h3>Choose Meal Type:</h3>
      <v-select id="mealType" v-model="meal.mealType"
        :items="mealTypes"
      ></v-select>
      <div id="food-entry">
        <div>
            <v-text-field label="Food Name" id="foodName" v-model="food.foodName"></v-text-field>
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
      
      <v-container fluid>
          <v-data-iterator
          :items="mealRecordList"
          :items-per-page.sync="itemsPerPage"
          :page.sync="page"
          :search="search"
          :sort-by="sortBy.toLowerCase()"
          :sort-desc="sortDesc"
          hide-default-footer
          >
            <template v-slot:header>
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
            </template>

            <template v-slot:default="mealRecordList">
              <v-row>
                <v-col
                  v-for="item in mealRecordList"
                  :key="item.mealId"
                  cols="12"
                  sm="6"
                  md="4"
                  lg="3"
                >
                  <v-card>
                    <v-card-title class="subheading font-weight-bold">
                        {{item.mealType}}
                    </v-card-title>

                    <v-divider></v-divider>

                    <v-list dense>
                      <v-list-item
                        v-for="(key, index) in filteredKeys"
                        :key="index"
                      >
                        <v-list-item-content :class="{ 'blue--text' : sortBy === key}">
                            {{key}}:
                        </v-list-item-content>
                        <v-list-item-content
                          class="align-end"
                          :class="{ 'blue--text': sortBy === key }"
                        >
                          {{ item[key.toLowerCase()] }}
                        </v-list-item-content>
                      </v-list-item>
                    </v-list>
                  </v-card>
                </v-col>
              </v-row>
            </template>

            <template v-slot:footer>
                <v-row
                  class="mt-2"
                  align="center"
                  justify="center"
                >
                  <span class="grey--text">Items per page</span>
                  <v-menu offset-y>
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        dark
                        text
                        color="primary"
                        class="ml-2"
                        v-bind="attrs"
                        v-on="on"
                      >
                        {{ itemsPerPage }}
                        <v-icon>mdi-chevron-down</v-icon>
                      </v-btn>
                    </template>
                    <v-list>
                      <v-list-item
                        v-for="(number, index) in itemsPerPageArray"
                        :key="index"
                        @click="updateItemsPerPage(number)"
                      >
                        <v-list-item-title>{{ number }}</v-list-item-title>
                      </v-list-item>
                    </v-list>
                  </v-menu>

                  <v-spacer></v-spacer>

                  <span
                    class="mr-4
                    grey--text"
                  >
                    Page {{ page }} of {{ numberOfPages }}
                  </span>
                  <v-btn
                    fab
                    dark
                    color="blue darken 3"
                    class="ml-1"
                    @click="formerPage"
                  >
                    <v-icon>mdi-chevron-left</v-icon>
                  </v-btn>
                  <v-btn
                    fab
                    dark
                    color="blue darken-3"
                    class="ml-1"
                    @click="nextPage"
                  >
                    <v-icon>mdi-chevron-right</v-icon>
                  </v-btn>
                </v-row>
            </template>
          </v-data-iterator>
      </v-container>

      <!-- <div v-for="mealRecord in filteredList" v-bind:key="mealRecord.mealId">
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
      </div> -->
  </div>
</template>

<script>
import mealItemRow from '../components/MealItemRow.vue'
//import mealHistoryRow from '../components/MealHistoryRow.vue'
import foodService from '../services/FoodService.js'
//import mealDetailRow from '../components/MealDetailRow.vue'
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
            itemsPerPage: 4,
            itemsPerPageArray: [4, 8, 12],
            page: 1,
            filter: {},
            search: '',
            sortBy: 'name',
            keys: [
                'Date Logged',
                'Meal Type',
                'Total Calories'
            ],
            mealTypes: ["Breakfast", "Lunch", "Dinner", "Snack"],
            dates: [],
            placeholderDate: ""
        }
    },
    components: {
        mealItemRow,
        // mealHistoryRow,
        // mealDetailRow,
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
            foodService.createMeal(this.meal).then(this.$router.go());
        },
        showFoodList(meal) {
            meal.showFoods = !meal.showFoods;
        },
        deleteMealRecord(mealId) {
            foodService.deleteMeal(mealId).then(this.$router.go());
        },
        sortDates(dates) {
            if(Date.parse(dates[0]) > Date.parse(dates[1])) {
                this.placeholderDate = dates[0];
                dates.shift();
                dates.push(this.placeholderDate);
                this.dates = dates;
            }
        },
        nextPages() {
            if(this.page + 1 <= this.numberOfPages) this.page += 1
        },
        formerPage() {
            if(this.page - 1 >= 1) this.page -= 1
        },
        updateItemsPerPage(number) {
            this.itemsPerPage = number
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
        },
        numberOfPages() {
            return Math.ceil(this.mealRecordList.length / this.itemsPerPage)
        },
        filteredKeys() {
            return this.keys.filter(key => key !== 'mealId')
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

<style>

.root {
    padding: 10px;
}

h1, h3, #mealType {
    text-align: center;
}

#mealType {
    align-items: center;
    display: block;
    margin: 0 auto;
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