package test;

import java.time.LocalDate;
import java.time.LocalTime;

import comercio.Turno;

public class TestTurno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Turno turno = new Turno(LocalDate.now(), LocalTime.of(20, 0), true);
		System.out.println(turno);
		
		try {
			turno.setDiaTurno(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			turno.setHoraTurno(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
