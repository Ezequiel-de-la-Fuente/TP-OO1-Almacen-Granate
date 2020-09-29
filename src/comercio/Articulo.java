package comercio;

import java.security.InvalidParameterException;

public class Articulo {

	private static int count = 0;
	private int id;
	private String nombre;
	private String codBarras;
	private double precio;
	
	public Articulo() {
		
	}
	
	public Articulo(String nombre, String codBarras, double precio) {
		id = Articulo.count;
		setNombre(nombre);
		setPrecio(precio);
		setCodBarras(codBarras);
		Articulo.count++;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre != null)
			this.nombre = nombre;
		else 
			throw new InvalidParameterException("[WARNING] El nombre no puede ser nulo.");
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		//TODO: Hacer la comprobación con el CU de cod de barras 
		this.codBarras = codBarras;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if(precio < 0)
			this.precio = precio;
		else 
			throw new InvalidParameterException("[WARNING] El precio no puede ser negativo.");
		}
	
	@Override
	public String toString() {
		return "Id: " + id + ", nombre: " + nombre + ", código de barras: " + codBarras + ", precio: " + precio + ".";
	}
	
	public boolean equals(Articulo a) {
		boolean iguales = false;
		if (a != null) {
			iguales = a.getId() == this.id;
		}else {
			throw new InvalidParameterException("El articulo no debe ser nulo.");
		}
		return iguales;	
	}

}
