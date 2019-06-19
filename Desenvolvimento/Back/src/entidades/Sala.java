package entidades;

public class Sala {
	
	private int idSala;
	private String sDescricao;
	
	public Sala(int idSala, String sDescricao) {
		super();
		this.idSala = idSala;
		this.sDescricao = sDescricao;
	}

	public Sala() {
		// TODO Auto-generated constructor stub
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public String getsDescricao() {
		return sDescricao;
	}

	public void setsDescricao(String sDescricao) {
		this.sDescricao = sDescricao;
	}

}
