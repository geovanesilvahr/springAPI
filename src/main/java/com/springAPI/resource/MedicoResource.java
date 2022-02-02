package com.springAPI.resource;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springAPI.event.RecursoCriadoEvent;
import com.springAPI.model.Medico;
import com.springAPI.repository.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoResource {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	private List<Medico> listarTodos(){
		return medicoRepository.findAll();
	}
	
	@PostMapping
	private ResponseEntity<Medico> criar(@Valid @RequestBody Medico medico, HttpServletResponse response){
		Medico medicoSalvo = medicoRepository.save(medico);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, medicoSalvo.getCodigo()));
		
		//Retorna através do ResponseEntity os dados salvos da classe.
		return ResponseEntity.status(HttpStatus.CREATED).body(medicoSalvo);
		
	}
	//Retorna a lista do codigo solicitado (Caso não haja, retorna NotFound - 404)
	@GetMapping("/{codigo}")
	private ResponseEntity<Medico> listarTodos(@PathVariable Long codigo){
		Optional<Medico> medico = this.medicoRepository.findById(codigo);
		return medico.isPresent() ? ResponseEntity.ok(medico.get())	: ResponseEntity.notFound().build();	
	}

}
