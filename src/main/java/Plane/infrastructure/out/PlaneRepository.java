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
    private PreparedStatement preparedStatement = null;
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
        } finally { // agregamos un bloque finally para que al momento de finalizar de hacer el procedimiento cierre las herramientas que estan usando
            closeResources();
        }

        // retornamos el mensaje
        return response;
    }

    @Override
    public Plane findPlane(int idPlane) {
        String sql = "{CALL findPlane(?)}";
        Plane newPlane = null;

        try {
            connection = DatabaseConfig.getConnection();
            
            callableStatement = connection.prepareCall(sql);
            
            callableStatement.setInt(1, idPlane);
            
            resultSet = callableStatement.executeQuery();

            if (resultSet.next()) {
                // si hay un avion; crearlo y retornarlo
                newPlane = new Plane();
                // asignamos los datos de la columna en esta instancia
                newPlane.setIdPlane(resultSet.getInt("id"));
                newPlane.setPlate(resultSet.getString("plate"));
                newPlane.setCapacity(resultSet.getInt("capacity"));
                newPlane.setFabricationDate(resultSet.getDate("fabrication_date"));
                newPlane.setIdModel(resultSet.getInt("id_model"));
                newPlane.setIdStatus(resultSet.getInt("id_status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // retornar avion
        return newPlane;
    }

    @Override
    public String updatePlane(Plane plane) {
        String sql = "{CALL updatePlane(?,?,?,?,?,?,?)}";

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
        } finally { // agregamos un bloque finally para que al momento de finalizar de hacer el procedimiento cierre las herramientas que estan usando
            closeResources();
        }

        // retornamos el mensaje
        return response;
    }

    @Override
    public String deletePlane(int idPlane) {
        String sql = "{CALL deletePlane(?,?)}";
        
        try {
            // establecer conexión
            connection = DatabaseConfig.getConnection();

            callableStatement = connection.prepareCall(sql);

            callableStatement.setInt(1, idPlane);

            callableStatement.registerOutParameter(2, Types.VARCHAR);

            callableStatement.execute();

            response = callableStatement.getString(2);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    public List<Plane> getAllPlanes() {
        String sql = "SELECT * FROM planeView";
        List<Plane> planes = new ArrayList<>();

        try {
            // establecer la conexion
            connection = DatabaseConfig.getConnection();
            // preparar la declaracion
            preparedStatement = connection.prepareStatement(sql);
            // ejecutar la declaracion y guardar los resultados dentro de una "Lista" (ResultSet me devuelve los datos de una fila completa)
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) { 
                // mientras haya aviones dentro de la lista, crearemos una nueva instancia de avion
                Plane newPlane = new Plane();
                // asignamos los datos de la columna en esta instancia
                newPlane.setIdPlane(resultSet.getInt("id"));
                newPlane.setPlate(resultSet.getString("plate"));
                newPlane.setCapacity(resultSet.getInt("capacity"));
                newPlane.setFabricationDate(resultSet.getDate("fabrication_date"));
                newPlane.setIdModel(resultSet.getInt("id_model"));
                newPlane.setIdStatus(resultSet.getInt("id_status"));
                // asignamos este nuevo avion a la lista de aviones
                planes.add(newPlane);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        
        // retornamos todos los aviones
        return planes;
    }
    
    // funcion para cerrar los recursos
    private void closeResources() {
        try {
            if (connection != null) connection.close();
            if (resultSet != null) resultSet.close();
            if (callableStatement != null) callableStatement.close();
            if (preparedStatement != null) preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
