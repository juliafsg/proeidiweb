package entidades;

import java.sql.Date;
import java.sql.Timestamp;

public class Voluntario extends Pessoa{
	private int DDD;
	private String telefone;
	private boolean gerenciador;
	
	public Voluntario(int idPessoa, String pNome, Date dataNascimento, String cpf, String pEmail, boolean ativo,
			String senha, Timestamp dataMatricula, int DDD, String telefone, boolean gerenciador) {
		super(idPessoa, pNome, dataNascimento, cpf, pEmail, ativo, senha, dataMatricula);
		
		this.DDD = DDD;
		this.telefone = telefone;
		this.gerenciador = gerenciador;
	}

	public Voluntario() {
		super();
	}

	public int getDDD() {
		return DDD;
	}

	public void setDDD(int DDD) {
		this.DDD = DDD;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isGerenciador() {
		return gerenciador;
	}

	public void setGerenciador(boolean gerenciador) {
		this.gerenciador = gerenciador;
	}
}
