package org.nerfilin.services;

import org.nerfilin.models.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImpl implements ProductoService {


    @Override
    public List<Producto> listar() {
        return Arrays.asList(
                new Producto(1L, "Meditaciones", "Libros", 10000),
                new Producto(2L, "Dune 1", "Libros", 15000),
                new Producto(3L, "Teclado mecanico", "computacion", 30000)
        );
    }
}
