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

public class DB_linea {


	
	public static void main(String args[]) throws SQLException {
		//DB_linea.anadir_marca("ss");
	}
	public  static void anadir_marca(String linea) throws SQLException{
	      
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.insertar_linea(?) }"))   // dentro statement connection and resulset
	        

	       {	       
cstm.setString(1, linea);	 
cstm.executeUpdate();
System.out.println("datos insertados");	       
	       }
		
		
	}
	
	public static DefaultTableModel model_view_linea() throws SQLException {
		List<Object> n_linea = new ArrayList<Object>();
		Object dat[];
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.ver_lineas() }"); ResultSet rs= cstm.executeQuery())// dentro statement connection and resulset
	       
	       {	       
while(rs.next()) {
	dat = new Object[2];
	dat[0]=	rs.getInt(1);	
	dat[1]=	rs.getString(2);
n_linea.add(dat);	
	


}
    }
		
		String[] columnNames = {"id","Marcas"};
		Object[][] data = new Object[n_linea.size()][columnNames.length];

		data_row = new Object[n_linea.size()][columnNames.length];
	      
		for (int j =  0; j < n_linea.size();j++) {
			datos = (Object[]) n_linea.get(j);
			for (int i =  0; i < datos.length;i++) {
				data_row[j][i] =datos[i];
			}	
		}




			
modelo.setDataVector(data_row, columnNames);

		return modelo;
		
	}
	
	public static void eliminar_lineas(String linea) throws SQLException {
		
		try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass);
				CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.eliminar_linea(?) }")){		
			cstm.setString(1, linea);
			cstm.executeUpdate();
		}
		
	}
	
	
	private static Object[][] data_row;	
	private static Object[] datos;
private	static DefaultTableModel modelo = new DefaultTableModel();
}
