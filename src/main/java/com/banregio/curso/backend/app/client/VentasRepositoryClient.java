package com.banregio.curso.backend.app.client;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


import com.banregio.curso.backend.entity.Producto;

@FeignClient( name = "ventas-client" , url = "${url-feign}" )
public interface VentasRepositoryClient 
{
	
	@GetMapping("/producto")
	public List<Producto> getAll();
}
