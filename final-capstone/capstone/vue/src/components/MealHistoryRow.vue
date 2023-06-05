<template>
  <div>
      <v-simple-table>
          <thead>
              <tr>
                  <th class="text-left">
                      Date
                  </th>
                  <th class="text-left">
                      Meal Type
                  </th>
                  <th class="text-left">
                      Total Calories
                  </th>
              </tr>
          </thead>
      <tr>
          <td>{{mealRecord.mealDate}}</td>
          <td>{{mealRecord.mealType}}</td>
          <td>{{mealRecord.totalCalories}}</td>
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