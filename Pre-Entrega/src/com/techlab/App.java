package com.techlab;

import com.techlab.consoleUI.VistaConsola;
import com.techlab.productos.Bebida;
import com.techlab.productos.Comida;
import com.techlab.productos.Producto;
import models.Modelo;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // Se instancia al modelo
        Modelo modelo = new Modelo();
        // Se instancia la vista en consola
        VistaConsola vc = new VistaConsola(modelo);
        // Se hace llamada al menu principal
        vc.menu();
    }
}
