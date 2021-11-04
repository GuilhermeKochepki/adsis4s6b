package com.unicesumar.adsis4s2021.dozero.televisao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicesumar.adsis4s2021.dozero.base.RegistroJáExistente;
import com.unicesumar.adsis4s2021.dozero.base.RegistroNãoExistente;

@Service
@Transactional
public class TelevisaoService {
	@Autowired
	private TelevisaoRepository repo;
	
	public List<Televisao> obterTodos() {
		return repo.findAll();
	}
	
	public Televisao criarNova(Televisao nova) {
		if (repo.findById(nova.getId()).isPresent()) {		//verificar se já tem para chamar o erro
			throw new RegistroJáExistente();
		}
		return repo.save(nova);
	}
	
	public Televisao atualizar(Televisao televisao) {
		if (repo.findById(televisao.getId()).isEmpty()) {		//verificar se não tem para chamar o erro
			throw new RegistroNãoExistente();
		}
		return repo.save(televisao);
	}
	
	public void deletar(String id) {
		try {
			Televisao recuperada = repo.findById(id).get();	//perguntar o pq da necessidade do get
			
			repo.delete(recuperada);
		} catch (Exception e) {
			throw new RegistroNãoExistente();
		}
	}
}
