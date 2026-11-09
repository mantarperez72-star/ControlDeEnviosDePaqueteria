# PF-26 Control de Envíos de Paquetería

**Estudiante:** Arturo Pérez Mantar
**Carné:** 9941-25-22044
**Código del Proyecto:** PF-26
**Enlace del Repositorio:** https://github.com/mantarperez72-star/ControlDeEnviosDePaqueteria

## Descripción del Problema
Un servicio local de paquetería necesita registrar sus tipos de envío (nacionales e internacionales) y dar seguimiento a los paquetes. El sistema calcula automáticamente el costo del envío basándose en el peso del paquete, la tarifa del destino y el tipo de empaque (Caja o Flyer). Además, permite consultar el estado de cada paquete, filtrar envíos por destinatario/estado y obtener el total cobrado por fecha.

## Tecnologías Utilizadas
*   **Lenguaje:** Java 17+ (Compatible con Spring Boot 4)
*   **Framework Backend:** Spring Boot (Spring Web, Spring Data JPA, Validation)
*   **Base de Datos:** PostgreSQL
*   **Herramientas:** Maven, IntelliJ IDEA, Postman
*   **Frontend:** HTML5, CSS3, JavaScript (Vanilla)

## Estructura General del Sistema
El backend sigue una arquitectura por capas:
*   `controller`: Exposición de los endpoints de la API REST.
*   `service`: Lógica de negocio (cálculo de costos, validaciones).
*   `repository`: Interfaces de Spring Data JPA para acceso a datos.
*   `entity`: Clases del modelo de datos (Envio, TipoEnvio).
*   `dto`: Objetos de transferencia de datos (Request y Response).
*   `exception`: Manejo centralizado de errores (GlobalExceptionHandler).

## Reglas de Negocio Principales
1.  **Validación de Peso:** El peso del paquete debe ser estrictamente mayor a cero (0.01 en adelante).
2.  **Cálculo de Costo:** El costo total se calcula multiplicando el peso del envío por la tarifa base del tipo de envío seleccionado.
3.  **Estados Permitidos:** Un envío solo puede tener los estados: `recibido`, `en_transito`, `entregado` o `cancelado`.
4.  **Destinos Únicos:** No se pueden duplicar los nombres de los tipos de envío (destinos).

## Requisitos para Ejecutar el Proyecto
*   Java Development Kit (JDK) 17 o superior.
*   Maven instalado.
*   PostgreSQL instalado y en ejecución.
*   Un navegador web moderno.

## Configuración de PostgreSQL
1. Abre pgAdmin o tu consola de PostgreSQL.
2. Crea una base de datos con el nombre: `paqueteria_db`.
3. El proyecto está configurado para crear las tablas automáticamente (Hibernate `ddl-auto=update`).
4. **Nota sobre credenciales:** El archivo `application.properties` utiliza variables de entorno para no exponer contraseñas. Si deseas ejecutarlo localmente, configura tu usuario y contraseña en dicho archivo.

## Instrucciones para Iniciar el Backend y Frontend
1. Clona este repositorio o descarga el código.
2. Abre el proyecto en IntelliJ IDEA y espera a que Maven descargue las dependencias.
3. Ejecuta el archivo `PaqueteriaApplication.java` (botón Run/Play).
4. El servidor estará disponible en: `http://localhost:8080`.
5. El Frontend se abrirá automáticamente al ingresar a `http://localhost:8080` en tu navegador.
6. **Opcional:** Ejecuta el script `datos_prueba.sql` en tu base de datos para cargar los registros de prueba.

## Descripción de los Endpoints (API REST)

### Tipos de Envío
*   `GET /api/tipos-envio` - Lista todos los tipos de envío.
*   `POST /api/tipos-envio` - Registra un nuevo tipo de envío.

### Envíos
*   `GET /api/envios` - Lista todos los envíos registrados.
*   `GET /api/envios/{id}` - Busca un envío por su ID.
*   `POST /api/envios` - Registra un nuevo envío (Calcula el costo automáticamente).
*   `PUT /api/envios/{id}` - Modifica los datos de un envío existente.
*   `DELETE /api/envios/{id}` - Elimina un envío.

### Filtros y Consultas Específicas
*   `GET /api/envios/filtrar/estado?estado={estado}` - Filtra envíos por estado.
*   `GET /api/envios/filtrar/destinatario?destinatario={nombre}` - Busca envíos por destinatario.

### Indicador
*   `GET /api/envios/total-cobrado?fecha=YYYY-MM-DD` - Devuelve la suma de los costos de todos los envíos realizados en una fecha específica.

## Documentación y Pruebas
*   **Scripts SQL:** En la raíz del proyecto se encuentra `datos_prueba.sql`.
*   **Colección de Postman:** En la raíz del proyecto se encuentra `Coleccion_Postman_PF26.json`.
*   **Evidencias:** El documento de Word con las capturas de pantalla está en la carpeta `Evidencias proyecto final 2026`.

---
*Proyecto desarrollado para el curso de Programación Orientada a Objetos - Universidad Mariano Gálvez de Guatemala.*
