package conexionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class DB_caja {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
	/*	Object dat[] = {500,"ENTRADA","DEPOSITO",500.0,400,1};
		DB_caja.insertarMovimientosCaja(dat);*/
	
	}

	public  static void insertarCajaInicial(Object datos_campos[]) throws SQLException{

		

	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.insertarMoviminentosCaja(?,?,?,?,?) }"))   // dentro statement connection and resulset
	        
		
	       {	       


cstm.setDouble( 1, Double.parseDouble(datos_campos[0].toString()));  //bigint (20)
cstm.setString(2,datos_campos[1].toString() );	  				//varchar
cstm.setString(3, datos_campos[2].toString( ));	 				//smallint

if(datos_campos[3].equals("")) {
	cstm.setNull(4, java.sql.Types.NULL);
}else {
	cstm.setDouble(4, Double.parseDouble(datos_campos[3].toString() ));                //double	
}
          

if(datos_campos[4].equals("")) {
	cstm.setNull(5, java.sql.Types.NULL);
}else {
	cstm.setDouble(5, Integer.parseInt(datos_campos[4].toString() ));                //double	
}


cstm.executeUpdate();
System.out.println("datos insertados");	       
	       }
		
		
	}
	
	public  static void insertarMovimientosCaja(Object datos_campos[]) throws SQLException{

		
		

	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.insertarMoviminentosCaja(?,?,?,?,?) }"))   // dentro statement connection and resulset
	        
		
	       {	       


cstm.setDouble( 1, Double.parseDouble(datos_campos[0].toString()));  //bigint (20)
cstm.setString(2,datos_campos[1].toString() );	  				//varchar
cstm.setString(3, datos_campos[2].toString( ));	 				//smallint

if(datos_campos[3].equals("")) {
	cstm.setNull(4, java.sql.Types.NULL);
}else {
	cstm.setDouble(4, Double.parseDouble(datos_campos[3].toString() ));                //double	
}
       

if(datos_campos[4].equals("")) {
	cstm.setNull(5, java.sql.Types.NULL);
}else {
	cstm.setDouble(5, Integer.parseInt(datos_campos[4].toString() ));                //double	
}


cstm.executeUpdate();
System.out.println("datos insertados");	       
	       }
		
		
		
	}
	
	public  static void cerrarCaja(Object datos_campos[]) throws SQLException{

		
		

	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.cerrarCaja(?,?,?,?,?) }"))   // dentro statement connection and resulset
	        
		
	       {	       


cstm.setDouble( 1, Double.parseDouble(datos_campos[0].toString()));  //bigint (20)
cstm.setDouble( 2, Double.parseDouble(datos_campos[1].toString()));  //bigint (20)
cstm.setDouble( 3, Double.parseDouble(datos_campos[2].toString()));  //bigint (20)
cstm.setDouble( 4, Double.parseDouble(datos_campos[3].toString()));  //bigint (20)
cstm.setInt( 5, Integer.parseInt(datos_campos[4].toString()));  //bigint (20)


cstm.executeUpdate();
System.out.println("datos insertados");	       
	       }
		
		
		
	}
	
	public static double calcularEntradasCaja(String fecha, int id) throws SQLException {
		double sumaTotalEntradas = 0;
		 try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
				 CallableStatement cstm = con.prepareCall("	{ CALL pv_canoa_segunda.calcularEntradasCaja(?,?) }")  )   // dentro statement connection and resulset
		 
		   
		    {
			 
			 cstm.setString(1, fecha);
			 cstm.setInt(2, id);
			 ResultSet rs = cstm.executeQuery();
			 while(rs.next()) {
				 sumaTotalEntradas += rs.getDouble(1);
		  }
		     
		  

		    	
		    	
		    	
		    	
		    }


	return sumaTotalEntradas;
	}
	
	public static double calcularSalidasCaja(String fecha, int id) throws SQLException {
		double sumaTotalSalidas = 0;
		 try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
				 CallableStatement cstm = con.prepareCall("	{ CALL pv_canoa_segunda.calcularSalidasCaja(?,?) }")  )   // dentro statement connection and resulset
		 
		   
		    {
			 
			 cstm.setString(1, fecha);
			 cstm.setInt(2, id);
			 ResultSet rs = cstm.executeQuery();
			 while(rs.next()) {
				 sumaTotalSalidas += rs.getDouble(1);
			  
		  }
		     
		  

		    	
		    	
		    	
		    	
		    }


	return sumaTotalSalidas;
	}
	public static DefaultTableModel model_view_dev_caja_movimientos(String fechaInicial,String fechafinal) throws SQLException {
		
		List<Object> n_ver_movimientos = new ArrayList<Object>();
		Object[] dat ;
		
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	CallableStatement cstm_movimientos = con.prepareCall("{ CALL pv_canoa_segunda.verMovimientosCaja(?,?) }"))// dentro statement connection and resulset
	       
	    		   {	       

	    	   
	    	   cstm_movimientos.setString(1, fechaInicial);
	    	   cstm_movimientos.setString(2, fechafinal);
	    	
	    	   System.out.println(fechafinal+ " "+fechaInicial);
	    	   
	    	   
	    	   
	    	   ResultSet rs_movimientos= cstm_movimientos.executeQuery();
	    	   
	    	   
	    	   
	    	   
	    	   
	while(rs_movimientos.next()) {

		dat = new Object[6];
		dat[0]=(rs_movimientos.getString(1));	
		dat[1]=(rs_movimientos.getString(2));	
		dat[2]=(rs_movimientos.getString(3));
		dat[3]=(rs_movimientos.getString(4));
		dat[4]=(rs_movimientos.getString(5));
		dat[5]=(rs_movimientos.getString(6));
		n_ver_movimientos.add(dat);	
		
	}


	}
		
			String[] columnNames = {"SALDO INICIAL","MOVIMIENTO","MOTIVO","MONTO", "FECHA" ,"USUARIO" };
		
			
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
	
public static DefaultTableModel model_view_dev_caja_Cierre(String fechaInicial,String fechafinal) throws SQLException {
		
		List<Object> n_ver_movimientos = new ArrayList<Object>();
		Object[] dat ;
		
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	CallableStatement cstm_movimientos = con.prepareCall("{ CALL pv_canoa_segunda.verCierresCaja(?,?) }"))// dentro statement connection and resulset
	       
	    		   {	       

	    	   
	    	   cstm_movimientos.setString(1, fechaInicial);
	    	   cstm_movimientos.setString(2, fechafinal);
	    	
	    	   System.out.println(fechafinal+ " "+fechaInicial);
	    	   
	    	   
	    	   
	    	   ResultSet rs_movimientos= cstm_movimientos.executeQuery();
	    	   
	    	   
	    	   
	    	   
	    	   
	while(rs_movimientos.next()) {

		dat = new Object[6];
		dat[0]=(rs_movimientos.getString(1));	
		dat[1]=(rs_movimientos.getString(2));	
		dat[2]=(rs_movimientos.getString(3));
		dat[3]=(rs_movimientos.getString(4));
		dat[4]=(rs_movimientos.getString(5));
		dat[5]=(rs_movimientos.getString(6));
		n_ver_movimientos.add(dat);	
		
	}


	}
		
			String[] columnNames = {"SALDO INICIAL","ENTRADAS","SALIDAS","SALDO TOTAL", "FECHA" ,"USUARIO" };
		
			
			data_ver_movimientosCierre = new Object[n_ver_movimientos.size()][columnNames.length];
			
			for (int j =  0; j < n_ver_movimientos.size();j++) {
				
				datos_movimientosCierre = (Object[]) n_ver_movimientos.get(j);
				
				for (int i =  0; i < datos_movimientosCierre.length;i++) {
					data_ver_movimientosCierre[j][i] = datos_movimientosCierre[i];

				}			
			}
				

			
			modelo_ver_movimientosCierre.setDataVector(data_ver_movimientosCierre, columnNames);

		return modelo_ver_movimientosCierre;
		
	}
	private static Object[][] data_ver_movimientosCierre;	
	private static Object datos_movimientosCierre[];
	private	static DefaultTableModel modelo_ver_movimientosCierre = new DefaultTableModel();
}
