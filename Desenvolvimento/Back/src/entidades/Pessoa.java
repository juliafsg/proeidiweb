package entidades;

import java.sql.Date;
import java.sql.Timestamp;

public class Pessoa {
	private int idPessoa;
	private String pNome;
	private Date dataNascimento;
	private String cpf;
	private String pEmail;
	private boolean ativo;
	private String senha;
	private Timestamp dataMatricula;
	
	public Pessoa(int idPessoa, String pNome, Date dataNascimento, String cpf, String pEmail, boolean ativo, String senha, Timestamp dataMatricula) {
		super();
		this.idPessoa = idPessoa;
		this.pNome = pNome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.pEmail = pEmail;
		this.ativo = ativo;
		this.senha = senha;
		this.dataMatricula = dataMatricula;
	}

	public Pessoa() {
		super();
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getpNome() {
		return pNome;
	}

	public void setpNome(String pNome) {
		this.pNome = pNome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getpEmail() {
		return pEmail;
	}

	public void setpEmail(String pEmail) {
		this.pEmail = pEmail;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Timestamp getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Timestamp dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
}
