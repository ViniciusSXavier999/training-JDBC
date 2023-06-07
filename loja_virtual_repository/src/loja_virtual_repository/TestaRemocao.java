package loja_virtual_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		// criando o objeto da minha classe de conexão
		CriaConexao criaConexao = new CriaConexao();

		// acessando meu método de conexão
		Connection connection = criaConexao.recuperarConexao();

		// após criar a conexão eu preciso criar o statement e vou receber ele na
		// variavel chamada STM
		PreparedStatement stm = connection.prepareStatement("DELETE FROM TB_PRODUTO WHERE ID > ?");
		
		stm.setInt(1, 2);
		
		// logo em seguida vou chamar o método execute
		stm.execute();

		/*
		 * eu tenho um método que chama getUpdateCount(), que nos retorna um inteiro.
		 * Esse inteiro significa o seguinte, quantas linhas que foram modificadas após
		 * o Statement ser executado. Então, quando eu executo esse delete do meu
		 * código, quantas linhas ele vai apagar?
		 * 
		 */
		
		Integer linhasModificadas = stm.getUpdateCount();
		
		System.out.println("Quantas linhas foram excluidas? " + linhasModificadas);

	}

}
