package entidades;

import java.time.Year;

public class Turma_Voluntario {
	
	private int idTurma;
	private int idPessoa;
	private Year ano;
	private int semestre;
	
	public Turma_Voluntario(int idTurma, int idPessoa, Year ano, int semestre) {
		super();
		this.idTurma = idTurma;
		this.idPessoa = idPessoa;
		this.ano = ano;
		this.semestre = semestre;
	}

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public Year getAno() {
		return ano;
	}

	public void setAno(Year ano) {
		this.ano = ano;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	
}
