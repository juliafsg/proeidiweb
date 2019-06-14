package entidadeJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import conexao.ConFactory;

public class PessoaJDBC {
	
	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;
	
	public PessoaJDBC(String server, String user, String password) throws SQLException {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
	}

	
	public void conectar() throws ClassNotFoundException, SQLException  {
        con = ConFactory.conexao(URL, NOME, SENHA, BANCO);  
		comando = con.createStatement();  
        System.out.println("Conectado!");     
	}	 

}
