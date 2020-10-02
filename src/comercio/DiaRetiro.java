package comercio;

import java.security.InvalidParameterException;
import java.time.LocalTime;

public class DiaRetiro {
	
	private static int cantidad = 0;
	protected int id;
	protected int diaSemana;
	protected LocalTime horaDesde;
	protected LocalTime horaHasta;
	protected int intervalo;

	public DiaRetiro(int diaSemana, LocalTime horaDesde, LocalTime horaHasta, int intervalo) {
		this.id = DiaRetiro.cantidad;
		setDiaSemana(diaSemana);
		setHoraDesde(horaDesde);
		setHoraHasta(horaHasta);
		setIntervalo(intervalo);
		DiaRetiro.cantidad++;
	}
	public DiaRetiro(int id, int diaSemana, LocalTime horaDesde, LocalTime horaHasta, int intervalo) {
		this.id = id;
		setDiaSemana(diaSemana);
		setHoraDesde(horaDesde);
		setHoraHasta(horaHasta);
		setIntervalo(intervalo);
		DiaRetiro.cantidad++;
	}

	public int getId() {
		return id;
	}

	public int getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(int diaSemana) {
		if(diaSemana!=0 && diaSemana < 8){
		this.diaSemana = diaSemana;
	}else {
		throw new InvalidParameterException("[WARNING] Los valores deben ir de 1 a 7 ya que "
				+ "la semana cuenta con dicha cantidad de dias");
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

	public int getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(int intervalo) {
		if(intervalo>0) {
		this.intervalo = intervalo;
	}else {
		throw new InvalidParameterException("[WARNING] Tienen que existir intervalos para asignar turnos de entrega");
	}
		
	}
	
	
	@Override
	public String toString() {
		return "Id: "+id+", dia de la semana: "+diaSemana+", hora para retirar desde: "+horaDesde+", hasta: "+horaHasta+" , intervalo: "+intervalo+".";
	}
	
	public boolean equals(DiaRetiro retiro) {
		return this.diaSemana == ((DiaRetiro)retiro).getDiaSemana();
	}
	
}
