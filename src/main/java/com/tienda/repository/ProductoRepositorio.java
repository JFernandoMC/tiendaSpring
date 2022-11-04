package com.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.entities.Producto;

public interface ProductoRepositorio extends JpaRepository <Producto, Integer>{

	
	
}
