package br.com.stackx.projetoweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.stackx.projetoweb.model.Cidade;

public class CidadeDAO extends Cidade {

	public void insert() {

		try {
			Connection minhaConexao = DAO.getConnection();
			// criei um comando SQL
			PreparedStatement meuSQL = minhaConexao
					.prepareStatement("INSERT INTO Cidade (idEstado, nome, codigoIbge) VALUES (?, ?, ?)");

			// atribuindo valores aos ? do comando SQL
			meuSQL.setInt(1, this.idEstado);
			meuSQL.setString(2, this.nome);
			meuSQL.setInt(3, this.codigoIbge);

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
