<template>
  <div>
      <v-simple-table>
          <thead>
              <tr>
                  <th class="text-left">
                      Type
                  </th>
                  <th class="text-left">
                      TotalCalories
                  </th>
                  <th class="text-left">
                      Date
                  </th>
                  <th class="">
                      Number of Servings
                  </th>
              </tr>
          </thead>
      <tr>
          <td>{{mealRecord.type}}</td>
          <td>{{mealRecord.totalCalories}}</td>
          <td>{{this.date}}</td>
          <td>{{mealRecord.numOfServings}}</td>
      </tr>
      </v-simple-table>
  </div>
</template>

<script>
export default {
    props: ["mealRecord"],
    data() {
        return {
            date: "6/5/2023"
        }
    }
}
</script>

<style>

</style>