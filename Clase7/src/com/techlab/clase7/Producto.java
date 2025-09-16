package com.techlab.clase7;

public abstract class Producto {
    private String nombre;
    private double precio;
    private String tipoRecipiente = "Taza";

    public Producto(String nom, double prec){

        this.nombre = nom;
        this.precio = prec;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipoRecipiente() {
        return tipoRecipiente;
    }

    public void tipoRecipiente(String tipo){
        tipoRecipiente = tipo;
    }

    public abstract  double calcularPrecioFinal();
}