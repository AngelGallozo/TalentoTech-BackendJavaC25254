package com.techlab.clase6;

public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;
    private static int cantidadCreados = 0;

    public Producto(String nom, double prec, int cant){
        this.nombre = nom;
        this.precio = prec;
        this.cantidad = cant;
        cantidadCreados += 1;
        System.out.println("Cantidad de Productos creados: "+cantidadCreados);
    }

    public double getPrecio() {
        return precio;
    }
    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cant) {

        if (cant>0) {
            this.cantidad = cant;
        }else{
            System.out.println("Error(!) Cantidad incorrecta..");
        }
    }

    public void mostrarInformacion(){
        System.out.println("Producto: "+this.nombre+", Precio: $"+this.precio+", Stock: "+this.cantidad);
    }

    public static double calcularImpuesto(double precio){
        return precio * 0.10; // 10% de impuesto
    }
}