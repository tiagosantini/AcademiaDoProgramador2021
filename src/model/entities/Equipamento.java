package model.entities;

import java.util.Date;

public class Equipamento {

	
	private Integer id;
	private String nomeProduto;
	private String numeroSerie;
	private Double precoAquisicao;
	private Date dataFabricacao;
	private String fabricante;
	
	public Equipamento() {
		
	}
	
	public Equipamento(Integer id, String nomeProduto, String numeroSerie, String fabricante) {
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.numeroSerie = numeroSerie;
		this.fabricante = fabricante;
	}

	public Equipamento(Integer id, String nomeProduto, Double precoAquisicao, Date dataFabricacao, String fabricante) {
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.precoAquisicao = precoAquisicao;
		this.dataFabricacao = dataFabricacao;
		this.fabricante = fabricante;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getPrecoAquisicao() {
		return precoAquisicao;
	}

	public void setPrecoAquisicao(Double precoAquisicao) {
		this.precoAquisicao = precoAquisicao;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	
}
