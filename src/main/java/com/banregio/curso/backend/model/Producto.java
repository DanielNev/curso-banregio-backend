package com.banregio.curso.backend.model;



import com.banregio.curso.backend.entity.Categoria;

import lombok.Data;

@Data
public class Producto 
{
	private Long id;

	private String nombre;
	
	private double precio;
	
	private Categoria categoria;

}
