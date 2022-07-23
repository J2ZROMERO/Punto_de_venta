package interfaces_no_graficas;

import java.sql.SQLException;

import javax.swing.JTable;

public interface CRUD {

	public void actualizar(Object t[]);
	public void anadir(Object campos[]) ;
	public Object []buscar(int id);
	public void eliminar(int id);
	
	
}
