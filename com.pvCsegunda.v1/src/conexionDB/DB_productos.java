package conexionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DB_productos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		
		
//		try {
//			Object datosDB[] = new Object[17];
//			datosDB[0] = 12313;
//			datosDB[1] = "sda";
//			datosDB[2] = "ffsad";
//			datosDB[3] = "ffsad";
//			datosDB[4] = "25";
//			datosDB[5] = "25";
//			datosDB[6] = "25";
//			datosDB[7] = "25";
//			datosDB[8] = "25";
//			datosDB[9] = "25";
//			datosDB[10] = "25";
//			datosDB[11] = "25";
//			datosDB[12] = "";
//			datosDB[13] = "";
//			datosDB[14] = "";
//			datosDB[15] = "";
//			datosDB[16] = "";
//	
//			DB_productos.actualizar(datosDB);
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
////		
//Object dato[] = new Object[17];
//
//dato[0] = "9";
//dato[1] = "asdas";
//dato[2] ="asdas";
//dato[3] ="asdas";
//dato[4] = "2";
//dato[5] ="122.12";
//dato[6] = "122.12";
//dato[7] ="122.12";
//dato[8] = "asdas";
//dato[9] ="122.12"; 
//dato[10]="122.12";
//dato[11] ="122.12";
//dato[12] ="";
//dato[13] ="";
//dato[14] ="";
//dato[15] ="";
//dato[16] ="";
//
//try {
//	DB_productos.model_view_ventas_buscar(dato);
//} catch (SQLException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//
//
//
//
//
//
//try {
//	DB_productos.anadir(dato);
//} catch (SQLException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//	
	}


	public  static void anadir(Object datos_campos[]) throws SQLException{


//		}
//		
//	
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.añadir_producto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }"))   // dentro statement connection and resulset
	        

	       
	       {	       
//  obligatorios / id / producto / tipo / stock / precio de venta / precio de compra /  we dont put the value date because that value is getting put in database


cstm.setLong( 1,Long.parseLong(datos_campos[0].toString()));  //bigint (20)
System.out.println("pasa");
cstm.setString(2, datos_campos[1].toString() );	  				//varchar
cstm.setString(3, datos_campos[2].toString() );	 				//varchar  				
cstm.setString(4, datos_campos[3].toString() );                 //varchar
cstm.setInt(5,Integer.parseInt( datos_campos[4].toString() ));	 				//smallint

if(datos_campos[5].equals("")) {
	cstm.setNull(6, java.sql.Types.NULL);
}else {
	System.out.println("no estav acio");
	cstm.setDouble(6, Double.parseDouble(datos_campos[5].toString() ));                //double	
}


if(datos_campos[6].equals("")) {
	cstm.setNull(7, java.sql.Types.NULL);
}else {
	cstm.setDouble(7, Double.parseDouble(datos_campos[6].toString() ));                //double	
}


if(datos_campos[7].equals("")) {
	cstm.setNull(8, java.sql.Types.NULL);
}else {
	cstm.setDouble(8, Double.parseDouble(datos_campos[7].toString() ));                //double	
}

cstm.setString(9, datos_campos[8].toString() );               //varchar	(20)

if(datos_campos[9].equals("")) {
	cstm.setNull(10, java.sql.Types.NULL);
}else {
	cstm.setString(10, datos_campos[9].toString());	
}
                 //double	
cstm.setDouble(11, Double.parseDouble(datos_campos[10].toString() ));	        //double    
cstm.setDouble(12, Double.parseDouble(datos_campos[11].toString() ));	           //double

if(datos_campos[12].toString().equals("")) {
	cstm.setNull(13, java.sql.Types.NULL);	                 //int
}else {
	cstm.setString(13, datos_campos[12].toString() );	                 //int
}
if(datos_campos[13].toString().equals("")) {
	cstm.setNull(14, java.sql.Types.NULL);	                 //int
}else {
	cstm.setString(14, datos_campos[13].toString());	                 //int
}
if(datos_campos[14].toString().equals("")) {
	cstm.setNull(15, java.sql.Types.NULL);	                 //int
}else {
	cstm.setString(15,datos_campos[14].toString());	                 //int
}
if(datos_campos[15].toString().equals("")) {
	cstm.setNull(16, java.sql.Types.NULL);	                 //int
}else {
	cstm.setString(16, datos_campos[15].toString());	                 //int
}
if(datos_campos[16].toString().equals("")) {
	cstm.setNull(17, java.sql.Types.NULL);	                 //int
}else {
	cstm.setString(17, datos_campos[16].toString());	                 //int
}


	

//cstm.setInt(14, Integer.parseInt(datos_campos[13].toString() ));	                 //int	
//cstm.setInt(15, Integer.parseInt(datos_campos[14].toString() ));		                 //int
//cstm.setInt(16, Integer.parseInt(datos_campos[15].toString() ));		                 //int
//cstm.setInt(17, Integer.parseInt(datos_campos[16].toString() ));		                 //int
//cstm.setString(18, datos_campos[17].toString() );		                 //varchar (30)

cstm.executeUpdate();
System.out.println("datos insertados");	       
	       }
		
		
	}
	
	public  static Object[] buscar(long id) throws SQLException{
	     
		Object valores_campos[] = new Object[17];
		
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.busca_producto(?) }"))   // dentro statement connection and resulset
	        

	       {	       

	    	   
cstm.setLong(1,id );


ResultSet rs = cstm.executeQuery();


while(rs.next()) {
	valores_campos[0]= rs.getLong(1);
	valores_campos[1]= rs.getString(2);
	valores_campos[2]= rs.getString(3);
	valores_campos[3]= rs.getString(4);
	valores_campos[4]= rs.getInt(5);
	valores_campos[5]= rs.getDouble(6);
	valores_campos[6]= rs.getDouble(7);
	valores_campos[7]= rs.getDouble(8);
	valores_campos[8]= rs.getString(9);
	valores_campos[9]= rs.getString(10);
	valores_campos[10]= rs.getDouble(11);
	valores_campos[11]= rs.getDouble(12);
	valores_campos[12]= rs.getString(13);
	valores_campos[13]= rs.getString(14);
	valores_campos[14]= rs.getString(15);
	valores_campos[15]= rs.getString(16);
	valores_campos[16]= rs.getString(17);
	//valores_campos[16]= rs.getInt(18);
	
	
    	
}	 

			
for(int i = 0; i < valores_campos.length;i++) {
if(valores_campos[i] == null || valores_campos[i].equals(Integer.valueOf(0)) || valores_campos[i].equals(Double.valueOf(0.0)) ){
	valores_campos[i]= "";
}
}


	       }
	       
		return valores_campos;
		
	       	
	}
		
	public  static void eliminar(String idusuario,long idproducto) throws SQLException{
	      
		
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.eliminar_producto(?,?) }"))  // dentro statement connection and resulset
	        

	       {	       

	    	   
cstm.setString(1,idusuario );
cstm.setLong(2,idproducto );
 cstm.executeUpdate();
System.out.println("datos eliminados");

	       }

		
	       	
	}
	
	
	

	
	public  static void actualizar(Object datos_campos[]) throws SQLException{
	    // id para compararar / campo motivo es agregadoe en la base de datos / razon y fecha no se actualizan eso lo hace la base de datos
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.actualizar_producto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }"))   // dentro statement connection and resulset
	        

	       {	       


cstm.setLong( 1,Long.parseLong(datos_campos[0].toString()));  //bigint (20)
cstm.setString(2, datos_campos[1].toString() );	  				//varchar
cstm.setString(3, datos_campos[2].toString() );	 				//varchar  				
cstm.setString(4, datos_campos[3].toString() );                 //varchar
cstm.setInt(5,Integer.parseInt( datos_campos[4].toString() ));	 				//smallint

if(datos_campos[5].equals("")) {
	cstm.setNull(6, java.sql.Types.NULL);
}else {
	
	cstm.setDouble(6, Double.parseDouble(datos_campos[5].toString() ));                //d	
}


if(datos_campos[6].equals("")) {
	cstm.setNull(7, java.sql.Types.NULL);
}else {

	cstm.setDouble(7, Double.parseDouble(datos_campos[6].toString() ));                
}


if(datos_campos[7].equals("")) {
	cstm.setNull(8, java.sql.Types.NULL);
}else {
	cstm.setDouble(8, Double.parseDouble(datos_campos[7].toString() ));                //double
	
}

cstm.setString(9, datos_campos[8].toString() );               //varchar	(20)

if(datos_campos[9].equals("")) {
	cstm.setNull(10, java.sql.Types.NULL);
}else {
	cstm.setString(10, datos_campos[9].toString());
	
}
                 //double	
cstm.setDouble(11, Double.parseDouble(datos_campos[10].toString() ));	
    
cstm.setDouble(12, Double.parseDouble(datos_campos[11].toString() ));	           //double


if(datos_campos[12].toString().equals("")) {
	cstm.setNull(13, java.sql.Types.NULL);	                 //int
}else {
	cstm.setString(13, datos_campos[12].toString() );	                 //int

}
if(datos_campos[13].toString().equals("")) {
	cstm.setNull(14, java.sql.Types.NULL);	                 //int
}else {
	cstm.setString(14, datos_campos[13].toString());	                 //int

}
if(datos_campos[14].toString().equals("")) {
	cstm.setNull(15, java.sql.Types.NULL);	                 //int
}else {
	cstm.setString(15,datos_campos[14].toString());	                 //int

}
if(datos_campos[15].toString().equals("")) {
	cstm.setNull(16, java.sql.Types.NULL);	                 //int
}else {
	cstm.setString(16, datos_campos[15].toString());	                 //int

}
if(datos_campos[16].toString().equals("")) {
	cstm.setNull(17, java.sql.Types.NULL);	                 //int
}else {
	cstm.setString(17, datos_campos[16].toString());	                 //int

}

cstm.executeUpdate();
System.out.println("datos actualizados");

	       }

	}
	

	public static DefaultTableModel model_view_usuarios() throws SQLException {
		List<Object> n_usuarios = new ArrayList<Object>();
		Object[] dat ;
		
	       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
	    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.ver_clientes() }"); ResultSet rs= cstm.executeQuery())// dentro statement connection and resulset	       
	       {	       
	    	   
  	   
while(rs.next()) {
	dat = new Object[3];
dat[0]=(rs.getInt(1));	
dat[1]=(rs.getString(2));	
dat[2]=(rs.getString(6));

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
////////
public static DefaultTableModel model_view__prod_marcas() throws SQLException {
	
	List<Object> n_marcas = new ArrayList<Object>();
	
	
       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
    		   CallableStatement cstm_marcas = con.prepareCall("{ CALL pv_canoa_segunda.ver_marcas() }"); ResultSet rs_marcas= cstm_marcas.executeQuery() 
    		   )// dentro statement connection and resulset
       
    		   {	       
while(rs_marcas.next()) {

n_marcas.add(rs_marcas.getString(2));	
}
}
	
		String[] columnNames = {"Marcas"};
	
		
		data_marca = new Object[n_marcas.size()][columnNames.length];
		for (int j =  0; j < columnNames.length;j++) {
				
				for (int i =  0; i < n_marcas.size();i++) {
					data_marca[i][j] =n_marcas.get(i);
			
		}}

	modelo_marca.setDataVector(data_marca, columnNames);

	return modelo_marca;
	
}
private static Object[][] data_marca;	

private	static DefaultTableModel modelo_marca = new DefaultTableModel();

public static DefaultTableModel model_view_prod_linea() throws SQLException {
	
	
	List<Object> n_linea = new ArrayList<Object>();
       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
    		    CallableStatement cstm_lineas = con.prepareCall("{ CALL pv_canoa_segunda.ver_lineas() }"); ResultSet rs_lineas= cstm_lineas.executeQuery(); 
    		   )
       
    		   {	       

while(rs_lineas.next()) {

n_linea.add(rs_lineas.getString(2));	
}
}
	
		String[] columnNames = {"Linea"};
	
		data_linea = new Object[n_linea.size()][columnNames.length];
		for (int j =  0; j < columnNames.length;j++) {
				
			
				for (int i =  0; i < n_linea.size();i++) {
					data_linea[i][j] =n_linea.get(i);
							}
			
			
			}
			
		
	modelo_linea.setDataVector(data_linea, columnNames);

	
	return modelo_linea;
	
}
private static Object[][] data_linea;	
private	static DefaultTableModel modelo_linea = new DefaultTableModel();







public static DefaultTableModel model_view_prod_categoria() throws SQLException {
	
	
	List<Object> n_categoria = new ArrayList<Object>();
	
       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
 CallableStatement cstm_categorias = con.prepareCall("{ CALL pv_canoa_segunda.ver_categoria() }"); ResultSet rs_categorias= cstm_categorias .executeQuery()
    		   )// dentro statement connection and resulset
       
    		   {	       

while(rs_categorias.next()) {

n_categoria.add(rs_categorias.getString(2));	
}

}
	
		String[] columnNames = {"categoria"};
	
		
		data_categoria = new Object[n_categoria.size()][columnNames.length];
		for (int j =  0; j < columnNames.length;j++) {
				
	
				for (int i =  0; i < n_categoria.size();i++) {
					data_categoria[i][j] =n_categoria.get(i);

				}
			
			
		}

	modelo_categoria.setDataVector(data_categoria, columnNames);

	return modelo_categoria;
	
}
private static Object[][] data_categoria;	
private	static DefaultTableModel modelo_categoria = new DefaultTableModel();


public static DefaultTableModel model_view_prod_provedores() throws SQLException {
	
	List<Object> n_provedores = new ArrayList<Object>();

	
       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
CallableStatement cstm_provedores = con.prepareCall("{ CALL pv_canoa_segunda.ver_provedores() }"); ResultSet rs_provedores= cstm_provedores.executeQuery()
    		   )// dentro statement connection and resulset
       
    		   {	       

while(rs_provedores.next()) {

n_provedores.add(rs_provedores.getString(2));	
}

}
	
		String[] columnNames = {"Provedores"};
	
		
		data_provedores = new Object[n_provedores.size()][columnNames.length];
		for (int j =  0; j < columnNames.length;j++) {
				
			for (int i =  0; i < n_provedores.size();i++) {
				data_provedores[i][j] =n_provedores.get(i);

			}			
		}
			

		
	modelo_provedores.setDataVector(data_provedores, columnNames);

	return modelo_provedores;
	
}
private static Object[][] data_provedores;	

private	static DefaultTableModel modelo_provedores = new DefaultTableModel();


public static DefaultTableModel model_view_ventas_buscar(Object datos_campos[]) throws SQLException {
	List<Object> n_ventas_buscar = new ArrayList<Object>();
	Object[] dat ;
	
       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
    		   CallableStatement cstm = con.prepareCall("{ CALL pv_canoa_segunda.productos_like(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }"))// dentro statement connection and resulset	       
       {	       
    	 
    	   
    	   
    	   
    	   
    	   
    	   
  /*  	   
    pensar para optimizar codigo	   
    	   Object transfo [] = new Object [17];    	   
    	   int increase = 1 ;
for(int i = 0; i < datos_campos.length;i++) {
	if(datos_campos[i].toString().equals("")) {
		cstm.setNull(i+1, java.sql.Types.NULL );	
		System.out.println("hay nulos");
	}else {
		cstm.setString(i+1, datos_campos[i].toString() );
		System.out.println("no hay nulos");
	}
	
}


*/


    		if(datos_campos[0].toString().equals("")) { cstm.setNull(1, java.sql.Types.NULL );
    	   		}else {   									cstm.setString(1, datos_campos[0].toString() ); 		}
    	   		if(datos_campos[1].toString().equals("")) { cstm.setNull(2, java.sql.Types.NULL );
    	   		}else {   									cstm.setString(2, datos_campos[1].toString() ); 		}	
    	   		if(datos_campos[2].toString().equals("")) { cstm.setNull(3, java.sql.Types.NULL );
    	   		}else {   									cstm.setString(3, datos_campos[2].toString() ); 		}	
    	   		if(datos_campos[3].toString().equals("")) { cstm.setNull(4, java.sql.Types.NULL );
    	   		}else {   									cstm.setString(4, datos_campos[3].toString() ); 		}	
    	   		if(datos_campos[4].toString().equals("")) { cstm.setNull(5, java.sql.Types.NULL );
    	   		}else {   									cstm.setString(5, datos_campos[4].toString() ); 		}	
    	   		if(datos_campos[5].toString().equals("")) { cstm.setNull(6, java.sql.Types.NULL );
    	   		}else {   									cstm.setString(6, datos_campos[5].toString() ); 		}	
    	   		if(datos_campos[6].toString().equals("")) { cstm.setNull(7, java.sql.Types.NULL );
    	   		}else {   									cstm.setString(7, datos_campos[6].toString() ); 		}	
    	   		if(datos_campos[7].toString().equals("")) { cstm.setNull(8, java.sql.Types.NULL );
    	   		}else {   									cstm.setString(8, datos_campos[7].toString() ); 		}	
    	   		if(datos_campos[8].toString().equals("")) { cstm.setNull(9, java.sql.Types.NULL );
    	   		}else {   									cstm.setString(9, datos_campos[8].toString() ); 		}	
    	   		if(datos_campos[9].toString().equals("")) { cstm.setNull(10, java.sql.Types.NULL );
    	   		}else {   									cstm.setString(10, datos_campos[9].toString() ); 		}	
    	   		if(datos_campos[10].toString().equals("")) { cstm.setNull(11, java.sql.Types.NULL );
    	   		}else {   									cstm.setString(11, datos_campos[10].toString() ); 		}	
    	   		if(datos_campos[11].toString().equals("")) { cstm.setNull(12, java.sql.Types.NULL );
    	   		}else {   									cstm.setString(12, datos_campos[11].toString() ); 		}	
    	   		if(datos_campos[12].toString().equals("")) { cstm.setNull(13, java.sql.Types.NULL );
    	   		}else {   									cstm.setString(13, datos_campos[12].toString() ); 		}	
    	   		if(datos_campos[13].toString().equals("")) { cstm.setNull(14, java.sql.Types.NULL );
    	   		}else {   									cstm.setString(14, datos_campos[13].toString() ); 		}	
    	   		if(datos_campos[14].toString().equals("")) { cstm.setNull(15, java.sql.Types.NULL );
    	   		}else {   									cstm.setString(15, datos_campos[14].toString() ); 		}	
    	   		if(datos_campos[15].toString().equals("")) { cstm.setNull(16, java.sql.Types.NULL );
    	   		}else {   									cstm.setString(16, datos_campos[15].toString() ); 		}	
    	   									
   ResultSet rs =   cstm.executeQuery();
    	


while(rs.next()) {
dat = new Object[17];
dat[0]=(rs.getBigDecimal(1));	
dat[1]=(rs.getString(2));	
dat[2]=(rs.getString(3));	
dat[3]=(rs.getString(4));	
dat[4]=(rs.getInt(5));	
dat[5]=(rs.getDouble(6));	
dat[6]=(rs.getDouble(7));	
dat[7]=(rs.getDouble(8));
dat[8]=(rs.getString(9));	
dat[9]=(rs.getString(10));	
dat[10]=(rs.getDouble(11));
dat[11]=(rs.getDouble(12));
dat[12]=(rs.getInt(13));	
dat[13]=(rs.getInt(14));	
dat[14]=(rs.getInt(15));	
dat[15]=(rs.getInt(16));	
dat[16]=(rs.getInt(17));

n_ventas_buscar.add(dat);

for(Object t: dat) {
System.out.println(t);	
}
}

String[] columnNames = {"Id" ,"Producto","Caracteristica","Extra distintivo","Stock","Kilogramos","Medida","Mililitros","Color","Tamaño","Precio Compra","Precio Venta","Provedores","Marca","Linea","Categoria","Usuario"};


data_row_ventas_buscar = new Object[n_ventas_buscar.size()][columnNames.length];
  
for (int j =  0; j < n_ventas_buscar.size();j++) {
datos_ventas_buscar = (Object[]) n_ventas_buscar.get(j);
for (int i =  0; i < datos_ventas_buscar.length;i++) {
	data_row_ventas_buscar[j][i] =datos_ventas_buscar[i];
}	
}

modelo_ventas_buscar.setDataVector(data_row_ventas_buscar, columnNames);	
       }
       
	return modelo_ventas_buscar;
}




private static Object[][] data_row_ventas_buscar;	
private static Object[] datos_ventas_buscar;
private	static DefaultTableModel modelo_ventas_buscar = new DefaultTableModel();




public static DefaultTableModel model_view_prod_movimientos(String fechaInicial,String fechafinal) throws SQLException {
	
	List<Object> n_ver_movimientos = new ArrayList<Object>();
	Object[] dat ;
	
       try(Connection con = DriverManager.getConnection(Maria_db.URL,Maria_db.user,Maria_db.pass); 
CallableStatement cstm_movimientos = con.prepareCall("{ CALL pv_canoa_segunda.ver_movimientos_productos(?,?) }"))// dentro statement connection and resulset
       
    		   {	       

    	   
    	   cstm_movimientos.setString(1, fechaInicial);
    	   cstm_movimientos.setString(2, fechafinal);
    	
    	   System.out.println(fechafinal+ " "+fechaInicial);
    	   
    	   
    	   
    	   ResultSet rs_movimientos= cstm_movimientos.executeQuery();
    	   
    	   
    	   
    	   
    	   
while(rs_movimientos.next()) {

	dat = new Object[8];
	dat[0]=(rs_movimientos.getLong(1));	
	dat[1]=(rs_movimientos.getString(2));	
	dat[2]=(rs_movimientos.getString(3));
	dat[3]=(rs_movimientos.getInt(4));
	dat[4]=(rs_movimientos.getInt(5));
	dat[5]=(rs_movimientos.getString(6));
	dat[6]=(rs_movimientos.getString(7));
	dat[7]=(rs_movimientos.getString(8));
	n_ver_movimientos.add(dat);	
}


}
	
		String[] columnNames = {"ID","Producto","Distintivo","Stock Antiguo", "Stock nuevo" ,"motivo" ,"Usuario", "fecha"};
	
		
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
