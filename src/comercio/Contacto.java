package comercio;

import java.security.InvalidParameterException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Contacto {
	private String email;
	private String celular;
	private Ubicacion ubicacion;
	//TODO: Hacer una validacion para email y para celular.
	public Contacto(String email, String celular, Ubicacion ubicacion) {
		super();
		setEmail(email);
		setCelular(celular);
		setUbicacion(ubicacion);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email!=null) {
			if(validarEmail(email)) this.email = email;
			else throw new InvalidParameterException("[WARNING] El email no es valido");	
		}else {
			throw new InvalidParameterException("[WARNING] El email no debe ser nulo");
		}
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		if(celular!=null) {
			if(validarCelular(celular, " "))
				this.celular = celular;
			else
			throw new InvalidParameterException("[WARNING] El celular no es valido");
		}else {
			throw new InvalidParameterException("[WARNING] El celular no debe ser nulo");
		}
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		if(ubicacion!=null) {
			this.ubicacion = ubicacion;			
		}else {
			throw new InvalidParameterException("[WARNING] La ubicacion no debe ser nulo");
		}
	}

	@Override
	public String toString() {
		return "Contacto -> email=" + email + ", celular=" + celular + ", ubicacion=[ " + ubicacion + " ]";
	}
	
	public boolean equals(Contacto contacto) {
		boolean sonIguales = false;
		if (contacto != null) {
			sonIguales = this.email.equals(contacto.getEmail()) && this.celular.equals(contacto.getCelular()) && this.ubicacion.equals(contacto.getUbicacion());
		}else {
			throw new InvalidParameterException("[WARNING] El contacto no debe ser nulo");
		}
		return sonIguales;
	}
	
	private boolean validarEmail(String email){
		boolean valido = false;
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(email);
		valido = mather.find();
		return valido;
	}

	private boolean validarCelular(String celular, String delim){
		boolean valido = false;
		try {
			int posDelimUno = celular.indexOf(delim);
			String codigoArea = celular.substring(0, posDelimUno);


			int posDelimDos = celular.indexOf(delim, posDelimUno+1);
			String primeraParte = null;

			primeraParte = celular.substring(posDelimUno+1,posDelimDos);
			

			String segundaParte = celular.substring(posDelimDos+1);
			if(isNumeric(codigoArea) && isNumeric(primeraParte) && isNumeric(segundaParte)){
				if(segundaParte.length()==4){
					valido = (primeraParte.length() + segundaParte.length() + codigoArea.length())==10;
				}
			}
		} catch (Exception e) {
			// System.out.println(e);
		}
		return valido;
		
	}

	private boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
}
