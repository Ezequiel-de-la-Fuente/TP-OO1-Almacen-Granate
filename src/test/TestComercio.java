package test;
import comercio.Comercio;
import comercio.Contacto;
import comercio.Ubicacion;

public class TestComercio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contacto contacto = new Contacto("almacen@gmail.com", "11 3123 7897", new Ubicacion(31, 12));
		Comercio almacen = new Comercio(24,contacto,"Granate-Store","30-52745070-1",100,15.50,28,3,5);
		System.out.println(almacen);
		try {
			 almacen.setContacto(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			 almacen.setCuit("30-45687989-1");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
