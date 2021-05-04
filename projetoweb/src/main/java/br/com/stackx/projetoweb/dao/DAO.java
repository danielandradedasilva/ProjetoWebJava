package br.com.stackx.projetoweb.dao;

import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;

import br.com.stackx.projetoweb.exception.StackxException;

public class DAO {

	private static BasicDataSource basicDataSource = null;

	public static void init() {
		try {
			basicDataSource = new BasicDataSource();

			basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // url conexao banco dados mysql
			basicDataSource.setUsername("root");
			basicDataSource.setPassword("1234");
			basicDataSource.setUrl("jdbc:mysql://localhost:3306/projweb"); // string de conexão do banco mySQL Basico

			basicDataSource.setInitialSize(3); // --> Intermediario

			basicDataSource.setDefaultAutoCommit(false); // true/false
			basicDataSource.setDefaultTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

			basicDataSource.setValidationQuery("SELECT CURRENT_TIMESTAMP");

		} catch (Exception exception) {
			System.out.print("Deu ruim!");
			exception.printStackTrace();
		} finally {
			// fecha conexao
		}
	}

	// recuperar uma conexão
	public static Connection getConnection() throws StackxException {
		try {
			return basicDataSource.getConnection();
		} catch (Exception exception) {
			throw new StackxException("ERRO AO OBTER A CONEXÃO", exception);
		}
	}

	public static void close() {
		try {
			basicDataSource.close();
		} catch (Exception exception) {

		}
	}
}
