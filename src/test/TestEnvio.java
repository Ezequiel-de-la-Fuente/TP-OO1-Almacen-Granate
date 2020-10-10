package test;

import java.time.LocalDate;
import java.time.LocalTime;

import comercio.Envio;
import comercio.Ubicacion;

public class TestEnvio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Envio envio = new Envio(LocalDate.now(), true, LocalTime.of(23, 55, 50),LocalTime.of(23,10,20), 500, new Ubicacion(80, 20));
		System.out.println(envio);
		
		try {
			envio.setHoraHasta(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			envio.setHoraHasta(LocalTime.of(20,5,5));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			envio.setHoraDesde(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			envio.setHoraDesde(LocalTime.of(23,57,55));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			envio.setCosto(-100);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println(envio);
	}

}
