package loja_virtual_repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		// criando o objeto da minha classe de conexão
		CriaConexao criaConexao = new CriaConexao();

		// acessando meu método de conexão
		Connection connection = criaConexao.recuperarConexao();
		
		/*
		 * AS QUERYS QUE A GENTE UTILIZA NO MYSQL COMO SELECT * FROM, SELECT E OS CAMPOS QUE A GENTE QUER TRAZER
		 * DA NOSSA TABELA POR EXEMPLO, NO MUNDO JAVA, ELES SÃO CONHECIDOS COMO STATEMENT
		 * 
		 * */

		
		// exemplo sem o prepareStatement
		Statement stm = connection.createStatement();

		stm.execute("INSERT INTO TB_PRODUTO (nome, descricao) VALUES ('Mouse', 'Mouse sem fio') ",
				Statement.RETURN_GENERATED_KEYS);

		ResultSet rst = stm.getGeneratedKeys();

		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}

	}

}

/*
 * Olá buscante.
 * 
 * ResultSet é uma interface utilizada pra guardar dados vindos de um banco de
 * dados.
 * 
 * Basicamente, ela guarda o resultado de uma pesquisa numa estrutura de dados
 * que pode ser percorrida, de forma que você possa ler os dados do banco.
 * 
 * Exemplo:
 * 
 * Conection con = //de alguma forma vc pega conexao com o banco Statement stmt
 * = con.createStatement(); //aqui voce recebe um objeto ResultSet com todos os
 * elementos //da tabela cliente: ResultSet rs =
 * stmt.executeQuery("SELECT * FROM Clientes"); //para percorrer o resultset,
 * faca: while(rs.next()) { //pega o valor da coluna nome, de cada linha: String
 * nome = rs.getString("Nome"); //imprime no console:
 * System.out.println("Nome do Cliente: " + nome); } Espero ter ajudado!
 * 
 * 
 */
