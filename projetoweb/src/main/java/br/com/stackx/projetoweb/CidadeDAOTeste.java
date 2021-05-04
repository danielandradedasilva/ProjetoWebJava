package br.com.stackx.projetoweb;

import br.com.stackx.projetoweb.dao.CidadeDAO;
import br.com.stackx.projetoweb.dao.DAO;

public class CidadeDAOTeste {

	public static void main(String[] args) {

		try {

			// inicializar o banco de dados
			DAO.init();

			CidadeDAO cidade = new CidadeDAO();
			cidade.setIdEstado(1);
			cidade.setNome("São Paulo");
			cidade.setCodigoIbge(11);
			cidade.insert();

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

}
