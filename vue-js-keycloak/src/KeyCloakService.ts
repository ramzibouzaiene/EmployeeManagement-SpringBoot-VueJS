import Keycloak from "keycloak-js";

const keycloakInstance = new Keycloak();

interface CallbackOneParam<T1 = void, T2 = void> {
  (param1: T1): T2;
}

const Login = (onAuthenticatedCallback: CallbackOneParam) => {
  keycloakInstance
    .init({ onLoad: "login-required" })
    .then(function (authenticated) {
      authenticated ? onAuthenticatedCallback() : alert("non authenticated");
    })
    .catch((e) => {
      console.dir(e);
      console.log(`keycloak init exception: ${e}`);
    });
};

const Logout = () => {
  keycloakInstance.logout();
};

const GetToken = () => {
  return keycloakInstance.token;
};

const KeyCloakService = {
  CallLogin: Login,
  CallLogout: Logout,
  GetToken: GetToken,
};

export default KeyCloakService;