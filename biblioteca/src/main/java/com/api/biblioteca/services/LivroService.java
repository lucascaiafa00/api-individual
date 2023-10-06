package com.api.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.biblioteca.entities.Livro;
import com.api.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	LivroRepository livroRepository;
	
	public List <Livro> listarLivros(){
		return livroRepository.findAll();
	}
	
	public Livro buscarLivroPorId(Integer id) {
		return livroRepository.findById(id).get();
	}
	
	public Livro salvarLivro(Livro livro) {
		return livroRepository.save(livro);
	}
	
	public Livro atualizarLivro(Livro livro) {
		return livroRepository.save(livro);
	}
	
	public void deletarLivro(Livro livro) {
		livroRepository.delete(livro);
	}
}
