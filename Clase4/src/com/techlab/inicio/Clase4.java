package com.techlab.inicio;

public class Clase4 {
    public static void main(String[] args) {
        System.out.println("Precio Final: "+calcularDescuento(1000,50));
        System.out.println("Precio Final: "+calcularDescuento(2000,50));
        System.out.println("Precio Final: "+calcularDescuento(3000,50));
        System.out.println("Precio Final: "+calcularDescuento(4000,50));

        System.out.println("------------------------------------------------------------------");
        System.out.println("Precio Final: "+calcularPrecioFinal(1000,50, 10));
        System.out.println("Precio Final: "+calcularPrecioFinal(2000,50,20 ));
        System.out.println("Precio Final: "+calcularPrecioFinal(3000,50,60));
        System.out.println("Precio Final: "+calcularPrecioFinal(4000,50,100));

        System.out.println("------------------------------------------------------------------");
        System.out.println(mostrarMensaje("Juan"));
        System.out.println(mostrarMensaje("Pedro",3));
        System.out.println(mostrarMensaje("Luis",5));

    }


    public static double calcularDescuento(double precio, double procentajeImpuesto){
        double impuesto = precio*(procentajeImpuesto/100);
        return precio - impuesto;
    }

    public static double calcularPrecioFinal(double precio, double procentajeBase, int cantidad){
        if(cantidad>50){
            procentajeBase +=5; // Aumentamos el descuenta si compra más de 50 unidades
        }

        return calcularDescuento(precio, procentajeBase);
    }


    public static String mostrarMensaje(String nombre){
        return "Bienvenido a nuestra tienda "+nombre;
    }

    public static String mostrarMensaje(String nombre, int veces){
        return "Bienvenido a nuestra tienda "+nombre+" por "+veces+" vez.";
    }

}
