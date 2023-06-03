<template>
  <div>
      <tr>
          <td>{{food.foodName}}</td>
          <td>{{food.calories}}</td>
          <td>{{sizeAndUnit()}}</td>
          <td>{{food.numOfServings}}</td>
      </tr>
  </div>
</template>

<script>
export default {
    props: ["food"],
    methods: {
        sizeAndUnit() {
            return this.food.servingSize + " " + this.food.measureUnit
        }
    }
}
</script>

<style>

</style>