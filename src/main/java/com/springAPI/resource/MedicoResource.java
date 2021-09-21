package com.springAPI.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springAPI.model.Medico;
import com.springAPI.repository.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoResource {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@GetMapping
	private List<Medico> listarTodos(){
		return medicoRepository.findAll();
	}
	/*Retorna 404 - NotFound caso não tenha nenhum dado na tabela. Caso haja, ele retorna 200 - Ok.
	private ResponseEntity<?> listarTodos(){
		List<Medico> medico = medicoRepository.findAll();
		return !medico.isEmpty() ? ResponseEntity.ok(medico) : ResponseEntity.notFound().build();
		
	}
	*/
	

}
