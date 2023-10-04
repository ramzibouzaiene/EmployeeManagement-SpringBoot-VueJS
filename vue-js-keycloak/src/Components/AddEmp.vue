<template>
    <section class="form">
      <div class="field">
        <label class="label">Name</label>
        <div class="control">
          <input v-model="name" class="input" type="text" placeholder="Enter the name" required aria-required="true">
        </div>
      </div>
      <div class="field">
        <label class="label">Salary</label>
        <div class="control">
          <input v-model="salary" class="input" type="number" placeholder="Enter the salary">
        </div>
      </div>
      <div class="field">
        <button class="button" @click="saveEmployee">{{ mode === 'Add' ? 'Add New Employee' : 'Update Employee' }}</button>
        <div class="error-message" v-if="error">{{ error }}</div>
    </div>
    </section>
  </template>
<script lang="ts">
import axios from "axios";
import { defineComponent } from "vue";
import KeyCloakService from "../KeyCloakService";

export default defineComponent({
    name:"AddEditEmployee",
    data(){
        return {
            name: '' as String,
            salary: 0 as Number,
            error: '',
            token: "" as unknown,
            mode: 'Add',
            employeeId: null as any,
            base_url: "http://localhost:8070",
        };
    },
    computed: {
        isAddMode() {
        return this.mode === "Add";
        },
    },
    watch: {
        $route(to) {
        this.employeeId = to.params.employeeId;
        this.mode = this.employeeId ? "Edit" : "Add";
        this.initializeForm();
        },
  },
  created() {
    this.token = KeyCloakService.GetToken();
    this.initializeForm();
  },
  beforeRouteUpdate(to, from, next) {
    this.employeeId = to.params.employeeId;
    this.mode = this.employeeId ? "Edit" : "Add";
    this.initializeForm();
    next();
    },
  beforeMount() {
    this.initializeForm();
  },
    methods: {
        async loadExistingData() {
      if (!this.employeeId) return;
      try {
        const config = {
          headers: {
            Authorization: `Bearer ${this.token}`,
          },
        };
        const response = await axios.get(
          `${this.base_url}/employees/${this.employeeId}`,
          config
        );
        this.name = response.data.name;
        this.salary = response.data.salary;
      } catch (error: any) {
        this.error = "Error loading employee data: " + error.message;
      }
    },
    initializeForm() {
        if (this.mode === "Add") {
        this.name = "";
        this.salary = 0;
      } else if (this.mode === "Edit") {
        this.loadExistingData();
      }
    },
    async saveEmployee() {
        if (!this.name) {
            this.error = 'Name is required';
            return;
        }
      const employeeData = {
        name: this.name,
        salary: this.salary,
      };
      if (this.mode === 'Add'){
        try {
        const config = {
          headers: {
            Authorization: `Bearer ${this.token}`,
          },
        };
        const response = await axios.post(`${this.base_url}/employees/create`, employeeData, config);
        this.name = '';
        this.salary = 0;
        window.location.href = '/';
        } catch (error: any) {
            this.error = 'Error adding employee: ' + error.message;
        }
      } else {
        try {
        const config = {
          headers: {
            Authorization: `Bearer ${this.token}`,
          },
        };
        const response = await axios.put(`${this.base_url}/employees/${this.employeeId}`, employeeData, config);
        console.log('Employee added:', response.data);
        this.name = '';
        this.salary = 0;
        window.location.href = '/';
      } catch (error: any) {
        this.error = 'Error adding employee: ' + error.message;
      }
      }
    },
  },
})
</script>
<style scoped>
.form {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  background-color: #f7f7f7;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.field {
  margin-bottom: 15px;
}

.label {
  font-size: 16px;
  font-weight: bold;
  display: block;
  margin-bottom: 5px;
}

.input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 16px;
}

.button {
  background-color: #007BFF;
  color: #fff;
  border: none;
  border-radius: 5px;
  padding: 10px 20px;
  font-size: 18px;
  cursor: pointer;
}

.button:hover {
  background-color: #0056b3;
}
</style>