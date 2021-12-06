package persistencias;

import java.util.ArrayList;
import java.util.List;

import entidades.Fabricante;
import entidades.Producto;


public final class FabricantesDAO extends DAO {

	
	public List<Fabricante> buscar()  {
		String sql = "SELECT * FROM fabricante";
		List<Fabricante> fabricantes = new ArrayList();
		try {
			
			buscar(sql);
			while( resultado.next()) {
				Fabricante f = new Fabricante();
				Integer id = resultado.getInt(1);
				String nombre = resultado.getString(2);
				f.setIdf(id);
				f.setNombre(nombre);

				fabricantes.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fabricantes;
	}
	
	public void agregar(String sql) throws Exception {
		System.out.println("producto dao agregar");
		insertarModificarELiminar(sql);
	}
	

}
