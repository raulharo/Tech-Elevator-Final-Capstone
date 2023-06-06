<template>
  <div class="modal-overlay">
    <div class="modal">
      <p>
        You've been enjoying the physical health side of this app for 5 minutes.
        Now is a great time to take a break and do a mindfulness activity.
      </p>
      <v-btn id="logTab" @click="$router.push('/mindfulness')">Log Mindfulness</v-btn>
    </div>
    <div class="close">
      <v-btn @click="$emit('close-alert')">close</v-btn>
    </div>
  </div>
</template>

<script>
export default {


};
</script>
<style scoped>

.modal-overlay {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  display: flex;
  justify-content: center;
  background-color: #000000da;
}

.modal {
  text-align: center;
  background-color: white;
  height: 200px;
  width: 500px;
  margin-top: 10%;
  padding: 60px 0;
  border-radius: 20px;
}
.close {
  margin: 10% 0 0 16px;
  cursor: pointer;
  font-size: 8;
}

p {
  font-size: 16px;
  margin: 10px 0;
  padding: 5px;
}

</style>