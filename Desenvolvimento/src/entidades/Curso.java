package entidades;

public class Curso {
	
	private int idCurso;
	private String cNome;
	private String cDescricao;
	private int cargaHoraria;
	
	public Curso(int idCurso, String cNome, String cDescricao, int cargaHoraria) {
		super();
		this.idCurso = idCurso;
		this.cNome = cNome;
		this.cDescricao = cDescricao;
		this.cargaHoraria = cargaHoraria;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getcNome() {
		return cNome;
	}

	public void setcNome(String cNome) {
		this.cNome = cNome;
	}

	public String getcDescricao() {
		return cDescricao;
	}

	public void setcDescricao(String cDescricao) {
		this.cDescricao = cDescricao;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

}
