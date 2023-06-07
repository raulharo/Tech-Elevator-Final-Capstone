<template>
  <body>
    <div class="container">
      <v-app-bar app color="teal lighten-3" dark>
        <navigation />
        <v-img
          src="../../public/logo.png"
          max-height="60"
          max-width="60"
          contain
        ></v-img>
      </v-app-bar>
      <div class="content">
        <v-banner rounded color="indigo lighten-2">
          <p id="instructions">
            Try your best to sync your breath with the growing circle. Inhale as
            the circle increases, hold your inhale until it resets, and then
            exhale as the circle increases.
          </p>
          <p>
            Studies show that even one deep breath can cause a positive shift in
            wellbeing.
          </p>
        </v-banner>
        <div class="circle-wrap">
          <div class="circle-progress"></div>
        </div>
      </div>
    </div>
  </body>
</template>

<script>
import Navigation from "../components/Navigation.vue";
export default {
  components: { Navigation },
};
</script>

<style scoped>
.container {
  position: relative;
  height: 100vh;
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
  background: url("../../public/rays.jpg");
  background-size: cover;
}

.circle-wrap {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  position: relative;
  margin-bottom: 40px;
  margin-top: 35%;
}

.circle-progress {
  width: 400px;
  height: 400px;
  position: absolute;
  background-color: #563bb685;
  border-radius: 50%;
  transition: 6s ease all;
  box-shadow: 0 10px 15px 1px rgba(61, 19, 146, 0.1),
    0 4px 6px -2px rgba(0, 0, 0, 0.05);
  transform: scale(1);
  animation: pulse-black 6s infinite;
}

@keyframes pulse-black {
  0% {
    transform: scale(0.95);
    box-shadow: 0 0 0 0 rgba(0, 0, 0, 0.7);
  }

  70% {
    transform: scale(1);
    box-shadow: 0 0 0 100px rgba(0, 0, 0, 0);
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
h1 {
  color: white;
}
p {
  color: white;
}

.instructions {
  text-align: center;
  margin-bottom: 32px;
}
@media only screen and (min-width: 768px) {
  .container {
    text-align: center;
  }
  .nav {
    display: flex;
    justify-content: flex-start;
  }

  .circle-wrap {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    position: relative;
    margin-bottom: 40px;
    margin-top: 35%;
  }

  .circle-progress {
    width: 400px;
    height: 400px;
    position: absolute;
    background-color: #563bb685;
    border-radius: 50%;
    transition: 6s ease all;
    box-shadow: 0 10px 15px -3px rgba(61, 19, 146, 0.1),
      0 4px 6px -2px rgba(0, 0, 0, 0.05);
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
      box-shadow: 0 0 0 100px rgba(0, 0, 0, 0);
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
}

/* button {
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
} */
</style>