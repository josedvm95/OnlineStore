package modelo;

public class Ordenador {

	private String marca;
	private String modelo;
	private String procesador;
	private String grafica;
	private double pulgadas;
	private double precio;
	private int stock;
	private int id;
	private int idCategoria;
	
	private CategoriaOrdenador categoriaOrdenador;

	public Ordenador() {

	}

	public Ordenador(String marca, String modelo, double precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
	}

	public Ordenador(String marca, String modelo, String procesador, String grafica, double pulgadas, double precio,
			int stock) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.procesador = procesador;
		this.grafica = grafica;
		this.pulgadas = pulgadas;
		this.precio = precio;
		this.stock = stock;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public String getGrafica() {
		return grafica;
	}

	public void setGrafica(String grafica) {
		this.grafica = grafica;
	}

	public double getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(double pulgadas) {
		this.pulgadas = pulgadas;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public CategoriaOrdenador getCategoriaOrdenador() {
		return categoriaOrdenador;
	}

	public void setCategoriaOrdenador(CategoriaOrdenador categoriaOrdenador) {
		this.categoriaOrdenador = categoriaOrdenador;
	}

	@Override
	public String toString() {
		return "Ordenador [marca=" + marca + ", modelo=" + modelo + ", procesador=" + procesador + ", grafica="
				+ grafica + ", pulgadas=" + pulgadas + ", precio=" + precio + ", stock=" + stock + ", id=" + id
				+ ", idCategoria=" + idCategoria + "]";
	}

}
