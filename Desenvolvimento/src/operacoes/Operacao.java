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
		System.out.println("  Aluno    Voluntário    Data      Horario    Confirmado");
		System.out.println("-------------------------------------------------------");
		List<Agendar> listagendar = agendarjdbc.retrieveAgendamentos();
		for (Agendar a : listagendar) {
			System.out.println("     " +a.getIdAluno() + "          " + a.getIdVoluntario() + "      " + a.getData() + "    " + a.getHorario() + "       " + a.isConfirmado());
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
			System.out.println("  Nome       Email                  Disponibilidade");
			System.out.println("--------------------------------------------------");
			
			while (rs.next()){
				
				System.out.println(rs.getInt("idPessoa") + " " + rs.getString("pNome") + "     " + rs.getString("pEmail") + "       " + rs.getString("horario_disponibilidade"));
				
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	 
	
	public void listarTurmasPorAluno(Turma_AlunoJDBC turma_alunojdbc, int idAluno) {

		List<Turma_Aluno> turma_alunolist = turma_alunojdbc.retrieveTurma_Aluno();
		for (Turma_Aluno t : turma_alunolist) {
			if(t.getIdPessoa() == idAluno) {
				System.out.println(t.getIdTurma());
			}
		}
		
	}
	
	public void listarAlunosPorTurma(Turma_AlunoJDBC turma_alunojdbc, int idTurma) {

		List<Turma_Aluno> turma_alunolist = turma_alunojdbc.retrieveTurma_Aluno();
		for (Turma_Aluno t : turma_alunolist) {
			if(t.getIdTurma() == idTurma) {
				System.out.println(t.getIdPessoa());
			}
		}	
	}	
}