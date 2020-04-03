<template>
  <el-menu
    default-active="2"
    class="el-menu-vertical-demo"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b"
    :router=true
  >
    <el-submenu index="1">
      <template slot="title">
        <i class="el-icon-location"></i>
        <span>CRUD</span>
      </template>
      <el-menu-item-group>
        <template slot="title">编辑</template>
        <el-menu-item index="/blog/add">新增</el-menu-item>
        <el-menu-item index="/blog/edit">修改</el-menu-item>
      </el-menu-item-group>
      <el-menu-item-group title="浏览">
        <el-menu-item index="/blog/list">列表</el-menu-item>
      </el-menu-item-group>
    </el-submenu>
    <el-menu-item index="/about">
      <i class="el-icon-menu"></i>
      <span slot="title">导航二</span>
    </el-menu-item>
    <el-menu-item index="3">
      <i class="el-icon-setting"></i>
      <span slot="title">导航三</span>
    </el-menu-item>
  </el-menu>
</template>
<script>
export default {};
</script>
<style lang="scss" scoped>
.el-menu-vertical-demo {
  height: 100%;
}
</style>