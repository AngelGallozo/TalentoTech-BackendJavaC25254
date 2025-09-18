package com.techlab.productos;

public class Te extends Producto implements Descontable{
    public Te(String nom, double prec,int cant) {
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