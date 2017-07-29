package br.com.sistemagerenciador.modelo.entidade.usuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.sistemagerenciador.modelo.entidade.EntidadeBase;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable, EntidadeBase {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 60, nullable = false)
	private String nome;
	  
	
	public void setId(Long id) {
		this.id = id;
	}  
	
	@Override
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
