package conexionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class DB_usuarios {
///** campos id,rol,nombre,nickname son obligatorios  ---- solo en este campo se podra asignar el id manualmente "no habra muchos usuarios"*/
//public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		try {
//			Object e[] =  DB_usuarios.buscar(80);
//		
//			for(Object d : e) {
//			System.out.println(d);		
//		};
//		
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		
//	}
	
		
		public  static void anadir(Object datos_campos[]) throws SQLException{
	      
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.insertar_usuarios(?,?,?,?,?,?,?) }"))   // dentro statement connection and resulset
	        

	       
	       {	       

cstm.setInt( 1,Integer.parseInt(datos_campos[0].toString()));
cstm.setString(2, datos_campos[1].toString() );	 
cstm.setString(3, datos_campos[2].toString() );	 
cstm.setString(4, datos_campos[3].toString() );
cstm.setString(5, datos_campos[4].toString() );	 
cstm.setString(6, datos_campos[5].toString() );	 
cstm.setInt(7, Integer.parseInt(  datos_campos[6].toString() ));	 


cstm.executeUpdate();
System.out.println("datos insertados");	       
	       }
		
		
	}
	
	public  static Object[] buscar(int id) throws SQLException{
	      
		Object valores_campos[] = new Object[8];
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.buscar_usuario(?,?) }"))   // dentro statement connection and resulset
	        

	       {	       

	    	   
cstm.setInt(1,id );
cstm.registerOutParameter(2, java.sql.Types.VARCHAR);

ResultSet rs = cstm.executeQuery();
  String pass = cstm.getString("passDB");

while(rs.next()) {
	valores_campos[0]= rs.getInt(1);
	valores_campos[1]= rs.getString(2);
	valores_campos[2]= rs.getString(3);
	valores_campos[3]= rs.getString(4);
	valores_campos[4]= rs.getString(5);
	valores_campos[5]= rs.getString(6);
	valores_campos[6]= pass;
	valores_campos[7]= rs.getDate(8).toString();

		       	
}

	       }
	       
	    
		return valores_campos;
		
	       	
	}
		
	public  static void eliminar(int id) throws SQLException{
	      
		
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.eliminar_usuario(?) }"))   // dentro statement connection and resulset
	        

	       {	       

	    	   
cstm.setInt(1,id );

 cstm.executeUpdate();
System.out.println("datos eliminados");

	       }

		
	       	
	}
	
	
	

	
	public  static void actualizar(Object datos_campos[]) throws SQLException{
	    // use los 5 paramtros pero solo el id no sirve para la comparacion de la consulta en la base de datos  
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.actualizar_usuarios(?,?,?,?,?,?,?) }"))   // dentro statement connection and resulset
	        

	       {	       
cstm.setInt(1, Integer.parseInt((String)datos_campos[0].toString() ));
cstm.setString(2, datos_campos[1].toString() );
cstm.setString(3, datos_campos[2].toString() );	 
cstm.setString(4, datos_campos[3].toString() );	 
cstm.setString(5, datos_campos[4].toString() );	 
cstm.setString(6, datos_campos[5].toString() );	 
cstm.setString(7, datos_campos[6].toString() );	 	 

cstm.executeUpdate();
System.out.println("datos actualizados");	       
	       }
		
		
	}
	

	public static DefaultTableModel model_view_usuarios() throws SQLException {
		List<Object> n_usuarios = new ArrayList<Object>();
		Object[] dat ;
		
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.ver_usuarios() }"); ResultSet rs= cstm.executeQuery())// dentro statement connection and resulset	       
	       {	       
	    	   
  	   
while(rs.next()) {
	dat = new Object[3];
dat[0]=(rs.getString(1));	
dat[1]=(rs.getString(2));	
dat[2]=(rs.getString(3));

n_usuarios.add(dat);
    }
String[] columnNames = {"Id" ,"Rol","Nick_name"};


data_row = new Object[n_usuarios.size()][columnNames.length];
      
for (int j =  0; j < n_usuarios.size();j++) {
	datos = (Object[]) n_usuarios.get(j);
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
