package entidadeJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Anexo;

public class AnexoJDBC extends EntidadeJDBC {

	public AnexoJDBC(String server, String user, String password) throws SQLException {
		super(server, user, password);
		// TODO Auto-generated constructor stub
	}

	// MÉTODOS DE CONSULTA
	
	// Atualizar
	public void update(Anexo antigo, Anexo novo) {
		
        try {
        	super.conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE anexo SET ");
            buffer.append(returnFieldValuesBD(novo));
            buffer.append(" WHERE idPostagem=");
            buffer.append(antigo.getIdPostagem());
            buffer.append(" AND enderecoAnexo=");
            buffer.append(retornarValorStringBD(antigo.getEnderecoAnexo()));
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR em anexo : " + sql);
            
			comando.executeUpdate(sql);
			
			super.fechar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}

	// Procurar
	
	// Inserir
	public void insert(Anexo anexo) {
		try {	
			super.conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO anexo (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(anexo));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR em PESSOA : " + sql);

	        comando.executeUpdate(sql);
	        super.fechar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Remover
	public void remove(Anexo anexo) {

        try {
        	super.conectar();
    		
    		String sql ="DELETE FROM anexo WHERE idPostagem=" + anexo.getIdPostagem() + " AND enderecoAnexo=" + this.retornarValorStringBD(anexo.getEnderecoAnexo());
            System.out.println("SQL para REMOVER em anexo : "+sql);
			comando.executeUpdate(sql);

			super.fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	} 
	
	// Listar
	public List<Anexo> retrievePessoas() {
		try {
			super.conectar();
			
			String sql = "SELECT * FROM anexo";
			ResultSet rs = comando.executeQuery(sql);
			List<Anexo> anexos = new ArrayList<Anexo>();
			
			while (rs.next()){
				Anexo anexo = new Anexo();
				
				anexo.setIdPostagem(rs.getInt("idPostagem"));
				anexo.setEnderecoAnexo((rs.getString("enderecoAnexo")));
				
				anexos.add(anexo);
			}
			super.fechar();
			
			return anexos;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Anexo> retrievePessoas(int idPostagem) {
		try {
			super.conectar();
			
			String sql = "SELECT * FROM anexo WHERE idPostagem=" + idPostagem;
			ResultSet rs = comando.executeQuery(sql);
			List<Anexo> anexos = new ArrayList<Anexo>();
			
			while (rs.next()){
				Anexo anexo = new Anexo();
				
				anexo.setIdPostagem(rs.getInt("idPostagem"));
				anexo.setEnderecoAnexo((rs.getString("enderecoAnexo")));
				
				anexos.add(anexo);
			}
			super.fechar();
			
			return anexos;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// MÉTODOS AUXILIARES
	
	private String retornarValoresBD(Anexo p) {
		return
		        p.getIdPostagem() + ", " +
		        retornarValorStringBD(p.getEnderecoAnexo());
	}

	private String returnFieldValuesBD(Anexo p) {
		StringBuffer buffer = new StringBuffer();
        buffer.append("idPostagem=");
        buffer.append(p.getIdPostagem());
        buffer.append(", enderecoAnexo=");
        buffer.append(retornarValorStringBD(p.getEnderecoAnexo()));

        return buffer.toString();
	}
	
	protected String retornarCamposBD() {
    	return "idPostagem, enderecoAnexo";
    }
}
