package test.CU;

import java.time.LocalDate;
import java.time.LocalTime;
import comercio.Envio;
import comercio.Ubicacion;


public class TestC16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
      Envio envio1 = new Envio(LocalDate.now(), true, LocalTime.now(), LocalTime.now(), 8, new Ubicacion(-34.8080732,-58.3981827));
		  envio1.setCosto(new Ubicacion(-34.8285678,-58.3915826), 400, 8);
		  System.out.println("Costo Fijo $400 y Costo por Km $8");
		  System.out.println("Las locaciones se encuentran a un poco mas de 2km");
		  System.out.println("Costo de envio es: " + envio1.getCosto());
			
	}

}
