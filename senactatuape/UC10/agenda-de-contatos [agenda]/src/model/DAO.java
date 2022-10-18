package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

	// criando variáveis encapsuladas para acesso ao banco
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://10.26.49.111:3306/agenda";
	private String user = "root";
	private String password = "123@senac";

	/**
	 * Método responsavel por abrir uma coneção com o banco
	 * 
	 * @return conectar
	 */
	public Connection conectar() {

		// criar um objeto
		Connection con = null;
		// tratamento de exceções
		try {
			// lógica principal para abrir a conexão
			// Uso do driver
			Class.forName(driver);
			// Obter os parâmetros da conexão (Informações do servidor)
			con = DriverManager.getConnection(url, user, password); //conectar
			// retornar a conexão ("abrir a porta da geladeira")
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
}
