package com.banregio.curso.backend.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banregio.curso.backend.app.client.VentasRepositoryClient;

import com.banregio.curso.backend.entity.Producto;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class VentaController 
{
	@Autowired
	VentasRepositoryClient feign;	
	
	@ApiOperation( value = "REALIZAR PETICIÓN A FEIGN CLIENT PARA CONSULTAR LAS VENTAS " , 
			notes = "RECURSO PARA SOLICITAR UNA PETICIÓN POR MEDIO DE FEIGN CLIENT PARA ACCEDER A UN "
					+ "RECURSO SITUADO EN OTRO SERVICIO." )
	@GetMapping("/venta")
	public List<Producto> getVentas ()
	{
		return feign.getAll();		
	}
}
