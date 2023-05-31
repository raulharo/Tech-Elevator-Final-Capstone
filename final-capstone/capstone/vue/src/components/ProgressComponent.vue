<template>
  <div class="progress">
    <div class="today">
      <h1>Today's Progress</h1>
      <h2>Daily Goal: </h2>
      <h2> Calories Consumed: </h2>
      <h2>Calories Remaining: </h2> 
      <h2>Mindfullness Goal: </h2>
      <h2>Mindful Activity: </h2>
      </div>
      <div class="overall">
        <h1>Overall Progress</h1>

      </div>
  </div>
</template>

<script>
export default {
  name: 'progress',

}
</script>

<style scoped>
.progress{
  display: grid;
  grid-template-columns: 1fr 1fr;
}

.today {
  border: 1px solid gray;
}

.overall {
  border: 1px solid gray;
}

@media only screen and (max-width: 768px) {
  .progress {
  display: flex;
  flex-direction: column;
  }

  .today {
    border: 1px solid gray;
  }

  .overall {
    border: 1px solid gray;
  }
}
</style>