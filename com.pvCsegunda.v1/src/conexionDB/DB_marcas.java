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

public class DB_marcas {

	public  static void anadir_marca(String marca) throws SQLException{
	      
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.insertar_marca(?) }"))   // dentro statement connection and resulset
	        

	       {	       
cstm.setString(1, marca);	 
cstm.executeUpdate();
System.out.println("datos insertados");	       
	       }
		
		
	}
	
	public static DefaultTableModel model_view_marcas() throws SQLException {
		List<String> n_marcas = new ArrayList<String>();
		
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.ver_marcas() }"); ResultSet rs= cstm.executeQuery())// dentro statement connection and resulset
	       
	       {	       
while(rs.next()) {

n_marcas.add(rs.getString(1));	
	
}
    }
		
		String[] columnNames = {"Marcas"};
		Object[][] data = new Object[n_marcas.size()][1];

		for(int i = 0; i < 1;i++) {
	for(int j = 0; j <n_marcas.size();j++) {
		data[j][i] = n_marcas.get(j);
	} 	
}


			
modelo.setDataVector(data, columnNames);

		return modelo;
		
	}
	
	public static void eliminar_marcas(String marca) throws SQLException {
		
		try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass);
				CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.eliminar_marca(?) }")){
		
			cstm.setString(1, marca);
			cstm.executeUpdate();
		}
		
	}
	
    
private	static DefaultTableModel modelo = new DefaultTableModel();
}
