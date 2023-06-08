<template>
  <div class="center">
      
      <div class="circle pulse"></div>

        <a  href="https://reactgo.com/css-pulse-animation/" target="_blank" class="master"></a>
</div>

   
</template>

<script>
export default {

}
</script>

<style scoped>
body {
  height: 100vh;
  overflow: hidden;
}

.purple{
  background-color: rgba(102, 51, 153, 1);
}



.center {
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  height: 70vh;
}

.circle {
  width: 200px;
  height: 200px;
  border-radius: 50%;
  box-shadow: 0px 0px 1px 1px #0000001a;
}

.pulse {
  animation: pulse-animation 5s infinite;
  background-color: #7986CB;
}

@keyframes pulse-animation {
  0% {
    box-shadow: 0 0 0 0px rgba(255, 255, 255, 0.6);
  }
  100% {
    box-shadow: 0 0 0 40px rgba(255, 255, 255, .1);
  }
}


.master{
  color:black;
  float:right;
}

@media (max-width:900px){
  .master{
    display:none
  }
}
</style>