<template>
  <div id="app">
    <div class="top">
      <Header />
    </div>
    <div class="main">
      <div class="main-aside">
        <AsideMenu />
      </div>
      <div class="main-body">
        <router-view />
      </div>
    </div>
  </div>
</template>
<script>
// @ is an alias to /src
import Header from "@/components/Header.vue";
import AsideMenu from "@/components/AsideMenu.vue";
export default {
  name: "Home",
  components: {
    Header,
    AsideMenu
  }
};
</script>

<style lang="scss" scoped>
#app {
  height: 100%;
  display: flex;
  flex-direction: column;
  height: 100%;

  .main {
    flex: 1;
    display: flex;

    .main-aside {
      width: 200px;
    }

    .main-body {
      flex: 1;
    }
  }
}
</style>
<style>
.el-menu {
  border-right-width: 0;
}
</style>
