package com.techlab.backend.productos;

public abstract class Producto {
    private String nombre;
    private double precio;
    private String tipoRecipiente = "Taza";
    private int cantidad;
    private int id;
    private static int contador=1;

    public Producto(String nom, double prec, int cant){
        this.id = contador;
        this.nombre = nom;
        this.precio = prec;
        this.cantidad = cant;
        contador++;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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

        return "ID: "+this.id+", Producto: "+this.nombre+", Precio: $"+this.precio+", Cantidad: "+this.cantidad;
    }

    // Verifica si el id buscado es el del objeto
    public boolean coincideId(int id) {
        return this.id == id;
    }
}