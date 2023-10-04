import { createRouter, createWebHistory } from 'vue-router';
import AddEmp from '../Components/AddEmp.vue';
import Home from '../Components/Home.vue'
const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home,
      },
  {
    path: '/add',
    name: 'Add Employee',
    component: AddEmp,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
