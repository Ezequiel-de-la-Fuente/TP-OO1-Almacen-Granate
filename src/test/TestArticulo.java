package test;

import comercio.Articulo;

public class TestArticulo {

	public static void main(String[] args) {
		Articulo articulo = new Articulo("Gallo Snack Salados", "7790070411365", 60);
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
		
		try {
			articulo.setCodBarras("1111112531"); //Código de barras menor a 13 digitos. 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			articulo.setCodBarras("1111112531123"); //Código de barras de 13 digitos pero invalido. 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//TODO: Falta la prueba del cod de barras que se hace con el CU 

	}

}
