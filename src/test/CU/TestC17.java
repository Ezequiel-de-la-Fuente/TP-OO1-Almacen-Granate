package test.CU;

import comercio.Cliente;
import comercio.Comercio;
import comercio.Contacto;
import comercio.Ubicacion;

public class TestC17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Contacto contactoAlmacen = new Contacto("almacen@gmail.com", "11 3123 7897", new Ubicacion(31, 12));
		Comercio almacen = new Comercio(24,contactoAlmacen,"Granate-Store","30-52745070-1",100,15.50,28,3,5);
		Contacto contactoCliente = new Contacto("anafc@gmail.com", "11 3030 3456", new Ubicacion(28, 10));
		Cliente cliente1=new Cliente(1,contactoCliente,"Fernandez","Ana",36500548);
    System.out.println("Ubicacion del almacen: "+almacen.traerUbicacion());
		System.out.println("Ubicacion del cliente: "+cliente1.traerUbicacion());
		
    try {
			 almacen.setContacto(null);
			 almacen.traerUbicacion();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			 cliente1.setContacto(null);
			 cliente1.traerUbicacion();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
