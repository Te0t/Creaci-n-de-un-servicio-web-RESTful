package com.gestion.productosREST.controlador;

import com.gestion.productosREST.modelo.Producto;
import com.gestion.productosREST.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//indica que el cliente va hacer una peticion
@RestController
public class ProductoControlador {

    @Autowired
    private ProductoServicio servicio;

    @GetMapping("/productos")
    public List<Producto> listarProductos(){
        return servicio.listarProductos();
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id){
        try {
            Producto producto = servicio.obtenerProductoPorId(id);
            return new ResponseEntity<Producto>(producto,HttpStatus.OK);
        }catch (Exception excepcion){
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/productos")
    public void guardarProducto(@RequestBody Producto producto){
        servicio.guardarProductos(producto);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto, @PathVariable Integer id){
        try {
            Producto productoActual = servicio.obtenerProductoPorId(id);
                productoActual.setNombre(producto.getNombre());
                productoActual.setPrecio(producto.getPrecio());
                productoActual.setId(producto.getId());
                    servicio.guardarProductos(productoActual);
        return new ResponseEntity<Producto>(HttpStatus.OK);

        }catch (Exception excepcion){
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/productos/{id}")
    public void eliminarProducto(@PathVariable Integer id){
        servicio.eliminarProductos(id);
    }
}
