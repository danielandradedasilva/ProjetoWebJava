package br.com.stackx.projetoweb;

public class Circulo extends FiguraGeometrica {

	public Circulo() {

	}

	public Circulo(double raio) {
		this.raio = raio;
	}

	double raio;

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	public double getArea() {

		return Math.pow(Math.PI * raio, 2);
	}

	public double getPerimetro() {

		return 2 * Math.PI * raio;
	}

}
