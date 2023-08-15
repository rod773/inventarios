package com.gm.inventarios.servicio;

import com.gm.inventarios.modelo.Producto;

import java.util.List;

public interface IProdructoServicio {
    public List<Producto> listarProductos();

    public Producto buscarProductoPorId(Integer idProducto);

    public void guardarProducto(Producto producto);

    public void eliminarProductoPorId(Integer idProducto);
}
