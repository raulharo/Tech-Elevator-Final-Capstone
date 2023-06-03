<template>
  <div class="container">
      <h1>These are the rules</h1>
      <p>Abide by them or we won't let you in</p>
      <ul>
        <li>Don't sue us</li>
        <li>Be nice to other people</li>
        <li>Don't sue us</li>
      </ul>
      <br>
      <v-btn @click="$router.push('/')">I agree, let me in!</v-btn> 
      <scoped><v-btn @click="router.push('logout')">I don't agree, I like to sue</v-btn></scoped>
  </div>
</template>

<script>
export default {

}
</script>

<style>
.container{
  display: block;
  margin-top: 5px;
  padding: 5px;
  
}

</style>