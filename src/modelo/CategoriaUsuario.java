package modelo;

public class CategoriaUsuario {

	private String nombre;
	private String descripcion;
	private int id;

	public CategoriaUsuario() {

	}

	public CategoriaUsuario(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CategoriaUsuario [nombre=" + nombre + ", descripcion=" + descripcion + ", id=" + id + "]";
	}

}
