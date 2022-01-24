package com.springAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.springAPI.model.Especialidade;

@Controller
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long>{

}
