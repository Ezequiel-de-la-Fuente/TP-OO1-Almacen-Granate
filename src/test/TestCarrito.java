package test;

import java.time.LocalDate;
import java.time.LocalTime;
import comercio.Entrega;
import comercio.Carrito;
import comercio.Cliente;
import comercio.Contacto;
import comercio.Ubicacion;


public class TestCarrito {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Entrega entrega = new Entrega(LocalDate.now(), true);
		Contacto contacto1 = new Contacto("abbruzzesemax@gmail.com", "1151609898" ,new Ubicacion(28, 15));
		Cliente cliente = new Cliente(1, contacto1, "Abbruzzese","Maximiliano", 38154177);
		Carrito carrito1 = new Carrito (LocalDate.now(), LocalTime.now(), false, 20.50,cliente,entrega);
				
		
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
		
	}

}
