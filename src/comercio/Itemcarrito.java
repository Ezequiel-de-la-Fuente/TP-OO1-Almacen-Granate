package comercio;

import java.security.InvalidParameterException;


public class Itemcarrito {

	private int cantidad;
	private Articulo articulo;
	
	public Itemcarrito(int cantidad, Articulo articulo) {
	
		setCantidad(cantidad);
		setArticulo(articulo);
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
	@Override
	public String toString() {
		return "Cantidad: "+cantidad+", articulo: "+articulo;
	}
	
	public boolean equals(Itemcarrito Itemcarrito) {
		boolean sonIguales = false;
		if (Itemcarrito != null) {
			sonIguales = ( this.articulo == Itemcarrito.getArticulo());
		}else {
			throw new InvalidParameterException("[WARNING] No hay items en carrito");
		}
		return sonIguales;
	}

	//CU 9
	public double calcularSubTotalItem(){
		return cantidad*articulo.getPrecio();
	}
	
	
}
