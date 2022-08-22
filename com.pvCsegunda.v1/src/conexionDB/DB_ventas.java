package conexionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

//import com.itextpdf.text.log.SysoCounter;

public class DB_ventas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

public static Long numero_venta() throws SQLException {
long id_venta_generada = 0;
	
    try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
 		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.conteo_filas_venta_generadas() }"); ResultSet rs = cstm.executeQuery()  )   // dentro statement connection and resulset
   
    {	
    	
    	rs.next();
    	id_venta_generada = rs.getLong(1);

    	
    	
    	
    	
    }
	return id_venta_generada;
	
}
	
	
	
	
	public  static void anadir(Object datos_campos[]) throws SQLException{

	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.generar_venta(?,?,?,?,?,?) }"))   // dentro statement connection and resulset
	        

	       
	       {	       



cstm.setLong( 1,Long.parseLong(datos_campos[0].toString()));  
cstm.setInt(2,  Integer.parseInt(  datos_campos[1].toString()) );	  				//varchar
cstm.setDouble(3, Double.parseDouble(  datos_campos[2].toString()) );	 				//varchar  				
if(datos_campos[3].equals("")) {
	cstm.setNull(4, java.sql.Types.NULL);
}else {
	cstm.setInt(4, Integer.parseInt(datos_campos[3].toString() ));                //double	
}


if(datos_campos[4].equals("")) {
	cstm.setNull(5, java.sql.Types.NULL);
}else {
	cstm.setInt(5, Integer.parseInt(datos_campos[4].toString() ));                //double	
}
cstm.setLong( 6,Long.parseLong(datos_campos[5].toString()));
	


cstm.executeUpdate();
System.out.println("datos insertados");	       
	       }
		
		
	}
	
	
	
	
	
public static Object[] add_row(long id,DefaultTableModel modelo) throws SQLException {
	
	List<Object> n_ver_ventas = new ArrayList<Object>();
	Object[] dat ;
	   int conteo = 0;
       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.buscar_id_ventas(?) }"))// dentro statement connection and resulset      
    		   {	         	
 cstm.setLong(1, id);
    	   
    	   
    	   ResultSet rs= cstm.executeQuery();
     int contador = 0;
			dat = new Object[7];
			
  	  		 while(rs.next()) {
  	    		for(int i =0 ; i <= modelo.getRowCount()-1;i++) {
  	  	  		
  					if(modelo.getValueAt(i, 0).equals(rs.getString(1))) {
  					contador= i;	
  					}else {

  					}}

  	    		dat[0]=(rs.getString(1));
  	  			dat[1]=(rs.getString(2));	
  	  			dat[2]=(rs.getString(3));	
  	  			dat[3]=(rs.getString(4));
  	  			dat[4]=(rs.getString(5));
  	  			dat[5]=(1);
  	  			dat[6]=(rs.getString(6));
  	  			
  	  	
  	  		 }//while

  	  		 
  	  		 if(dat[0] != null) {
  	  			 
  	  		 
	  			if(modelo.getRowCount() == 0) {
	  				
	  				modelo.addRow(dat);
	  				int stock_disponible = Integer.parseInt((modelo.getValueAt(contador, 3).toString()));
	  				
	  				if(stock_disponible == 0) { 
	  					
	  					modelo.setValueAt(0, contador, 5);
	  					
	  				}
	  				
	  				
	  				
  	  				
  	  			
  	  			
  	  			
  	  			}else {
  	  			

  	  				
	  		if(modelo.getValueAt(contador,0).equals(dat[0].toString())) {

	  			int stock_disponible = Integer.parseInt((modelo.getValueAt(contador, 3).toString()));
	  			int solicitud = Integer.parseInt((modelo.getValueAt(contador, 5).toString()));
	  			
	  			System.out.println(stock_disponible);
	  			
	  			if( solicitud >= stock_disponible) {
	  				
	  			}else {

	  				
	  				
	  				
	  					int suma = Integer.parseInt((modelo.getValueAt(contador, 5).toString()));
							
		  				suma+=1;
		  				modelo.setValueAt (suma,contador , 5);
		  					
	  				
		  			
	  			}
	  			
	  	  	  }else {
		  	  		
	  	  		  
	  	  		  
	  	  		  if(Integer.parseInt( dat[3].toString()) == 0) {
	  	  			dat[5] = 0;  
	  	  		  }
	  	  	
	  	  		  modelo.addRow(dat);
	  	  			


	  	  	
				
				
			
	  	  	  }
  	  			}
  	  			
  	  			}  	  		

  	  	
  	  		 
  	  			}//clstam
  	 if(dat[6] == null) {
			 dat[6] = "";
		 }
  
	return  dat;
  }//class



	
public static DefaultTableModel model_view_ventas(long id) throws SQLException {
	
	List<Object> n_ver_ventas = new ArrayList<Object>();
	Object[] dat ;
	
       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.buscar_id_ventas(?) }"))// dentro statement connection and resulset
       
    		   {	         	   
    	   cstm.setLong(1, id);
    	   
    	   ResultSet rs= cstm.executeQuery();
    	   
    	   
    	   
    	   
    	   
while(rs.next()) {
	dat = new Object[6];
	
	dat[0]=(rs.getString(1));	
	dat[1]=(rs.getString(2));	
	dat[2]=(rs.getString(3));
	dat[3]=(rs.getString(4));
	dat[4]=(rs.getString(5));
	dat[5]=(rs.getString(6));
	n_ver_ventas.add(dat);	
	
}


}
	
		String[] columnNames = {"Id","Producto","Distintivo1","Stock", "Precio", "Cantidad"};
	
		
		data_row = new Object[n_ver_ventas.size()][columnNames.length];
		
		for (int j =  0; j < n_ver_ventas.size();j++) {
			
			datos = (Object[]) n_ver_ventas.get(j);
			
			for (int i =  0; i < datos.length;i++) {
				data_row[j][i] = datos[i];

			}			
		}
			

		
	modelo.setDataVector(data_row, columnNames);

	return modelo;
	
}
private static Object[][] data_row;	
private static Object datos[];
private	static DefaultTableModel modelo= new DefaultTableModel();



public static DefaultTableModel model_view_ventas_movimientos(String fechaInicial,String fechafinal) throws SQLException {
	
	List<Object> n_ver_movimientos = new ArrayList<Object>();
	Object[] dat ;
	
       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
CallableStatement cstm_movimientos = con.prepareCall("{ CALL pv_canoa_segunda.ver_movimientos_ventas(?,?) }"))// dentro statement connection and resulset
       
    		   {	       

    	   
    	   cstm_movimientos.setString(1, fechaInicial);
    	   cstm_movimientos.setString(2, fechafinal);
    	
    	   System.out.println(fechafinal+ " "+fechaInicial);
    	   
    	   
    	   
    	   ResultSet rs_movimientos= cstm_movimientos.executeQuery();
    	   
    	   
    	   
    	   
    	   
while(rs_movimientos.next()) {

	dat = new Object[10];
	//dat[0]=(rs_movimientos.getLong(1));	
	dat[0]=(rs_movimientos.getString(1));	
	dat[1]=(rs_movimientos.getString(2));
	dat[2]=(rs_movimientos.getString(3));
	dat[3]=(rs_movimientos.getString(4));
	dat[4]=(rs_movimientos.getString(5));
	dat[5]=(rs_movimientos.getString(6));
	dat[6]=(rs_movimientos.getString(7));
	dat[7]=(rs_movimientos.getString(8));
	dat[8]=(rs_movimientos.getString(9));
	dat[9]=(rs_movimientos.getLong(10));
	n_ver_movimientos.add(dat);	
	System.out.println(dat[6]);
}


}
	
		String[] columnNames = {"ID","Producto","Distintivo1","Precio", "Cantidad" ,"total" ,"fecha", "cliente","usuario","numero venta"};
	
		
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

