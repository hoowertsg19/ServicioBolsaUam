# Bolsa de Trabajo UAM

Bienvenido a la Bolsa de Trabajo UAM, una plataforma diseñada para conectar a empresas con estudiantes y egresados de la Universidad Americana (UAM). Este proyecto ofrece una solución integral para la gestión de oportunidades laborales, facilitando la inserción laboral de la comunidad universitaria y proporcionando a las empresas acceso a talento calificado.

## Descripción del Proyecto

La Bolsa de Trabajo UAM se compone de dos componentes principales:

- **Aplicación Móvil en Android**: Permite a los estudiantes y egresados buscar y aplicar a vacantes de trabajo y pasantías, gestionar su perfil y hacer seguimiento de sus postulaciones.
- **Administrador en HTML**: Proporciona a los administradores una interfaz para gestionar solicitudes de registro y publicación de vacantes, monitorear postulaciones y generar reportes.

## Características Principales

### Para Estudiantes y Egresados
- **Registro y Gestión de Perfil**: Registro sencillo y gestión de información personal y académica.
- **Búsqueda de Vacantes**: Búsqueda avanzada de vacantes y pasantías según criterios específicos.
- **Aplicación a Vacantes**: Aplicación rápida y seguimiento de postulaciones.
- **Notificaciones**: Recibe notificaciones sobre el estado de tus aplicaciones.

### Para Empresas
- **Publicación de Vacantes**: Publicación de vacantes y pasantías, con posibilidad de edición y cancelación.
- **Gestión de Postulaciones**: Visualización y gestión de las aplicaciones recibidas.
- **Reportes y Estadísticas**: Generación de reportes sobre vacantes publicadas y postulaciones.

### Para Administradores
- **Gestión de Solicitudes**: Revisión y autorización de registros de nuevos usuarios y publicaciones de vacantes.
- **Monitoreo de Actividad**: Supervisión de la actividad de la plataforma y generación de reportes detallados.

## Tecnologías Utilizadas
- **Backend**: Spring Boot
- **Base de Datos**: PostgreSQL
- **Frontend Web**: HTML, CSS, JavaScript
- **Aplicación Móvil**: Android (Kotlin, Jetpack Compose)
- **Autenticación**: Firebase

## Instalación y Configuración

### Requisitos Previos
- JDK 19.0.2
- Android Studio
- PostgreSQL
- IntelliJ IDEA (opcional para desarrollo backend)

### Pasos para la Instalación

1. **Clonar el repositorio**:
    ```sh
    git clone https://github.com/tu_usuario/bolsa-de-trabajo-uam.git
    ```

2. **Backend**:
    - Importar el proyecto en IntelliJ IDEA o tu IDE favorito.
    - Configurar la base de datos PostgreSQL en `application.properties`.
    - Ejecutar el servidor Spring Boot.

3. **Frontend Web**:
    - Abrir el archivo `index.html` en tu navegador o desplegarlo en un servidor web.

4. **Aplicación Móvil**:
    - Importar el proyecto en Android Studio.
    - Configurar Firebase para autenticación.
    - Ejecutar la aplicación en un emulador o dispositivo físico.

## Contribuir

Si deseas contribuir al proyecto, por favor sigue los siguientes pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`).
3. Realiza los cambios necesarios y realiza commit (`git commit -m 'Añadir nueva característica'`).
4. Sube los cambios (`git push origin feature/nueva-caracteristica`).
5. Abre un Pull Request.

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para obtener más información.
