package entidades;

import java.sql.Date;

public class Data {
	
	private int idTurma;
	private Date dataAula;
	
	public Data(int idTurma, Date dataAula) {
		super();
		this.idTurma = idTurma;
		this.dataAula = dataAula;
	}

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public Date getDataAula() {
		return dataAula;
	}

	public void setDataAula(Date dataAula) {
		this.dataAula = dataAula;
	}

}
