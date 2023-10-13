package com.api.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.biblioteca.entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer>{

}