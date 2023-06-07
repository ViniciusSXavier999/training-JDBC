package loja_virtual_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// PADRÃO DE PROJETO FACTORY METHOD

public class TestaListagem {
	
	public static void main(String[] args) throws SQLException {
		
		// criando o objeto da minha classe de conexão
		CriaConexao criaConexao = new CriaConexao();
		
		// acessando meu método de conexão
		Connection connection = criaConexao.recuperarConexao();
		
		
		
		
		/*
		 * AS QUERYS QUE A GENTE UTILIZA NO MYSQL COMO SELECT * FROM, SELECT E OS CAMPOS QUE A GENTE QUER TRAZER
		 * DA NOSSA TABELA POR EXEMPLO, NO MUNDO JAVA, ELES SÃO CONHECIDOS COMO STATEMENT
		 * 
		 * */
		
		PreparedStatement stm =  connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM TB_PRODUTO");
		
		// aqui eu vou passar a query sql que eu desejo executar 
		stm.execute();
		
		
		// com esse metodo eu consigo pegar o conteudo da minha tabela no banco de dados
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			// fazendo a recuperação dos dados para eles aparecer no console 
			Integer id = rst.getInt("ID");
			System.out.println(id);
			
			String nome = rst.getString("NOME");
			System.out.println(nome);
			
			String descricao = rst.getString("DESCRICAO");
			System.out.println(descricao);

			
		}
		
		
		// TUDO QUE A GENTE ABRE A GENTE TEM QUE FECHAR 
		connection.close();
		
	}

}
