package com.techlab.clase6;

import java.util.ArrayList;

public class Carrito {
    private ArrayList<Producto> productos = new ArrayList<>();


    public void sumarProductos(Producto p){
        this.productos.add(p);
    }

    public double calcularTotal(){
        double total = 0;

       for (Producto p: this.productos){
           total += p.getPrecio() * p.getCantidad();
       }

        return total;
    }
}
