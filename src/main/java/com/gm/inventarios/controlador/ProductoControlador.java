package com.gm.inventarios.controlador;


import com.gm.inventarios.modelo.Producto;
import com.gm.inventarios.servicio.ProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("inventario-api")
@CrossOrigin(value="http://localhost:4200")
public class ProductoControlador {

    private static final Logger logger =
            LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){

        return productoServicio.listarProductos();
    }
}
