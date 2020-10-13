package comercio;

import java.security.InvalidParameterException;


public class ItemCarrito {

	private int cantidad;
	private Articulo articulo;
	
	public ItemCarrito(int cantidad, Articulo articulo) {
	
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
	
	public boolean equals(ItemCarrito Itemcarrito) {
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
