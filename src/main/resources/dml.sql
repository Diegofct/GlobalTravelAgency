USE railway;

INSERT INTO Role VALUES
(1,"Admin"),
(2,"Agente Ventas"),
(3,"Tecnico Mantenimiento"),
(4,"Cliente");

INSERT INTO Permission (idPermission, description) VALUES
(1, "Registrar Avión"),
(2, "Asignar Tripulación a Trayecto"),
(3, "Crear Reserva de Vuelo"),
(4, "Registrar Revisión de Mantenimiento"),
(5, "Consultar Información de Cliente"),
(6, "Consultar Reserva de Vuelo"),
(7, "Registrar Cliente"),
(8, "Consultar Información de Avión"),
(9, "Consultar Información de Trayecto"),
(10, "Registrar Aeropuerto"),
(11, "Consultar Información de Aeropuerto"),
(12, "Consultar Historial de Revisiones de Avión"),
(13, "Actualizar Información de Cliente"),
(14, "Eliminar Reserva de Vuelo"),
(15, "Actualizar Información de Avión"),
(16, "Eliminar Avión"),
(17, "Asignar Aeronave a Trayecto"),
(18, "Actualizar Información de Trayecto"),
(19, "Eliminar Trayecto"),
(20, "Actualizar Información de Aeropuerto"),
(21, "Eliminar Aeropuerto"),
(22, "Actualizar Información de Cliente"),
(23, "Consultar Información de Vuelo"),
(24, "Actualizar Información de Revisión"),
(25, "Eliminar Revisión de Mantenimiento"),
(26, "Consultar Asignación de Tripulación"),
(27, "Consultar Escalas de un Trayecto"),
(28, "Actualizar Información de Escala"),
(29, "Eliminar Escala"),
(30, "Registrar Tarifa de Vuelo"),
(31, "Actualizar Información de Tarifa de Vuelo"),
(32, "Eliminar Tarifa de Vuelo"),
(33, "Consultar Tarifa de Vuelo"),
(34, "Registrar Tipo de Documento"),
(35, "Actualizar Tipo de Documento"),
(36, "Eliminar Tipo de Documento"),
(37, "Consultar Tipo de Documento"),
(38, "Buscar Vuelos"),
(39, "Seleccionar Vuelo"),
(40, "Añadir Pasajeros"),
(41, "Seleccionar Asientos"),
(42, "Realizar Pago"),
(43, "Consultar Reserva de Vuelo"),
(44, "Cancelar Reserva de Vuelo"),
(45, "Modificar Reserva de Vuelo");

-- Relacionando permisos para el rol ADMINISTRADOR
INSERT INTO RoleHasPermission (idRole, idPermission, validacion) VALUES
(1, 1, "avion"),  
(1, 8, "avion"),  
(1, 12, "avion"), 
(1, 15, "avion"), 
(1, 16, "avion"), 
(1, 10, "aeropuerto"), 
(1, 11, "aeropuerto"), 
(1, 20, "aeropuerto"), 
(1, 21, "aeropuerto"), 
(1, 2, "tripulacion"),  
(1, 26, "tripulacion"), 
(1, 9, "viaje"),  
(1, 17, "viaje"), 
(1, 18, "viaje"), 
(1, 19, "viaje"), 
(1, 27, "viaje"), 
(1, 28, "viaje"), 
(1, 29, "viaje"), 
(1, 30, "tarifa"), 
(1, 31, "tarifa"), 
(1, 32, "tarifa"), 
(1, 33, "tarifa"), 
(1, 34, "documentacion"), 
(1, 35, "documentacion"), 
(1, 36, "documentacion"), 
(1, 37, "documentacion"), 

-- Relacionando permisos para el rol VENTAS
(2, 5, "cliente"),  
(2, 7, "cliente"),  
(2, 13, "cliente"), 
(2, 22, "cliente"), 
(2, 3, "reserva"),  
(2, 6, "reserva"),  
(2, 14, "reserva"), 
(2, 23, "viaje"), 

-- Relacionando permisos para el rol TECNICO
(3, 8, "avion"),  
(3, 12, "avion"), 
(3, 15, "avion"), 
(3, 4, "mantenimiento"),  
(3, 24, "mantenimiento"), 
(3, 25, "mantenimiento"), 

-- Relacionando permisos para el rol CLIENTE
(4, 38, "viaje"), 
(4, 39, "viaje"), 
(4, 40, "viaje"), 
(4, 41, "viaje"), 
(4, 42, "viaje"), 
(4, 43, "reserva"), 
(4, 44, "reserva"), 
(4, 45, "reserva"); 