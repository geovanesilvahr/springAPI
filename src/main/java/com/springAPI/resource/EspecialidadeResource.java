package com.springAPI.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springAPI.model.Especialidade;
import com.springAPI.repository.EspecialidadeRepository;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeResource {
	
	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	
	//Lista Todas as Especialidades do Banco
	@GetMapping
	private List<Especialidade> listarTodos(){
		return especialidadeRepository.findAll();
	}
	
	//Cria uma nova Especialidade e Retorna através do Response o Status (202 - Quando criado)
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private void criar(@RequestBody Especialidade especialidade) {
		especialidadeRepository.save(especialidade);
	}
	
	//Retorna a lista do codigo solicitado (Caso não haja, retorna NotFound - 404)
	@GetMapping("/{codigo}")
	public ResponseEntity<Especialidade> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<Especialidade> espec = this.especialidadeRepository.findById(codigo);
		return espec.isPresent() ? ResponseEntity.ok(espec.get()) : ResponseEntity.notFound().build();
	}
	
	
	
	
	
}
