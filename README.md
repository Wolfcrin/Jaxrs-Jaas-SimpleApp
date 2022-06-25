# Jaxrs-Jaas-SimpleApp

Client:  
Java: openjdk 17  

Server:  
Java: openjdk 17  
Application Server: WildFly  
DB: Mysql  


In: application/json  
Out: application/json  
Paths Base  
/cursos  

Out: application/json  
POST  /webapp-jaxrs-jaas/api/cursos  
CursoRestController.crear(Curso curso)  

GET /webapp-jaxrs-jaas/api/cursos  
CursoRestController.listar()  

In:  application/json 
Out: application/json  
GET /webapp-jaxrs-jaas/api/cursos/{id}  

Out: application/json 
PUT  /webapp-jaxrs-jaas/api/cursos/{id}  
CursoRestController.editar(@PathParam long id,Curso curso)   
  
DELETE /webapp-jaxrs-jaas/api/cursos/{id}  
CursoRestController.eliminar(@PathParam long id)  
