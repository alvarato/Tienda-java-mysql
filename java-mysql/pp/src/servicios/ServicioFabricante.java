package servicios;

import java.util.ArrayList;
import java.util.Scanner;

import entidades.Fabricante;
import entidades.Producto;
import persistencias.FabricantesDAO;



public class ServicioFabricante {
	Scanner sc = new Scanner(System.in);
	
	FabricantesDAO dao = new FabricantesDAO();
	
	public void btodos() {
		ArrayList<Fabricante> f = (ArrayList<Fabricante>) dao.buscar();
		for (Fabricante aux : f) {
			System.out.println(aux.getIdf() + "-" + aux.getNombre() );
		}
		try {
			dao.desconectar();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void nuevoProducto() throws Exception	{
		System.out.println("ingrese nombre del fabricante");
		String nombre = sc.next();
		Integer idf = null;
		Fabricante f = new Fabricante(idf,nombre);
		String sql = "INSERT INTO fabricante(nombre)"
				+ "Values('"+f.getNombre()+"');";
		dao.agregar(sql);
	}
	
}
