package com.springAPI.model;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_medicos")
public class Medico {
	
	@Id
	@Column(name = "med_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull
	@Column(name = "med_nome")
	private String nome;
	
	@NotNull
	@Column(name = "med_sobrenome")
	private String sobrenome;
	
	@NotNull
	@Column(name = "med_dtnascimento")
	private int dtNascimento;

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		return Objects.equals(codigo, other.codigo);
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(int dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	
}
