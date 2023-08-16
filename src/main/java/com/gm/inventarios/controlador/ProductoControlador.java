package com.gm.inventarios.controlador;


import com.gm.inventarios.excepcion.RecursoNoEncontradoExcepcion;
import com.gm.inventarios.modelo.Producto;
import com.gm.inventarios.servicio.ProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        List<Producto> productos = productoServicio.listarProductos();

        logger.info("Productos Obtenidos");

        productos.forEach(producto -> logger.info(producto.toString()));
        return productos;
    }


    @PostMapping("/productos")
    public Producto abregarProducto(@RequestBody Producto producto){
        logger.info("Producto a Agregar : "+producto);

        return this.productoServicio.guardarProducto(producto);
    }


    @GetMapping("productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int id)
    {
       Producto producto = productoServicio.buscarProductoPorId(id);

if(producto != null)
       return ResponseEntity.ok(producto);

else
    throw new RecursoNoEncontradoExcepcion("no se encontró el id : "+id);
    }
}
