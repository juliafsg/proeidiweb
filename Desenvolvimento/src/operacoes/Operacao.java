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

		List<Pessoa> listpessoa = pessoajdbc.retrievePessoas();
		for (Pessoa p : listpessoa) {
			System.out.println(p.getIdPessoa() + " " + p.getpNome());
		}
		
	}
	
	// Listar Turmas
	
	public void listarTurmas(TurmaJDBC turmajdbc) {

		List<Turma> listturma = turmajdbc.retrieveTurmas();
		for (Turma t : listturma) {
			System.out.println(t.getIdTurma() + " " + t.getIdCurso() + " " + t.gettVagas() + " " + t.isConsolidada());
		}
		
	}
	
	// Listar Cursos
	
		public void listarCursos(CursoJDBC cursojdbc) {

			List<Curso> listcurso = cursojdbc.retrieveCursos();
			for (Curso c : listcurso) {
				System.out.println(c.getIdCurso() + " " + c.getcNome() + " " + c.getcDescricao() + " " + c.getCargaHoraria());
			}
		}
	
	// Listar Salas
	
	public void listarSalas(SalaJDBC salajdbc) {

		List<Sala> listsala = salajdbc.retrieveSalas();
		for (Sala s : listsala) {
			System.out.println(s.getIdSala() + " " + s.getsDescricao());
		}
		
	}

	// Listar Postagem
	
	public void listarPostagens(PostagemJDBC postagemjdbc) {

		List<Postagem> listpostagem = postagemjdbc.retrievePostagens();
		if (listpostagem != null) {
			for (Postagem p : listpostagem) {
				System.out.println(p.getIdPostagem() + " " + p.getIdPessoa() + " " + p.getTexto() + " " + p.getData());
			}
		}
		else{System.out.println("\n Ainda não foram feitas postagens!");}
		
	}
	
	// Listar Agendamentos
	
	public void listarAgendar(AgendarJDBC agendarjdbc) {

		List<Agendar> listagendar = agendarjdbc.retrieveAgendamentos();
		for (Agendar a : listagendar) {
			System.out.println(a.getIdAluno() + " " + a.getIdVoluntario() + " " + a.getData() + " " + a.getHorario() + " " + a.isConfirmado());
		}
		
	}
	
	// Listar Lista_Espera
	
	public void listarLista_Espera(Lista_EsperaJDBC lista_esperajdbc) {

		List<Lista_Espera> listlista_espera = lista_esperajdbc.retrieveListas_Espera();
		for (Lista_Espera l : listlista_espera) {
			System.out.println(l.getIdAluno() + " " + l.getIdCurso() + " " + l.getData() + " " + l.getData() + " " + l.isConfirmado());
		}
		
	}
	
	// Listar Voluntarios 
	  
	public void listarVoluntarios() {
		try{
			super.conectar();
			
			String sql = "SELECT * FROM pessoa NATURAL JOIN horario_disponibilidade"; 
			
			ResultSet rs = comando.executeQuery(sql);
			
			while (rs.next()){
				
				System.out.println(rs.getInt("idPessoa") + " " + rs.getString("pNome") + " " + rs.getString("pEmail") + " " + rs.getString("horario_disponibilidade") + " " + rs.getInt("ano") + " " + rs.getInt("periodo"));
				
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	// 
	
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