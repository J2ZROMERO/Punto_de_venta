package conexionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class DB_clientes {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

	
Object values[] = {6,"sdfasd","jghjgy","",""};
	DB_clientes.actualizar(values);

	

	

	
	}

	
	
	
	public  static void anadir(Object datos_campos[]) throws SQLException{
	      
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.anadir_cliente(?,?,?,?) }"))   // dentro statement connection and resulset
	        

	       {	       

cstm.setString(1, datos_campos[0].toString() );
cstm.setString(2, datos_campos[1].toString() );	 
cstm.setString(3, datos_campos[2].toString() );	 
cstm.setString(4, datos_campos[3].toString() );	 


cstm.executeUpdate();
System.out.println("datos insertados");	       
	       }
		
		
	}
	
	public  static Object[] buscar(int id) throws SQLException{
	      
		Object valores_campos[] = new Object[5];
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.buscar_clientes(?) }"))   // dentro statement connection and resulset
	        

	       {	       

	    	   
cstm.setInt(1,id );

ResultSet rs = cstm.executeQuery();

while(rs.next()) {
	valores_campos[0]= rs.getInt(1);
	valores_campos[1]= rs.getString(2);
	valores_campos[2]= rs.getString(3);
	valores_campos[3]= rs.getString(4);
	valores_campos[4]= rs.getString(5);

		       	
}

	       }
		return valores_campos;
		
	       	
	}
		
	public  static void eliminar(int id) throws SQLException{
	      
		
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.delete_clientes(?) }"))   // dentro statement connection and resulset
	        

	       {	       

	    	   
cstm.setInt(1,id );

 cstm.executeUpdate();
System.out.println("datos eliminados");

	       }

		
	       	
	}
	
	
	

	
	public  static void actualizar(Object datos_campos[]) throws SQLException{
	    // use los 5 paramtros pero solo el id no sirve para la comparacion de la consulta en la base de datos  
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.actualizar_clientes(?,?,?,?,?) }"))   // dentro statement connection and resulset
	        

	       {	       
cstm.setInt(1, Integer.parseInt((String)datos_campos[0].toString() ));
cstm.setString(2, datos_campos[1].toString() );
cstm.setString(3, datos_campos[2].toString() );	 
cstm.setString(4, datos_campos[3].toString() );	 
cstm.setString(5, datos_campos[4].toString() );	 


cstm.executeUpdate();
System.out.println("datos actualizados");	       
	       }
		
		
	}
	
	
	
	public static DefaultTableModel model_view_clientes() throws SQLException {
		List<Object> n_clientes = new ArrayList<Object>();
		Object[] dat ;
		
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.ver_clientes() }"); ResultSet rs= cstm.executeQuery())// dentro statement connection and resulset	       
	       {	       
	    	   
  	   
while(rs.next()) {
	dat = new Object[3];
dat[0]=(rs.getString(1));	
dat[1]=(rs.getString(4));	
dat[2]=(rs.getString(5));


n_clientes.add(dat);



    }
String[] columnNames = {"Id" ,"Nickname","Telefono"};


data_row = new Object[n_clientes.size()][columnNames.length];
      
for (int j =  0; j < n_clientes.size();j++) {
	datos = (Object[]) n_clientes.get(j);
	for (int i =  0; i < datos.length;i++) {
		data_row[j][i] =datos[i];
	}	
}


modelo.setDataVector(data_row, columnNames);	
	       }
	       


		return modelo;
		
	}
	

private static Object[][] data_row;	
private static Object[] datos;
private	static DefaultTableModel modelo = new DefaultTableModel();




}
