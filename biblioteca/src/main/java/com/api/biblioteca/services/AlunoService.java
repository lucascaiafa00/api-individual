package com.api.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.biblioteca.entities.Aluno;
import com.api.biblioteca.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	public List <Aluno> listarAlunos(){
		return alunoRepository.findAll();
	}
	
	public Aluno buscarAlunoPorId(Integer id) {
		return alunoRepository.findById(id).orElse(null);
	}
	
	public Aluno salvarAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public Aluno atualizarAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public Boolean deletarAluno(Aluno aluno) {
		if(aluno == null)
			return false;
		
		Aluno alunoExistente = buscarAlunoPorId(aluno.getNumeroMatriculaAluno());
		
		if(alunoExistente == null)
			return false;
		
		alunoRepository.delete(aluno);
		
		Aluno alunoContinuaExistindo = buscarAlunoPorId(aluno.getNumeroMatriculaAluno());
		
		if(alunoContinuaExistindo == null)
			return true;
		
		return false;
	}
}
