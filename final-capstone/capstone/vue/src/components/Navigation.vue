<template>
 <div>
   <div class="collapsible-menu">
     <input type="checkbox" id="menu-box">
     <label for="menu-box">Menu</label>
      <div class="menu-content">
          <ul>
            <li class="list-test" @click="$router.push('home')"><a href="#"></a>Home</li>
              <li><a href="#"></a>My Progress</li>
              <li><a href="#"></a>Track Food</li>
              <li><a href="#"></a>My Friends</li>
              <li><a href="#"></a>Mindfullness</li>
              <li><a href="#"></a>Edit Profile</li>
              <li @click="$router.push('logout')"><a href='#'></a>Logout</li>
          </ul>
        </div>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
ul{
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
}
</style>