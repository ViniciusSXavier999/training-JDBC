package loja_virtual_repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriaConexao {
	
	public Connection recuperarConexao() throws SQLException {
		/*
		 * Driver manager = Gerenciador de drives
		 * 
		 * 
		 * 
		 * */
		
		// COM ESSA CONEXÃO A GENTE VAI CONSEGUIR EXECUTAR OS COMANDO SELECT, UPDATE, ALTERAR E DELETAR DO MYSQL
		return DriverManager
				.getConnection("jdbc:mysql://localhost/db_loja_virtual?useTimezona=true&serverTimezone=UTC", "root", "soudev");
	}

}
