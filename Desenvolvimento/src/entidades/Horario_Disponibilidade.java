package entidades;

import java.time.Year;

public class Horario_Disponibilidade {
	
	private int idPessoa;
	private String horarioDisponibilidade;
	private Year ano;
	private int periodo;
	
	public Horario_Disponibilidade(int idPessoa, String horarioDisponibilidade, Year ano, int periodo) {
		super();
		this.idPessoa = idPessoa;
		this.horarioDisponibilidade = horarioDisponibilidade;
		this.ano = ano;
		this.periodo = periodo;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getHorarioDisponibilidade() {
		return horarioDisponibilidade;
	}

	public void setHorarioDisponibilidade(String horarioDisponibilidade) {
		this.horarioDisponibilidade = horarioDisponibilidade;
	}

	public Year getAno() {
		return ano;
	}

	public void setAno(Year ano) {
		this.ano = ano;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

}
