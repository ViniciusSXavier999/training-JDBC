package loja_virtual_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// USANDO O PREPAREDSTATEMENT

/*
 * Minha motivação para desenvolver essa classe é pensando o seguinte: se o sistema, um dia ele tiver uma interface gráfica e as 
 * informações como o nome e a descrição do produto forem informados através de um formulário, por exemplo, o que vai acontecer?

Quando o usuário colocar no meu formulário o nome e a descrição e dar um submit, do meu lado da aplicação, eu tenho que 
recuperar essa informação, guardar os valores em uma variável e concatenar com a cláusula SQL, que aí, de fato, quando for 
executado o comando stm.execute, ele vai inserir as informações com as informações que usuário nos passou.
 * 
 * */

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		String nome = "mouse";
		String descricao = "blablabla";

		// criando o objeto da minha classe de conexão
		CriaConexao criaConexao = new CriaConexao();

		// acessando meu método de conexão
		Connection connection = criaConexao.recuperarConexao();

		/*
		 * Invés de eu criar o Statement, eu vou preparar um Statement. Quando eu
		 * preparo um Statement, eu estou falando que a responsabilidade de gerenciar
		 * esses atributos que eu passo para a minha cláusula SQL, não vai ser mais eu
		 * que vou fazer, agora vai ser o JDBC.
		 * 
		 */

		/*
		 * COMO O PREPARESTATEMENT vai saber que as ? ? vai ser substituida por nome e
		 * descricao ? quando a gente utiliza um prepareStatement ele vai retornar para
		 * gente outro prepareStatement
		 * 
		 */
		PreparedStatement stm = connection.prepareStatement("INSERT INTO TB_PRODUTO (nome, descricao) VALUES (?, ?)",
				Statement.RETURN_GENERATED_KEYS);

		// aqui eu estou falando para o meu statment substituir as ?, ? por nome e
		// descrição
		stm.setString(1, nome);
		stm.setString(2, descricao);

		stm.execute();

		ResultSet rst = stm.getGeneratedKeys();

		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
	}

	/*
	 * Então aqui está a maravilha do PreparedStatement. Além de ele evitar os SQL
	 * Injections, ele deixa o código bem mais legível, então vemos agora, se você
	 * bater o olho em VALUES, eu tenho dois atributos e embaixo eu seto esses
	 * atributos. Então ficou muito mais bonito, fica muito menos vulnerável o nosso
	 * código.
	 * 
	 * [13:37] Além de mais bonito, menos vulnerável, então é muito vantajoso. Com
	 * isso, agora nós estamos aptos a fazer o Refactory de todas as classes que nós
	 * criamos até agora. Então, para isso, a TestaListagem, a TestaRemocao, invés
	 * de usarmos o Statement, agora nós podemos passar a utilizar o
	 * PreparedStatement
	 * 
	 */

}
