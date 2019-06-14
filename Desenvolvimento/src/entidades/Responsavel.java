package entidades;

public class Responsavel {
	
	private int idTurma;
	private int idPessoa;
	
	public Responsavel(int idTurma, int idPessoa) {
		super();
		this.idTurma = idTurma;
		this.idPessoa = idPessoa;
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

}
