-- ==========================================
-- PF-26 Control de Envíos de Paquetería
-- Script de datos de prueba
-- ==========================================

-- 1. Insertar Tipos de Envío (Entidad de apoyo - Mínimo 4)
INSERT INTO tipos_envio (nombre, tarifa_base) VALUES ('Envío Nacional', 50.00);
INSERT INTO tipos_envio (nombre, tarifa_base) VALUES ('Envío a Estados Unidos', 150.00);
INSERT INTO tipos_envio (nombre, tarifa_base) VALUES ('Envío a México', 100.00);
INSERT INTO tipos_envio (nombre, tarifa_base) VALUES ('Envío a Europa', 250.00);
INSERT INTO tipos_envio (nombre, tarifa_base) VALUES ('Envío a Sudamérica', 200.00);
INSERT INTO tipos_envio (nombre, tarifa_base) VALUES ('Envío a Asia', 350.00);

-- 2. Insertar Envíos (Entidad principal - Mínimo 10) con fechas actualizadas
INSERT INTO envios (destinatario, peso, fecha_envio, estado, costo_total, tipo_paquete, medidas, tipo_envio_id) VALUES ('Carlos Ruiz', 2.5, '2026-11-08', 'recibido', 125.00, 'Caja', '30x20x10', 1);
INSERT INTO envios (destinatario, peso, fecha_envio, estado, costo_total, tipo_paquete, medidas, tipo_envio_id) VALUES ('Maria Lopez', 1.0, '2026-11-08', 'en_transito', 150.00, 'Flyer', '20x10', 2);
INSERT INTO envios (destinatario, peso, fecha_envio, estado, costo_total, tipo_paquete, medidas, tipo_envio_id) VALUES ('John Doe', 3.0, '2026-11-08', 'entregado', 750.00, 'Caja', '40x30x20', 3);
INSERT INTO envios (destinatario, peso, fecha_envio, estado, costo_total, tipo_paquete, medidas, tipo_envio_id) VALUES ('Kenji Sato', 5.0, '2026-11-09', 'recibido', 1750.00, 'Caja', '50x40x30', 6);
INSERT INTO envios (destinatario, peso, fecha_envio, estado, costo_total, tipo_paquete, medidas, tipo_envio_id) VALUES ('Ana Garcia', 1.5, '2026-11-09', 'cancelado', 375.00, 'Flyer', '25x15', 4);
INSERT INTO envios (destinatario, peso, fecha_envio, estado, costo_total, tipo_paquete, medidas, tipo_envio_id) VALUES ('Pedro Pascal', 4.0, '2026-11-09', 'en_transito', 800.00, 'Caja', '35x25x15', 5);
INSERT INTO envios (destinatario, peso, fecha_envio, estado, costo_total, tipo_paquete, medidas, tipo_envio_id) VALUES ('Lucia Mendez', 0.8, '2026-11-09', 'entregado', 40.00, 'Flyer', '15x10', 1);
INSERT INTO envios (destinatario, peso, fecha_envio, estado, costo_total, tipo_paquete, medidas, tipo_envio_id) VALUES ('Roberto Gomez', 2.0, '2026-11-09', 'recibido', 300.00, 'Caja', '20x20x20', 2);
INSERT INTO envios (destinatario, peso, fecha_envio, estado, costo_total, tipo_paquete, medidas, tipo_envio_id) VALUES ('Elena Rostova', 3.5, '2026-11-09', 'en_transito', 875.00, 'Caja', '45x35x25', 4);
INSERT INTO envios (destinatario, peso, fecha_envio, estado, costo_total, tipo_paquete, medidas, tipo_envio_id) VALUES ('Diego Torres', 1.2, '2026-11-09', 'recibido', 60.00, 'Flyer', '30x15', 1);