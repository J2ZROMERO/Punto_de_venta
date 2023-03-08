package conexionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_acceso {

/*	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
DB_acceso acceso = new DB_acceso();

      


	}*/
	
	public static boolean acceso (int id, String contrasena_usuario) throws SQLException {
		boolean acceso_usuario = false;
		
	    try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	 		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.validar_usuario(?,?,?) }"))	       
	    {	       
	 	 
	 	   cstm.setInt(1, id);
	 	   cstm.setString(2, contrasena_usuario);
	 	   cstm.registerOutParameter(3, java.sql.Types.BOOLEAN);
	 	   
	 	   cstm.execute();
	 	   
	 	   
	 	   acceso_usuario = cstm.getBoolean(3);
	 	   
	 	   

	 	   
	 	   
	    }
		return acceso_usuario;
		
	}
	
}
