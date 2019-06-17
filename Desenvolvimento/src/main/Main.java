package main;

import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import entidadeJDBC.*;
import entidades.*;
import operacoes.Operacao;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Povoar();
		
		boolean valid = true;

		PessoaJDBC pessoajdbc = new PessoaJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		TurmaJDBC turmajdbc = new TurmaJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		CursoJDBC cursojdbc = new CursoJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		SalaJDBC salajdbc = new SalaJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		PostagemJDBC postagemjdbc = new PostagemJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		AgendarJDBC agendarjdbc = new AgendarJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		Lista_EsperaJDBC lista_esperajdbc = new Lista_EsperaJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		VoluntarioJDBC voluntariojdbc = new VoluntarioJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		Turma_AlunoJDBC turma_alunojdbc = new Turma_AlunoJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		
		Operacao comando = new Operacao("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");	
		System.out.println("\n---------------------------------------");
		System.out.println("	     ProEIDI Web");
		System.out.println("---------------------------------------");
		
		while (valid) {
			
			String acoes = "\n\n"
					+ "0: Sair\n"
					+ "1: Listar todas pessoas\n"
					+ "2: Listar todas turmas\n"
					+ "3: Listar todos cursos\n"
					+ "4: Listar salas\n"
					+ "5: Listar postagens\n"
					+ "6: Listar agendamentos\n"
					+ "7: Mostrar lista de espera\n"
					+ "8: Listar voluntarios\n"
					+ "9: Listar turmas por aluno (id)\n"
					+ "10: Listar alunos de uma turma (id)\n";
			
			System.out.print(acoes);
			System.out.println("---------------------------------------");
			System.out.print("Ação: ");  
			Scanner sc = new Scanner(System.in);
			int n = 999;
			try {
	            n = sc.nextInt();
	        } catch (InputMismatchException e) {
	            System.out.print("O valor informado não é um número!");
	        }
			System.out.println("---------------------------------------\n");
			
			switch (n) {
			  case 1:
				  System.out.println("Pessoas envolvidas no projeto:\n");
				  comando.listarPessoas(pessoajdbc);
				  break;
			  case 2:
				  System.out.println("Turmas do projeto:\n");
				  comando.listarTurmas(turmajdbc);
				  break;
			  case 3:
				  System.out.println("Cursos do projeto:\n");
				  comando.listarCursos(cursojdbc);
				  break;
			  case 4:
				  System.out.println("Salas de aula:\n");
				  comando.listarSalas(salajdbc);
				  break;
			  case 5:
				  System.out.println("Postagens:\n");
				  comando.listarPostagens(postagemjdbc);
				  break;
			  case 6:
				  System.out.println("Agendamentos:\n");
				  comando.listarAgendar(agendarjdbc);
			      break;
			  case 7:
				  System.out.println("Lista de Espera:\n");
				  comando.listarLista_Espera(lista_esperajdbc);
				  break;
			  case 8:
				  System.out.println("Voluntários:\n");
				  comando.listarVoluntarios();
				  break;
			  case 9:
				  System.out.print("Informe o id do aluno: ");
				  try {
					  int idAluno = sc.nextInt();
			          comando.listarTurmasPorAluno(turma_alunojdbc, idAluno);
			        } catch (InputMismatchException e) {
			          System.out.print("O valor informado não é um número!");
			        }
				  break;			  
			  case 10:
				  System.out.print("Informe o id da turma: ");
				  try {
					  int idTurma = sc.nextInt();
			          comando.listarAlunosPorTurma(turma_alunojdbc, idTurma);
			        } catch (InputMismatchException e) {
			          System.out.print("O valor informado não é um número!");
			        }
				  break;
				  
			  case 0:
				  valid = false;
				  break;
			  
			  default:
				  System.out.println("Ação não reconhecida ou esperada.");
				  break;
			}
			
		}
	
	}
		
		
	private static void Povoar() throws ParseException, SQLException {

		// Data de nascimento
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy"); 
		java.sql.Date dataN = new java.sql.Date(fmt.parse("29/11/2019").getTime());	

		// Data de matrícula
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp dataM = new java.sql.Timestamp(now.getTime());
		
		
		// PESSOA		
		//Pessoa pessoa = new Pessoa(2,"Abmael", dataN, "01544377", "netless@gmail.com", true, "abma123", dataM);    
		//PessoaJDBC pessoajdbc = new PessoaJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");	
		//pessoajdbc.update(pessoa);
		//pessoajdbc.remove(pessoa);	
		
		// ALUNO
		//Aluno aluno = new Aluno(6, "Terezinha ",dataN,"34343434", "tete@gmail.com", true, "123321", dataM, 84, "919234586");	
		//AlunoJDBC alunojdbc = new AlunoJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		//alunojdbc.insert(aluno);
		
		// VOLUNTÁRIO
		//Voluntario voluntario = new Voluntario(3,"Abmael", dataN, "01544377", "netless@gmail.com", true, "abma123", dataM, 84, "988887654", false);    
		//VoluntarioJDBC voluntariojdbc = new VoluntarioJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		//voluntariojdbc.insert(voluntario);
		//voluntariojdbc.remove(voluntario);	
		
		// CURSO
		//Cur4so curso = new Curso(1,"Smatphone", "aprender a usar o celular", 4);
		//CursoJDBC cursojdbc = new CursoJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		//cursojdbc.insert(curso);
		
		// SALA
		//Sala sala = new Sala(1, "A104");
		//SalaJDBC salajdbc = new SalaJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		//salajdbc.insert(sala);
		
		// TURMA
		//Turma turma = new Turma(1, 50, 1, 1, false);
		//TurmaJDBC turmajdbc= new TurmaJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");		
		//turmajdbc.insert(turma);
		//turmajdbc.remove(turma);
		
		// AGENDAR
		//Agendar agenda = new Agendar(6,1,true, dataN, "M12");
		//AgendarJDBC agendarjdbc = new AgendarJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		//agendarjdbc.insert(agenda);
		
		// HORARIO
		//@SuppressWarnings("deprecation")
		//Time time = new Time(13,50,0);
		//Horario horario = new Horario(1,time, time, dataN);
		//HorarioJDBC horariojdbc = new HorarioJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		//horariojdbc.insert(horario);
		
		// MATRICULA
		//Matricula matricula = new Matricula(6,1,dataM);
		//MatriculaJDBC matriculajdbc = new MatriculaJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		//matriculajdbc.insert(matricula);
		
		// POSTAGEM
		//Postagem postagem = new Postagem(1,1,"As aula de sábado foram canceladas!", "Cancelamento Aula", dataN);
		//PostagemJDBC postagemjdbc = new PostagemJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		//postagemjdbc.insert(postagem);
		
		// ANEXO
		//Anexo anexo = new Anexo(1,"http::// seila");
		//AnexoJDBC anexojdbc = new AnexoJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		//anexojdbc.insert(anexo);
		
		// RESPONSAVEL
		//Responsavel responsavel = new Responsavel(1,1);
		//ResponsavelJDBC responsaveljdbc = new ResponsavelJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		//responsaveljdbc.insert(responsavel);
		
		// FREQUENCIA
		//Frequencia frequencia = new Frequencia(6,1, dataN, true);
		//FrequenciaJDBC frequenciajdbc = new FrequenciaJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		//frequenciajdbc.insert(frequencia);
		
		// TURMA_ALUNO
		//Turma_Aluno turma_Aluno = new Turma_Aluno(1,6);
		//Turma_AlunoJDBC turma_Alunojdbc = new Turma_AlunoJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		//turma_Alunojdbc.insert(turma_Aluno);
		
		// TURMA_VOLUNTARIO
		//Turma_Voluntario turma_Voluntario= new Turma_Voluntario(1,1,2019,2);
		//Turma_VoluntarioJDBC turma_Voluntariojdbc = new Turma_VoluntarioJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		//turma_Voluntariojdbc.insert(turma_Voluntario);
		
		// LISTA_ESPERA
		//Lista_Espera lista_Espera= new Lista_Espera(6,1,dataM,true);
		//Lista_EsperaJDBC lista_Esperajdbc = new Lista_EsperaJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		//lista_Esperajdbc.insert(lista_Espera);
		
		// HORARIO_DISPONIBILIDADE
		//Horario_Disponibilidade horario_Disponibilidade= new Horario_Disponibilidade(1,"M12",2019,2);
		//Horario_DisponibilidadeJDBC horario_Disponibilidadejdbc = new Horario_DisponibilidadeJDBC("jdbc:mysql://localhost/proeidiweb","projeto","pass12344321");
		//horario_Disponibilidadejdbc.insert(horario_Disponibilidade);
		
		
		
	}
}
