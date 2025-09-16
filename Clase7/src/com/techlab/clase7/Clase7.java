package com.techlab.clase7;

import java.util.ArrayList;

public class Clase7 {
    public static void main(String[] args) {
        Te p1 = new Te("Té Chai",45.0);
        Cafe p2 = new Cafe("Café Americano",70.0);

        System.out.println(p1.calcularPrecioFinal());
        System.out.println(p2.calcularPrecioFinal());


        ArrayList<Producto> prds = new ArrayList<>();
        prds.add(new Te("Té Chai",45.0));
        prds.add(new Te("Té Verde",25.0));
        prds.add(new Cafe("Café Americano",65.0));
        prds.add(new Cafe("Café Negro",75.0));

        prds.get(2).tipoRecipiente("Vaso de Papel");

        for ( int i=0; i<prds.size(); i++) {
            System.out.println("Producto: "+prds.get(i).getNombre()+", Precio: $"+prds.get(i).calcularPrecioFinal()+", En: "+prds.get(i).getTipoRecipiente());
        }

        Cafe c1 = new Cafe("Café Negro",50.0);
        Te t1 = new Te("Té Chai",50.0);

        System.out.println("Producto: "+t1.getNombre()+", Descuento: $"+t1.aplicarDescuento(54.5));
        System.out.println("Producto: "+c1.getNombre()+", Descuento: $"+c1.aplicarDescuento(50));


    }
}
