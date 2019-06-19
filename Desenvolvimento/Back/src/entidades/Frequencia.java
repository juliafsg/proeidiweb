package entidades;

import java.sql.Date;

public class Frequencia {
	private int idPessoa;
	private int idTurma;
	private Date data;
	private boolean estavaFrequente;
	
	public Frequencia(int idPessoa, int idTurma, Date data, boolean estavaFrequente) {
		super();
		this.idPessoa = idPessoa;
		this.idTurma = idTurma;
		this.data = data;
		this.estavaFrequente = estavaFrequente;
	}

	public Frequencia() {
		super();
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isEstavaFrequente() {
		return estavaFrequente;
	}

	public void setEstavaFrequente(boolean estavaFrequente) {
		this.estavaFrequente = estavaFrequente;
	}
}
