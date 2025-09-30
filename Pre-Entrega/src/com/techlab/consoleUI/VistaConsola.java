package com.techlab.consoleUI;

import models.Modelo;

import java.util.Scanner;

public class VistaConsola {
    Modelo modelo;
    public VistaConsola(Modelo mode){
        this.modelo = mode;
    }


    public void menu(){
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        while(!salir){
            System.out.println("=================================== SISTEMA DE GESTIÓN - TECHLAB ==================================");
            System.out.println("________________________________");
            System.out.println("1) Agregar producto");
            System.out.println("2) Listar productos");
            System.out.println("3) Buscar/Actualizar producto");
            System.out.println("4) Eliminar producto");
            System.out.println("5) Crear un pedido");
            System.out.println("6) Listar pedidos");
            System.out.println("7) Salir");
            System.out.println("________________________________");
            System.out.println("Elija una opción:");


            String opcion = sc.nextLine();

            switch (opcion){
                case "1":
                    menuAgregarProducto();
                    break;
                case "2":
                    listarProductos();
                    break;
                case "3":
                    System.out.println("3)");
                    break;
                case "4":
                    System.out.println("4)");
                    break;
                case "5":
                    System.out.println("5)");
                    break;
                case "6":
                    System.out.println("6)");
                    break;
                case "7":
                    System.out.println("¡Gracias vuelva pronto!");
                    salir = true;
                    break;

                default:
                    System.out.println("!)Error. Opcion no válida.");
            }
        }

    }


    public void menuAgregarProducto(){
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        while(!salir){
            System.out.println("------[ Agregar Producto ]------");
            System.out.println("________________________________");
            System.out.println("1) Bebida");
            System.out.println("2) Comida");
            System.out.println("3) Salir");
            System.out.println("________________________________");
            System.out.println("Ingrese tipo de Producto:");

            String opcion = sc.nextLine();


            switch (opcion){
                case "1","2":
                    vcAgregarProducto(opcion);
                    break;
                case "3":
                    salir = true;
                    break;

                default:
                    System.out.println("!)Error. Opcion no válida.");
            }

        }
    }

    public void vcAgregarProducto(String tipo){

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese Nombre del Producto:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese Precio del Producto ($):");
        double precio = sc.nextDouble();
        System.out.println("Ingrese Cantidad del Producto:");
        int cantidad = sc.nextInt();

        modelo.agregarProducto(tipo,nombre,precio,cantidad);
    }

    public void listarProductos(){
        System.out.println(modelo.mostrarStock());
    }
}
