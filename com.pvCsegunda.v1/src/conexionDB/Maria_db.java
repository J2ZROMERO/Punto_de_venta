package conexionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class Maria_db {
	

/*PreparedStatement.executeUpdate() permite ejecutar sentencias INSERT / UPDATE / DELETE y sentencias DDL.

PreparedStatement.executeQuery() se utiliza para ejecutar sentencias SELECT.
Este procedimiento getNamesSalary ejecuta una sentencia de selección y, por lo tanto, devuelve un conjunto de registros.

 Por ello, podemos considerar que, desde el punto de vista JDBC, el resultado del procedimiento es un resultado desconocido. Por este motivo utilizamos execute para ejecutar el procedimiento almacenado.
*
*
*/
    			   public static void main (String args[]) throws SQLException {

    			
    			    }

			   

	

 static final String URL = "jdbc:mariadb://localhost:3306/pv_canoa_segunda";
 static final String user = "root";
 static final String pass = "";
 
private Connection conn;	
}
