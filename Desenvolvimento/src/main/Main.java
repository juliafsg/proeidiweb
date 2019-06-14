package main;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import conexao.ConFactory;
import entidadeJDBC.PessoaJDBC;

public class Main {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");  
		java.sql.Date data = new java.sql.Date(format.parse("2022-10-13").getTime()); 
		
		System.out.println(data);
		
		PessoaJDBC pessoajdbc = new PessoaJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
	
		pessoajdbc.conectar();	
	
	}
}
