package com.springAPI.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	private ResponseEntity<Medico> criar(@RequestBody Medico medico, HttpServletResponse response){
		Medico medicoSalvo = medicoRepository.save(medico);
		
		//Retorna o Location de onde foi salvo no Header.
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(medicoSalvo.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		//Retorna através do ResponseEntity os dados salvos da classe.
		return ResponseEntity.created(uri).body(medicoSalvo);
		
	}
	

}
