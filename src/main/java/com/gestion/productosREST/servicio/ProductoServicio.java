package com.gestion.productosREST.servicio;

import com.gestion.productosREST.modelo.Producto;
import com.gestion.productosREST.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio repositorio;

    public List<Producto> listarProductos(){
        return repositorio.findAll();
    }

    public void guardarProductos(Producto producto){
        repositorio.save(producto);
    }

    public Producto obtenerProductoPorId(Integer id){
        return repositorio.findById(id).get();
    }

    public void eliminarProductos(Integer id){
        repositorio.deleteById(id);
    }
}
