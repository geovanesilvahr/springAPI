package com.springAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import com.springAPI.model.Medico;

@Controller
public interface MedicoRepository extends JpaRepository<Medico, Long>{

}
