package com.springAPI.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springAPI.model.Especialidade;
import com.springAPI.repository.EspecialidadeRepository;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeResource {
	
	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	
	@GetMapping
	private List<Especialidade> listarTodos(){
		return especialidadeRepository.findAll();
	}
	
	
	
	
}