package com.techlab.consoleUI;

import models.Modelo;

import java.util.Scanner;

// Clase que se encarga de mostrar la interface en consola
public class VistaConsola {
    Modelo modelo;
    public VistaConsola(Modelo mode){
        // Le pasamos el modelo que contiene la logica de productos a la vista
        // Con el fin de que se comunique con este objeto para la gestion de productos
        this.modelo = mode;
    }

    // Menu principal que muestra las primeras opciones al usuario
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
                    buscarProducto();
                    break;
                case "4":
                    eliminarProdcuto();
                    break;
                case "5":
                    crearPedido();
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


    // Submenu para Agregar Prodcuto
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

    // Funcion encargada de tomar los datos del nuevo producto y enviarlo al modelo
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

    // Funcion que se encarga de mostrar en pantalla la lista de productos obtenida del Modelo
    public void listarProductos(){
        System.out.println(modelo.mostrarStock());
        pausa();
    }

    // Funcion que se encarga de pedir datos y obtener respuesta de su existencia del lado del Modelo
    public void buscarProducto(){
        Scanner sc = new Scanner(System.in);
        System.out.println("------[ Buscar/Actualizar Producto ]------");
        System.out.println("________________________________");
        System.out.println("Ingrese Nombre del producto:");
        String dato = sc.nextLine();

        System.out.println(modelo.buscarProductoPorNombre(dato)+"\n");
        System.out.println("Ingrese ID del producto que coincide:");
        dato = sc.nextLine();
        int idPrd = modelo.obtenerProducto(dato);

        if (idPrd!=-1){
            actualizarProducto(idPrd);
        }else{
            System.out.println("!)Error. No existe el producto.");
        }
    }


    // Funcion para actualizar el precio o stock
    public void actualizarProducto(int id){
        Scanner sc = new Scanner(System.in);

        boolean salir = false;
        while(!salir){
            String datosProducto = modelo.obtenerDatosProductoPorID(id);

            System.out.println("------[ Actualizar Producto ]------");
            System.out.println(datosProducto);
            System.out.println("________________________________");
            System.out.println("1) Precio");
            System.out.println("2) Cantidad");
            System.out.println("3) Salir");
            System.out.println("________________________________");
            System.out.println("Ingrese opcion que desea actualizar:");

            String opcion = sc.nextLine();

            switch (opcion){
                case "1":
                    System.out.println("Ingrese nuevo Precio:");
                    String precioNuevo = sc.nextLine();
                    if(modelo.actualizarPrecioProducto(id,precioNuevo)) {
                        System.out.println("i) Se actualizó correctamente el precio del producto.");
                    }else{
                        System.out.println("!) Error. Precio no válido.");
                    }
                    break;

                case "2":
                    System.out.println("Ingrese Cantidad:");
                    String cantidadNuevo = sc.nextLine();
                    if(modelo.actualizarCantidadProducto(id,cantidadNuevo)){
                        System.out.println("i) Se actualizó correctamente la cantidad del producto.");
                    }else {
                        System.out.println("!) Error. Cantidad no válida.");
                    }

                    break;

                case "3":
                    salir = true;
                    break;

                default:
                    System.out.println("!)Error. Opcion no válida.");
            }
        }
    }

    // Funcion para eliminar un producto
    public void eliminarProdcuto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("------[ Eliminar Producto ]------");
        System.out.println("________________________________");
        System.out.println("Ingrese Nombre del producto:");
        String dato = sc.nextLine();

        System.out.println(modelo.buscarProductoPorNombre(dato)+"\n");
        System.out.println("Ingrese ID del producto que coincide:");
        dato = sc.nextLine();

        int idPrd = modelo.obtenerProducto(dato);

        if (idPrd!=-1){
            System.out.println("------[ Eliminar Producto ]------");
            System.out.println("________________________________");
            System.out.println(modelo.obtenerDatosProductoPorID(idPrd));
            System.out.println("________________________________");
            System.out.println("¿Desea eliminar el producto?");
            System.out.println("Ingrese 'y' para continuar, para cancelar ingrese cualquier tecla...");
            String confirmacion = sc.nextLine().toLowerCase();
            if (confirmacion.equals("y") ){
                modelo.eliminarProducto(idPrd);
                System.out.println("i) Se eliminó correctamente el producto.");

            }else{
                System.out.println("!) Se canceló eliminación del producto.");
            }
        }else{
            System.out.println("!)Error. No existe el producto.");
        }
    }

    // Funcion para crear Pedido
    public void crearPedido(){
        boolean salir = false;
        while(!salir){
            System.out.println("------[ Crear Pedido ]------");
            System.out.println(modelo.mostrarStock());
            System.out.println("x) Salir");
            System.out.println("________________________________");
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese ID o nombre del Producto que desea agregar al pedido:");
            String nombre = sc.nextLine();

            if(nombre.toLowerCase().equals("x")){
                salir = true;
            }else{
                int idPrd = modelo.obtenerProducto(nombre);
                if (idPrd!=-1){
                    //modelo.agregarAlPedido();
                }else{
                    System.out.println("!)Error. No existe el producto.");
                }

                System.out.println("Ingrese Cantidad del Producto:");
                int cantidad = sc.nextInt();
            }


        }
    }

    // Pausa para ver resultados
    public static void pausa() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\nPulse ENTER para continuar...");
        entrada.nextLine();
        for (int i = 0; i < 20; ++i) {
            System.out.println();
        }
    }

}
