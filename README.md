
                                                           🧠 Descripción
        
La aplicación permite:

Consultar libros desde una API pública (como Gutendex).

Guardar libros y autores en una base de datos PostgreSQL.

Consultar y listar libros y autores.

Filtrar libros por idioma.

Listar autores vivos en un año determinado.

Ofrecer endpoints REST para interactuar con los datos.

🛠 Tecnologías utilizadas

✔ Java 17+
✔ Spring Boot
✔ Spring Data JPA
✔ PostgreSQL
✔ Jackson (para manejo de JSON)
✔ Maven

🚀 Características

La API ofrece las siguientes funcionalidades:

Buscar libro por título

Listar todos los libros registrados

Listar todos los autores registrados

Buscar autores vivos en un año específico

Listar libros por idioma

Persistencia de datos en base de datos

Capacidad de consumir datos desde una API externa y mapear JSON a objetos Java.

                                                        📥 Requisitos previos

Antes de ejecutar el proyecto necesitás:

✔ Tener instalado Java 17 o superior
✔ Tener PostgreSQL instalado
✔ Crear una base de datos llamada, por ejemplo, literatura
✔ Maven o IDE que maneje proyectos Maven

                                                            💡 Instalación

Cloná el repositorio:

git clone https://github.com/carlosmendez98/challenge-alura-literatura.git

Entrá al proyecto:

cd challenge-alura-literatura/demo
⚙ Configuración de base de datos

Editá tu archivo application.properties o application.yml con tus credenciales de PostgreSQL:

spring.datasource.url=jdbc:postgresql://localhost:5432/literatura
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update
🏃‍♂️ Cómo ejecutar

Desde tu IDE (como IntelliJ) ejecutá la clase principal (p. ej., DemoApplication.java) o desde consola:

mvn spring-boot:run
📡 Endpoints disponibles
Método	Ruta	Descripción
GET	/api/libros	Lista todos los libros
GET	/api/libros/{id}	Muestra libro por ID
GET	/api/autores	Lista autores
GET	/api/autores/vivos?anio=X	Autores vivos en año
GET	/api/libros/idioma/{idioma}	Libros por idioma
POST	/api/libros	Guarda libro (usando API externa)

⚠ Estos son ejemplos típicos de rutas en este tipo de proyecto. Ajustá según tu código real.

                                                      🧩 Flujo de uso
 
Registrar libro por título: Se consume la API externa (p. ej., Gutendex).

Guardar en DB: Se mapean los datos relevantes (título, autor, idiomas, etc.).

Consultar / Listar: Se exponen vía endpoints REST.

Filtros: Se aplican filtros por idioma o año.

                                                             🧪 Tests

Si tu proyecto incluye tests unitarios o de integración, listalos aquí.

                                                       📌 Buenas prácticas
 
✔ Mapeo de JSON a objetos con Jackson
✔ Uso de DTO para separar entidad y transporte
✔ Arquitectura en capas (Controller → Service → Repository)
✔ Manejo de errores y validaciones REST

                                                              👨‍💻 Autor

Carlos Méndez
Desarrollador Back End en formación – Parte del proyecto Oracle NEXT Education + Alura Latam.

                                                                         📝 Licencia

Este proyecto es para fines de práctica y aprendizaje.
