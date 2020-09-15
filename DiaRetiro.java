package comercio;

import java.security.InvalidParameterException;
import java.time.LocalTime;

public class DiaRetiro {
	
	private int id;
	private int diaSemana;
	private LocalTime horaDesde;
	private LocalTime horaHasta;
	private int intervalo;

	public DiaRetiro(int id, int diaSemana, LocalTime horaDesde, LocalTime horaHasta, int intervalo) {
		setId(id);
		setDiaSemana(diaSemana);
		setHoraDesde(horaDesde);
		setHoraHasta(horaHasta);
		setIntervalo(intervalo);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}

	public LocalTime getHoraDesde() {
		return horaDesde;
	}

	public void setHoraDesde(LocalTime horaDesde) {
		this.horaDesde = horaDesde;
	}

	public LocalTime getHoraHasta() {
		return horaHasta;
	}

	public void setHoraHasta(LocalTime horaHasta) {
		this.horaHasta = horaHasta;
	}

	public int getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}
	
	@Override
	public String toString() {
		return "Id: "+id+", dia de la semana: "+diaSemana+", hora para retirar desde: "+horaDesde+", hasta: "+horaHasta+" , intervalo: "+intervalo+".";
	}
	
	public boolean equals(DiaRetiro retiro) {
		boolean sonIguales = false;
		if (retiro != null) {
			sonIguales = retiro.getId() == this.id;
		}else {
			throw new InvalidParameterException("[WARNING] El retiro no debe ser nulo");
		}
		return sonIguales;
	}
	
}
