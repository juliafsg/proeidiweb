package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import entidadeJDBC.PessoaJDBC;
import entidades.Pessoa;
import operacoes.Operacao;

public class Main {

	public static void main(String[] args) throws Exception {
		
		// Data de nascimento
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy"); 
		java.sql.Date dataN = new java.sql.Date(fmt.parse("01/04/2000").getTime());	
		System.out.println(dataN);
		
		// Data de matrícula
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp dataM = new java.sql.Timestamp(now.getTime());
		System.out.println(dataM);
				
		Pessoa pessoa = new Pessoa(3,"Abma", dataN, "016ere437", "juliafsg@outlook.com", false, "julinha123", dataM);    
		
		PessoaJDBC pessoajdbc = new PessoaJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");

		pessoajdbc.insert(pessoa);
		Operacao comando = new Operacao();
		
		comando.listarPessoas(pessoajdbc);
	
	}
}
