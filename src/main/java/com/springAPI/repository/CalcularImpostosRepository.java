package com.springAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import com.springAPI.model.CalcularImpostos;

@Controller
public interface CalcularImpostosRepository extends JpaRepository<CalcularImpostos, Double>{

}
