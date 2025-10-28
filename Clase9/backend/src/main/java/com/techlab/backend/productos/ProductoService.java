package com.techlab.backend.productos;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Arrays;

@Service
public class ProductoService {

    public List<Producto> listarProductos() {
        return Arrays.asList(
                new Bebida("Café", 250.0, 100),
                new Bebida("Té", 180.0, 80),
                new Bebida("Jugo de naranja", 220.0, 50)
        );
    }
}
