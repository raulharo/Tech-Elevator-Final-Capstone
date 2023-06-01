<template>
  <div>
      <v-progress-circular :rotate= "360" :size="100" :width="10" :value="25" color="teal">Calories</v-progress-circular>
       <v-progress-circular :rotate= "360" :size="100" :width="10" :value="65" color="teal">Mindfullness</v-progress-circular>
  </div>
</template>

<script>
export default {
  data () {
      return {
        interval: {},
        value: 0,
      }
    },
    beforeDestroy () {
      clearInterval(this.interval)
    },
    mounted () {
      this.interval = setInterval(() => {
        if (this.value === 100) {
          return (this.value = 0)
        }
        this.value += 10
      }, 1000)
    },

}
</script>

<style scoped>
.v-progress-circular {
  margin: 1rem;
  font-size: 65%;
}
</style>
