package com.techlab.clase7;

public class Cafe extends Producto implements Descontable{

    public Cafe(String nom, double prec) {
        super(nom,prec);
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

