package models;

import com.techlab.productos.Bebida;
import com.techlab.productos.Comida;
import java.text.Normalizer;
import com.techlab.productos.Producto;

import java.util.ArrayList;
// Clase encargada de instanciar y gestionar los objetos relacionados con:
// Productos, Exceptions, Pedidos,etc.
public class Modelo {
    // Array principal que tendra los productos en Stock
    ArrayList<Producto> stock = new ArrayList<>();
    // Array principal que tendra los pedidos
    ArrayList<Producto> pedidos = new ArrayList<>();

    public Modelo(){

        // Instanciando bebidas Default
        stock.add(new Bebida("Té Chai",45.0,20));
        stock.add(new Bebida("Té Verde",25.0,20));
        stock.add(new Bebida("Café Americano",65.0,20));
        stock.add(new Bebida("Café Negro",75.0,20));

        // Instanciando Comida Default
        stock.add(new Comida("Medialuna",65.0,50));
        stock.add(new Comida("Gallelitas",35.0,80));
    }

    // Funcion encargada de agregar el producto con los datos que nos brinda la vista en consola.
    public void agregarProducto(String tipo,String nombre, double precio, int cantidad ){
        if(tipo.equals("1")){ // Si es comida
            stock.add(new Comida(nombre,precio,cantidad));
        }else{ // Si es bebida
            stock.add(new Bebida(nombre,precio,cantidad));
        }
    }
    // Funcion que lista los producto en un String para ser mostrado por la vista consola.
    // Metodo principal con parámetro
    public String listarProductos(ArrayList<Producto> prds) {
        String mensaje = "";
        for (int i = 0; i < prds.size(); i++) {
            mensaje += "\n" +prds.get(i).toString();
        }
        return mensaje;
    }

    // Metodo "por defecto" que usa stock
    public String mostrarStock() {
        return listarProductos(stock);
    }

    // Funcion que busca un producto segun ID o Nombre, y devuelve su ID(Posicion en la lista), sino devuelve -1;
    public int obtenerProducto(String dato){
        int idPrd=-1;

        try{
            int idBuscar = Integer.parseInt(dato);
            for (Producto p : stock) {
                if (p.coincideId(idBuscar)) {
                    idPrd = p.getId();
                }

            }
        }catch (NumberFormatException e) {
            idPrd=-1;
        }

        return idPrd;
    }

    // Obtiene los datos de un producto mejor presentado que el toString.
    public String obtenerDatosProductoPorID(int id) {
        for (Producto p : stock) {
            if (p.coincideId(id)) {
                return "ID: " + p.getId() +
                        "\nNombre: " + p.getNombre() +
                        "\nPrecio: $" + p.getPrecio() +
                        "\nCantidad: " + p.getCantidad();
            }
        }
        return "Producto no encontrado";
    }

    // Actualiza la cantidad del producto seleccionado por ID
    public boolean actualizarCantidadProducto(int id, String cantidad) {
        boolean respuesta = false; // por defecto false

        try {
            int cantNueva = Integer.parseInt(cantidad);
            if (cantNueva <= 0) return false;

            for (Producto p : stock) {
                if (p.coincideId(id)) {
                    p.setCantidad(cantNueva);
                    respuesta = true;
                    break; // salimos al encontrar el producto
                }
            }
        } catch (NumberFormatException e) {
            respuesta = false;
        }

        return respuesta;
    }

    // Actualiza cantidad del producto seleccionado por ID
    public boolean actualizarPrecioProducto(int id, String precio) {
        boolean respuesta = false; // por defecto false

        try {
            double precNuevo = Double.parseDouble(precio);
            if (precNuevo <= 0) return false;

            for (Producto p : stock) {
                if (p.coincideId(id)) {
                    p.setPrecio(precNuevo);
                    respuesta = true;
                    break; // salimos al encontrar el producto
                }
            }
        } catch (NumberFormatException e) {
            respuesta = false;
        }

        return respuesta;
    }

    // Funcion que elimina un producto por ID
    public boolean eliminarProducto(int id) {
        for (int i = 0; i < stock.size(); i++) {
            if (stock.get(i).coincideId(id)) {
                stock.remove(i);
                return true; // producto eliminado correctamente
            }
        }
        return false; // no se encontró producto con ese id
    }

    // Funcion que verifica si la el nombre esta incluido en el nombre Completo del producto
    public boolean estaIncluido(String nombreCompleto, String nombreParcial) {
        String nombreCompletoFormateado = formatoBusqueda(nombreCompleto);
        String nombreParcialFormateado = formatoBusqueda(nombreParcial);

        return nombreCompletoFormateado.contains(nombreParcialFormateado);
    }

    // Formatea cadenas de texto, quita espacios, los pone en minuscula y le quita tildes
    public String formatoBusqueda(String texto) {
        if (texto == null) return "";

        // 1. Quita espacios y pasa a minúsculas
        String resultado = texto.trim().toLowerCase();

        // 2. Normaliza el texto para quitar acentos
        resultado = Normalizer.normalize(resultado, Normalizer.Form.NFD);
        resultado = resultado.replaceAll("\\p{M}", ""); // elimina marcas diacríticas (acentos)

        // 3. Quita signos de puntuación
        resultado = resultado.replaceAll("[\\p{Punct}]", "");

        return resultado;
    }

    // Funcion que busca por nombre en todos los productos.
    public String buscarProductoPorNombre(String nombre ) {

        ArrayList<Producto> productoEncontrados = new ArrayList<>();

        for (Producto producto : stock) {
            if (estaIncluido(producto.getNombre(), nombre)) {
                productoEncontrados.add(producto);
            }
        }

        return listarProductos(productoEncontrados);
    }

}
