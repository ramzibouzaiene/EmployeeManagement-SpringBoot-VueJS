import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import KeyCloakService from './KeyCloakService'
import router from './Config/Router'

const renderApp = () => {
    createApp(App)
    .use(router)
    .mount("#app");
  };
KeyCloakService.CallLogin(renderApp);
