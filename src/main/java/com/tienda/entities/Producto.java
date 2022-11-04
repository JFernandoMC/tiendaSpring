package com.tienda.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;


@Entity
@Data
public class Producto implements Serializable{

	@Id
	@SequenceGenerator(name="producto_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_id_seq")
	private Integer id;
	private String nombre;
	private String descripcion;
	
	
}
