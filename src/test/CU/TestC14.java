package test.CU;

import java.time.LocalDate;
import java.time.LocalTime;

import comercio.Articulo;
import comercio.Carrito;

public class TestC14 {

	public static void main(String[] args) {
		Articulo articulo = new Articulo("Coca-Cola", "7790070411365", 125);
        Articulo articulo2 = new Articulo("Manaos","7790070411365",50);

        Carrito carrito = new Carrito(LocalDate.now(), LocalTime.now(), false, 5, null, null);
        carrito.agregarItem(articulo, 5);
        carrito.agregarItem(articulo2, 10);
        System.out.println("El dia actual es " + LocalDate.now().getDayOfWeek().getValue() + ", y se pasa un 4");
        System.out.println("Decuento del dia: 10% y DescuentoEfectico: 15%");
        carrito.calcularDescuentoCarrito(4, 10, 15);
        System.out.println("El nuevo descuento es: " + carrito.getDescuento());


        System.out.println("El dia actual es " + LocalDate.now().getDayOfWeek().getValue() + ", y se pasa un 5");
        System.out.println("Decuento del dia: 25% y DescuentoEfectico: 10%");
        carrito.calcularDescuentoCarrito(5, 25, 10);
        System.out.println("El nuevo descuento es: " + carrito.getDescuento());
        System.out.println("Si hay 5 cocas y c/una vale 125, el subtotal es 625");
        System.out.println("Si hay 10 manaos y c/una vale 50, el subtotal es 500");
        System.out.println("El total seria 625 + 500 = 1125");
        System.out.println(carrito.calcularTotalCarrito());

        System.out.println("Pero si le aplicamos un descuento del 5%, el resultado deberia ser 1125 - 1125*0.05 = " + (1125 - 1125*0.05));
        System.out.println("EL nuevo total es: " + carrito.calcularDescuentoEfectivo(5));
        System.out.println("Si hay 5 cocas y c/una vale 125, el subtotal es 625");
        System.out.println("Si hay 10 manaos y c/una vale 50, el subtotal es 500");
        System.out.println("El total seria 625 + 500 = 1125");
        System.out.println(carrito.calcularTotalCarrito());

        System.out.println("Pero si le aplicamos un descuento del 10%, el resultado deberia ser 1125 - 1125*0.1 = " + (1125 - 1125*0.1));
        try {
            System.out.println("EL nuevo total es: " + carrito.calcularDescuentoDia(LocalDate.now().getDayOfWeek().getValue(), 10));
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println("EL nuevo total es: " + carrito.calcularDescuentoDia(1, 10));
        } catch (Exception e) {
            System.out.println(e);
        }

	}

}
