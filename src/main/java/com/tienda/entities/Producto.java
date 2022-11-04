package com.tienda.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Producto implements Serializable{

	@Id
	private Integer id;
	private String nombre;
	private String descripcion;
	
	
}
