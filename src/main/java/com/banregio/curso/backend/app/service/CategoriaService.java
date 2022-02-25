package com.banregio.curso.backend.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banregio.curso.backend.app.repository.CategoriaRepository;
import com.banregio.curso.backend.entity.Categoria;

@Service
public class CategoriaService 
{
	@Autowired
	CategoriaRepository categoriaRepo;
	
	public List<Categoria> getAll() 
	{
		return categoriaRepo.findAll();
	}	
	public Optional<Categoria> getByID( Long id ) 
	{
		return categoriaRepo.findById(id);
	}	
	public Categoria save( Categoria producto ) 
	{
		return categoriaRepo.save(producto);
	}
}
