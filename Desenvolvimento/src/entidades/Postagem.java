package entidades;

import java.sql.Date;

public class Postagem {
	
	private int idPostagem;
	private int idPessoa;
	private String texto;
	private Date data;
	
	public Postagem(int idPostagem, int idPessoa, String texto, Date data) {
			super();
			this.idPostagem = idPostagem;
			this.idPessoa = idPessoa;
			this.texto = texto;
			this.data = data;
	}

	public int getIdPostagem() {
		return idPostagem;
	}

	public void setIdPostagem(int idPostagem) {
		this.idPostagem = idPostagem;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
}
