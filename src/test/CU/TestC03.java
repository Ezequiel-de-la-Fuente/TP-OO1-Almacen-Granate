package test.CU;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import comercio.Articulo;
import comercio.Carrito;
import comercio.Cliente;
import comercio.Comercio;
import comercio.Contacto;
import comercio.Entrega;
import comercio.Turno;
import comercio.Ubicacion;

public class TestC03 {

	public static void main(String[] args) {
		Contacto contacto = new Contacto("almacen@gmail.com", "15 4567 7894", new Ubicacion(31, 12));
		Comercio almacen = new Comercio(24,contacto,"Granate-Store","30-52745070-1",100,15.50,28,3,5);
		Entrega entrega = new Entrega(LocalDate.now(), true);
		Cliente cliente = new Cliente(1, contacto, "Abbruzzese","Maximiliano", 38154177);
		Articulo pepas=new Articulo("Pepas Pig","7791762131394" , 9.50);
		Carrito carrito1 = new Carrito (LocalDate.now(), LocalTime.now(), false, 20.50,cliente,entrega);
		ArrayList<Carrito> listaCarritos = new ArrayList<Carrito>();
		LocalDate dia = null;
		
		try {
			carrito1.agregarItem(pepas, 3);
			listaCarritos.add(carrito1);
			almacen.setLstCarrito(listaCarritos);
			//System.out.println(almacen.getLstCarrito());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());

		}
		try {
			almacen.agregarDiaRetiro(5, LocalTime.of(9, 30),LocalTime.of(20,30), 30);
			almacen.agregarDiaRetiro(1,LocalTime.of( 8, 30), LocalTime.of( 21, 30),25);
			almacen.agregarDiaRetiro(2,LocalTime.of( 7, 30), LocalTime.of( 19, 30),10);
			almacen.agregarDiaRetiro(3,LocalTime.of( 8, 00), LocalTime.of( 21, 00),20);
			almacen.agregarDiaRetiro(4,LocalTime.of( 9, 00), LocalTime.of( 22, 00),15);
			almacen.agregarDiaRetiro(6,LocalTime.of( 10, 30), LocalTime.of( 22, 30),40);
			almacen.agregarDiaRetiro(7,LocalTime.of( 8, 30), LocalTime.of( 21, 30),50);
						
			//System.out.println(almacen.getLstDiaRetiro());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//while(almacen.traerHoraRetiro(LocalDate.now())!= null) {
			List<Turno> turnoLibre = almacen.generarTurnosLibres(LocalDate.now());
			System.out.println("--TURNOS LIBRES--");
			for(Turno turno : turnoLibre) {
				dia = turno.getDiaTurno();
			}
			System.out.println("Dia: " + dia);
			for (Turno turno : turnoLibre) {
				System.out.println("Hora:"  + turno.getHoraTurno());
			}	
			//}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
