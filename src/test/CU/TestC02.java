package test.CU;

import java.time.LocalDate;
import java.time.LocalTime;
import comercio.Cliente;
import comercio.Comercio;
import comercio.Contacto;
import comercio.RetiroLocal;
import comercio.Ubicacion;

public class TestC02 {

	public static void main(String[] args) {
		Contacto contacto = new Contacto("almacen@gmail.com", "15 4567 7894", new Ubicacion(31, 12));
		Comercio almacen = new Comercio(24,contacto,"Granate-Store","30-52745070-1",100,15.50,28,3,5);
		Cliente cliente = new Cliente(1, contacto, "Abbruzzese","Maximiliano", 38154177);
		Cliente cliente1 = new Cliente(2, contacto, "Brieva","Lucas", 39664602);
		Cliente cliente2 = new Cliente(3, contacto, "De La Fuente","Ezequiel", 42568324);

		RetiroLocal retiroLocal = new RetiroLocal(LocalDate.now(), true, LocalTime.of(15,30));
		RetiroLocal retiroLocal1 = new RetiroLocal(LocalDate.now(), true, LocalTime.of(10,30));
		RetiroLocal retiroLocal2 = new RetiroLocal(LocalDate.now(), true, LocalTime.of(12,30));

				
		try {
			almacen.agregarCarrito(LocalDate.now(), LocalTime.now(), false, 20.50, retiroLocal, cliente);
			almacen.agregarCarrito(LocalDate.now(), LocalTime.now(), false, 20.50, retiroLocal1, cliente1);
			almacen.agregarCarrito(LocalDate.now(), LocalTime.now(), false, 20.50, retiroLocal2, cliente2);

			System.out.println(almacen.getLstCarrito());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			almacen.agregarDiaRetiro(5, LocalTime.of(8, 30),LocalTime.of(20,30), 30);
			almacen.agregarDiaRetiro(7,LocalTime.of( 8, 30), LocalTime.of( 21, 30),30);
			almacen.agregarDiaRetiro(1,LocalTime.of( 8, 30), LocalTime.of( 21, 30),30);
			almacen.agregarDiaRetiro(2,LocalTime.of( 8, 30), LocalTime.of( 19, 30),30);
			almacen.agregarDiaRetiro(3,LocalTime.of( 8, 00), LocalTime.of( 21, 00),30);
			almacen.agregarDiaRetiro(4,LocalTime.of( 8, 00), LocalTime.of( 22, 00),30);
			almacen.agregarDiaRetiro(6,LocalTime.of( 8, 30), LocalTime.of( 22, 30),30);						
			System.out.println(almacen.getLstDiaRetiro());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		try {
			System.out.println("Hora:" + almacen.traerHoraRetiro(LocalDate.now()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
