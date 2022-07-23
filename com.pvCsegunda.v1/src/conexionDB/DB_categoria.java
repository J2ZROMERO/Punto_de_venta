package conexionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

// n_marcas = nombre de las marcas

public class DB_categoria {

	public  static void anadir_marca(String linea) throws SQLException{
	      
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.insertar_categoria(?) }"))   // dentro statement connection and resulset
	        

	       {	       
cstm.setString(1, linea);	 
cstm.executeUpdate();
System.out.println("datos insertados");	       
	       }
		
		
	}
	
	public static DefaultTableModel model_view_categoria() throws SQLException {
		List<String> n_categoria = new ArrayList<String>();
		
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.ver_categoria()}"); ResultSet rs= cstm.executeQuery())// dentro statement connection and resulset
	       
	       {	       
while(rs.next()) {

n_categoria.add(rs.getString(1));	
	
}
    }
		
		String[] columnNames = {"Marcas"};
		Object[][] data = new Object[n_categoria.size()][1];

		for(int i = 0; i < 1;i++) {
	for(int j = 0; j <n_categoria.size();j++) {
		data[j][i] = n_categoria.get(j);
	} 	
}


			
modelo.setDataVector(data, columnNames);

		return modelo;
		
	}
	
	public static void eliminar_lineas(String linea) throws SQLException {
		
		try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass);
				CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.eliminar_categoria(?) }")){		
			cstm.setString(1, linea);
			cstm.executeUpdate();
		}
		
	}
	
    
private	static DefaultTableModel modelo = new DefaultTableModel();
}
