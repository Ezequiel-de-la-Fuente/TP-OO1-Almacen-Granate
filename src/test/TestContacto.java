package test;

import comercio.Contacto;
import comercio.Ubicacion;

public class TestContacto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contacto contacto = new Contacto("ezequieldelafuente2001@gmail.com", "11 3633 6131", new Ubicacion(60, 50));
		System.out.println(contacto);
		try {
			contacto.setCelular(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			contacto.setCelular("101 1010 020");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			contacto.setEmail(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			contacto.setEmail("a@b.com");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			contacto.setUbicacion(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
