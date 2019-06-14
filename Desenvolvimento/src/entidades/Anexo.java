package entidades;

public class Anexo {
	
	private int idPostagem;
	private String enderecoAnexo;
	
	public Anexo(int idPostagem, String enderecoAnexo) {
		super();
		this.idPostagem = idPostagem;
		this.enderecoAnexo = enderecoAnexo;
	}

	public int getIdPostagem() {
		return idPostagem;
	}

	public void setIdPostagem(int idPostagem) {
		this.idPostagem = idPostagem;
	}

	public String getEnderecoAnexo() {
		return enderecoAnexo;
	}

	public void setEnderecoAnexo(String enderecoAnexo) {
		this.enderecoAnexo = enderecoAnexo;
	}

}
