package com.techlab;

import com.techlab.exceptions.ProductoNoEncontradoException;
import com.techlab.exceptions.StockInsuficienteException;
import com.techlab.productos.Cafe;
import com.techlab.productos.Producto;
import com.techlab.productos.Te;

import java.util.ArrayList;
import java.util.Scanner;

public class Clase8 {
    public static void main(String[] args) {
        ArrayList<Producto> prds = new ArrayList<>();
        prds.add(new Te("Té Chai",45.0,20));
        prds.add(new Te("Té Verde",25.0,20));
        prds.add(new Cafe("Café Americano",65.0,20));
        prds.add(new Cafe("Café Negro",75.0,20));

        try {
            Producto p =  buscarProductoPorNombre("Cafe",prds);
            System.out.println("Producto Encontrado: "+ p.getNombre());
        }catch (ProductoNoEncontradoException e){
            System.out.println("No se encontró producto: "+e.getMessage());
        }finally {
            System.out.println("Operacion de busqueda finalizada.");
        }


        try {
            comprarProducto(prds);
        }catch (StockInsuficienteException e){
            System.out.println("No hay Stock suficiente: "+e.getMessage());
        }finally {
            System.out.println("Operacion de compra finalizada.");
        }

    }

    private static Producto buscarProductoPorNombre(String prd, ArrayList<Producto> prds) throws ProductoNoEncontradoException {
        Producto prdEncontrado = null;
        for (Producto p: prds){
            if (p.getNombre().equals(prd)){
                prdEncontrado = p;
            }
        }

        if (prdEncontrado == null){
            throw new ProductoNoEncontradoException("El producto " + prd + " no existe.");
        }

        return prdEncontrado;
    }

    private static void comprarProducto(ArrayList<Producto> prds) throws StockInsuficienteException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Productos:");
        System.out.println("______________");

        for(int i=0;i<prds.size();i++){
            System.out.println(i+")"+prds.get(i).getNombre());
        }
        System.out.println("______________");
        System.out.println("Elige el producto a comprar: ");
        int opcion = scanner.nextInt();
        System.out.println("Cantidad a comprar: ");
        int cantidadComprar = scanner.nextInt();
        if (cantidadComprar>prds.get(opcion).getCantidad()){
            throw new StockInsuficienteException("El producto "+prds.get(opcion).getNombre()+" no tiene stock suficiente.");
        }else{
            System.out.println("Producto "+prds.get(opcion).getNombre()+" con Stock Disponible.");
        }
    }
}
