package com.api.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.biblioteca.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{

}