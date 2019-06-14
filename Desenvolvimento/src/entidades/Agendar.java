package entidades;

import java.sql.Date;

public class Agendar {
	
	private int idAluno;
	private int idVoluntario;
	private boolean confirmado;
	private Date data;
	private String horario;
	
	public Agendar(int idAluno, int idVoluntario, boolean confirmado, Date data, String horario) {
		super();
		this.idAluno = idAluno;
		this.idVoluntario = idVoluntario;
		this.confirmado = confirmado;
		this.data = data;
		this.horario = horario;
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

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}
