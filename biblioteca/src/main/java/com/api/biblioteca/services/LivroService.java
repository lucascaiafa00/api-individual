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
		return livroRepository.findById(id).orElse(null);
	}
	
	public Livro salvarLivro(Livro livro) {
		return livroRepository.save(livro);
	}
	
	public Livro atualizarLivro(Livro livro) {
		return livroRepository.save(livro);
	}
	
	public Boolean deletarLivro(Livro livro) {
		if(livro == null)
			return false;
		
		Livro livroExistente = buscarLivroPorId(livro.getCodigoLivro());
		
		if(livroExistente == null)
			return false;
		
		livroRepository.delete(livro);
		
		Livro livroContinuaExistindo = buscarLivroPorId(livro.getCodigoLivro());
		
		if(livroContinuaExistindo == null)
			return true;
		
		return false;
	}
}
