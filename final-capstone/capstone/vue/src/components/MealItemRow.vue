<template>
  <div>
      <tr>
          <td>{{food.foodName}}</td>
          <td>{{food.calories}}</td>
          <td>{{food.sizeAndUnit}}</td>
          <td>{{food.numOfServings}}</td>
      </tr>
  </div>
</template>

<script>
export default {
    props: ["food", "servingSizeAndUnit"],
    methods: {
        sizeAndUnits() {
            return this.servingSizeAndUnit.servingSize + " " + this.servingSizeAndUnit.measureUnit;
        }
    }

    
}
</script>

<style>

</style>