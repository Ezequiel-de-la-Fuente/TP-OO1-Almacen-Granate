package test.CU;

import java.time.LocalDate;
import java.time.LocalTime;

import comercio.Articulo;
import comercio.Carrito;

public class TestC13 {
    public static void main(final String[] args) {
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


    }
}
