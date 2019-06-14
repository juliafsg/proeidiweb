package operacoes;

import java.util.List;

import entidadeJDBC.PessoaJDBC;
import entidades.Pessoa;

public class Operacao {

	public Operacao() {
		super();
	}
	
	
	// Listar todos os envolvidos no projeto
	public void listarPessoas(PessoaJDBC pessoajdbc) {

		List<Pessoa> listpessoa = pessoajdbc.retrievePessoas();
		for (Pessoa p : listpessoa) {
			System.out.println(p.getCpf() + " " + p.getpNome());
		}
		
	}
	
	// Listar Turma Específica (horário, nome professores, nome alunos)
	
	// Listar Todas as Turmas e seus Horários
	
	// Listar os Professores, seus telefones e horários de disponibilidade
	
	
	
}
