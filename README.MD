# PF-26 Control de envíos de paquetería

**Estudiante:** Arturo Pérez Mantar
**Carné:** "9941-25-22044"
**Problema:** Un servicio local de paquetería necesita registrar sus tipos de envío y dar seguimiento a los paquetes. El sistema debe calcular costos y consultar el estado de cada envío.

## Tecnologías Utilizadas
- Java 17+ / Spring Boot
- PostgreSQL
- Maven / Spring Data JPA

## Configuración Local
1. Crear la base de datos en PostgreSQL con el nombre: `paqueteria_db`.
2. Configurar el archivo `src/main/resources/application.properties` con el usuario y contraseña locales.
3. Ejecutar el proyecto desde IntelliJ.
4. Ejecutar el script `database/datos_prueba.sql` para cargar los datos de prueba.

## Endpoints (Avance 1)
- `GET /api/tipos-envio` - Listar tipos de envío.
- `POST /api/tipos-envio` - Registrar un tipo de envío.
- `GET /api/envios` - Listar todos los envíos.
- `POST /api/envios` - Registrar un nuevo envío.
