package com.api.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.biblioteca.entities.Autor;
import com.api.biblioteca.repositories.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	AutorRepository autorRepository;
	
	public List <Autor> listarAutores(){
		return autorRepository.findAll();
	}
	
	public Autor buscarAutorPorId(Integer id) {
		return autorRepository.findById(id).orElse(null);
	}
	
	public Autor salvarAutor(Autor autor) {
		return autorRepository.save(autor);
	}
	
	public Autor atualizarAutor(Autor autor) {
		return autorRepository.save(autor);
	}
	
	public Boolean deletarAutor(Autor autor) {
		if(autor == null)
			return false;
		
		Autor autorExistente = buscarAutorPorId(autor.getCodigoAutor());
		
		if(autorExistente == null)
			return false;
		
		autorRepository.delete(autor);
		
		Autor autorContinuaExistindo = buscarAutorPorId(autor.getCodigoAutor());
		
		if(autorContinuaExistindo == null)
			return true;
		
		return false;
	}
}
