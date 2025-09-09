package com.techlab.clase5;


public class Clase5 {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Angel","an@gmail.com");
        Cliente c2 = new Cliente("Sofia","sofi@gmail.com");
        Cliente c3 = new Cliente("Alice","alice@gmail.com");

        Producto p1 = new Producto("Café Premium Molido",250.0,100);
        Producto p2 = new Producto("Capuccino",300.0,150);
        Producto p3 = new Producto("Chocolate Caliente",150.0,50);
        Producto p4 = new Producto("Café Americano",200.0,200);

        p1.mostrarInformacion();
        System.out.println( "Descuento: $"+Producto.calcularImpuesto(p1.getPrecio()));
        p2.mostrarInformacion();
        System.out.println( "Descuento: $"+Producto.calcularImpuesto(p2.getPrecio()));
        p3.mostrarInformacion();
        System.out.println( "Descuento: $"+Producto.calcularImpuesto(p3.getPrecio()));
        p4.mostrarInformacion();
        System.out.println( "Descuento: $"+Producto.calcularImpuesto(p4.getPrecio()));


        c1.mostrarInformacion();
        c2.mostrarInformacion();
        c3.mostrarInformacion();
    }
}
