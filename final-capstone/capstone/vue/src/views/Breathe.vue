<template>
  <body>
    <div class="container">
      <v-app-bar app color="teal lighten-3" dark>
        <navigation />
        <div class="picture">
          <v-img
          src="../../public/logo.png"
          max-height="60"
          max-width="60"
          contain
        ></v-img>
        </div>
      </v-app-bar>
      <div class="content">
        <v-banner rounded color="indigo lighten-2">
          <h3>Breathing App</h3>
          <br>
           <p>
            Studies show that even one deep breath can cause a positive shift in
            wellbeing.
          </p>
          <p id="instructions">
            Try your best to sync your breath with the growing circle. Inhale as
            the circle increases, hold your inhale until it resets, and then
            exhale as the circle increases.
          </p>
         
        </v-banner>
        <breath-circle id="breathThing" />
      </div>
    </div>
  </body>
</template>

<script>
import Navigation from "../components/Navigation.vue";
import BreathCircle from "../components/BreathCircle.vue"
export default {
  components: { Navigation, BreathCircle },
};
</script>

<style scoped>
#breathThing{
  display: flex;
  justify-content: center;
}
.picture {
  display: flex;
  justify-content: flex-end;
  width: 100%;
}
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
  background-color: rgba(0, 128, 128, 0.1)
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

h3 {
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

  .instructions {
    text-align: center;
    margin-bottom: 32px;
  }
}
</style>