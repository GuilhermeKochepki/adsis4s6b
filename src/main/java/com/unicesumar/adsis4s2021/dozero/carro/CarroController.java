package com.unicesumar.adsis4s2021.dozero.carro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unicesumar.adsis4s2021.dozero.base.RequisiçãoPutInválido;

@RestController
@RequestMapping("/api/carros")
public class CarroController {
	@Autowired
	private CarroService service;

	@GetMapping
	public List<Carro> obterTodos(){
		return service.obterTodos();
	}
	
	@GetMapping("/{id}")
	public Carro obterPeloId(@PathVariable String id){
		return service.obterPeloId(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String criarNovo(@RequestBody Carro novo) {
		service.criarNovo(novo);
		return novo.getId();
	}
	
	@PutMapping("/{id}")
	//@RequestMapping("/{id}") ISSO NÃO EXISTE
	public void atualizar(@PathVariable String id,@RequestBody Carro carro) {
		if (!id.equals(carro.getId())) {
			throw new RequisiçãoPutInválido();
		}
		service.atualizar(carro);
	}
	
	@DeleteMapping("/{id}")
	public void excluirPeloId(@PathVariable String id) {
		service.excluirPeloId(id);
	}
}
