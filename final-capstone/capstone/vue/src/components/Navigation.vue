
     <template>
<div>
  <v-menu offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="primary"
          dark
          v-bind="attrs"
          v-on="on"
        >
          Menu
        </v-btn>
      </template>
      <v-list>
        <v-list-item @click="$router.push('home')">
          <v-list-item-title>Home</v-list-item-title>
        </v-list-item>
        <v-list-item>
          <v-list-item-title>Track Food</v-list-item-title>
        </v-list-item>
        <v-list-item>
          <v-list-item-title>Track Mindfullness</v-list-item-title>
        </v-list-item>
        <v-list-item>
          <v-list-item-title>Edit Profile</v-list-item-title>
        </v-list-item>
        <v-list-item @click="$router.push('logout')">
          <v-list-item-title>Logout</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>
  
  </div>
</template>

<script>
export default {
// data: () => ({
//       items: [
//         { title: 'Home' },
//         { title: 'Track Food' },
//         { title: 'My Friends' },
//         { title: 'Track Mindfulness' },
//         { title: 'Edit Profile'}
//       ],
//     }),
}
</script>

<style scoped>
.container{
  position: relative;
}


/* ul{
  background-color: plum;
}
li {
  display: block;
  color: #000;
  padding: 8px 16px;
  text-decoration: none;
}

.collapsible-menu label{
  background-image: url("../../public/Hamburger_icon.svg.png");
}

input#menu-box {
  display: none;
}

.menu-content {
  max-height: 0;
  overflow: hidden;
  padding: 12px 16px;
  z-index: 1;
}

input:checked ~ .menu-content{
  max-height: 100%;
}

@media only screen and (min-width: 768px) {
  ul {
    background-color: plum;
    width: 100%;
  }
  

  li {
    color: #000;
    padding: 4px 4px;
    text-decoration: none;
  }

  input, label {
    display: none;
  }

  .menu-content {
    width: 100%;
    max-height: 100%;
    overflow: unset;
  }

  .menu-content > ul {
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
  }
} */
</style>