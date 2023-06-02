<template>
  <div class="container">
      <div class="input">
      <label >Select Breaths</label>
      <select class="breath-input"></select>
      <option value="3">3 Breaths</option>
       <option value="3">5 Breaths</option>
        <option value="3">7 Breaths</option>
  </div>
    <div class="circle-wrap">
        <div class="circle-outline"></div>
        <div class="circle-progress"></div>
    </div>
    <p class="breaths">Breaths Remaining: <span class="breaths-texts">3<span></p>
    <p class="instructions">Are you ready to start breathing?</p>
    <button class="start">Begin</button>
  </div>
</template>

<script>
export default {

}
</script>

<style>
.input {
    display: flex;
    flex-direction: column;
    margin-bottom: 40;
}
</style>