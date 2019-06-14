package entidades;

import java.sql.Timestamp;

public class Lista_Espera {
	
	private int idAluno;
	private int idCurso;
	private Timestamp data;
	private boolean confirmado;
	
	public Lista_Espera(int idAluno, int idCurso, Timestamp data, boolean confirmado) {
		super();
		this.idAluno = idAluno;
		this.idCurso = idCurso;
		this.data = data;
		this.confirmado = confirmado;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

}
