package br.com.stackx.projetoweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.stackx.projetoweb.model.Professor;

public class ProfessorDAO extends Professor {

	public void insert() {
		try {

			Connection minhaConexao = DAO.getConnection();
			// criei um comando SQL
			PreparedStatement meuSQL = minhaConexao.prepareStatement(
					"INSERT INTO Professor (idCidade, nome, sexo, cpf, email, ddd, telefone, cep, logradouro, numero, complemento)"
							+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			// atribuindo valores aos ? do comando SQL
			meuSQL.setInt(1, this.idCidade);
			meuSQL.setString(2, this.nome);
			meuSQL.setString(3, this.sexo);
			meuSQL.setString(4, this.cpf);
			meuSQL.setString(5, this.email);
			meuSQL.setInt(6, this.ddd);
			meuSQL.setInt(7, this.telefone);
			meuSQL.setString(8, this.cep);
			meuSQL.setString(9, this.logradouro);
			meuSQL.setInt(10, this.numero);
			meuSQL.setString(11, this.complemento);

			// execultando o comando SQL
			meuSQL.executeUpdate();
			meuSQL.close();
			// dando os commits para o banco
			minhaConexao.commit();
			minhaConexao.close();

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	public void update() {

	}

	public void delete() {

	}

	public void select() {

	}
}
