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
    data() {
        return {
            meal: {
                
            }
        }
    }
}
</script>

<style>

</style>