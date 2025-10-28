package com.techlab.backend.productos;

public class Comida extends Producto implements Descontable{

    public Comida(String nom, double prec,int cant) {
        super(nom,prec,cant);
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio()*0.80;
    }

    @Override
    public void tipoRecipiente(String tipo) {
        super.tipoRecipiente(tipo);
    }

    @Override
    public double aplicarDescuento(double percent) {
        return (getPrecio() - (getPrecio()*percent/100));
    }
}