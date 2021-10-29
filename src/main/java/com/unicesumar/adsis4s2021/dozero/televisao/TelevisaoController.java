package com.unicesumar.adsis4s2021.dozero.televisao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/televisao")
public class TelevisaoController {
	@Autowired
	private TelevisaoService service;
	
	@GetMapping
	public List<Televisao> obterTodos() {
		return service.obterTodos();
	}
}
