package com.techlab.clase6;

public class Clase6 {
    public static void main(String[] args) {
        Producto p1 = new Producto("Café Molido Premium", 40.0,2);
        Producto p2 = new Producto("Chocolatada", 80.0,4);
        Producto p3 = new Producto("Café Americano", 140.0,7);
        Producto p4 = new Producto("Capucciono", 230.0,20);


        Carrito carrito = new Carrito();

        carrito.sumarProductos(p1);
        carrito.sumarProductos(p2);
        carrito.sumarProductos(p3);
        carrito.sumarProductos(p4);

        p1.setCantidad(10);
    }
}
