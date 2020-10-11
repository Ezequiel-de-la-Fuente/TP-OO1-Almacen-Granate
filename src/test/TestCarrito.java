package test;

import java.time.LocalDate;
import java.time.LocalTime;
import comercio.Entrega;
import comercio.Articulo;
import comercio.Carrito;
import comercio.Cliente;
import comercio.Contacto;
import comercio.Ubicacion;


public class TestCarrito {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Entrega entrega = new Entrega(LocalDate.now(), true);
		Contacto contacto1 = new Contacto("abbruzzesemax@gmail.com", "11 5160 9898" ,new Ubicacion(28, 15));
		Cliente cliente = new Cliente(1, contacto1, "Abbruzzese","Maximiliano", 38154177);
		Carrito carrito1 = new Carrito (LocalDate.now(), LocalTime.now(), false, 20.50,cliente,entrega);
		carrito1.agregarItem(new Articulo("coca", "11111111", 300), 3);
		
		System.out.println("Carrito con entrega:\n");
		System.out.println(carrito1);
		
		
		try {
			 carrito1.setEntrega(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			 carrito1.setCliente(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Carrito carrito2 = new Carrito (LocalDate.now(), LocalTime.now(), false, 20.50,cliente);
		carrito2.agregarItem(new Articulo("coca", "11111111", 300), 3);

		System.out.println("\n\nCarrito sin entrega:\n");
		System.out.println(carrito2);
	}

}
