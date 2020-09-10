package comercio;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Envio extends Entrega {

	private LocalTime horaHasta;
	private LocalTime horaDesde;
	private double costo;
	private Ubicacion ubicacion;
	//TODO: Agregar la comprobasion horaDesde a horaHasta se respete que la primera sea antes de la segunda.
	//TODO: Agregar un limite superior a costo.
	public Envio(LocalDate fecha, boolean efectivo, LocalTime horaHasta, LocalTime horaDesde, double costo, Ubicacion ubicacion) {
		super(fecha, efectivo);
		setHoraHasta(horaHasta);
		setHoraDesde(horaDesde);
		setCosto(costo);
		setUbicacion(ubicacion);
	}
	
	public LocalTime getHoraHasta() {
		return horaHasta;
	}
	
	public void setHoraHasta(LocalTime horaHasta) {
		if(horaHasta!=null) {
			this.horaHasta = horaHasta;
		}else {
			throw new InvalidParameterException("[WARNING] La hora no puede ser nula");
		}
	}
	
	public LocalTime getHoraDesde() {
		return horaDesde;
	}
	public void setHoraDesde(LocalTime horaDesde) {
		if(horaDesde!=null) {
			this.horaDesde = horaDesde;
		}else {
			throw new InvalidParameterException("[WARNING] La hora no puede ser nula");
		}
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		if (costo>0) {
			this.costo = costo;
		}else {
			throw new InvalidParameterException("[WARNING] El costo debe ser mayor a cero");
		}
	}

	
	
	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		if (ubicacion!=null) {
			this.ubicacion = ubicacion;
		}else {
			throw new InvalidParameterException("[WARNING] La ubicacion no puede ser nula");
		}
	}

	@Override
	public String toString() {
		return "Envio" + this.atributosToString();
	}
	
	@Override
	protected String atributosToString() {
		return super.atributosToString() + ", horaHasta=" + horaHasta + ", horaDesde=" + horaDesde + ", costo=" + costo + ", ubicacion=[ "+ubicacion +" ]";
	}
	
	public boolean equals(Envio envio) {
		boolean sonIguales = false;
		if (envio != null) {
			sonIguales = envio.getId() == this.getId();
		}else {
			throw new InvalidParameterException("[WARNING] El envio no debe ser nula");
		}
		return sonIguales;
	}

}
