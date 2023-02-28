package models;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

	// criando vari�veis encapsuladas para acesso ao banco
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://10.26.45.107:3306/dbmecanica";
	private String user = "dba";
	private String password = "123@senac";

	/**
	 * M�todo responsavel por abrir uma cone��o com o banco
	 * 
	 * @return conectar
	 */
	public Connection conectar() {

		// criar um objeto
		Connection con = null;
		// tratamento de exce��es
		try {
			// l�gica principal para abrir a conex�o
			// Uso do driver
			Class.forName(driver);
			// Obter os par�metros da conex�o (Informa��es do servidor)
			con = DriverManager.getConnection(url, user, password); // conectar
			// retornar a conex�o ("abrir a porta da geladeira")
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
}
