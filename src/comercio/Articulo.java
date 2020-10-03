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
		//TODO: Hacer la comprobaciï¿½n con el CU de cod de barras 
		if(validarCodBarras(codBarras))
			this.codBarras = codBarras;
		else {
			throw new InvalidParameterException("[WARNING] El código de barras es invalido.");
		}
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if(precio > 0)
			this.precio = precio;
		else 
			throw new InvalidParameterException("[WARNING] El precio no puede ser negativo.");
		}
	
	@Override
	public String toString() {
		return "Id: " + id + ", nombre: " + nombre + ", codigo de barras: " + codBarras + ", precio: " + precio;
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
	
	//Caso de uso 7
	public boolean validarCodBarras(String codBarras) {
        int digito;
        int calcular;
        String ean;
        String checkSum = "131313131313";
        int sum = 0;

        if (codBarras.length() == 13) {
            digito = Integer.parseInt("" + codBarras.charAt(codBarras.length() - 1));            
            ean = codBarras.substring(0, codBarras.length() - 1);            
            for (int i = 0; i <= ean.length() - 1; i++) {
                sum += (Integer.parseInt("" + ean.charAt(i))) * (Integer.parseInt("" + checkSum.charAt(i)));
            }            
            calcular = 10 - (sum % 10);            
            return (digito == calcular);
        } else {
            return false;
        }
    }

}
