package entidadeJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Responsavel;

public class ResponsavelJDBC extends EntidadeJDBC{

	public ResponsavelJDBC(String server, String user, String password) throws SQLException {
		super(server, user, password);
		// TODO Auto-generated constructor stub
	}
	// MÉTODOS DE CONSULTA
	
	// Atualizar
	public void update(Responsavel antigo, Responsavel novo) {
		
        try {
        	super.conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE responsavel SET ");
            buffer.append(returnFieldValuesBD(novo));
            buffer.append(" WHERE idTurma=");
            buffer.append(antigo.getIdTurma());
            buffer.append(" AND idPessoa=");
            buffer.append(antigo.getIdPessoa());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR em responsavel : " + sql);
            
			comando.executeUpdate(sql);
			
			super.fechar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}

	// Procurar
	public Responsavel search(int idPessoa, int idTurma) {
		try{
			super.conectar();
			
			String sql = "SELECT * FROM responsavel WHERE idPessoa = " + idPessoa + " AND idTurma = " + idTurma; 
			
			ResultSet rs = comando.executeQuery(sql);
			
			Responsavel responsavel = new Responsavel();
			
			if (rs.next()){
				responsavel.setIdPessoa(rs.getInt("idPessoa"));
				responsavel.setIdTurma((rs.getInt("idTurma")));
			}
			
			System.out.println(responsavel.getIdPessoa() + ", " + responsavel.getIdTurma());
			super.fechar();
			return responsavel;
			
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	// Inserir
	public void insert(Responsavel responsavel) {
		try {	
			super.conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO responsavel (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(responsavel));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR em Responsavel : " + sql);

	        comando.executeUpdate(sql);
	        super.fechar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Remover
	public void remove(Responsavel responsavel) {

        try {
        	super.conectar();
    		
    		String sql ="DELETE FROM responsavel WHERE idTurma=" + responsavel.getIdTurma() + " AND idPessoa=" + responsavel.getIdPessoa();
            System.out.println("SQL para REMOVER em responsavel : "+sql);
			comando.executeUpdate(sql);

			super.fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	} 
	
	// Listar
	public List<Responsavel> retrieveResponsaveis() {
		try {
			super.conectar();
			
			String sql = "SELECT * FROM responsavel ";
			ResultSet rs = comando.executeQuery(sql);
			List<Responsavel> responsaveis = new ArrayList<Responsavel>();
			
			while (rs.next()){
				Responsavel responsavel = new Responsavel();
				
				responsavel.setIdPessoa(rs.getInt("idPessoa"));
				responsavel.setIdTurma((rs.getInt("idTurma")));
				
				responsaveis.add(responsavel);
			}
			super.fechar();
			
			return responsaveis;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// MÉTODOS AUXILIARES
	
	private String retornarValoresBD(Responsavel p) {
		return
	        p.getIdPessoa() + ", " +
	        p.getIdTurma();
}

	private String returnFieldValuesBD(Responsavel p) {
		StringBuffer buffer = new StringBuffer();
        buffer.append("idTurma=");
        buffer.append(p.getIdTurma());
        buffer.append(", idPessoa=");
        buffer.append(p.getIdPessoa());

        return buffer.toString();
	}
	
	protected String retornarCamposBD() {
    	return "idTurma, idPessoa";
    }
	

}
