package com.banregio.curso.backend.app.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.banregio.curso.backend.entity.Categoria;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CategoriaControllerTest 
{	
	@Spy
	@InjectMocks
	private CategoriaController controller;	
	
	@Test
    public void getAll() 
    {   
		Categoria cat = new Categoria( 1L , "ACCESORIOS" );
		List<Categoria> list = new ArrayList<Categoria>();
		list.add(cat);
		ResponseEntity<List<Categoria>> r = new ResponseEntity<>( list , HttpStatus.OK );
		when( controller.getAll() ).thenReturn( r );
    }	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
    public void getById() 
    {   
		Categoria cat = new Categoria( 1L , "ACCESORIOS" );
		ResponseEntity<Optional<Categoria>> r = new ResponseEntity( cat , HttpStatus.OK );
		when( controller.getByID( 1L ) ).thenReturn( r );
    }
	@Test
    public void save() 
    {   	
		Categoria cat = new Categoria( null , "TESTING" );
		ResponseEntity<Categoria> r = new ResponseEntity<>( cat , HttpStatus.CREATED );
		when( controller.save( cat ) ).thenReturn( r );
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
		Categoria cat = new Categoria( 3L , "ACCESORIO MODIFICADO" );
		ResponseEntity<Categoria> r = new ResponseEntity<>( cat , HttpStatus.OK );
		when( controller.save( cat ) ).thenReturn( r );
    }
	

}
