package com.banregio.curso.backend.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banregio.curso.backend.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository< Producto , Long > 
{

}
