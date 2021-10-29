package com.unicesumar.adsis4s2021.dozero.notebook;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
