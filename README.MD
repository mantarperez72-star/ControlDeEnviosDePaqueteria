# PF-26 Control de Envíos de Paquetería

**Estudiante:Arturo Pérez Mantar
**Carné:** 9941-25-22044
**Código del Proyecto:** PF-26
**Enlace del Repositorio:** https://github.com/mantarperez72-star/ControlDeEnviosDePaqueteria

## Descripción del Problema
Un servicio local de paquetería necesita registrar sus tipos de envío y dar seguimiento a los paquetes. El sistema calcula automáticamente el costo del envío basándose en el peso y la tarifa del tipo de envío seleccionado, además de permitir consultar el estado de cada paquete, filtrar envíos por destinatario/estado y obtener el total cobrado por fecha.

## Tecnologías Utilizadas
*   **Lenguaje:** Java 17+ (Compatible con Spring Boot 4)
*   **Framework Backend:** Spring Boot (Spring Web, Spring Data JPA, Validation)
*   **Base de Datos:** PostgreSQL
*   **Herramientas:** Maven, IntelliJ IDEA, Postman
*   **Frontend:** HTML5, CSS3, JavaScript (Vanilla)

## Estructura General del Sistema
El backend sigue una arquitectura por capas, garantizando la separación de responsabilidades:
*   `controller`: Exposición de los endpoints de la API REST.
*   `service`: Lógica de negocio (cálculo de costos, validaciones).
*   `repository`: Interfaces de Spring Data JPA para acceso a datos.
*   `entity`: Clases del modelo de datos (Envio, TipoEnvio).
*   `dto`: Objetos de transferencia de datos (Request y Response) para no exponer las entidades.
*   `exception`: Manejo centralizado de errores (GlobalExceptionHandler).

## Reglas de Negocio Principales
1.  **Validación de Peso:** El peso del paquete debe ser estrictamente mayor a cero (0.01 en adelante).
2.  **Cálculo de Costo:** El costo total se calcula multiplicando el peso del envío por la tarifa base del tipo de envío seleccionado.
3.  **Estados Permitidos:** Un envío solo puede tener los estados: `recibido`, `en_transito`, `entregado` o `cancelado`.

## Requisitos para Ejecutar el Proyecto
*   Java Development Kit (JDK) 17 o superior.
*   Maven instalado.
*   PostgreSQL instalado y en ejecución.
*   Un navegador web moderno (para el frontend).

## Configuración de PostgreSQL
1. Abre pgAdmin o tu consola de PostgreSQL.
2. Crea una base de datos con el nombre: `paqueteria_db`.
3. El proyecto está configurado para crear las tablas automáticamente (Hibernate `ddl-auto=update`).
4. **Nota sobre credenciales:** El archivo `application.properties` utiliza variables de entorno. Si deseas ejecutarlo localmente, asegúrate de configurar tu usuario y contraseña en dicho archivo:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/paqueteria_db
   spring.datasource.username=TU_USUARIO
   spring.datasource.password=TU_CONTRASEÑA
