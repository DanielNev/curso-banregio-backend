package com.banregio.curso.backend.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banregio.curso.backend.app.repository.CategoriaRepository;
import com.banregio.curso.backend.app.service.CategoriaService;
import com.banregio.curso.backend.entity.Categoria;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class CategoriaController 
{
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@ApiOperation( value = "Consultar las categorías" , notes = "Traer en una lista las categorías"
			+ " almacenadas en la base de datos" )
	@GetMapping("/categoria")
	public ResponseEntity<List<Categoria>> getAll()
	{
		try 
		{
			List<Categoria> listaCategorias = new ArrayList<Categoria>();
			listaCategorias = categoriaService.getAll();
			return new ResponseEntity<List<Categoria>>( listaCategorias , HttpStatus.OK );			
		}
		catch( Exception e )
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@ApiOperation( value = "Consultar una categoría por id" , notes = "Traer una categoría seleccionada"
			+ " por medio de su identificador"
			+ " almacenadas en la base de datos" )
	@GetMapping("/categoria/{id}")
	public ResponseEntity<Optional<Categoria>> getByID( @PathVariable Long id )
	{
		try 
		{
			Optional<Categoria> categoria = categoriaService.getByID(id);
			return new ResponseEntity<Optional<Categoria>>( categoria , HttpStatus.OK );			
		}
		catch( Exception e )
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@ApiOperation( value = "Agregar categoría" , notes = "Agregar un nuevo recurso de la entidad Categoría" )
	@PostMapping("/categoria")
	public ResponseEntity<Categoria> save( @RequestBody Categoria categoria )
	{
		try 
		{
			Categoria categoriaGuardado = categoriaService.save(categoria);
			return new ResponseEntity<Categoria>( categoriaGuardado , HttpStatus.CREATED );
		}	
		catch( Exception e )
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@ApiOperation( value = "Modificar categoría" , notes = "Modificar recurso de la entidad Categoría" )
	@PutMapping("/categoria/{id}")
	public ResponseEntity<Categoria> update(@PathVariable("id") Long id, @RequestBody Categoria categoria ) throws NullPointerException 
	{
		Optional<Categoria> categoriaData = categoriaService.getByID(id);
	    if (categoriaData.isPresent()) 
	    {
	      Categoria cat = categoriaData.get();
	      cat.setNombre_categoria( categoria.getNombre_categoria() );
	      return new ResponseEntity<Categoria>(categoriaService.save( cat ), HttpStatus.OK);
	    } 
	    else 
	    {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	@ApiOperation( value = "Eliminar categoría" , notes = "Eliminar una categoría por su ID" )	
	@DeleteMapping("/categoria/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) 
	{
		try 
		{
			categoriaRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
