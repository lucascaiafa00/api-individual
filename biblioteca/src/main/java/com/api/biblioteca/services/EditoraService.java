package com.api.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.biblioteca.entities.Editora;
import com.api.biblioteca.repositories.EditoraRepository;

@Service
public class EditoraService {
	
	@Autowired
	EditoraRepository editoraRepository;
	
	public List <Editora> listarEditoras(){
		return editoraRepository.findAll();
	}
	
	public Editora buscarEditoraPorId(Integer id) {
		return editoraRepository.findById(id).get();
	}
	
	public Editora salvarEditora(Editora editora) {
		return editoraRepository.save(editora);
	}
	
	public Editora atualizarEditora(Editora editora) {
		return editoraRepository.save(editora);
	}
	
	public void deletarEditora(Editora editora) {
		editoraRepository.delete(editora);
	}
}
