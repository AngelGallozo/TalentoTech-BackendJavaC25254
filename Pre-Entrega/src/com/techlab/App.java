package com.techlab;

import com.techlab.consoleUI.VistaConsola;
import com.techlab.productos.Bebida;
import com.techlab.productos.Comida;
import com.techlab.productos.Producto;
import models.Modelo;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        VistaConsola vc = new VistaConsola(modelo);
        vc.menu();
    }
}
