package conexionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class DB_categoria {

	

		
			
	
				    
			public  static void anadir_categoria(String categoria) throws SQLException{
		      
		       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
		    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.insertar_categoria(?) }"))   // dentro statement connection and resulset
		        

		       {	       
	cstm.setString(1, categoria);	 
	cstm.executeUpdate();
	System.out.println("datos insertados");	       
		       }
			
		
		}
		
		public static DefaultTableModel model_view_categoria() throws SQLException {
			List<Object> n_categoria = new ArrayList<Object>();
			Object dat[];
		       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
		    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.ver_categoria() }"); ResultSet rs= cstm.executeQuery())// dentro statement connection and resulset
		       
		       {	       
	while(rs.next()) {
		dat = new Object[2];
dat[0]=	rs.getString(1);	
dat[1]=	rs.getString(2);		
	n_categoria.add(dat);
	}
	    }
			
			String[] columnNames = {"id","categorias"};

data_row = new Object[n_categoria.size()][columnNames.length];
      
for (int j =  0; j < n_categoria.size();j++) {
	datos = (Object[]) n_categoria.get(j);
	for (int i =  0; i < datos.length;i++) {
		data_row[j][i] =datos[i];
	}	
}



				
	modelo.setDataVector(data_row, columnNames);

			return modelo;
			
		}
		
		public static void eliminar_categoria(String id) throws SQLException {
			
			try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass);
					CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.eliminar_categoria(?) }")){		
				cstm.setString(1, id);
				cstm.executeUpdate();
			}
			
		}
		
		private static Object[][] data_row;	
		private static Object[] datos;
	private	static DefaultTableModel modelo = new DefaultTableModel();


	}


