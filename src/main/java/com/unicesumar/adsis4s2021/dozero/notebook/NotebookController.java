package com.unicesumar.adsis4s2021.dozero.notebook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicesumar.adsis4s2021.dozero.base.RequisiçãoPutInválido;

@RestController
@RequestMapping("/api/notebook")
public class NotebookController {
	@Autowired
	private NotebookService service;
	
	@GetMapping
	public List<Notebook> obterTodos() {
		return service.obterTodos();	//o método não será findAll(), será usado o nome da função
	}									//declarada no service
	
	@GetMapping("/{id}")
	public Notebook obterPeloId(@PathVariable String id) {
		return service.obterPeloId(id);
	}
	
	@PutMapping("/{id}")
	public Notebook atualizar(@PathVariable String id, @RequestBody Notebook notebook) {
		if (!id.equals(notebook.getId())) {
			throw new RequisiçãoPutInválido();
		}
		return service.atualizar(notebook);
	}
	
	@PostMapping("/{id}")
	public Notebook criarNovo(@RequestBody Notebook notebook) {
		return service.criarNovo(notebook);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable String id) {
		service.deletar(id);
	}
	
}
