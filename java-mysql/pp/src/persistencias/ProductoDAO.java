package persistencias;

import java.util.ArrayList;
import java.util.List;
import entidades.Producto;

public final class ProductoDAO extends DAO{
	
	public List<Producto> traerp(String sql)  {
		List<Producto> productos = new ArrayList();
		try {
			
			buscar(sql);
			while( resultado.next()) {
				Producto p = new Producto();
				Integer id = resultado.getInt(1);
				String nombre = resultado.getString(2);
				double precio = resultado.getDouble(3);
				int idf = resultado.getInt(4);
				p.setId(id);
				p.setNombre(nombre);
				p.setPrecio(precio);
				p.setIdF(idf);
				productos.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productos;
	}
	
	
	public void agregar(String sql) throws Exception {
		System.out.println("producto dao agregar");
		insertarModificarELiminar(sql);
	}
	
	
	
	
	
	
	
}

