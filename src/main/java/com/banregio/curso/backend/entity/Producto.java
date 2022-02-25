package com.banregio.curso.backend.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table( name = "producto" )
@Data @AllArgsConstructor @NoArgsConstructor
public class Producto implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column( name = "nombre" )
	private String nombre;
	
	@Column( name = "precio" )
	private double precio;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn( name = "id_categoria" )
	private Categoria categoria;

}
