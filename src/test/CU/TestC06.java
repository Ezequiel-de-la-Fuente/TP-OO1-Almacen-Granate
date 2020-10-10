package test.CU;

import java.time.LocalTime;
import comercio.Comercio;
import comercio.DiaRetiro;
import comercio.Ubicacion;
import comercio.Contacto;

public class TestC06 {

	public static void main(String[] args) {
		
		Contacto contacto = new Contacto("almacen@gmail.com", "15 4567 7894", new Ubicacion(31, 12));
		Comercio almacen = new Comercio(24,contacto,"Granate-Store","30-52745070-1",100,15.50,28,3,5);	
		String dia = null;
		try {
			almacen.agregarDiaRetiro(5, LocalTime.of(9, 30),LocalTime.of(20,30), 30);
			almacen.agregarDiaRetiro(7,LocalTime.of( 8, 30), LocalTime.of( 21, 30),50);
			almacen.agregarDiaRetiro(1,LocalTime.of( 8, 30), LocalTime.of( 21, 30),25);
			almacen.agregarDiaRetiro(2,LocalTime.of( 7, 30), LocalTime.of( 19, 30),10);
			almacen.agregarDiaRetiro(3,LocalTime.of( 8, 00), LocalTime.of( 21, 00),20);
			almacen.agregarDiaRetiro(4,LocalTime.of( 9, 00), LocalTime.of( 22, 00),15);
			almacen.agregarDiaRetiro(6,LocalTime.of( 10, 30), LocalTime.of( 22, 30),40);

			
			for (DiaRetiro diaRetiro : almacen.getLstDiaRetiro()) {
				switch (diaRetiro.getDiaSemana()) {
				case 1: dia = "Lunes";
				break;
				case 2: dia = "Martes";
				break;
				case 3: dia = "Miercoles";
				break;
				case 4: dia = "Jueves";
				break;
				case 5: dia = "Viernes";
				break;
				case 6: dia = "Sabado";
				break;
				case 7: dia = "Domingo";
				break;
				}
				System.out.println("Los días " + dia);
				System.out.println("Estamos desde la hora: " + diaRetiro.getHoraDesde());
				System.out.println("Hasta la hora: " + diaRetiro.getHoraHasta());
				System.out.println("Con un intervalo de atención de: " + diaRetiro.getIntervalo());
				System.out.println("");
			}		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("--DEMOSTRACIÓN DE EXCEPCIONES--\n");
		System.out.println("Error de día diferente del 1 al 7");
		try {
			almacen.agregarDiaRetiro(10, LocalTime.of(9, 30),LocalTime.of(20,30), 30);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Error de fecha desde en null");
		try {
			almacen.agregarDiaRetiro(5, null,LocalTime.of(20,30), 30);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Error de fecha hasta en null");
		try {
			almacen.agregarDiaRetiro(5, LocalTime.of(9, 30),null, 30);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Error de intervalo negativo");
		try {
			almacen.agregarDiaRetiro(5, LocalTime.of(9, 30),LocalTime.of(20,30), -5);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
