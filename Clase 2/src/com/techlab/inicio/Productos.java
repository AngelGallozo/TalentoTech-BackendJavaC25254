package com.techlab.inicio;
import java.util.Scanner;

public class Productos {

    public static void main(String[] args) {
        // Definicion de variables
        int stock = 150;
        double precioUnitario=200;
        int cantidadProdsCliente;
        String nombreCliente;

        //Ejecución del Proceso de Compra
        Scanner sc = new Scanner(System.in);
        System.out.print("Por favor, ingrese su nombre:");
        nombreCliente = sc.nextLine();
        System.out.println("¡Bienvenido a nuestra tienda, "+ nombreCliente+"!");
        System.out.println("Por favor, ingrese cantidad de productos a comprar:");
        cantidadProdsCliente  = sc.nextInt();
        System.out.println("Vas a comprar "+cantidadProdsCliente+" productos.");
        System.out.println("Revisando stock del producto...");

        // Condicional sobre Stock actual de productos
        if (stock>=cantidadProdsCliente){
            System.out.println("Podemos cubrir el pedido de "+cantidadProdsCliente+" unidades.");
        }else{
            System.out.println("No hay stock suficiente para cubrir el pedido.");
        }

        // Calculando precio total
        double costoTotal =  precioUnitario * cantidadProdsCliente;

        // Condicional para aplicar descuento
        if (cantidadProdsCliente>100){
            System.out.println("Le ofrecemos un descuento del 20% por su compra de mas de 100 unidades.");
            costoTotal = costoTotal-(costoTotal*0.2);
            System.out.println("El costo total aplicando descuento del 20%: $"+costoTotal);
        }else {
            System.out.println("El costo total del pedido es: $" + costoTotal);
        }

        // Bucle

        System.out.print("Por favor, ingrese un numero:");
        int numero = sc.nextInt();

        // Version While
        int i = 1;
        while(i<=numero){
            System.out.println(i);
            i++;
        }

        // Version For
        for (int index = 1; index<= numero; index++){
            System.out.println(index);
        }
    }
}
