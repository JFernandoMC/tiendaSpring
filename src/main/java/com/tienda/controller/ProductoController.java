package com.tienda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.entities.Producto;
import com.tienda.repository.ProductoRepository;


@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	ProductoRepository productoRepository;
	
	@GetMapping
	public List<Producto> getProductoAll() {
		
		return productoRepository.findAll();
		
	}
	
	@GetMapping("/{id}")
	public Producto getProductosById(@PathVariable Integer id) {
		
		Optional<Producto> producto = productoRepository.findById(id);
		
		if(producto.isPresent()) {
			return producto.get();
		}	
		return null;
		
	}
	
	@DeleteMapping("/{id}")
	public Producto deleteProductosById(@PathVariable Integer id) {
		
		Optional<Producto> producto = productoRepository.findById(id);
		
		if(producto.isPresent()) {
			
			Producto productoReturn = producto.get();
			
			productoRepository.deleteById(id);
			return productoReturn;
		}
		return null;
		
	}
	
	@PostMapping
	public Producto postProductos(@RequestBody Producto producto) {
				
		productoRepository.save(producto);
		return producto;
		
	}
	
	@PutMapping("/{id}")
	public Producto putProductosById(@PathVariable Integer id,@RequestBody Producto producto) {
		
		Optional<Producto> productoCurrent = productoRepository.findById(id);
		
		if(productoCurrent.isPresent()) {
			
			Producto productoReturn = productoCurrent.get();
			
			productoReturn.setDescripcion(producto.getDescripcion());
			productoReturn.setNombre(producto.getNombre());
			
			productoRepository.save(productoReturn);
			return productoReturn;
		}
		return null;
		
	}
	
}
