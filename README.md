# school-life
Libro de Clases Online School Life
El objetivo principal de este proyecto es desarrollar un sistema de software que pueda administrar y comunicar la información del colegio y su alumnado utilizando la base de datos entregada por el DAEM. ¡School Life, ¡Permitiendo la modernización de la gestión escolar! ¡Vivamos juntos una gestión de excelencia!

Proyecto de Portafolio de Título Duoc UC.

Comenzando 🚀
Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.

Pre-requisitos 📋
Que cosas necesitas para instalar el software y como instalarlas

- Eclipse IDE Versión 2024-03
- Para el Eclipse es necesario instalar en el eclipse marketplace las siguientes herramientes:
  -  Eclipse Enterprise Java and web developers tools 3.33
  -  Spring Tools 4 (AKA Spring tool suite 4) 4.22.0 RELEASE
- MS SQL SERVER 2022 
- SQL Server Management Studio 20
- GitHub Desktop para el manejo del versionado.

Instalación 🔧
Primero Habilitar el usuario SA y darle un password propio en el SQL Server Management Studio 20. Para luego iniciar el cliente con la autenticación "SQL SERVER AUTHENTICATION",
Crear la base de datos school_life vacía y luego ejecutar el script "daem_hualpendb_v4" para crear las tablas e insertar los datos que se encuentran en este.

Luego importar como proyecto maven el proyecto con ECLIPSE IDE y esperar que se instalen todas las dependencias.
Verificar los datos de configuración en el archivo "application.properties" encontrado en el paquete "src/main/resources/". Y cambiar la password del usuario SA por la creada respectivamente.

Para ejecutar el proyecto debe hacer clic secundario en el proyecto para ir a "run as" y presionar en spring boot app.

se dejó configurado el puerto 8080 pero este se puede cambiar en el archivo application.properties a su gusto.

luego de que se ejecute correctamente el proyecto en cualquier navegador debe ir a la ruta "localhost:8080/"

Ojo* 
  Puede que la primera vez que se intente ejecutar se produzca un error de la configuración de TCP/IP. la cual es referente a la configuración de la base de datos.
Para solucionar este error común debe ir a la herramienta "SQL SERVER 2022 CONFIGURATION MANAGER" dirigirse a "Sql server network configuration" desplegar y presionar en "protocols for MSSQLSERVER" habilitar TCP/IP en "enabled" click secundario en TCP/IP y propiedades.
hacer click en la pestaña "IP ADDRESSES" y al final en IP ALL en ambos inputs dejar el puerto por defecto "1433", luego de reiniciar los servicios de la base de datos debería funcionar sin problemas.


Spring Framework - El framework web usado
Maven - Manejador de dependencias
Microsoft SQL Server - Base de datos

Autores ✒️
- Jordan Escobar Soto
- Martín Reyes Pereira
