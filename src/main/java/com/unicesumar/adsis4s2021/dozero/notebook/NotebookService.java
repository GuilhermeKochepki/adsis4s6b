package com.unicesumar.adsis4s2021.dozero.notebook;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicesumar.adsis4s2021.dozero.base.RegistroJáExistente;
import com.unicesumar.adsis4s2021.dozero.base.RegistroNãoExistente;

@Service
@Transactional
public class NotebookService {
	@Autowired
	private NotebookRepository repo;
	
	public List<Notebook> obterTodos() {
		return repo.findAll();
	}

	public Notebook obterPeloId(String id) {
		try {
			return repo.findById(id).get();  //precisa chamar o get, senão ele não puxa os dados
		} catch (Exception e) {
			throw new RegistroNãoExistente();
		}
	}
	
	public Notebook criarNovo(Notebook novo) {
		if (repo.findById(novo.getId()).isPresent()) {
			throw new RegistroJáExistente();
		}
		return repo.save(novo);
	}
	
	public Notebook atualizar(Notebook notebook) {
		if(repo.findById(notebook.getId()).isEmpty()) {
			throw new RegistroNãoExistente();
		}
		return repo.save(notebook);
	}
	
	public void deletar(String id) {	//primeiro encontre ele para passar ao delete o objeto para ser deletado
		try {
			Notebook recuperado = repo.findById(id).get();
			
			repo.delete(recuperado);
		} catch (NoSuchElementException e) {
			throw new RegistroNãoExistente();
		}	
	}
	
}
