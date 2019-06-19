package entidades;

import java.sql.Date;
import java.sql.Timestamp;

public class Aluno extends Pessoa{
	private int DDD;
	private String telefone;
	
	public Aluno(int idPessoa, String pNome, Date dataNascimento, String cpf, String pEmail, boolean ativo,
			String senha, Timestamp dataMatricula, int DDD, String telefone) {
		super(idPessoa, pNome, dataNascimento, cpf, pEmail, ativo, senha, dataMatricula);
		// TODO Auto-generated constructor stub
		this.DDD = DDD;
		this.telefone = telefone;
	}
	
	public Aluno() {
		super();
	}

	public int getDDD() {
		return DDD;
	}
	public void setDDD(int dDD) {
		DDD = dDD;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
