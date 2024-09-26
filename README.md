# ToDo Application

Este proyecto es una aplicación de gestión de tareas (ToDo), permite a los usuarios gestionar sus tareas de manera eficiente. Incluye funcionalidad de login y autorización mediante Spring Security.

## Características principales
- Gestión de tareas (crear, leer, actualizar, eliminar).
- Autenticación y autorización de usuarios.
- Conexión a base de datos MySQL para el almacenamiento de datos.
- Exportación de informes en PDF.
- API RESTful para la interacción con el frontend.
- Notificaciones por correo electrónico.

## Tecnologías y Dependencias

La aplicación utiliza las siguientes tecnologías y dependencias:

### Framework y lenguaje
- **Java 17**: Versión del lenguaje de programación.
- **Spring Boot 2.7.16**: Framework principal para el desarrollo de la aplicación.

### Dependencias clave
- **spring-boot-starter-data-jpa**: Para manejar operaciones con bases de datos mediante JPA.
- **spring-boot-starter-jdbc**: Para conectarse a bases de datos mediante JDBC.
- **spring-boot-starter-web**: Para crear APIs RESTful.
- **spring-boot-devtools**: Herramienta para mejorar la experiencia de desarrollo con reinicio automático.
- **mysql-connector-j**: Conector JDBC para MySQL.
- **lombok**: Para reducir el boilerplate de código con anotaciones como `@Getter`, `@Setter`, etc.
- **itextpdf**: Generación de archivos PDF.
- **pdfbox**: Manipulación avanzada de archivos PDF.
- **guava**: Librería utilitaria de Google.
- **gson**: Procesamiento de datos JSON.
- **android-json**: Otra librería para trabajar con JSON.
- **spring-boot-starter-security**: Para la autenticación y autorización de usuarios.
- **jjwt**: Manejo de tokens JWT para la autenticación.
- **spring-boot-starter-mail**: Envío de correos electrónicos desde la aplicación.

### Dependencias para pruebas
- **spring-boot-starter-test**: Herramientas de prueba unitaria y de integración para Spring Boot.
- **spring-security-test**: Pruebas relacionadas con la seguridad.

## Requisitos Previos

- **Java 17** o superior instalado.
- **Maven** para gestionar las dependencias.
- **MySQL** para la base de datos.

## Configuración

1. Clona este repositorio:
    ```bash
    git clone https://github.com/tuusuario/todo-app.git
    ```

2. Configura la base de datos en `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/todoapp
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    ```

3. Ejecuta el proyecto:
    ```bash
    mvn spring-boot:run
    ```

## Funcionalidades

### Gestión de Tareas
- Los usuarios pueden crear, editar y eliminar tareas.
- Las tareas se pueden organizar en categorías o listas, similar a Trello.

### Login y Autorización
- La aplicación utiliza **Spring Security** para gestionar el acceso.
- Autenticación basada en JWT para proteger las APIs.

### Generación de PDF
- Se pueden exportar informes de tareas en formato PDF utilizando **iTextPDF**.

### Envío de correos electrónicos
- Notificaciones automáticas por correo electrónico utilizando **spring-boot-starter-mail**.

## Pruebas
Para ejecutar las pruebas unitarias y de integración, puedes ejecutar el siguiente comando:

```bash
mvn test
