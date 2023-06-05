<template>
  <div>
      <tr>
          <td>{{mealRecord}}</td>
          <td>{{calories}}</td>
          <td>{{sizeAndUnit}}</td>
          <td>{{numOfServings}}</td>
      </tr>
  </div>
</template>

<script>
export default {
    props: ["mealRecord"]
}
</script>

<style>

</style>