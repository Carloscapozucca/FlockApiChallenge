Challenge API Provincias

Esta API contiene 2 endpoints, uno para loguear y otro para consultar el id, nombre, latitud y longitud de una provincia por medio del nombre.

Login: http://localhost:8080/login

username: Ariel
password: ApiChallenge

Para el Login use spring-security-core y spring-boot-starter-security. Con el usuario y contraseña en el application.properties.

Una mejor aplicación, con una base de datos, sería crear una tabla de usuarios relacionadas con otra tabla de rol_users, donde la tabla de usuarios tenga el usuario y la contraseña encriptada con una configuración y un @Bean con un BCryptPasswordEncoder.

Luego use thymeleaf con HTML para generar una página Index simple, con el request de la API de provincias y la documentación de Swagger.

Para los logs use lombok con @Log4j2

El Service de provincia tiene un metodo "getByName" donde le paso por parametro el nombre de la provincia a mostrar.
Ejemplo de url: http://localhost:8080/api/provincia/Santiago%20del%20Estero
Si usan postman, uso de basic auth con user y password ya proporcionados anteriormente.
Aplico Test para esta clase con JUnit y SpringRunner.

Para el uso de Swagger use SpringFox con una configuracion y un @Bean Docket
Url swagger: http://localhost:8080/swagger-ui.html#/

Se pueden probar todas las provincias correspondientes a la api.
