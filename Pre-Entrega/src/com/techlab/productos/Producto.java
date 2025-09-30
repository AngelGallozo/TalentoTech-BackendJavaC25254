package com.techlab.productos;

public abstract class Producto {
    private String nombre;
    private double precio;
    private String tipoRecipiente = "Taza";
    private int cantidad;

    public Producto(String nom, double prec, int cant){

        this.nombre = nom;
        this.precio = prec;
        this.cantidad = cant;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getTipoRecipiente() {
        return tipoRecipiente;
    }

    public void tipoRecipiente(String tipo){
        tipoRecipiente = tipo;
    }

    public abstract  double calcularPrecioFinal();

    @Override
    public String toString() {

        return "Producto: "+this.nombre+", Precio: $"+this.precio+", Cantidad: "+this.cantidad;
    }
}