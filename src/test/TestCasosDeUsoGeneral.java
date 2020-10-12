package test;

import java.time.LocalDate;
import java.time.LocalTime;
import comercio.Contacto;
import comercio.Envio;
import comercio.Ubicacion;
import comercio.Articulo;
import comercio.Carrito;
import comercio.Cliente;
import comercio.Comercio;
import comercio.RetiroLocal;

public class TestCasosDeUsoGeneral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Contacto contacto = new Contacto("almacen@gmail.com", "11 3123 7897", new Ubicacion(-34.7373213, -58.3892883));
		  Comercio almacen = new Comercio(24,contacto,"Granate-Store","30-52745070-1",100,15.50,28,3,5);
		  
		  Contacto contactoAna = new Contacto("anafc@gmail.com", "11 3030 3456", new Ubicacion(-34.8250834,-58.3943303));
		  Cliente clienteAna=new Cliente(1,contactoAna,"Fernandez","Ana",36500548);
		  
		  Contacto contactoMaxi = new Contacto("abbruzzesemax@gmail.com", "11 5160 9898" ,new Ubicacion(28, 15));
		  Cliente clienteMaxi = new Cliente(1, contactoMaxi, "Abbruzzese","Maximiliano", 38154177);
		
		  Contacto contactoLucas = new Contacto("lucas.brieva@gmail.com", "11 3487 9463", new Ubicacion(30, 50));
		  Cliente clienteLucas = new Cliente(2, contacto, "Brieva","Lucas", 39664602);
			
		  Contacto contactoEze = new Contacto("ezequieldelafuente2001@gmail.com", "11 3633 6131", new Ubicacion(60, 50));
		  Cliente clienteEze = new Cliente(3, contacto, "De La Fuente","Ezequiel", 42568324);
		  
		  Articulo pepas=new Articulo("Pepas Pig","7791762131394" , 9.50);
		  Articulo choco=new Articulo("Chocolate Milka","9780425270721" , 80.50);
		  Articulo papas=new Articulo("Papas Lays","7791274198991" , 20.00);
		  Articulo cocacola = new Articulo("Coca-Cola", "7790070411365", 125);
	          Articulo manaos = new Articulo("Manaos","7790070411365",50);
		  
		  Envio envio1 = new Envio(LocalDate.now(), true, LocalTime.of(20, 00, 00), LocalTime.of(18, 00, 00), 8, new Ubicacion(-34.8080732,-58.3981827));
		  RetiroLocal retiroLocal = new RetiroLocal(LocalDate.now(), true, LocalTime.of(12,30));  
		  
		  almacen.agregarCarrito(LocalDate.of(2020,10 , 28), LocalTime.of(20, 55), false, 10,envio1, clienteAna);
		  almacen.agregarCarrito(LocalDate.of(2020,10 , 28), LocalTime.of(20, 55), false, 10,retiroLocal, clienteMaxi);
		 
		
		 System.out.println(almacen);
			
	}

}
