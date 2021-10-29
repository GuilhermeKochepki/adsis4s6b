package com.unicesumar.adsis4s2021.dozero.notebook;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class NotebookService {
	@Autowired
	private NotebookRepository repo;
	
	public List<Notebook> obterTodos() {
		return repo.findAll();
	}
	
}
