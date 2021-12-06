package entidades;

public class Fabricante {
	private Integer idf;
	private String nombre;
	public Fabricante(Integer idf, String nombre) {
		super();
		this.idf = idf;
		this.nombre = nombre;
	}
	public Fabricante() {
		super();
	}
	public Integer getIdf() {
		return idf;
	}
	public void setIdf(Integer idf) {
		this.idf = idf;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
