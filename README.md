# spring-oauth2-demo

An oauth2 show case based on spring cloud(zuul,eureka,oauth2), using JWT(JSON Web Token). 

Webapp is an API gateway and oauth2 client, and it is also a resource server protected by oauth2 which represents all the internal web services. 

Auth-server is for authentication and authorization server protected by spring security modules.


mvn spring-boot:run

http://localhost:8080/resource/
