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
        <div class="circle-progress"></div>
    </div>
    
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
    justify-content: center;
    margin-bottom: 40;
}
.circle-wrap{
    display: flex;
    flex-direction: column;
  justify-content: center;
  align-items: center;
  position: relative;
  margin-bottom: 40px;
}

.circle-progress {
  width: 200px;
  height: 200px;
  position: absolute;
  background-color: #6236ff;
  border-radius: 50%;
  transition: 6s ease all;
  box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.1), 0 4px 6px -2px rgba(0, 0, 0, 0.05);
  transform: scale(2);
  animation: pulse-black 6s infinite;
}

@keyframes pulse-black {
    0% {
		transform: scale(0.95);
		box-shadow: 0 0 0 0 rgba(0, 0, 0, 0.7);
	}

	70% {
		transform: scale(1);
		box-shadow: 0 0 0 10px rgba(0, 0, 0, 0);
	}

	100% {
		transform: scale(0.95);
		box-shadow: 0 0 0 0 rgba(0, 0, 0, 0);
	}
}

.circle-grow {
  transform: scale(5.3);
}

.breaths {
  text-align: center;
  margin-bottom: 24px;
  font-size: 24px;
}

.instructions {
  text-align: center;
  margin-bottom: 32px;
}

button {

  padding: 8px 20px;
  border-radius: 8px;
  background-color: #421bd1;
  color: #fff;
  border: none;
  cursor: pointer;
  transition: 0.3s ease all;
  box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.1), 0 1px 2px 0 rgba(0, 0, 0, 0.06);
}

button:hover {
  background-color: #f1f1f1;
  color: #6236ff;
}

.button-inactive {
  pointer-events: none;
  background-color: #969696;
}

</style>