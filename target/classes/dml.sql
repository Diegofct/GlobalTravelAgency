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

-- Inserts for Country
INSERT INTO Country (idCountry, name) VALUES 
('US', 'United States'), 
('CA', 'Canada'), 
('MX', 'Mexico'), 
('BR', 'Brazil'), 
('AR', 'Argentina'), 
('JP', 'Japan');

-- Inserts for City
INSERT INTO City (idCity, name, idCountry) VALUES 
('NYC', 'New York', 'US'), 
('TOR', 'Toronto', 'CA'), 
('MEX', 'Mexico City', 'MX'), 
('SAO', 'Sao Paulo', 'BR'), 
('BUE', 'Buenos Aires', 'AR'), 
('TOK', 'Tokyo', 'JP');

-- Inserts for Airport
INSERT INTO Airport (idAirport, name, idCity) VALUES 
('JFK', 'John F. Kennedy International Airport', 'NYC'), 
('YYZ', 'Toronto Pearson International Airport', 'TOR'), 
('MEX', 'Mexico City International Airport', 'MEX'), 
('GRU', 'São Paulo/Guarulhos International Airport', 'SAO'), 
('EZE', 'Ministro Pistarini International Airport', 'BUE'), 
('HND', 'Tokyo Haneda Airport', 'TOK');

-- Inserts for Gate
INSERT INTO Gate (idGate, gateNumber, idAirport) VALUES 
(1, 1, 'JFK'), 
(2, 2, 'JFK'), 
(3, 1, 'YYZ'), 
(4, 2, 'YYZ'), 
(5, 1, 'MEX'), 
(6, 2, 'MEX');

-- Inserts for Airline
INSERT INTO Airline (idAirline, name) VALUES 
(1, 'American Airlines'), 
(2, 'Air Canada'), 
(3, 'Aeromexico'), 
(4, 'LATAM Airlines'), 
(5, 'Aerolineas Argentinas'), 
(6, 'All Nippon Airways');

-- Inserts for AirportHasAirline
INSERT INTO AirportHasAirline (idAirport, idAirline) VALUES 
('JFK', 1), 
('YYZ', 2), 
('MEX', 3), 
('GRU', 4), 
('EZE', 5), 
('HND', 6);

-- Inserts for PositionEmployee
INSERT INTO PositionEmployee (idPositionEmployee, positionType) VALUES 
(1, 'Pilot'), 
(2, 'Co-Pilot'), 
(3, 'Flight Attendant'), 
(4, 'Ground Staff'), 
(5, 'Maintenance'), 
(6, 'Manager');

-- Inserts for Employee
INSERT INTO Employee (idEmployee, name, idPositionEmployee, ingressDate, idAirline, idAirport) VALUES 
(1, 'Alice Smith', 1, '2020-01-15', 1, 'JFK'), 
(2, 'Bob Johnson', 2, '2019-03-10', 2, 'YYZ'), 
(3, 'Charlie Brown', 3, '2021-07-22', 3, 'MEX'), 
(4, 'David Wilson', 4, '2018-05-18', 4, 'GRU'), 
(5, 'Eva Davis', 5, '2020-11-29', 5, 'EZE'), 
(6, 'Frank Miller', 6, '2017-09-14', 6, 'HND');

-- Inserts for Revision
INSERT INTO Revision (idRevision, revisionDate, idPlane) VALUES 
(1, '2021-01-10', 1), 
(2, '2021-02-15', 2), 
(3, '2021-03-20', 3), 
(4, '2021-04-25', 4), 
(5, '2021-05-30', 5), 
(6, '2021-06-05', 6);

-- Inserts for RevisionEmployee
INSERT INTO RevisionEmployee (idEmployee, idRevision) VALUES 
(1, 1), 
(2, 2), 
(3, 3), 
(4, 4), 
(5, 5), 
(6, 6);

-- Inserts for RevisionDetails
INSERT INTO RevisionDetails (idRevisionDetails, description, idEmployee, idRevision) VALUES 
(1, 'Engine check', 1, 1), 
(2, 'Fuel system check', 2, 2), 
(3, 'Hydraulics check', 3, 3), 
(4, 'Landing gear check', 4, 4), 
(5, 'Avionics check', 5, 5), 
(6, 'Cabin inspection', 6, 6);

-- Inserts for Trip
INSERT INTO Trip (idTrip, dateTrip, price, originCity, destinationCity) VALUES 
(1, '2021-07-01', 299.99, 'NYC', 'TOR'), 
(2, '2021-07-05', 399.99, 'TOR', 'MEX'), 
(3, '2021-07-10', 499.99, 'MEX', 'SAO'), 
(4, '2021-07-15', 599.99, 'SAO', 'BUE'), 
(5, '2021-07-20', 699.99, 'BUE', 'TOK'), 
(6, '2021-07-25', 799.99, 'TOK', 'NYC');

-- Inserts for TripBooking
INSERT INTO TripBooking (idTripBooking, date, idTrip) VALUES 
(1, '2021-06-01', 1), 
(2, '2021-06-05', 2), 
(3, '2021-06-10', 3), 
(4, '2021-06-15', 4), 
(5, '2021-06-20', 5), 
(6, '2021-06-25', 6);

-- Inserts for FlightFare
INSERT INTO FlightFare (idFlightFare, description, details, value) VALUES 
(1, 'Economy', 'Basic economy seat', 99.99), 
(2, 'Premium Economy', 'Premium economy seat', 199.99), 
(3, 'Business', 'Business class seat', 299.99), 
(4, 'First Class', 'First class seat', 399.99), 
(5, 'Extra Baggage', 'Extra baggage allowance', 49.99), 
(6, 'Priority Boarding', 'Priority boarding', 29.99);

-- Inserts for FlightConnection
INSERT INTO FlightConnection (idFlightConnection, connectionNumber, idTrip, idPlane, idAirport) VALUES 
(1, 'CN001', 1, 1, 'JFK'), 
(2, 'CN002', 2, 2, 'YYZ'), 
(3, 'CN003', 3, 3, 'MEX'), 
(4, 'CN004', 4, 4, 'GRU'), 
(5, 'CN005', 5, 5, 'EZE'), 
(6, 'CN006', 6, 6, 'HND');

-- Inserts for TripBookingDetails
INSERT INTO TripBookingDetails (idTripBookingDetails, idTripBooking, idCustomer, idFlightFare) VALUES 
(1, 1, 1, 1), 
(2, 2, 2, 2), 
(3, 3, 3, 3), 
(4, 4, 4, 4), 
(5, 5, 5, 5), 
(6, 6, 6, 6);

-- Inserts for TripCrew
INSERT INTO TripCrew (idEmployee, idFlightConnection) VALUES 
(1, 1), 
(2, 2), 
(3, 3), 
(4, 4), 
(5, 5), 
(6, 6);

-- Inserts for DocumentType
INSERT INTO DocumentType (idDocumentType, name, documentNumber) VALUES 
(1, 'Passport', 'P123456'), 
(2, 'ID Card', 'ID123456'), 
(3, 'Driver License', 'DL123456'), 
(4, 'Social Security', 'SS123456'), 
(5, 'Military ID', 'M123456'), 
(6, 'Visa', 'V123456');

-- Inserts for Customer
INSERT INTO Customer (idCustomer, name, age, idDocumentType) VALUES 
(1, 'Alice Smith', 30, 1), 
(2, 'Bob Johnson', 35, 2), 
(3, 'Charlie Brown', 25, 3), 
(4, 'David Wilson', 40, 4), 
(5, 'Eva Davis', 28, 5), 
(6, 'Frank Miller', 33, 6);

-- Inserts for Plane
INSERT INTO Plane (idPlane, plate, capacity, fabricationDate, idModel, idStatus) VALUES 
(1, 'PL001', 150, '2010-01-01', 1, 1), 
(2, 'PL002', 200, '2011-02-01', 2, 2), 
(3, 'PL003', 250, '2012-03-01', 3, 3), 
(4, 'PL004', 300, '2013-04-01', 4, 4), 
(5, 'PL005', 350, '2014-05-01', 5, 5), 
(6, 'PL006', 400, '2015-06-01', 6, 6);

-- Inserts for Model
INSERT INTO Model (idModel, name, idManufacturer) VALUES 
(1, 'Boeing 737', 1), 
(2, 'Airbus A320', 2), 
(3, 'Embraer 190', 3), 
(4, 'Bombardier CRJ', 4), 
(5, 'Boeing 787', 1), 
(6, 'Airbus A380', 2);

-- Inserts for Manufacturer
INSERT INTO Manufacturer (idManufacturer, name) VALUES 
(1, 'Boeing'), 
(2, 'Airbus'), 
(3, 'Embraer'), 
(4, 'Bombardier'), 
(5, 'Lockheed Martin'), 
(6, 'Northrop Grumman');

-- Inserts for Status
INSERT INTO Status (idStatus, name) VALUES 
(1, 'Active'), 
(2, 'Inactive'), 
(3, 'Maintenance'), 
(4, 'Retired'), 
(5, 'Scheduled for Maintenance'), 
(6, 'Decommissioned');