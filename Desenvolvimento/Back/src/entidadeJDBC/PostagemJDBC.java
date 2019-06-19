package entidadeJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Postagem;


public class PostagemJDBC extends EntidadeJDBC {

	public PostagemJDBC(String server, String user, String password) throws SQLException {
		super(server, user, password);
		// TODO Auto-generated constructor stub
	}
	// MÉTODOS DE CONSULTA
	
	// Atualizar
	public void update(Postagem postagem) {
		
        try {
        	super.conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE postagem SET ");
            buffer.append(returnFieldValuesBD(postagem));
            buffer.append(" WHERE idPostagem=");
            buffer.append(postagem.getIdPostagem());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR em postagem : " + sql);
            
			comando.executeUpdate(sql);
			
			super.fechar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}

	// Procurar
	public Postagem search(int idPostagem) {
		try{
			super.conectar();
			
			String sql = "SELECT * FROM postagem WHERE idPostagem = " + idPostagem; 
			
			ResultSet rs = comando.executeQuery(sql);
			
			Postagem postagem = new Postagem();
			
			if (rs.next()){
				
				postagem.setIdPessoa(rs.getInt("idPessoa"));
				postagem.setIdPostagem(rs.getInt("idPostagem"));
				postagem.setTexto(rs.getString("dataNascimento"));
				postagem.setAssunto(rs.getString("assunto"));
				postagem.setData(rs.getDate("data"));
			}
			
			System.out.println(postagem.getAssunto());
			super.fechar();
			return postagem;
			
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	// Inserir
	public void insert(Postagem postagem) {
		try {	
			super.conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO postagem (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(postagem));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR em postagem : " + sql);

	        comando.executeUpdate(sql);
	        super.fechar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Remover
	public void remove(Postagem postagem) {

        try {
        	super.conectar();
    		
    		String sql ="DELETE FROM postagem WHERE idPostagem=" + postagem.getIdPostagem();
            System.out.println("SQL para REMOVER em postagem : "+sql);
			comando.executeUpdate(sql);

			super.fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	} 
	
	// Listar
	public List<Postagem> retrievePostagens() {
		try {
			super.conectar();
			
			String sql = "SELECT * FROM postagem";
			ResultSet rs = comando.executeQuery(sql);
			List<Postagem> postagens = new ArrayList<Postagem>();
			
			while (rs.next()){
				Postagem postagem = new Postagem();
				
				postagem.setIdPostagem(rs.getInt("idPostagem"));
				postagem.setIdPessoa(rs.getInt("idPessoa"));
				postagem.setTexto(rs.getString("texto"));
				postagem.setAssunto(rs.getString("assunto"));
				postagem.setData(rs.getDate("data"));
				
				postagens.add(postagem);
			}
			super.fechar();
			
			return postagens;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// MÉTODOS AUXILIARES
	
	private String retornarValoresBD(Postagem p) {
		return
	        p.getIdPostagem() + ", " +
	        p.getIdPessoa() + ", " +
	        retornarValorStringBD(p.getAssunto()) + ", " +
	        retornarValorStringBD(p.getTexto()) + ", " +
	        retornarValorStringBD(p.getData().toString());
	}

	private String returnFieldValuesBD(Postagem p) {
		StringBuffer buffer = new StringBuffer();
        buffer.append("idPostagem=");
        buffer.append(p.getIdPostagem());
        buffer.append(", idPessoa=");
        buffer.append(p.getIdPessoa());
        buffer.append(", texto=");
        buffer.append(retornarValorStringBD(p.getTexto()));
        buffer.append(", data=");
        buffer.append(retornarValorStringBD(p.getData().toString()));
        buffer.append(", assunto=");
        buffer.append(retornarValorStringBD(p.getAssunto()));

        return buffer.toString();
	}
	
	protected String retornarCamposBD() {
    	return "idPostagem, idPessoa, assunto,texto, data";
    }
	


}
