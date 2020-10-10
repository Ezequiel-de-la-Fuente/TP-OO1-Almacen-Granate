package test;
import comercio.Cliente;
import comercio.Contacto;
import comercio.Ubicacion;
public class TestCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Contacto contacto = new Contacto("anafc@gmail.com", "11 3030 3456", new Ubicacion(28, 10));
		Cliente cliente1=new Cliente(1,contacto,"Fernandez","Ana",36500548);
		System.out.println(cliente1);
		
		try {
			 cliente1.setContacto(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			cliente1.setContacto(null);
			System.out.println(cliente1.traerUbicacion());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			 cliente1.setDni(10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			 cliente1.setDni(107891234);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
