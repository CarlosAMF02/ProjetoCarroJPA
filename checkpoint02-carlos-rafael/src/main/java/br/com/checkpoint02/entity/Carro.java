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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_carro")
@SequenceGenerator(name = "carro", sequenceName = "SQ_TB_CARRO", allocationSize = 1)
public class Carro implements Serializable {

	private static final long serialVersionUID = 7606987496117754968L;
	
	public Carro() {
		this.dataCadastro = LocalDateTime.now();
		this.dataAtualizacao = LocalDateTime.now();
	}
	
	public Carro(String placa, String cor, String chassi) {
		this();
		this.placa = placa;
		this.cor = cor;
		this.chassi = chassi;
	}
	
	@Id
	@GeneratedValue(generator = "carro", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "ds_placa", length = 7)
	private String placa;
	
	@Column(name = "ds_cor", length = 20, nullable = false)
	private String cor;
	
	@Column(name = "ds_chassi", length = 17, nullable = false)
	private String chassi;
	
	@Column(name = "dt_cadastro", nullable = false)
	private LocalDateTime dataCadastro;
	
	@Column(name = "dt_atualizacao", nullable = false)
	private LocalDateTime dataAtualizacao;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "tb_carro_acessorio",
			joinColumns = @JoinColumn(name = "carro_id"),
			inverseJoinColumns = @JoinColumn(name = "acessorio_id"))
	private List<Acessorio> acessorios;
	
	@ManyToOne
	@JoinColumn(name = "modelo_id")
	private Modelo modelo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
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
		return "Carro [id=" + id + ", placa=" + placa + ", cor=" + cor + ", chassi=" + chassi + ", dataCadastro="
				+ dataCadastro + ", dataAtualizacao=" + dataAtualizacao + ", acessorios=" + acessorios + ", modelo="
				+ modelo.getDescricao() + "]";
	}
}
