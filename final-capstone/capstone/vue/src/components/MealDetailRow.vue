<template>
  <div>
      <div class="food-container" v-if="!switchToInputs">
        <v-simple-table>
            <tr>
                <td>{{food.foodName}}</td>
                <td>{{food.calories}}</td>
                <td>{{food.sizeAndUnit}}</td>
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
                <input type="number" name="servingSize" id="servingSize" min="0" v-model="foodObject.servingSize" :placeholder="food.sizeAndUnit">
                <select name="measureUnit" id="measureUnit" v-model="foodObject.measureUnit">
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
                <input type="number" name="numOfServings" id="numOfServings" min="0" v-model="foodObject.numOfServings">
            </div>
        </div>
      </div>
  </div>
</template>

<script>
export default {
    props: ["food", "servingSizeAndUnit"],
    data() {
        return {
            foodObject: {
                foodName: "",
                calories: "",
                servingSize: "",
                measureUnit: "",
                numOfServings: ""
            },
            switchToInputs: false
        }
    },
    methods: {
        sizeAndUnits() {
            return this.servingSizeAndUnit.servingSize + " " + this.servingSizeAndUnit.measureUnit;
        },
        switchToInputsMethod() {
            this.switchToInputs = !this.switchToInputs;
        },
        modifyFood() {

        }
    }

    
}
</script>

<style>

</style>