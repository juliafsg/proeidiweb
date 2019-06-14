package entidades;

import java.sql.Date;
import java.sql.Time;

public class Horario {
	
	private int idTurma;
	private Time horaInicio;
	private Time horaFim;
	private Date data;
	
	public Horario(int idTurma, Time horaInicio, Time horaFim, Date data) {
		super();
		this.idTurma = idTurma;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.data = data;
	}

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Time horaFim) {
		this.horaFim = horaFim;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
