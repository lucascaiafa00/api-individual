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
	
	public Emprestimo buscarEmprestimosPorId(Integer id) {
		return emprestimoRepository.findById(id).get();
	}
	
	public Emprestimo salvarEmprestimo(Emprestimo emprestimo) {
		return emprestimoRepository.save(emprestimo);
	}
	
	public Emprestimo atualizarEmprestimo(Emprestimo emprestimo) {
		return emprestimoRepository.save(emprestimo);
	}
	
	public void deletarEmprestimo(Emprestimo emprestimo) {
		emprestimoRepository.delete(emprestimo);
	}
}
