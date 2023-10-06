package com.api.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.biblioteca.entities.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer>{

}