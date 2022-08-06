package conexionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import interfaces.Clientes_Tabla_Ver_Clientes;

public class DB_devoluciones_perdidas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public  static void anadir(Object datos_campos[]) throws SQLException{


//		}
//		
//	
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.anadir_devoluciones_perdidas(?,?,?,?,?,?) }"))   // dentro statement connection and resulset
	        
		
	       {	       


cstm.setLong( 1,Long.parseLong(datos_campos[0].toString()));  //bigint (20)
cstm.setInt(2, Integer.parseInt(datos_campos[1].toString()) );	  				//varchar
cstm.setDouble(3,Double.parseDouble( datos_campos[2].toString() ));	 				//smallint

cstm.setString(4, datos_campos[3].toString() );          

if(datos_campos[4].equals("")) {
	cstm.setNull(5, java.sql.Types.NULL);
}else {
	cstm.setDouble(5, Integer.parseInt(datos_campos[4].toString() ));                //double	
}

if(datos_campos[5].equals("")) {
	cstm.setNull(6, java.sql.Types.NULL);
}else {
	cstm.setDouble(6,Integer.parseInt(datos_campos[5].toString() ));                //double	
}

cstm.executeUpdate();
System.out.println("datos insertados");	       
	       }
		
		
	}
	public static DefaultTableModel model_view_dev_per(int id) throws SQLException {
		
		List<Object> n_ver_dev_per = new ArrayList<Object>();
		Object[] dat ;
		
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.buscar_producto_per_dev(?)}"))// dentro statement connection and resulset
	       
	    		   {	       

	    	   
	    	   cstm.setInt(1, id);
	    	   
	    	
	    	   
	    	   
	    	   
	    	   
	    	   ResultSet rs= cstm.executeQuery();
	    	   
	    	   
	    	   
	    	   
	    	   
	while(rs.next()) {

		dat = new Object[4];
		dat[0]=(rs.getString(1));	
		dat[1]=(rs.getString(2));	
		dat[2]=(rs.getString(3));
		dat[3]=(rs.getString(4));
		n_ver_dev_per.add(dat);	
		
	}


	}
		
			String[] columnNames = {"Producto","Distintivo","Detalle","Precio"};
		
			
			data = new Object[n_ver_dev_per.size()][columnNames.length];
			
			for (int j =  0; j < n_ver_dev_per.size();j++) {
				
				datos = (Object[]) n_ver_dev_per.get(j);
				
				for (int i =  0; i < datos.length;i++) {
					data[j][i] = datos[i];

				}			
			}
				

			
		modelo.setDataVector(data, columnNames);

		return modelo;
		
	}
	private static Object[][] data;	
	private static Object datos[];
	private	static DefaultTableModel modelo = new DefaultTableModel();
	

public static DefaultTableModel model_view_dev_per(String fechaInicial,String fechafinal) throws SQLException {
	
	List<Object> n_ver_movimientos = new ArrayList<Object>();
	Object[] dat ;
	
       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
CallableStatement cstm_movimientos = con.prepareCall("{ CALL pv_canoa_segunda.ver_devoluciones_perdidas(?,?) }"))// dentro statement connection and resulset
       
    		   {	       

    	   
    	   cstm_movimientos.setString(1, fechaInicial);
    	   cstm_movimientos.setString(2, fechafinal);
    	
    	   System.out.println(fechafinal+ " "+fechaInicial);
    	   
    	   
    	   
    	   ResultSet rs_movimientos= cstm_movimientos.executeQuery();
    	   
    	   
    	   
    	   
    	   
while(rs_movimientos.next()) {

	dat = new Object[10];
	dat[0]=(rs_movimientos.getString(1));	
	dat[1]=(rs_movimientos.getString(2));	
	dat[2]=(rs_movimientos.getString(3));
	dat[3]=(rs_movimientos.getString(4));
	dat[4]=(rs_movimientos.getString(5));
	dat[5]=(rs_movimientos.getString(6));
	dat[6]=(rs_movimientos.getString(7));
	dat[7]=(rs_movimientos.getString(8));
	dat[8]=(rs_movimientos.getString(9));
	dat[9]=(rs_movimientos.getString(10));
	n_ver_movimientos.add(dat);	
	System.out.println(dat[6]);
}


}
	
		String[] columnNames = {"ID_producto","Producto","Distintivo 1","Distintivo 2", "Unidades" ,"Cantidad devolver" ,"Motivo", "Cliente","Usuarios","Fecha"};
	
		
		data_ver_movimientos = new Object[n_ver_movimientos.size()][columnNames.length];
		
		for (int j =  0; j < n_ver_movimientos.size();j++) {
			
			datos_movimientos = (Object[]) n_ver_movimientos.get(j);
			
			for (int i =  0; i < datos_movimientos.length;i++) {
				data_ver_movimientos[j][i] = datos_movimientos[i];

			}			
		}
			

		
	modelo_ver_movimientos.setDataVector(data_ver_movimientos, columnNames);

	return modelo_ver_movimientos;
	
}
private static Object[][] data_ver_movimientos;	
private static Object datos_movimientos[];
private	static DefaultTableModel modelo_ver_movimientos = new DefaultTableModel();


	
}
