package operacoes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entidadeJDBC.*;
import entidades.*;

public class Operacao extends EntidadeJDBC {

	public Operacao(String server, String user, String password) throws SQLException {
		super(server, user, password);
	}
	
	
	// Listar todos os envolvidos no projeto
	public void listarPessoas(PessoaJDBC pessoajdbc) {
		
		System.out.println("Id    Nome");
		System.out.println("---------------------------------------");

		List<Pessoa> listpessoa = pessoajdbc.retrievePessoas();
		for (Pessoa p : listpessoa) {
			System.out.println(p.getIdPessoa() + "    " + p.getpNome());
		}
		
	}
	
	// Listar Turmas
	
	public void listarTurmas(TurmaJDBC turmajdbc) {
		System.out.println(" Turma    Id Curso    Total de Vagas");
		System.out.println("---------------------------------------");
		List<Turma> listturma = turmajdbc.retrieveTurmas();
		for (Turma t : listturma) {
			System.out.println("   " + t.getIdTurma() + "          " + t.getIdCurso() + "            " + t.gettVagas());
		}
		
	}
	
	// Listar Cursos
	
		public void listarCursos(CursoJDBC cursojdbc) {
			System.out.println("  Nome         Descrição                     Carga Horária ");
			System.out.println("-----------------------------------------------------------");
			List<Curso> listcurso = cursojdbc.retrieveCursos();
			for (Curso c : listcurso) {
				System.out.println(c.getIdCurso() + " " + c.getcNome() + "   " + c.getcDescricao() + "            " + c.getCargaHoraria());
			}
		}
	
	// Listar Salas
	
	public void listarSalas(SalaJDBC salajdbc) {
		System.out.println("Id    Descrição");
		System.out.println("---------------------------------------");
		List<Sala> listsala = salajdbc.retrieveSalas();
		for (Sala s : listsala) {
			System.out.println(s.getIdSala() + " " + s.getsDescricao());
		}
		
	}

	// Listar Postagem
	
	public void listarPostagens(PostagemJDBC postagemjdbc) {
		System.out.println("  Pessoa    Publicação                                 Data");
		System.out.println("--------------------------------------------------------------");
		List<Postagem> listpostagem = postagemjdbc.retrievePostagens();
		if (listpostagem != null) {
			for (Postagem p : listpostagem) {
				System.out.println("    " + p.getIdPessoa() + "       " + p.getTexto() + "    " + p.getData());
			}
		}
		else{System.out.println("\n Ainda não foram feitas postagens!");}
		
	}
	
	// Listar Agendamentos
	
	public void listarAgendar(AgendarJDBC agendarjdbc) {
		System.out.println("\t Aluno \t Voluntário \t Data \t\t Horario \t Confirmado");
		System.out.println("----------------------------------------------------------------------------");
		List<Agendar> listagendar = agendarjdbc.retrieveAgendamentos();
		for (Agendar a : listagendar) {
			System.out.println("\t " +a.getIdAluno() + " \t   " + a.getIdVoluntario() + " \t \t" + a.getData() + " \t " + a.getHorario() + " \t\t " + a.isConfirmado());
		}
		
	}
	
	// Listar Lista_Espera
	
	public void listarLista_Espera(Lista_EsperaJDBC lista_esperajdbc) {
		
		System.out.println("  Aluno    Curso");
		System.out.println("---------------------------------------");
		List<Lista_Espera> listlista_espera = lista_esperajdbc.retrieveListas_Espera();
		for (Lista_Espera l : listlista_espera) {
			System.out.println("    " + l.getIdAluno() + "        " + l.getIdCurso());
		}
		
	}
	
	// Listar Voluntarios 
	  
	public void listarVoluntarios() {
		try{
			super.conectar();
			
			String sql = "SELECT * FROM pessoa NATURAL JOIN horario_disponibilidade"; 
			
			ResultSet rs = comando.executeQuery(sql);
			System.out.println(" \tNome\t\tEmail\t\t Disponibilidade");
			System.out.println("--------------------------------------------------");
			
			while (rs.next()){
				
				System.out.println(rs.getInt("idPessoa") + "\t" + rs.getString("pNome") + "\t" + rs.getString("pEmail") + "\t" + rs.getString("horario_disponibilidade"));
				
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	 
	
	public void listarTurmasPorAluno(Turma_AlunoJDBC turma_alunojdbc, int idAluno) {
		
		try{
			super.conectar();
			
			String sql = "select * from turma_aluno natural join turma natural join curso  where idPessoa=" + idAluno; 
			
			ResultSet rs = comando.executeQuery(sql);
			System.out.println("\nTurmas do Aluno com id =" + idAluno);
			System.out.println("--------------------------------------------------");
			
			while (rs.next()){
				
				System.out.println(rs.getInt("idTurma")+ "\t"  + rs.getString("cNome"));
				
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void listarAlunosPorTurma(Turma_AlunoJDBC turma_alunojdbc, int idTurma) {

		try{
			super.conectar();
			
			String sql = "select * from turma_aluno natural join pessoa  where idTurma=" + idTurma; 
			
			ResultSet rs = comando.executeQuery(sql);
			System.out.println("\nAlunos da Turma " + idTurma);
			System.out.println("--------------------------------------------------");
			
			while (rs.next()){
				
				System.out.println(rs.getInt("idPessoa")+ "\t"  + rs.getString("pNome"));
				
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
}