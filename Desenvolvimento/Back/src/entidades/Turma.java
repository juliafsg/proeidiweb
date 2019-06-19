package entidades;

public class Turma {
	
	private int idTurma;
	private int tVagas;
	private int idSala;
	private int idCurso;
	private boolean consolidada;
	
	public Turma(int idTurma, int tVagas, int idSala, int idCurso, boolean consolidada) {
		this.idTurma = idTurma;
		this.tVagas = tVagas;
		this.idSala = idSala;
		this.idCurso = idCurso;
		this.consolidada = consolidada;
	}
	
	public Turma() {
		super();
	}
	
	public int getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}
	public int gettVagas() {
		return tVagas;
	}
	public void settVagas(int tVagas) {
		this.tVagas = tVagas;
	}
	public int getIdSala() {
		return idSala;
	}
	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public boolean isConsolidada() {
		return consolidada;
	}
	public void setConsolidada(boolean consolidada) {
		this.consolidada = consolidada;
	}
	
	
}
