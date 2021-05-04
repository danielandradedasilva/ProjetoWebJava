package br.com.stackx.projetoweb;

import java.util.List;

import br.com.stackx.projetoweb.dao.DAO;
import br.com.stackx.projetoweb.dao.EstadoDAO;
import br.com.stackx.projetoweb.model.Estado;

public class EstadoDAOTeste {

	public static void main(String[] args) {

		try {

			// inicializar o banco de dados
			DAO.init();

			// criar um estado
			EstadoDAO estadoDAO = new EstadoDAO();

			List<Estado> minhaLista = estadoDAO.sellectAll();

			for (int i = 0; i < minhaLista.size(); i++) {
				System.out.println(minhaLista.get(i).getIdEstado());
				System.out.println(minhaLista.get(i).getNome());
				System.out.println(minhaLista.get(i).getSigla());
				System.out.println(minhaLista.get(i).getCodigoIbge());
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

}
