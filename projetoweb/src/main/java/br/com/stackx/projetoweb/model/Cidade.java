package br.com.stackx.projetoweb.model;

public class Cidade {
	protected int idCidade;
	protected int idEstado;
	protected String nome;
	protected int codigoIbge;

	public Cidade() {
		this(0, 0, null, 0);
	}

	public Cidade(int idCidade, int idEstado, String nome, int codigoIbge) {
		super();
		this.idCidade = idCidade;
		this.idEstado = idEstado;
		this.nome = nome;
		this.codigoIbge = codigoIbge;
	}

	public int getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigoIbge() {
		return codigoIbge;
	}

	public void setCodigoIbge(int codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

}
