# Proyecto Agencia de Vuelo Globales.

Este proyecto es una aplicación de gestión de usuarios y roles implementada en Java utilizando las arquitecturas de **Vertical Slicing** y **Hexagonal Architecture**.

Integrantes:
Diego Carreño
Tomas Olaya

## Tecnologías Utilizadas

- **Java**: Lenguaje principal de programación.
- **Arquitectura Vertical Slicing**: Para una mejor separación de funcionalidades y módulos.
- **Arquitectura Hexagonal**: Para una clara separación entre la lógica del negocio y las dependencias externas.
- **MySQL**: Base de datos utilizada, desplegada en Railway.
- **Railway**: Plataforma de despliegue de la base de datos.

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes y subpaquetes:

- **User**
  - **Domain**: Contiene las entidades y lógica de negocio.
  - **Application**: Contiene los casos de uso y servicios.
  - **Infrastructure**: Contiene las implementaciones de persistencia y conectividad.
- **Menus**: Gestión de menús de la aplicación.
- **DBConnection.config**: Contiene el archivo de configuración de la base de datos `DatabaseConfig.java`.

## Funcionalidades

- **Gestión de Usuarios y Roles**:
  - Crear, eliminar, listar, encontrar por ID y actualizar usuarios y roles.
  - Gestión de permisos de acuerdo a los roles de usuario.
  - Autenticación de usuarios y autorización basada en roles.

### Instalación

1. Clona el repositorio:
   ```sh
   https://github.com/Diegofct/GlobalTravelAgency.git
