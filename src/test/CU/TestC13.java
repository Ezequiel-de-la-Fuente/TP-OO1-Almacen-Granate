package test.CU;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import comercio.Articulo;
import comercio.Itemcarrito;
import comercio.Carrito;

public class TestC13 {
    public static void main(final String[] args) {
        Articulo articulo = new Articulo("Coca-Cola", "| ||||| || ||| |", 125);
        Articulo articulo2 = new Articulo("Manaos","|||| ||| |||",50);
        Itemcarrito itemcarrito = new Itemcarrito(5,articulo);
        Itemcarrito itemcarrito2 = new Itemcarrito(10, articulo2);
        ArrayList<Itemcarrito> lstItemcarrito = new ArrayList<Itemcarrito>();
        lstItemcarrito.add(itemcarrito);
        lstItemcarrito.add(itemcarrito2);

        Carrito carrito = new Carrito(0, LocalDate.now(), LocalTime.now(), false, 5, null, lstItemcarrito, null);
        System.out.println("Decuento del dia: 10 y DescuentoEfectico: 15");
        carrito.calcularDescuentoCarrito(3, 10, 15);
        System.out.println("El nuevo descuento es: " + carrito.getDescuento());

        System.out.println("Decuento del dia: 25 y DescuentoEfectico: 10");
        carrito.calcularDescuentoCarrito(3, 25, 10);
        System.out.println("El nuevo descuento es: " + carrito.getDescuento());


    }
}