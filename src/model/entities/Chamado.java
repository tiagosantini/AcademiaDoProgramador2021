package model.entities;

import java.util.Date;

public class Chamado{
	
	private String tituloChamado;
	private String descricao;
	private Equipamento equipamento;
	private Date dataAbertura;
	
	public Chamado(String tituloChamado, String descricao, Equipamento equipamento, Date dataAbertura) {
		this.tituloChamado = tituloChamado;
		this.descricao = descricao;
		this.equipamento = equipamento;
		this.dataAbertura = dataAbertura;
	}

	public String getTituloChamado() {
		return tituloChamado;
	}

	public void setTituloChamado(String tituloChamado) {
		this.tituloChamado = tituloChamado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
}
