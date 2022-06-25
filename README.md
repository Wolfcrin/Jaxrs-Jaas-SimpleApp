# Jaxrs-Jaas-SimpleApp

Client:
Java: openjdk 17



Server:
Java: openjdk 17
Application Server: WildFly
DB: Mysql


Resource Paths
/cursos
→ application/json
← application/json

POST/webapp-jaxrs-jaas/api/cursos
CursoRestController.crear(Curso arg0)
← application/json

GET/ webapp-jaxrs-jaas/api/cursos
CursoRestController.listar()

/cursos/{id}
→ application/json
← application/json
PUT/webapp-jaxrs-jaas/api/cursos/{id}
CursoRestController.editar(@PathParam long id, ar.com.wolfscrin.webapp.jaxrs.models.Curso arg1)
← application/json


DELETE/webapp-jaxrs-jaas/api/cursos/{id}
CursoRestController.eliminar(@PathParam long id)
← application/json
GET/   webapp-jaxrs-jaas/api/cursos/{id}
CursoRestController.porId(@PathParam long id)