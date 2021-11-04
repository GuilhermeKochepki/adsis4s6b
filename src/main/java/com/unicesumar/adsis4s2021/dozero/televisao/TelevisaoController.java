package com.unicesumar.adsis4s2021.dozero.televisao;

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
@RequestMapping("/api/televisao")
public class TelevisaoController {
	@Autowired
	private TelevisaoService service;
	
	@GetMapping
	public List<Televisao> obterTodos() {
		return service.obterTodos();
	}
	
	@PutMapping("/{id}")
	public Televisao atualizar(@PathVariable String id, @RequestBody Televisao televisao) {
		if (!id.equals(televisao.getId())) {			//pedir explicação
			throw new RequisiçãoPutInválido();
		}
		return service.atualizar(televisao);
	}
	
	@PostMapping("/{id}")
	public Televisao criarNova(@PathVariable String id, @RequestBody Televisao televisao) {
		return service.criarNova(televisao);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable String id) {
		service.deletar(id);		//sem retorno
	}
}
