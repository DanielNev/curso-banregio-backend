package com.banregio.curso.backend.app.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.banregio.curso.backend.entity.Categoria;
import com.banregio.curso.backend.entity.Producto;

class ProductoControllerTest {

	@Spy
	@InjectMocks
	private ProductoController controller;	
	
	@Test
    public void getAll() 
    {   
		Categoria cat = new Categoria( 1L, "ACCESORIOS"); 
		Producto prod = new Producto( 1L , "TECLADO" , 150 , cat );
		List<Producto> list = new ArrayList<Producto>();
		list.add(prod);
		ResponseEntity<List<Producto>> r = new ResponseEntity<>( list , HttpStatus.OK );
		when( controller.getAll() ).thenReturn( r );
    }	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
    public void getById() 
    {   
		Categoria cat = new Categoria( 1L, "ACCESORIOS"); 
		Producto prod = new Producto( 1L , "TECLADO" , 150 , cat );
		ResponseEntity<Optional<Producto>> r = new ResponseEntity( prod , HttpStatus.OK );
		when( controller.getByID( 1L ) ).thenReturn( r );
    }
	@Test
    public void save() 
    {   
		Categoria cat = new Categoria( 1L, "ACCESORIOS"); 
		Producto prod = new Producto( null , "TESTING PRODUCTS" , 400.50 , cat );
		ResponseEntity<Producto> r = new ResponseEntity<>( prod , HttpStatus.CREATED );
		when( controller.save( prod ) ).thenReturn( r );
    }
	@Test
    public void delete() 
    {   	
		ResponseEntity<HttpStatus> r = new ResponseEntity<>( HttpStatus.NO_CONTENT );
		when( controller.delete( 1L ) ).thenReturn( r );
    }
	@Test
    public void update() 
    {   	
		Categoria cat = new Categoria( 1L, "ACCESORIOS"); 
		Producto prod = new Producto( 3L , "PRODUCTO MODIFICADO" , 500 , cat );
		ResponseEntity<Producto> r = new ResponseEntity<>( prod , HttpStatus.OK );
		when( controller.save( prod ) ).thenReturn( r );
    }

}
