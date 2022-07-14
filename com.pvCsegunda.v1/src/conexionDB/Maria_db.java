package conexionDB;
import java.sql.*;

public class Maria_db {
	

/*PreparedStatement.executeUpdate() permite ejecutar sentencias INSERT / UPDATE / DELETE y sentencias DDL.

PreparedStatement.executeQuery() se utiliza para ejecutar sentencias SELECT.
Este procedimiento getNamesSalary ejecuta una sentencia de selección y, por lo tanto, devuelve un conjunto de registros.

 Por ello, podemos considerar que, desde el punto de vista JDBC, el resultado del procedimiento es un resultado desconocido. Por este motivo utilizamos execute para ejecutar el procedimiento almacenado.
*
*
*/
    			    

			   
	public  static void anadir_marca(String marca) throws SQLException{
	      
	       try(Connection con = DriverManager.getConnection(URL,"root",null); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.insertar_marca(?) }"))   // dentro statement connection and resulset
	        

	       {	       
cstm.setString(1, marca);	 
cstm.executeUpdate();
System.out.println("datos insertados");	       
	       }
		
		
	}
	
	
    
			   
private static final String URL = "jdbc:mariadb://localhost:3306/pv_canoa_segunda";
    private Connection conn;	
}
