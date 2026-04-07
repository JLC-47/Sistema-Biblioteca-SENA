Sistema de Gestión de Biblioteca Municipal
Este documento describe la arquitectura, funcionalidad y reglas de negocio del sistema de gestión de biblioteca desarrollado en lenguaje Java. El objetivo del proyecto es proporcionar una herramienta robusta para la administración de usuarios, ejemplares bibliográficos y el control de préstamos.

Descripción del Proyecto
La aplicación consiste en una interfaz de escritorio que permite centralizar las operaciones de una biblioteca. El sistema diferencia entre roles de usuario, como administradores y lectores, permitiendo que cada uno acceda a funciones específicas. La gestión de datos se realiza de forma dinámica en memoria, utilizando estructuras de datos eficientes para el procesamiento de la información en tiempo real.

Estructura de Directorios
De acuerdo con la organización del repositorio PROYECTO_BIBLIOTECA, el código se distribuye de la siguiente manera:

Carpeta src
Contiene el código fuente organizado en paquetes lógicos.

Paquete config
Incluye el archivo Configuracion.java, donde se definen las constantes del sistema, tales como el nombre de la institución, la versión actual, el límite máximo de préstamos y las credenciales de administración.

Paquete gui
Contiene las clases responsables de la interfaz gráfica:
VentanaLogin.java: Gestiona el acceso al sistema y el registro rápido de nuevos lectores.
VentanaPrincipal.java: Actúa como el panel central donde se visualizan las tablas de datos y se ejecutan las acciones principales.

Paquete main
Contiene la clase Main.java, que es el punto de inicio de la aplicación. Se encarga de instanciar los gestores de datos y realizar la carga inicial de información de prueba.

Paquete models
Es el núcleo de la lógica de negocio y contiene tanto las entidades como sus controladores:
Libros.java y GestorLibros.java: Para el manejo del catálogo.
Usuarios.java y GestionUsuarios.java: Para la administración de perfiles y roles.
Prestamo.java y GestorPrestamos.java: Para el control de las transacciones de libros.

Paquete utils
Incluye Validador.java, una clase de utilidad diseñada para centralizar las verificaciones de seguridad y consistencia de los datos ingresados por el usuario.

Carpeta bin
Contiene los archivos compilados (.class) generados por el entorno de desarrollo.

Carpeta .vscode
Almacena la configuración específica del editor para el manejo del proyecto Java.

Funcionalidades Detalladas
Control de Acceso y Seguridad
El sistema implementa un mecanismo de autenticación que valida el documento y la contraseña del usuario. Posee un sistema de protección que cierra la aplicación si se detectan tres intentos fallidos de inicio de sesión.

Administración de Catálogo
El módulo de libros permite la creación de registros validados por ISBN único. El sistema impide el registro de libros con años de publicación superiores al actual (2026) y gestiona estados automáticos de disponibilidad.

Gestión de Préstamos
La lógica de préstamos verifica la disponibilidad del libro y el historial del usuario antes de procesar una solicitud. Para los usuarios con rol de lector, el sistema restringe la posesión simultánea a un máximo de tres ejemplares.

Especificaciones Técnicas
El desarrollo se fundamenta en las siguientes tecnologías:
Lenguaje de programación: Java.
Librerías de interfaz: Java Swing y AWT.
Arquitectura: Programación Orientada a Objetos con separación de responsabilidades por paquetes.
Gestión de datos: Colecciones de tipo ArrayList.

Guía para el Desarrollador
Requisitos de Sistema
Es necesario contar con el Java Development Kit (JDK) instalado y configurado en las variables de entorno del sistema operativo.

Ejecución desde Consola
Para ejecutar el proyecto, se debe compilar el contenido de la carpeta src y lanzar la clase principal ubicada en main.Main.

Mantenimiento del Código
Cualquier modificación en las reglas de negocio, como el número permitido de préstamos o el cambio de año actual, debe realizarse directamente en la clase de configuración para asegurar que los cambios se apliquen de forma global en todos los módulos.