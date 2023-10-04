# EmployeeManagement-SpringBoot-VueJS
Key Cloak implementation project in the front end with vue js and in the back end with spring boot/spring security.
The frontend client will be redirected to Keycloak to sign in if the credentials are correct it will be redirected to the home page so he can add, edit, or delete an employee.
The frontend was built with Vue js version 3, TypeScript, and CSS
All the CRUD Operations are handled in the backend and with spring security there are some processes for the token to be valid for every request and some other functionalities like keycloak login and token generate ..
The backend is built with Spring boot, Spring Security, JPA, Postgres, keycloak, oauth2

Both the front end and the back end are dockerized and they have a public image in the Docker Hub.
Run the docker-compose file to run all the containers and consult the project.

## Some SccreenShot from the front end
Redirect to keycloak 
![image](https://github.com/ramzibouzaiene/EmployeeManagement-SpringBoot-VueJS/assets/74255678/603834b6-6523-4f7b-b210-35e78fbc2079)
Home page with data table, add employee, delete or logout
![image](https://github.com/ramzibouzaiene/EmployeeManagement-SpringBoot-VueJS/assets/74255678/455aff16-8e3f-446f-95d9-93060d8e9ea4)
Add New Employee
![image](https://github.com/ramzibouzaiene/EmployeeManagement-SpringBoot-VueJS/assets/74255678/fa941ca2-c8ac-4aee-9aae-4db184c28fb0)
Redirect to home
![image](https://github.com/ramzibouzaiene/EmployeeManagement-SpringBoot-VueJS/assets/74255678/4b980c0b-a9ee-443f-a707-1b5fa75e810d)

### Some SccreenShot from the back end
Authentication
![authentication](https://github.com/ramzibouzaiene/EmployeeManagement-SpringBoot-VueJS/assets/74255678/07fb7751-51b4-4a9c-9469-3f2d25ced611)
Token
![token](https://github.com/ramzibouzaiene/EmployeeManagement-SpringBoot-VueJS/assets/74255678/887bc6b4-3e19-4a1f-b793-3a4923ccde33)
