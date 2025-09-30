package com.techlab.productos;

public class Bebida extends Producto implements Descontable{
    public Bebida(String nom, double prec,int cant) {
        super(nom,prec,cant);
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio()*0.95;
    }

    @Override
    public double aplicarDescuento(double percent) {
        return (getPrecio() - (getPrecio()*percent/100));
    }
}