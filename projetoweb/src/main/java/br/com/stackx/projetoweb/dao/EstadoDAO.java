package br.com.stackx.projetoweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.stackx.projetoweb.exception.StackxException;
import br.com.stackx.projetoweb.model.Estado;

public class EstadoDAO extends Estado {

	public void insert() throws StackxException {

		try {
			Connection minhaConexao = DAO.getConnection();// conex?o com o banco

			// criei um comando SQL
			PreparedStatement meuSQL = minhaConexao
					.prepareStatement("INSERT INTO Estado (nome, sigla, codigoIbge) VALUES (?, ?, ?)");

			// atribuindo valores aos ? do comando SQL
			meuSQL.setString(1, this.nome);
			meuSQL.setString(2, this.sigla);
			meuSQL.setInt(3, this.codigoIbge);
			// execultando o comando SQL
			meuSQL.executeUpdate();
			meuSQL.close();

			// dando os commits para o banco
			minhaConexao.commit();
			minhaConexao.close();

		} catch (Exception exception) {
			throw new StackxException("Erro de inclus?o", exception);
		}
	}

	public void update() throws StackxException {
		try {
			Connection minhaConexao = DAO.getConnection();
			PreparedStatement meuSQL = minhaConexao.prepareStatement("UPDATE Estado " + "  SET nome = ?, "
					+ "      sigla = ?, " + "      codigoIbge = ? " + "WHERE idEstado = ? ");

			meuSQL.setString(1, nome);
			meuSQL.setString(2, sigla);
			meuSQL.setInt(3, codigoIbge);
			meuSQL.setInt(4, idEstado);

			meuSQL.executeUpdate();
			meuSQL.close();
			minhaConexao.commit();
			minhaConexao.close();
		} catch (Exception exception) {
			throw new StackxException("Erro de update", exception);
		}
	}

	public void delete() throws StackxException {
		try {
			Connection minhaConexao = DAO.getConnection();
			PreparedStatement meuSQL = minhaConexao.prepareStatement(" DELETE FROM Estado WHERE idEstado = ? ");
			meuSQL.setInt(1, idEstado);
			meuSQL.executeUpdate();
			meuSQL.close();
			minhaConexao.commit();
			minhaConexao.close();
		} catch (Exception exception) {
			throw new StackxException("Erro ao deletar", exception);
		}
	}

	public void select() throws StackxException {
		try {
			Connection minhaConexao = DAO.getConnection();

			PreparedStatement meuSQL = minhaConexao
					.prepareStatement(" SELECT  nome, sigla, codigoIbge FROM Estado WHERE idEstado = ? ");
			meuSQL.setInt(1, idEstado);
			ResultSet meuResultado = meuSQL.executeQuery();

			while (meuResultado.next()) {
				nome = meuResultado.getString(1);
				sigla = meuResultado.getString(2);
				codigoIbge = meuResultado.getInt(3);
			}
			meuResultado.close();
			meuSQL.close();
			minhaConexao.commit();
			minhaConexao.close();
		} catch (Exception exception) {
			throw new StackxException("Erro ao fazer o select", exception);
		}
	}

	public List<Estado> sellectAll() throws StackxException {
		return sellectAll(null);
	}

	public List<Estado> sellectAll(String nomeEstadoPesquisa) throws StackxException {

		try {
			Connection minhaConexao = DAO.getConnection();

			StringBuilder stringQuery = new StringBuilder("SELECT idEstado, nome, sigla, codigoIbge FROM Estado");

			if (nomeEstadoPesquisa != null) {
				stringQuery.append(" where nome LIKE ? ");
			}

			stringQuery.append(" ORDER BY nome");

			PreparedStatement meuSQL = minhaConexao.prepareStatement(stringQuery.toString());

			if (nomeEstadoPesquisa != null) {
				meuSQL.setString(1, "%" + nomeEstadoPesquisa + "%");
			}

			ResultSet meuResultado = meuSQL.executeQuery();

			ArrayList<Estado> arrayListRetorno = new ArrayList();

			while (meuResultado.next()) {

				Estado estado = new Estado();
				estado.setIdEstado(meuResultado.getInt(1));
				estado.setNome(meuResultado.getString(2));
				estado.setSigla(meuResultado.getString(3));
				estado.setCodigoIbge(meuResultado.getInt(4));

				arrayListRetorno.add(estado);
			}
			meuResultado.close();
			meuSQL.close();
			minhaConexao.commit();
			minhaConexao.close();

			return arrayListRetorno;

		} catch (Exception exception) {
			throw new StackxException("Erro ao fazer o selectAll", exception);
		}

	}

}
