package test;
import java.time.LocalTime;
import comercio.DiaRetiro;

public class TestDiaRetiro {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
		//dia de la semana, hora desde, hora hasta, intervalo.
		// DiaRetiro diaretiro1 = new DiaRetiro(5,LocalTime.of( 9, 30), LocalTime.of( 20, 30),30);
		DiaRetiro diaretiro1 = new DiaRetiro(5, LocalTime.of(9, 30),LocalTime.of(20,30), 30);
		DiaRetiro diaretiro2 = new DiaRetiro(7,LocalTime.of( 8, 30), LocalTime.of( 21, 30),50);
		
		System.out.println(diaretiro1);
		System.out.println(diaretiro2);
		
		try {
			diaretiro1.setDiaSemana(0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			diaretiro1.setHoraHasta(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			diaretiro1.setHoraDesde(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			diaretiro1.setIntervalo(-25);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
    }
}
