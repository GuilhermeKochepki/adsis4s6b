package com.unicesumar.adsis4s2021.dozero.televisao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TelevisaoService {
	@Autowired
	private TelevisaoRepository repo;
	
	public List<Televisao> obterTodos() {
		return repo.findAll();
	}
}
