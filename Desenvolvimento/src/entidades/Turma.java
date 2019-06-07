package entidades;

import java.sql.date;

public class Turma{
    private int id;
    private int vagas;
    private int idSala;
    private int idCurso;
    private Boolean consolidada;
    
	public Turma(int id, int vagas, int idSala, int idCurso, Boolean consolidada) {
		super();
		this.id = id;
		this.vagas = vagas;
		this.idSala = idSala;
		this.idCurso = idCurso;
		this.consolidada = consolidada;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVagas() {
		return vagas;
	}
	public void setVagas(int vagas) {
		this.vagas = vagas;
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
	public Boolean getConsolidada() {
		return consolidada;
	}
	public void setConsolidada(Boolean consolidada) {
		this.consolidada = consolidada;
	}
    
   
}