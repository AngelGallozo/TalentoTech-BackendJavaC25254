package com.techlab.clase5;

public class Producto {
    private String nombre;
    private double precio;
    private int cantidadStock;

    public Producto(String nom, double prec, int cantStock){
        this.nombre = nom;
        this.precio = prec;
        this.cantidadStock = cantStock;
    }

    public double getPrecio() {
        return precio;
    }

    public void mostrarInformacion(){
        System.out.println("Producto: "+this.nombre+", Precio: $"+this.precio+", Stock: "+this.cantidadStock);
    }

    public static double calcularImpuesto(double precio){
        return precio * 0.10; // 10% de impuesto
    }
}
