package com.gestion.productosREST.repositorio;

import com.gestion.productosREST.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
