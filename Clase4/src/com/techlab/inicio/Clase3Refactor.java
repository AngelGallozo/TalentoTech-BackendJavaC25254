package com.techlab.c3;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Clase3Refactor {
    public static void main(String[] args) {
        String prd = " té CHAi" ;
        String nuevoPrd = formatearNombreProducto(prd);
        System.out.println(nuevoPrd);
        System.out.println("Longitud de "+nuevoPrd+" "+nuevoPrd.length());

        if (nuevoPrd.contains("Chai")) {
            System.out.println("Contiene la palabra Chai");
        }else{
            System.out.println("NO Contiene la palabra Chai");
        }

        System.out.println("_________________");
        System.out.println("Array");
        System.out.println("_________________");


        String[] productos = new String[5];

        productos[0] = "Cafe Premium Molido";
        productos[1] = "Chocolate Amargo 80%";
        productos[2] = "Cafe Americano";
        productos[3] = "Capuccino";
        productos[4] = "Leche";

        mostrarArray(productos);

        // productos[5] = "Desconocido"; // Da error ya que es estatico el array

        ArrayList<String> listaProductos = new ArrayList<String>();

        listaProductos.add("Cafe Premium Molido");
        listaProductos.add("Chocolate Amargo 80%");
        listaProductos.add("Cafe Americano");
        listaProductos.add("Capuccino");
        listaProductos.add("Leche");
        //listaProductos.add("Gaseosa");

        System.out.println("_________________");
        System.out.println("ArrayList");
        System.out.println("_________________");
        mostrarArray(listaProductos);

        listaProductos.remove("Leche");

        System.out.println("_________________");
        System.out.println("ArrayList");
        System.out.println("_________________");
        mostrarArray(listaProductos);

        if (listaProductos.contains("Gaseosa")){
            System.out.println("Existe el producto Gaseosa.");
        }else{
            System.out.println("No existe el producto Gaseosa.");
        }



        // Mostrar lista de productos prolijos y desprolijos
        ArrayList<String> listaProductosSinFormato = new ArrayList<String>();
        ArrayList<String> listaProductosFormateada = new ArrayList<String>();

        listaProductosSinFormato.add("CaFE PremIUm moliDo");
        listaProductosSinFormato.add("choCOLate AMARgo 80%");
        listaProductosSinFormato.add("cAfe AmEricANo");
        listaProductosSinFormato.add("capUccInO");
        listaProductosSinFormato.add("LeCHE");

        System.out.println("_________________");
        System.out.println("Antes del Formateo");
        System.out.println("_________________");
        mostrarArray(listaProductos);


        for (String prdSinFormato: listaProductosSinFormato){
            listaProductosFormateada.add(formatearNombreProducto(prdSinFormato));
        }
        System.out.println("_________________");
        System.out.println("Despues del Formateo");
        System.out.println("_________________");
        mostrarArray(listaProductosFormateada);


    }

    public static String formatearNombreProducto(String texto){

        // Eliminar espacios extras
        texto = texto.trim();

        // Pasar todo a minusculas
        texto = texto.toLowerCase();

        String[] palabras = texto.split(" ");

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < palabras.length; i++){
            if(!palabras[i].isEmpty()){
                String primeraLetra = palabras[i].substring(0,1).toUpperCase();

                String resto = palabras[i].substring(1);

                sb.append(primeraLetra).append(resto);

                if (i<palabras.length-1) {
                    sb.append(" ");
                }

            }
        }

        return sb.toString();
    }


    public static void mostrarArray(String[] array){
        for(int i = 0; i<array.length; i++){
            System.out.println("Producto: "+array[i]);
        }
    }

    public static void mostrarArray(ArrayList<String> array){
        for(String itemProd: array){
            System.out.println("Producto: "+itemProd);
        }
    }
}
