package test.CU;

import java.time.LocalDate;
import java.time.LocalTime;

import comercio.Articulo;
import comercio.Carrito;

public class TestC10 {
    public static void main(final String[] args) {
        Articulo articulo = new Articulo("Coca-Cola", "7790070411365", 125);
        Articulo articulo2 = new Articulo("Manaos","7790070411365",50);

        Carrito carrito = new Carrito(LocalDate.now(), LocalTime.now(), false, 5, null, null, 1);
        carrito.agregarItem(articulo, 5);
        carrito.agregarItem(articulo2, 10);

        System.out.println("Si hay 5 cocas y c/una vale 125, el subtotal es 625");
        System.out.println("Si hay 10 manaos y c/una vale 50, el subtotal es 500");
        System.out.println("El total seria 625 + 500 = 1125");
        System.out.println(carrito.calcularTotalCarrito());

    }
}
