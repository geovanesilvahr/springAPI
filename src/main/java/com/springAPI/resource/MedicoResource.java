package com.springAPI.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	//Retorna a lista do codigo solicitado (Caso não haja, retorna NotFound - 404)
	@GetMapping("/{codigo}")
	private ResponseEntity<Medico> listarTodos(@PathVariable Long codigo){
		Optional<Medico> medico = this.medicoRepository.findById(codigo);
		return medico.isPresent() ? ResponseEntity.ok(medico.get())	: ResponseEntity.notFound().build();	
	}

}
