package test.CU;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


import comercio.Carrito;
import comercio.Cliente;
import comercio.Comercio;
import comercio.Contacto;
import comercio.RetiroLocal;
import comercio.Turno;
import comercio.Ubicacion;

public class TestC04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RetiroLocal retiroLocal1 = new RetiroLocal(LocalDate.now(), true, LocalTime.of(15,30));
		RetiroLocal retiroLocal2 = new RetiroLocal(LocalDate.now(), true, LocalTime.of(10,30));
		RetiroLocal retiroLocal3 = new RetiroLocal(LocalDate.now(), true, LocalTime.of(12,30));
	
		Contacto contacto = new Contacto("almacen@gmail.com", "15 4567 7894", new Ubicacion(31, 12));
		Comercio almacen = new Comercio(24,contacto,"Granate-Store","30-52745070-1",100,15.50,28,3,5);
		Cliente cliente = new Cliente(1, contacto, "Abbruzzese","Maximiliano", 38154177);
		Carrito carrito1 = new Carrito (LocalDate.now(), LocalTime.now(), false, 20.50,cliente,retiroLocal1, 1);
		Carrito carrito2 = new Carrito (LocalDate.now(), LocalTime.now(), false, 20.50,cliente,retiroLocal2, 2);
		Carrito carrito3 = new Carrito (LocalDate.now(), LocalTime.now(), false, 20.50,cliente,retiroLocal3, 3);
		ArrayList<Carrito> listaCarritos = new ArrayList<Carrito>();
		LocalDate dia = null;
		
		try {
			
			listaCarritos.add(carrito1);
			listaCarritos.add(carrito2);
			listaCarritos.add(carrito3);
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
			almacen.agregarDiaRetiro(7,LocalTime.of( 8, 30), LocalTime.of( 21, 30),30);
						
			//System.out.println(almacen.getLstDiaRetiro());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//while(almacen.traerHoraRetiro(LocalDate.now())!= null) {
			List<Turno> turnoLibre = almacen.generarTurnosOcupados(LocalDate.now());
			System.out.println("--TURNOS OCUPADOS--");
			for(Turno turno : turnoLibre) {
				dia = turno.getDiaTurno();
			}
			System.out.println("Dia: " + dia);
			for (Turno turno : turnoLibre) {
				if(turno.isOcupado() == false) {
					System.out.println("Hora:"  + turno.getHoraTurno() + " \nEstado:Disponible\n");
				}	else {
					System.out.println("Hora:"  + turno.getHoraTurno() + " \nEstado:Ocupado\n");
			}
			}	
			//}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
