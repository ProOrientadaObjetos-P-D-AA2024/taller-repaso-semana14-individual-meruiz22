package MODEL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConeccionDB {

    public Connection concDB;
    public ArrayList<Estudiante> lstEstudiantes;
    public String msj;

    // Metodo para estblecer conexion a la base de datos 
    public void setConcDB(String url) {
        try {
            this.concDB = DriverManager.getConnection(url);
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
    }

    public ArrayList<Estudiante> getLstEstudiantes() {
        lstEstudiantes = new ArrayList<Estudiante>();
        try {
            setConcDB("jdbc:sqlite:bd/dbTest1.db");
            Statement statement = concDB.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Estudiante");
            while (resultSet.next()) {
                lstEstudiantes.add(new Estudiante(
                        resultSet.getString("nombreEst"),
                        resultSet.getDouble("nota1"),
                        resultSet.getDouble("nota2"),
                        resultSet.getDouble("promedio"),
                        resultSet.getString("estado"),
                        resultSet.getString("id")));
            }
            statement.close();
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
        return lstEstudiantes;
    }

    // Metodo para insertar un nuevo estudiante 
    public void insertarEstudiante(Estudiante estudiante) {
        try {
            setConcDB("jdbc:sqlite:bd/dbTest1.db");
            Statement statement = concDB.createStatement();
            String strInsertEst = String.format("insert into Estudiante(nombreEst,"
                    + " nota1, "
                    + "nota2, "
                    + "promedio, "
                    + "estado,"
                    + "id) "
                    + "values('%s', %d, %d, %d, '%s','%s')", 
                    estudiante.nombreEst,(int) estudiante.nota1, 
                    (int) estudiante.nota2,(int) estudiante.promedio,
                    estudiante.estado, estudiante.id);
            statement.executeUpdate(strInsertEst);
            statement.close();
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
    }

    // Metodo para eliminar estudiante 
    public void deleteEstudiante(String id) {
        try {
            setConcDB("jdbc:sqlite:bd/dbTest1.db");
            Statement statement = concDB.createStatement();
            String strDeleteEst = String.format("DELETE FROM Estudiante "
                    + "WHERE id='%s'", id);
            statement.executeUpdate(strDeleteEst);
            statement.close();
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
    }

    
  
    // Metodo para actualizar estudiante
    public void updateEstudiante(Estudiante estudiante) {
        try {
            setConcDB("jdbc:sqlite:bd/dbTest1.db");
            Statement statement = concDB.createStatement();
            String strUpdateEst = String.format("UPDATE Estudiante SET "
                        + "nombreEst = '%s', "
                        + "estado = '%s', "
                        + "nota1 = %d, "
                        + "nota2 = %d, "
                        + "promedio = %d "
                        + "WHERE id = '%s'",
                        estudiante.nombreEst,estudiante.estado, 
                        (int)estudiante.nota1, (int)estudiante.nota2,
                        (int)estudiante.promedio, estudiante.id);
                statement.executeUpdate(strUpdateEst);

        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
    }

}
