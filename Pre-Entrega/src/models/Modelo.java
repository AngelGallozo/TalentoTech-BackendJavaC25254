package models;

import com.techlab.productos.Bebida;
import com.techlab.productos.Comida;
import com.techlab.productos.Producto;

import java.util.ArrayList;

public class Modelo {
    ArrayList<Producto> stock = new ArrayList<>();
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


    public void agregarProducto(String tipo,String nombre, double precio, int cantidad ){
        if(tipo.equals("1")){ // Si es comida
            stock.add(new Comida(nombre,precio,cantidad));
        }else{ // Si es bebida
            stock.add(new Bebida(nombre,precio,cantidad));
        }
    }

    public String mostrarStock(){
        String mensaje= "";

        for(int i=0; i<stock.size();i++){
            mensaje +="\n"+(i+1)+"-"+stock.get(i).toString();
        }

        return mensaje;
    }


}
