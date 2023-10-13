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
		return editoraRepository.findById(id).orElse(null);
	}
	
	public Editora salvarEditora(Editora editora) {
		return editoraRepository.save(editora);
	}
	
	public Editora atualizarEditora(Editora editora) {
		return editoraRepository.save(editora);
	}
	
	public Boolean deletarEditora(Editora editora) {
		if(editora == null)
			return false;
		
		Editora editoraExistente = buscarEditoraPorId(editora.getCodigoEditora());
		
		if(editoraExistente == null)
			return false;
		
		editoraRepository.delete(editora);
		
		Editora editoraContinuaExistindo = buscarEditoraPorId(editora.getCodigoEditora());
		
		if(editoraContinuaExistindo == null)
			return true;
		
		return false;
	}
}
