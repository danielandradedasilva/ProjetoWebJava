package br.com.stackx.projetoweb;

public class Teste {

	public static void main(String[] args) {

		String nomeEstadoPesquisa = "rio";

		String stringQuery = "SELECT idEstado, nome, sigla, codigoIbge FROM Estado";

		if (nomeEstadoPesquisa != null) {
			stringQuery += " where nome LIKE ? ";
		}

		stringQuery += " ORDER BY nome";
		System.out.println(stringQuery);
	}

}
