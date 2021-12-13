package com.springAPI.repository;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface CalcularImpostos extends JpaRepository<CalcularImpostos, BigDecimal>{

}
