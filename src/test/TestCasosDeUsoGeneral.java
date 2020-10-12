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

public class TestCasosDeUsoGeneral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Contacto contacto = new Contacto("almacen@gmail.com", "11 3123 7897", new Ubicacion(-34.7373213, -58.3892883));
		  Comercio almacen = new Comercio(24,contacto,"Granate-Store","30-52745070-1",100,15.50,28,3,5);
		  
		  Contacto contactoAna = new Contacto("anafc@gmail.com", "11 3030 3456", new Ubicacion(-34.8250834,-58.3943303));
		  Cliente clienteAna=new Cliente(1,contactoAna,"Fernandez","Ana",36500548);
		
		  Articulo pepas=new Articulo("Pepas Pig","7791762131394" , 9.50);
		  Articulo choco=new Articulo("Chocolate Milka","9780425270721" , 80.50);
		  Articulo papas=new Articulo("Papas Lays","7791274198991" , 20.00);
		  
		  
		  //almacen.agregarCarrito(LocalDate.of(2020,10 , 28), LocalTime.of(20, 55), false, 10, clienteAna);
		 
		 System.out.println(almacen);
			
	}

}
