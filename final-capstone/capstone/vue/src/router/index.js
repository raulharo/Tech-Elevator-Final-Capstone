import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import CreateProfile from '../views/CreateProfile.vue'
import Admin from '../views/Admin.vue'
import EditProfile from '../views/EditProfile.vue'
import Mindfulness from '../views/Mindfulness.vue'
import Breathe from '../views/Breathe.vue'
import RulesAndRegs from '../views/RulesAndRegs.vue'
Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false //change this back to true
      }
    },
    {
      path: '/admin-home',
      name: 'admin-home',
      component: Admin,
      meta: {
        requiresAuth: false //change to true before final impolementation
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false 
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/create-profile",
      name: "create-profile",
      component: CreateProfile,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/rules",
      name: "rules",
      component: RulesAndRegs,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/breathe",
      name: "breath-work",
      component: Breathe,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/mindfulness",
      name: "mindfulness",
      component: Mindfulness,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/edit-profile",
      name: "edit-profile",
      component: EditProfile,
      meta: {
        requiresAuth: false
      }
    },
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
