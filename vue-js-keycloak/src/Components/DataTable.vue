<template>
  <div class="table-container">
    <table class="custom-table">
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Salary</th>
          <th>Created At</th>
          <th>Updated At</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in emps" :key="item.id">
          <td>{{ item.id }}</td>
          <td>{{ item.name }}</td>
          <td>{{ item.salary }}</td>
          <td>{{ item.createdAt }}</td>
          <td>{{ item.updatedAt }}</td>
          <td class="delete-text" @click="deleteEmp(item.id)">Delete</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import axios from "axios"
import KeyCloakService from "../KeyCloakService";

export default defineComponent({
  name: "DataTable",
  data() {
    return {
      emps: [] as any,
      base_url: "http://localhost:8070",
      token: "" as unknown,
    };
  },
  mounted() {
    this.token = KeyCloakService.GetToken();
    this.getAllEmployees()
  },
  methods:{
    logout(){
      KeyCloakService.CallLogout();
    },
    async getAllEmployees(){
      try {
        const config = {
          headers: {
            Authorization: `Bearer ${this.token}`,
            Origin: "http://localhost:3000"
          },
        };
        const response = await axios.get(`${this.base_url}/employees/all`, config);
        this.emps = response.data
        console.log('ramzi', response)
      } catch (error) {
        console.log(error);
      }
    },
    async deleteEmp(userId: Number){
      try {
        const config = {
          headers: {
            Authorization: `Bearer ${this.token}`,
            Origin: "http://localhost:3000"
          },
        };
        const response = await axios.delete(`${this.base_url}/employees/delete/${userId}`, config);
        this.getAllEmployees();
      } catch (error) {
        console.log(error);
      }
    }
  },
});
</script>

<style scoped>
.table-container {
  width: 100%;
  height: 100%;
  overflow-x: auto;
}

.custom-table {
  width: 100%;
  height: 100%;
  border-collapse: collapse;
  background-color: #f5f5f5;
  white-space: nowrap;
}

.custom-table th,
.custom-table td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

.custom-table th {
  background-color: #333;
  color: #fff;
}

.custom-table tbody tr:nth-child(even) {
  background-color: #f2f2f2;
}

.delete-text {
  text-decoration: underline;
  color: red;
  display: flex;
  align-content: center;
  justify-content: center;
  cursor: pointer;
}

@media (max-width: 768px) {
  .table-container {
    overflow-x: scroll;
  }

  .custom-table {
    width: auto;
    min-width: 100%;
  }
}
</style>
