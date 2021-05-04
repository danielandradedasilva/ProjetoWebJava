package br.com.stackx.projetoweb;

public class Quadrado extends FiguraGeometrica {

	private double lado;

	public Quadrado() {
	}

	public Quadrado(double lado) {
		this.lado = lado;
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	public double getArea() {

		return lado * lado;
	}

	public double getPerimetro() {

		return 4 * lado;
	}

}
