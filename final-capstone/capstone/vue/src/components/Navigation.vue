
<template>
<div>
  <v-menu offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="teal"
          dark
          v-bind="attrs"
          v-on="on"
        >
          Menu
        </v-btn>
      </template>
      <v-list>
        <v-list-item @click="$router.push('/')">
          <v-list-item-title>Home</v-list-item-title>
        </v-list-item>
        <v-list-item @click="$router.push('meal-log')">
          <v-list-item-title>Log Meals</v-list-item-title>
        </v-list-item>
        <v-list-item @click="$router.push('mindfulness')">
          <v-list-item-title>Log Mindfulness</v-list-item-title>
        </v-list-item>
        <v-list-item @click="$router.push('breathe')">
          <v-list-item-title>Breath Work</v-list-item-title>
        </v-list-item>
        <v-list-item @click="$router.push('edit-profile')">
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
</style>