package com.banregio.curso.backend.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banregio.curso.backend.app.repository.ProductoRepository;
import com.banregio.curso.backend.entity.Producto;

@Service
public class ProductoService 
{
	@Autowired
	ProductoRepository productoRepo;
	
	public List<Producto> getAll() 
	{
		return productoRepo.findAll();
	}	
	public Optional<Producto> getByID( Long id ) 
	{
		return productoRepo.findById(id);
	}	
	public Producto save( Producto producto ) 
	{
		return productoRepo.save(producto);
	}
}
