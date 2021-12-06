package servicios;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Producto;
import persistencias.ProductoDAO;

public class ServicioProducto {
	Scanner sc = new Scanner(System.in);
	private ProductoDAO dao = new ProductoDAO();
	
	
	public ServicioProducto() {
	}

	public ServicioProducto(ProductoDAO dao) {
		super();
		this.dao = dao;
	}
	
	public void nuevoProducto() throws Exception	{
		System.out.println("ingrese nombre,precio y codigo del fabricante del producto");
		String nombre = sc.next();
		double precio = sc.nextDouble();
		Integer idf = sc.nextInt();
		Producto prueba = new Producto(1,nombre,precio,idf);
		String sql = "INSERT INTO producto(nombre,precio,codigo_fabricante)"
				+ "Values('"+ prueba.getNombre() +"', '"+prueba.getPrecio()+
				"','"+prueba.getIdF()+"');";
		dao.agregar(sql);
	}
	
	public void editar() {
		String sql;
		ArrayList<Producto> p;
		int id ;
		double precio;
		boolean aux = true;
		do {
			if(aux) {
				System.out.println("ingrese el codigo del producto");
				id = sc.nextInt();	
				aux = false;
			}else {
				System.out.println("el producto no a sido encontrado"
						+ "utilize uno de los siguientes");
				btodos();
				System.out.println("ingrese el codigo");
				id = sc.nextInt();
			}

			sql = "SELECT * FROM producto WHERE codigo = '"+ id +"' ;";
			p = (ArrayList<Producto>) dao.traerp(sql);
		} while (p.isEmpty());
		System.out.println("ingrese el nuevo precio del producto");
		precio = sc.nextDouble();
		sql =  "UPDATE producto SET precio= '"+ precio +"'"
				+ "WHERE codigo = '" + id +"';";
		try {
			dao.insertarModificarELiminar(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void btodos() {
		String sql = "SELECT * FROM producto";
		ArrayList<Producto> p = (ArrayList<Producto>) dao.traerp(sql);
		for (Producto aux : p) {
			System.out.println(aux.getId() + "-" + aux.getNombre() +"-" + 
		"-" + aux.getPrecio() + "-" + aux.getIdF() );
		}
		try {
			dao.desconectar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void b1() {
		String nombre;
		System.out.println("ingrese el nombre del producto");
		String sql;
		ArrayList<Producto> p;
		int i = 0;
		do {
			if(i !=0){
				System.out.println("nombre del producto no encontrado inserte otro");
			}
			nombre = sc.next();
			sql  = "SELECT * FROM producto WHERE nombre LIKE '%" + nombre + "%'";
			p = (ArrayList<Producto>) dao.traerp(sql);
			i +=1;
			dao.desconectar();
		} while ((p.isEmpty()));
		for (Producto aux : p) {
			System.out.println(aux.getId() + "-" + aux.getNombre() +"-" + 
		"-" + aux.getPrecio() + "-" + aux.getIdF() );
		}
		try {
			dao.desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	
	public void buscarXprecio() {
		int pmin;
		int pmax;
		System.out.println("ingrese el precio minimo");
		pmin = sc.nextInt();
		System.out.println("ingrese el precio maximo");
		pmax = sc.nextInt();
		String sql = "SELECT * FROM producto WHERE precio >="+ pmin +" AND precio <= "+ pmax +";";
		ArrayList<Producto> p = (ArrayList<Producto>) dao.traerp(sql);
		if(p.isEmpty()) {
			System.out.println("no hay productos en ese margen de precios");
		}else {
		for (Producto aux : p) {
			System.out.println(aux.getId() + "-" + aux.getNombre() +"-" + 
		"-" + aux.getPrecio() + "-" + aux.getIdF() );
		}
		}
	}
	
	public void borrar() {
		String sql;
		ArrayList<Producto> p;
		int id ;
		boolean aux = true;
		do {
			if(aux) {
				System.out.println("ingrese el codigo del producto");
				id = sc.nextInt();	
				aux = false;
			}else {
				System.out.println("el producto no a sido encontrado"
						+ "utilize uno de los siguientes");
				btodos();
				System.out.println("ingrese el codigo");
				id = sc.nextInt();
			}

			sql = "SELECT * FROM producto WHERE codigo = '"+ id +"' ;";
			p = (ArrayList<Producto>) dao.traerp(sql);
		} while (p.isEmpty());
		sql = "DELETE FROM producto WHERE codigo = '"+ id +"';";
		try {
			dao.insertarModificarELiminar(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	}// end
	
	
	
	
	
