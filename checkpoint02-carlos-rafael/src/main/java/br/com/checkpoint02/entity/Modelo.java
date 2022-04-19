package br.com.checkpoint02.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_modelo")
@SequenceGenerator(name = "modelo", sequenceName = "sq_tb_modelo", allocationSize = 1)
public class Modelo implements Serializable {

	private static final long serialVersionUID = -7127524315787996473L;
	
	
	public Modelo() {
		this.dataCadastro = LocalDateTime.now();
		this.dataAtualizacao = LocalDateTime.now();
	}
	
	public Modelo(String descricao) {
		this();
		this.descricao = descricao;
	}
	
	@Id
	@GeneratedValue(generator = "modelo", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "ds_modelo", length = 60,nullable = false)
	private String descricao;
	
	@Column(name = "dt_cadastro", nullable = false)
	private LocalDateTime dataCadastro;
	
	@Column(name = "dt_atualizacao", nullable = false)
	private LocalDateTime dataAtualizacao;
	
	@OneToMany(mappedBy = "modelo", fetch = FetchType.EAGER)
	private List<Carro> carros;
	
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

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	@Override
	public String toString() {
		return "Modelo [id=" + id + ", descricao=" + descricao + ", dataCadastro=" + dataCadastro
				+ ", dataAtualizacao=" + dataAtualizacao + ", carros=" + carros + "]";
	}
}
