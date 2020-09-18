package test.CU;

import comercio.Articulo;
import comercio.Itemcarrito;

public class TestCU9 {
    public static void main(String[] args) {
        Articulo articulo = new Articulo("Coca-Cola", "| ||||| || ||| |", 125);
        Itemcarrito itemcarrito = new Itemcarrito(5,articulo);
        // System.out.println(itemcarrito);

        System.out.println("Si hay 5 cocas y c/una vale 125, el subtotal es 625");
        System.out.println("El subtotal es: " + itemcarrito.calcularSubTotalItem());
        
    }
}
