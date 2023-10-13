package com.api.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.biblioteca.entities.Emprestimo;
import com.api.biblioteca.repositories.EmprestimoRepository;

@Service
public class EmprestimoService {
	
	@Autowired
	EmprestimoRepository emprestimoRepository;
	
	public List <Emprestimo> listarEmprestimos(){
		return emprestimoRepository.findAll();
	}
	
	public Emprestimo buscarEmprestimoPorId(Integer id) {
		return emprestimoRepository.findById(id).orElse(null);
	}
	
	public Emprestimo salvarEmprestimo(Emprestimo emprestimo) {
		return emprestimoRepository.save(emprestimo);
	}
	
	public Emprestimo atualizarEmprestimo(Emprestimo emprestimo) {
		return emprestimoRepository.save(emprestimo);
	}
	
	public Boolean deletarEmprestimo(Emprestimo emprestimo) {
		if(emprestimo == null)
			return false;
		
		Emprestimo emprestimoExistente = buscarEmprestimoPorId(emprestimo.getCodigoEmprestimo());
		
		if(emprestimoExistente == null)
			return false;
		
		emprestimoRepository.delete(emprestimo);
		
		Emprestimo emprestimoContinuaExistindo = buscarEmprestimoPorId(emprestimo.getCodigoEmprestimo());
		
		if(emprestimoContinuaExistindo == null)
			return true;
		
		return false;
	}
}
