package test.CU;

import comercio.Articulo;
import comercio.ItemCarrito;

public class TestCU9 {
    public static void main(String[] args) {
        Articulo articulo = new Articulo("Coca-Cola", "7790070411365", 125);
        ItemCarrito itemcarrito = new ItemCarrito(5,articulo);
        // System.out.println(itemcarrito);

        System.out.println("Si hay 5 cocas y c/una vale 125, el subtotal es 625");
        System.out.println("El subtotal es: " + itemcarrito.calcularSubTotalItem());
        
    }
}
