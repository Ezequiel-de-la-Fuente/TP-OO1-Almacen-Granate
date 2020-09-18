package test.CU;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import comercio.Articulo;
import comercio.Itemcarrito;
import comercio.Carrito;

public class TestC12 {
    public static void main(final String[] args) {
        Articulo articulo = new Articulo("Coca-Cola", "| ||||| || ||| |", 125);
        Articulo articulo2 = new Articulo("Manaos","|||| ||| |||",50);
        Itemcarrito itemcarrito = new Itemcarrito(5,articulo);
        Itemcarrito itemcarrito2 = new Itemcarrito(10, articulo2);
        ArrayList<Itemcarrito> lstItemcarrito = new ArrayList<Itemcarrito>();
        lstItemcarrito.add(itemcarrito);
        lstItemcarrito.add(itemcarrito2);

        Carrito carrito = new Carrito(0, LocalDate.now(), LocalTime.now(), false, 5, null, lstItemcarrito, null);
        System.out.println("Si hay 5 cocas y c/una vale 125, el subtotal es 625");
        System.out.println("Si hay 10 manaos y c/una vale 50, el subtotal es 500");
        System.out.println("El total seria 625 + 500 = 1125");
        System.out.println(carrito.calcularTotalCarrito());

        System.out.println("Pero si le aplicamos un descuento del 5%, el resultado deberia ser 1125 - 1125*0.05 = " + (1125 - 1125*0.05));
        System.out.println("EL nuevo total es: " + carrito.calcularDescuentoEfectivo(5));

    }
}

