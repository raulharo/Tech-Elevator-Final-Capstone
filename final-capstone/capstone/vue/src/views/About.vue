<template>
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
    <div class="header">
    <h1>About Us</h1>
    </div>
    <div class="about-andrew">
      <v-banner rounded color="teal lighten-4">
        <h3>Andrew Morrison</h3>
        <v-btn
          href="https://www.linkedin.com/in/andrew-morrison10/"
          v-for="icon in icons"
          :key="icon"
          class="mx-4 white--text"
          icon
        >
          <v-icon color="indigo darken-1" size="30px">
            {{ icon }}
          </v-icon>
        </v-btn>
        <br />
        <p>Andrew currently lives in Orlando, FL. After obtaining a B.S. degree
         in Psychology from Florida State University, he moved to South Korea where
         he lived for over seven years. In his free time, he enjoys exercising,
         listening to music, traveling, programming, and playing chess.</p>
      </v-banner>
    </div>
    <br />
    <div class="about-margie">
      <v-banner rounded color="teal lighten-4">
        <h3>Margie Callahan</h3>
        <v-btn
          href="https://www.linkedin.com/in/1margiecallahan/"
          v-for="icon in icons"
          :key="icon"
          class="mx-4 white--text"
          icon
        >
          <v-icon color="indigo darken-1" size="30px">
            {{ icon }}
          </v-icon>
        </v-btn>
        <br />
        <p>
          Margie lives in Milwauke, Wi and is looking forward to continuing her
          apprenticeship with Associated Bank. She is a former ICU nurse and
          has a BS in Microbiology, Economics, and Nursing. In her free time, she can be found watching movies/shows and traveling.
        </p>
      </v-banner>
    </div>
    <br />
    <div class="about-raul">
      <v-banner rounded color="teal lighten-4">
        <h3>Raul Haro</h3>
        <v-btn
          href="https://www.linkedin.com/in/raul-a-haro/"
          v-for="icon in icons"
          :key="icon"
          class="mx-4 white--text"
          icon
        >
          <v-icon color="indigo darken-1"  size="30px">
            {{ icon }}
          </v-icon>
        </v-btn>
        <br />
        <p>Raul H resides in New Castle, Delaware and is a Computer Science student 
          and soon-to-be boot camp graduate looking to learn as much about Software
           Development as possible. Hobbyist photographer 
          and lover of the hit video game Mother 3 and cilantro.</p>
      </v-banner>
    </div>
    <br />
    <div class="about-whitney">
      <v-banner rounded color="teal lighten-4">
        <h3>Whitney Bescheinen</h3>
        <v-btn
          href="https://www.linkedin.com/in/whitney-bescheinen/"
          v-for="icon in icons"
          :key="icon"
          class="mx-4 white--text"
          icon
        >
          <v-icon color="indigo darken-1" size="30px">
            {{ icon }}
          </v-icon>
        </v-btn>
        <br />
        <p>
          Whitney resides in Austin, Tx with her family. Prior to attending Tech
          Elevator she was a professional firefighter for the city of Austin.
          She has a BS degree in interdiscplinary studies with focuses on
          behavioral science and business management. When she's not coding her
          heart out, you can find her either practicing permaculture in the garden or on her mountain
          bike shredding trails.
        </p>
      </v-banner>
    </div>
  </div>
</template>

<script>
import Navigation from "../components/Navigation.vue";
export default {
  components: {
    Navigation,
  },
  data: () => ({
    icons: ["mdi-linkedin"],
  }),
};
</script>

<style scoped>
.header{
    margin-bottom: 18px;
}

.about-andrew {
  display: block;
  text-align: center;
}
.about-whitney {
  display: block;
  text-align: center;
}
.about-margie {
  display: block;
  text-align: center;
}
.about-raul {
  display: block;
  text-align: center;
}
.picture {
  display: flex;
  justify-content: flex-end;
  width: 100%;
}
</style>