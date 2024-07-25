package Plane.infrastructure.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import DBConnection.config.DatabaseConfig;
import Plane.domain.entity.Plane;
import Plane.domain.service.PlaneService;

public class PlaneRepository implements PlaneService{
    // obtenemos las herramientas necesarias
    private CallableStatement callableStatement = null;
    private ResultSet resultSet = null;
    private Connection connection = null;
    private String response = null;

    @Override
    public String createPlane(Plane plane) {
        String sql = "{CALL createPlane(?,?,?,?,?,?,?)}";

        try {
            // establecer una conexión
            connection = DatabaseConfig.getConnection();
            // preparar la llamada
            callableStatement = connection.prepareCall(sql);
            // pasar argumentos
            callableStatement.setInt(1, plane.getIdPlane());
            callableStatement.setString(2, plane.getPlate());
            callableStatement.setInt(3, plane.getCapacity());
            callableStatement.setDate(4, new Date(plane.getFabricationDate().getTime())); // convertimos la fecha
            callableStatement.setInt(5, plane.getIdModel());
            callableStatement.setInt(6, plane.getIdStatus());
            // registrar parámetros de salida
            callableStatement.registerOutParameter(7, Types.VARCHAR);
            // ejecutamos la llamada
            callableStatement.execute();
            // obtenemos el parámetro de salida
            response = callableStatement.getString(7);

        } catch (SQLException e) {
             e.printStackTrace(); // si algún error se presenta, que se imprima el mensaje de error
        }

        // retornamos el mensaje
        return response;
    }

    @Override
    public Plane findPlane(int idPlane) {
        // String sql = "SELECT * FROM Plane WHERE idPlane = ?";
        // try (Connection connection = DatabaseConfig.getConnection();
        //      PreparedStatement statement = connection.prepareStatement(sql)) {
        //     statement.setInt(1, idPlane);
        //     ResultSet resultSet = statement.executeQuery();
        //     if (resultSet.next()) {
        //         Plane plane = new Plane();
        //         plane.setIdPlane(resultSet.getInt("idPlane"));
        //         plane.setPlate(resultSet.getString("plate"));
        //         plane.setCapacity(resultSet.getInt("capacity"));
        //         plane.setFabricationDate(resultSet.getDate("fabricationDate"));
        //         plane.setIdModel(resultSet.getInt("idModel"));
        //         plane.setIdStatus(resultSet.getInt("idStatus"));
        //         return plane;
        //     }
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
        // return null;
    }

    @Override
    public String updatePlane(Plane plane) {
        // String sql = "UPDATE Plane SET plate = ?, capacity = ?, fabricationDate = ?, idModel = ?, idStatus = ? WHERE idPlane = ?";
        // try (Connection connection = DatabaseConfig.getConnection();
        //      PreparedStatement statement = connection.prepareStatement(sql)) {
        //     statement.setString(1, plane.getPlate());
        //     statement.setInt(2, plane.getCapacity());

        //     // Convertir java.util.Date a java.sql.Date
        //     java.util.Date utilDate = plane.getFabricationDate();
        //     java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        //     statement.setDate(3, sqlDate);

        //     statement.setInt(4, plane.getIdModel());
        //     statement.setInt(5, plane.getIdStatus());
        //     statement.setInt(6, plane.getIdPlane());
        //     statement.executeUpdate();
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
    }

    @Override
    public String deletePlane(int idPlane) {
        // String sql = "DELETE FROM Plane WHERE idPlane = ?";
        // try (Connection connection = DatabaseConfig.getConnection();
        //      PreparedStatement statement = connection.prepareStatement(sql)) {
        //     statement.setInt(1, idPlane);
        //     statement.executeUpdate();
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }        
    }

    @Override
    public List<Plane> getAllPlanes() {
        // String sql = "SELECT * FROM Plane";
        // List<Plane> planes = new ArrayList<>();
        // try (Connection connection = DatabaseConfig.getConnection();
        //      PreparedStatement statement = connection.prepareStatement(sql);
        //      ResultSet resultSet = statement.executeQuery()) {
        //     while (resultSet.next()) {
        //         Plane plane = new Plane();
        //         plane.setIdPlane(resultSet.getInt("idPlane"));
        //         plane.setPlate(resultSet.getString("plate"));
        //         plane.setCapacity(resultSet.getInt("capacity"));

        //         // Convertir java.sql.Date a java.util.Date
        //         java.sql.Date sqlDate = resultSet.getDate("fabricationDate");
        //         java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
        //         plane.setFabricationDate(utilDate);

        //         plane.setIdModel(resultSet.getInt("idModel"));
        //         plane.setIdStatus(resultSet.getInt("idStatus"));
        //         planes.add(plane);
        //     }
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
        // return planes;
    }
    
}
