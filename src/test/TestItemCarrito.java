package test;

import comercio.ItemCarrito;
import comercio.Articulo;



public class TestItemCarrito {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ItemCarrito itemcarrito1 = new ItemCarrito (20, new Articulo("fideos", "7794360936019", 17.50));
		System.out.println(itemcarrito1);
		
		
		try {
			itemcarrito1.setCantidad(0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

}
}
