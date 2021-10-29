package com.unicesumar.adsis4s2021.dozero.notebook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notebook")
public class NotebookController {
	@Autowired
	private NotebookService service;
	
	@GetMapping
	public List<Notebook> obterTodos() {
		return service.obterTodos();	//o método não será findAll(), será usado o nome da função
	}									//declarada no service
}
