package br.com.stackx.projetoweb;

import br.com.stackx.projetoweb.dao.DAO;
import br.com.stackx.projetoweb.dao.ProfessorDAO;

public class ProfessorDAOTeste {

	public static void main(String[] args) {

		try {
			// inicializar o banco de dados
			DAO.init();

			ProfessorDAO professor = new ProfessorDAO();

			professor.setIdCidade(1);
			professor.setNome("Augusto");
			professor.setSexo("M");
			professor.setCpf("323789459");
			professor.setEmail("exemplo@gmail.com");
			professor.setDdd(11);
			professor.setTelefone(97884533);
			professor.setCep("03672010");
			professor.setLogradouro("Rua Penha de França");
			professor.setNumero(549);
			professor.setComplemento(" ");

			professor.insert();

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

}
