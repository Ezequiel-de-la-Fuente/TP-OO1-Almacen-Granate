package test.CU;

import java.time.LocalDate;
import java.time.LocalTime;
import comercio.Contacto;
import comercio.Ubicacion;
import comercio.Carrito;
import comercio.Cliente;
import comercio.Articulo;

public class TestC08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Contacto con =new Contacto("anafc@hotmail", "150303456", new Ubicacion(-45, 88));
		 Cliente Ana = new Cliente(1, con, "Fernandez", "Analia", 36500548); 
		  Articulo pepas=new Articulo("Pepas Pig","c-odigo-barra" , 9.50);
		  Articulo choco=new Articulo("Chocolate Milka","c-odigo-barra" , 80.50);
		  Articulo papas=new Articulo("Papas Lays","c-odigo-barra" , 20.00);
		  
		  
		  Carrito carroEjemplo = new Carrito(LocalDate.now(), LocalTime.now(), false, 0, Ana);
		  carroEjemplo.agregarItem(papas, 1);
		  carroEjemplo.agregarItem(pepas, 2);
		  System.out.println(carroEjemplo);
		  try {
			  	carroEjemplo.borrarItem(choco, 3);
		       }
		  catch (Exception e) {
					System.out.println(e.getMessage());
				}
		carroEjemplo.borrarItem(pepas, 1);		
		System.out.println(carroEjemplo);	  
		  
	}

}
