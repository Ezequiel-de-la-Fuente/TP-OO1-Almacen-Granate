package test.CU;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import comercio.Articulo;
import comercio.Carrito;
import comercio.Cliente;
import comercio.Comercio;
import comercio.Contacto;
import comercio.Entrega;
import comercio.RetiroLocal;
import comercio.Ubicacion;

public class TestC02 {

	public static void main(String[] args) {
		Contacto contacto = new Contacto("almacen@gmail.com", "15 4567 7894", new Ubicacion(31, 12));
		Comercio almacen = new Comercio(24,contacto,"Granate-Store","30-52745070-1",100,15.50,28,3,5);
		Entrega entrega = new Entrega(LocalDate.now(), true);
		Cliente cliente = new Cliente(1, contacto, "Abbruzzese","Maximiliano", 38154177);
		Articulo pepas=new Articulo("Pepas Pig","7791762131394" , 9.50);
		RetiroLocal retiroLocal = new RetiroLocal(LocalDate.now(), true, LocalTime.of(15,30));
		RetiroLocal retiroLocal1 = new RetiroLocal(LocalDate.now(), true, LocalTime.of(10,30));
		RetiroLocal retiroLocal2 = new RetiroLocal(LocalDate.now(), true, LocalTime.of(12,30));

		Carrito carrito1 = new Carrito (LocalDate.now(), LocalTime.now(), false, 20.50,cliente,retiroLocal);
		Carrito carrito2 = new Carrito (LocalDate.now(), LocalTime.now(), false, 20.50,cliente,retiroLocal1);
		Carrito carrito3 = new Carrito (LocalDate.now(), LocalTime.now(), false, 20.50,cliente,retiroLocal2);

		ArrayList<Carrito> listaCarritos = new ArrayList<Carrito>();
		
		try {
			carrito1.agregarItem(pepas, 3);
			listaCarritos.add(carrito1);
			listaCarritos.add(carrito2);
			listaCarritos.add(carrito3);
			almacen.setLstCarrito(listaCarritos);
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
			//while(almacen.traerHoraRetiro(LocalDate.now())!= null) {
			for(int i = 0; i< listaCarritos.size();i++) {
			System.out.println("Hora:" + almacen.traerHoraRetiro(LocalDate.now()));
			}
			//}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
