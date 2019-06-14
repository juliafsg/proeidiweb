package entidades;

import java.sql.Timestamp;

public class Matricula {
	
	private int idAluno;
	private int idVoluntario;
	Timestamp dataMatricula;
	
	public Matricula(int idAluno, int idVoluntario, Timestamp dataMatricula) {
		super();
		this.idAluno = idAluno;
		this.idVoluntario = idVoluntario;
		this.dataMatricula = dataMatricula;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public int getIdVoluntario() {
		return idVoluntario;
	}

	public void setIdVoluntario(int idVoluntario) {
		this.idVoluntario = idVoluntario;
	}

	public Timestamp getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Timestamp dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	
}
