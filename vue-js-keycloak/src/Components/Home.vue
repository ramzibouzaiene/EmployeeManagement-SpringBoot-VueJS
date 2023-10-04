<template>
    <div class="app-container">
    <h2>Employee Management</h2>
    <button @click="logout()" class="logout-btn">Log Out</button>
  </div>
  <div>
    <router-link to="/add" class="add-employee-btn">Add Employee</router-link>
    <DataTable />
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import DataTable from '../Components/DataTable.vue'
import AddEmployee from '../Components/AddEmp.vue'
import KeyCloakService from "../KeyCloakService";

export default defineComponent({
    name: "Home",
    components: {
        DataTable,
        AddEmployee
    },
    data() {
    return {
    };
  },
  methods:{
    logout(){
      KeyCloakService.CallLogout();
    },
  },
})
</script>
