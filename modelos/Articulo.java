package modelos;

public class Articulo {
	private String codigoArticulo;
	private String descripcion;
	private double precioNetoConIVA;
	private int stock;
	private char rubro;
	private char categoria;
	private char porDemanda;
	private double precioNeto;

	public Articulo(String codigoArticulo, String descripcion,double precioNeto, double precioConDescuento,int stock, char porDemanda, char categoria) {
		this.codigoArticulo = codigoArticulo;
		this.descripcion = descripcion;
		this.stock = stock;
		this.rubro = porDemanda;
		this.categoria = categoria;
		this.porDemanda = porDemanda;
		this.precioNeto = precioNeto;
	}

	public char getPorDemanda() {
		return porDemanda;
	}

	public void setCategoria(char categoria) {
		this.categoria = categoria;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecioNetoConIVA() {
		return precioNetoConIVA;
	}

	public int getStock() {
		return stock;
	}

	public char getRubro() {
		return rubro;
	}

	public char getCategoria() {
		return categoria;
	}

	public char isPorDemanda() {
		return porDemanda;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setPrecio(double nuevoPrecio) {
		this.precioNetoConIVA = precioNetoConIVA;
	}
	public double getPrecioNeto() {
		return precioNeto;
	}
}
