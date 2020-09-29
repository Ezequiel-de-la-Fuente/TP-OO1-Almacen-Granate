package test;

import comercio.Articulo;

public class TestArticulo {

	public static void main(String[] args) {
		Articulo articulo = new Articulo("Oreos", "111111111", 18);
		System.out.println(articulo);
		
		try {
			articulo.setNombre(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			articulo.setPrecio(-100);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//TODO: Falta la prueba del cod de barras que se hace con el CU 

	}

}
