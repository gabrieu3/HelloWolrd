package dto;

import java.sql.Date;

public class LancamentoDto {

	
	private int id;
	
	private double valor;
	
	private Date dataCadastro;
	
	private String descricao;
	
	private String tipo;
	
	public LancamentoDto(int id, String descricao, Date dataCadastro, String tipo, double valor){
		this.id = id;
		this.valor = valor;
		this.dataCadastro = dataCadastro;
		this.descricao = descricao;
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
