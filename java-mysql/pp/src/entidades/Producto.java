package entidades;

public class Producto {
	
	private Integer id;
	private String nombre;
	private double precio;
	private int idF;
	public Producto(int id, String nombre, double precio, int idF) {
		
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.idF = idF;
	}
	public Producto() {

	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getIdF() {
		return idF;
	}
	public void setIdF(int idF) {
		this.idF = idF;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", idF=" + idF + "]";
	}
	
	

	
	
}
