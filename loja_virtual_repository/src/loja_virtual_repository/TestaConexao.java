package loja_virtual_repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		// criando o objeto da minha classe de conexão
				CriaConexao criaConexao = new CriaConexao();
				
				// acessando meu método de conexão
				Connection connection = criaConexao.recuperarConexao();
				
		
		// mostrando na tela que deu tudo certo
		System.out.println("Fechando conexão");
		
		// TUDO QUE A GENTE ABRE A GENTE TEM QUE FECHAR 
		connection.close();

	}

}
