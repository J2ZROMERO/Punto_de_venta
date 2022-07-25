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
		List<Object> n_marcas = new ArrayList<Object>();
		Object dat[];
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.ver_marcas() }"); ResultSet rs= cstm.executeQuery())// dentro statement connection and resulset
	       
	       {	       
while(rs.next()) {
	dat = new Object[2];
	dat[0]=	rs.getInt(1);	
	dat[1]=	rs.getString(2);
	n_marcas.add(dat);	
	


}
    }
		
			String[] columnNames = {"id","Marca"};
			Object[][] data = new Object[n_marcas.size()][columnNames.length];

			data_row = new Object[n_marcas.size()][columnNames.length];
		      
			for (int j =  0; j < n_marcas.size();j++) {
				datos = (Object[]) n_marcas.get(j);
				for (int i =  0; i < datos.length;i++) {
					data_row[j][i] =datos[i];
				}	
			}




				

			
		modelo.setDataVector(data_row, columnNames);

		return modelo;
		
	}
	
	public static void eliminar_marcas(String marca) throws SQLException {
		
		try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass);
				CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.eliminar_marca(?) }")){
		
			cstm.setString(1, marca);
			cstm.executeUpdate();
		}
		
	}
	private static Object[][] data_row;	
	private static Object[] datos;
private	static DefaultTableModel modelo = new DefaultTableModel();


}
