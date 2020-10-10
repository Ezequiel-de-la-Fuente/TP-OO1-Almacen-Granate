package test.CU;

import comercio.Articulo;

public class TestC07 {

	public static void main(String[] args) {
		Articulo articulo = new Articulo("Gallo Snack Salados", "7790070411365", 60);
		System.out.println(articulo.getCodBarras());
				
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

	}

}
