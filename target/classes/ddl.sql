-- DROP DATABASE IF EXISTS TravelAgency;
-- CREATE DATABASE TravelAgency;
-- USE TravelAgency;

USE railway;

-- Users Details
CREATE TABLE Role (
    idRole INT PRIMARY KEY,
    name VARCHAR(45) NOT NULL
);

CREATE TABLE User (
    idUser INT PRIMARY KEY,
    username VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    password VARCHAR(45) NOT NULL,
    idRole INT,
    FOREIGN KEY (idRole) REFERENCES Role(idRole)
);

CREATE TABLE Permission (
    idPermission INT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    description VARCHAR(45) NOT NULL
);

CREATE TABLE RoleHasPermission (
    idRole INT,
    idPermission INT,
    PRIMARY KEY (idRole, idPermission),
    FOREIGN KEY (idRole) REFERENCES Role(idRole),
    FOREIGN KEY (idPermission) REFERENCES Permission(idPermission)
);


-- Airport Details
CREATE TABLE Country (
    idCountry VARCHAR(5) PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE City (
    idCity VARCHAR(5) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    idCountry VARCHAR(5),
    FOREIGN KEY (idCountry) REFERENCES Country(idCountry)
);

CREATE TABLE Airport (
    idAirport VARCHAR(5) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    idCity VARCHAR(5),
    FOREIGN KEY (idCity) REFERENCES City(idCity)
);

CREATE TABLE Gate (
    idGate INT PRIMARY KEY,
    gateNumber INT NOT NULL,
    idAirport VARCHAR(5),
    FOREIGN KEY (idAirport) REFERENCES Airport(idAirport)
);

CREATE TABLE Airline (
    idAirline INT PRIMARY KEY,
    name VARCHAR(45) NOT NULL
);

CREATE TABLE AirportHasAirline (
    idAirport VARCHAR(5),
    idAirline INT,
    PRIMARY KEY (idAirport, idAirline),
    FOREIGN KEY (idAirport) REFERENCES Airport(idAirport),
    FOREIGN KEY (idAirline) REFERENCES Airline(idAirline)
);


-- Employee Details
CREATE TABLE Employee (
    idEmployee INT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    idPositionEmployee INT,
    ingressDate DATE,
    idAirline INT,
    idAirport VARCHAR(5),
    FOREIGN KEY (idPositionEmployee) REFERENCES PositionEmployee(idPositionEmployee),
    FOREIGN KEY (idAirline) REFERENCES Airline(idAirline),
    FOREIGN KEY (idAirport) REFERENCES Airport(idAirport)
);

CREATE TABLE PositionEmployee (
    idPositionEmployee INT PRIMARY KEY,
    positionType VARCHAR(45) NOT NULL
);

CREATE TABLE RevisionEmployee (
    idEmployee VARCHAR(20),
    idRevision INT,
    PRIMARY KEY (idEmployee, idRevision)
);

CREATE TABLE RevisionDetails (
    idRevisionDetails INT PRIMARY KEY,
    description TEXT NOT NULL,
    idEmployee VARCHAR(20),
    idRevision INT,
    FOREIGN KEY (idEmployee) REFERENCES Employee(idEmployee),
    FOREIGN KEY (idRevision) REFERENCES Revision(idRevision)
);

CREATE TABLE Revision (
    idRevision INT PRIMARY KEY,
    revisionDate VARCHAR(45) NOT NULL,
    idPlane INT,
    FOREIGN KEY (idPlane) REFERENCES Plane(idPlane)
);

-- Flight Details
CREATE TABLE Trip (
    idTrip INT PRIMARY KEY,
    dateTrip DATE,
    price DECIMAL(10, 2),
    originCity VARCHAR(45),
    destinationCity VARCHAR(45)
);

CREATE TABLE TripBooking (
    idTripBooking INT PRIMARY KEY,
    date DATE,
    idTrip INT,
    FOREIGN KEY (idTrip) REFERENCES Trip(idTrip)
);

CREATE TABLE FlightFare (
    idFlightFare INT PRIMARY KEY,
    description VARCHAR(20),
    details VARCHAR(85),
    value DECIMAL(10, 2)
);

CREATE TABLE FlightConnection (
    idFlightConnection INT PRIMARY KEY,
    connectionNumber VARCHAR(20) NOT NULL,
    idTrip INT,
    idPlane INT,
    idAirport VARCHAR(5),
    FOREIGN KEY (idTrip) REFERENCES Trip(idTrip),
    FOREIGN KEY (idPlane) REFERENCES Plane(idPlane),
    FOREIGN KEY (idAirport) REFERENCES Airport(idAirport)
);

CREATE TABLE TripBookingDetails (
    idTripBookingDetails INT PRIMARY KEY,
    idTripBooking INT,
    idCustomer INT,
    idFlightFare INT,
    FOREIGN KEY (idTripBooking) REFERENCES TripBooking(idTripBooking),
    FOREIGN KEY (idCustomer) REFERENCES Customer(idCustomer),
    FOREIGN KEY (idFlightFare) REFERENCES FlightFare(idFlightFare)
);

CREATE TABLE TripCrew (
    idEmployee VARCHAR(20),
    idFlightConnection INT,
    PRIMARY KEY (idEmployee, idFlightConnection)
);

-- Customers Details
CREATE TABLE DocumentType (
    idDocumentType INT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    documentNumber VARCHAR(40) NOT NULL
);

CREATE TABLE Customer (
    idCustomer INT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    age INT,
    idDocumentType INT,
    FOREIGN KEY (idDocumentType) REFERENCES DocumentType(idDocumentType)
);

-- Plane Details
CREATE TABLE Manufacturer (
    idManufacturer INT PRIMARY KEY,
    name VARCHAR(45) NOT NULL
);

CREATE TABLE Model (
    idModel INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    idManufacturer INT,
    FOREIGN KEY (idManufacturer) REFERENCES Manufacturer(idManufacturer)
);

CREATE TABLE Status (
    idStatus INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE Plane (
    idPlane INT PRIMARY KEY,
    plate VARCHAR(30) NOT NULL,
    capacity INT,
    fabricationDate DATE,
    idModel INT,
    idStatus INT,
    FOREIGN KEY (idModel) REFERENCES Model(idModel),
    FOREIGN KEY (idStatus) REFERENCES Status(idStatus)
);