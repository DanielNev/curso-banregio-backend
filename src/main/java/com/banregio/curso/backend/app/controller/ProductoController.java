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

import com.banregio.curso.backend.app.repository.ProductoRepository;
import com.banregio.curso.backend.app.service.ProductoService;
import com.banregio.curso.backend.entity.Producto;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class ProductoController 
{
	@Autowired
	ProductoService productoService;
	
	@Autowired
	ProductoRepository productoRepository;
	
	@ApiOperation( value = "Consultar los productos" , notes = "Traer en una lista los productos"
			+ " almacenadas en la base de datos" )
	@GetMapping("/producto")
	public ResponseEntity<List<Producto>> getAll()
	{
		try 
		{
			List<Producto> listaProductos = new ArrayList<Producto>();
			listaProductos = productoService.getAll();
			return new ResponseEntity<List<Producto>>( listaProductos , HttpStatus.OK );			
		}
		catch( Exception e )
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@ApiOperation( value = "Consultar un producto por id" , notes = "Traer un producto seleccionado"
			+ " por medio de su identificador"
			+ " almacenados en la base de datos" )
	@GetMapping("/producto/{id}")
	public ResponseEntity<Optional<Producto>> getByID( @PathVariable Long id )
	{
		try 
		{
			Optional<Producto> producto = productoService.getByID(id);
			return new ResponseEntity<Optional<Producto>>( producto , HttpStatus.OK );			
		}
		catch( Exception e )
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@ApiOperation( value = "Agregar producto" , notes = "Agregar un nuevo recurso de la entidad Producto" )
	@PostMapping("/producto")
	public ResponseEntity<Producto> save( @RequestBody Producto producto )
	{
		try 
		{
			Producto productoGuardado = productoService.save(producto);
			return new ResponseEntity<Producto>( productoGuardado , HttpStatus.CREATED );
		}	
		catch( Exception e )
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@ApiOperation( value = "Modificar producto" , notes = "Modificar recurso de la entidad Producto" )
	@PutMapping("/producto/{id}")
	public ResponseEntity<Producto> update(@PathVariable("id") Long id, @RequestBody Producto producto ) 
	{
		Optional<Producto> productoData = productoService.getByID(id);
	    if (productoData.isPresent()) 
	    {
	      Producto prod = productoData.get();
	      prod.setNombre( producto.getNombre() );
	      prod.setPrecio( producto.getPrecio() );
	      prod.setCategoria( producto.getCategoria() );
	      return new ResponseEntity<>(productoService.save( prod ), HttpStatus.OK);
	    } 
	    else 
	    {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	@ApiOperation( value = "Eliminar producto" , notes = "Eliminar un producto por su ID" )
	@DeleteMapping("/producto/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) 
	{
		try 
		{
			productoRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
