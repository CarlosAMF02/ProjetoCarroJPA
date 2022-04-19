package br.com.checkpoint02.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_acessorio")
@SequenceGenerator(name = "acessorio", sequenceName = "sq_tb_acessorio", allocationSize = 1)
public class Acessorio implements Serializable {

	private static final long serialVersionUID = -6021313334364354642L;
	
	public Acessorio() {
		this.dataCadastro = LocalDateTime.now();
		this.dataAtualizacao = LocalDateTime.now();
	}
	
	public Acessorio(String descricao) {
		this();
		this.descricao = descricao;
	}
	
	@Id
	@GeneratedValue(generator = "acessorio", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "ds_acessorio", length = 60,nullable = false)
	private String descricao;
	
	@Column(name = "dt_cadastro", nullable = false)
	private LocalDateTime dataCadastro;
	
	@Column(name = "dt_atualizacao", nullable = false)
	private LocalDateTime dataAtualizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public String toString() {
		return "Acessorio [id=" + id + ", descricao=" + descricao + ", dataCadastro="
				+ dataCadastro + ", dataAtualizacao=" + dataAtualizacao + "]";
	}
	
}
