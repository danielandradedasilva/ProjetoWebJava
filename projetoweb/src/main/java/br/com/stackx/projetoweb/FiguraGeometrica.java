package br.com.stackx.projetoweb;

public abstract class FiguraGeometrica implements IFiguraGeometrica {

	private String cor;

	public abstract double getArea();

	public abstract double getPerimetro();

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {

		this.cor = cor;
	}
}
