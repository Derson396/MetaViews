package model;

import java.sql.Date;

public class Midia {
	private int IdM,classificacaoIndicatoria,tipo;
	private float duracao;
	private String nome,sinopse;
	private Date dataLançamento;
	public Midia(int id,float duracao,String nome, int tipo,int classificacao,String sinopse,Date dataLancamento){
		setIdM(id);
		setDuracao(duracao);
		setNome(nome);
		setTipo(tipo);
		setClassificacaoIndicatoria(classificacao);
		setSinopse(sinopse);
		setDataLançamento(dataLancamento);
	}
	public int getIdM() {
		return IdM;
	}
	public void setIdM(int idM) {
		IdM = idM;
	}
	public int getClassificacaoIndicatoria() {
		return classificacaoIndicatoria;
	}
	public void setClassificacaoIndicatoria(int classificacaoIndicatoria) {
		this.classificacaoIndicatoria = classificacaoIndicatoria;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public float getDuracao() {
		return duracao;
	}
	public void setDuracao(float duracao) {
		this.duracao = duracao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public Date getDataLancamento() {
		return dataLançamento;
	}
	public void setDataLançamento(Date dataLançamento) {
		this.dataLançamento = dataLançamento;
	}
}
