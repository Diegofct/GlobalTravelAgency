USE railway;

INSERT INTO Role (idRole, name) VALUES 
        (1, 'Super Admin'),
        (2, 'AdminSistema'),
        (3, 'AgenteDeVentas'),
        (4, 'TecnicoMantenimiento');

INSERT INTO Permision (idPermission, name, description) VALUES  
        (1, 'SuperAdmin', 'Los desarrolladores tienen permisos generales.'),  
        (2, 'AdminSistema', 'El jefe o gerente general tiene acceso para todo.'),
        (3, 'AgenteDeVentas','Personal encargado de las ventas'),
        (4, 'TecnicoDeMantenimiento','Personal encargado de realizar los registros de mantenimiento');

INSERT INTO RoleHasPermission (idRoleHasPermission ,idRole, idpermission) VALUES
        (1, 1, 1),
        (2, 2, 2),
        (3, 3, 3),
        (4, 4, 4);

INSERT INTO User (idUser, username, email, password, idRole) VALUES  
        (1, 'diegofct', 'diegofct@gmail.com', 'diegofct123', 1),  
        (2, 'tomasolaya', 'tomas@gmail.com', 'tomas123', 1);