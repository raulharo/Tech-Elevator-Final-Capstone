
     <template>
  <div>
    <v-menu offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn color="primary" dark v-bind="attrs" v-on="on"> Menu </v-btn>
      </template>
      <v-list>
        <v-list-item @click="$router.push('home')">
          <v-list-item-title>Home</v-list-item-title>
        </v-list-item>
        <v-list-item>
          <v-list-item-title>Block Users</v-list-item-title>
        </v-list-item>
        <v-list-item>
          <v-list-item-title>Change User Status</v-list-item-title>
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
  
};
</script>

<style scoped>
.container {
  position: relative;
}

@media only screen and (min-width: 768px) {
}
</style>