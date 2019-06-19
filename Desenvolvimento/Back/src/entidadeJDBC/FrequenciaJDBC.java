package entidadeJDBC;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Frequencia;

public class FrequenciaJDBC extends EntidadeJDBC {

	public FrequenciaJDBC(String server, String user, String password) throws SQLException {
		super(server, user, password);
		// TODO Auto-generated constructor stub
	}
	// MÉTODOS DE CONSULTA
	
	// Atualizar
	public void update(Frequencia antiga, Frequencia nova) {
		
        try {
        	super.conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE frequencia SET ");
            buffer.append(returnFieldValuesBD(nova));
            buffer.append(" WHERE idTurma=");
            buffer.append(antiga.getIdTurma());
            buffer.append(" AND idPessoa=");
            buffer.append(antiga.getIdPessoa());
            buffer.append(" AND data=");
            buffer.append(antiga.getData());
            
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR em frequencia : " + sql);
            
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
	public void insert(Frequencia frequencia) {
		try {	
			super.conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO frequencia (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(frequencia));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR em frequencia : " + sql);

	        comando.executeUpdate(sql);
	        super.fechar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Remover
	public void remove(Frequencia frequencia) {

        try {
        	super.conectar();
    		
    		String sql ="DELETE FROM frequencia WHERE idTurma=" + frequencia.getIdTurma() + 
    				" AND idPessoa=" + frequencia.getIdPessoa() + " AND data=" + this.retornarValorStringBD(frequencia.getData().toString());
            System.out.println("SQL para REMOVER em frequencia : "+sql);
			comando.executeUpdate(sql);

			super.fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	} 
	
	// Listar
	public List<Frequencia> retrievePessoas() {
		try {
			super.conectar();
			
			String sql = "SELECT * FROM frequencia";
			ResultSet rs = comando.executeQuery(sql);
			List<Frequencia> frequencias = new ArrayList<Frequencia>();
			
			while (rs.next()){
				Frequencia frequencia = new Frequencia();
				
				frequencia.setIdPessoa(rs.getInt("idPessoa"));
				frequencia.setIdTurma(rs.getInt("idTurma"));
				frequencia.setData(rs.getDate("data"));
				frequencia.setEstavaFrequente(rs.getBoolean("estavaFrequente"));
				
				frequencias.add(frequencia);
			}
			super.fechar();
			
			return frequencias;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Frequencia> retrievePessoas(int idTurma) {
		try {
			super.conectar();
			
			String sql = "SELECT * FROM frequencia WHERE idTurma=" + idTurma;
			ResultSet rs = comando.executeQuery(sql);
			List<Frequencia> frequencias = new ArrayList<Frequencia>();
			
			while (rs.next()){
				Frequencia frequencia = new Frequencia();
				
				frequencia.setIdPessoa(rs.getInt("idPessoa"));
				frequencia.setIdTurma(rs.getInt("idTurma"));
				frequencia.setData(rs.getDate("data"));
				frequencia.setEstavaFrequente(rs.getBoolean("estavaFrequente"));
				
				frequencias.add(frequencia);
			}
			super.fechar();
			
			return frequencias;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Frequencia> retrievePessoas(int idTurma, Date data) {
		try {
			super.conectar();
			
			String sql = "SELECT * FROM frequencia WHERE idTurma="+ idTurma +" AND data="+retornarValorStringBD(data.toString());
			ResultSet rs = comando.executeQuery(sql);
			List<Frequencia> frequencias = new ArrayList<Frequencia>();
			
			while (rs.next()){
				Frequencia frequencia = new Frequencia();
				
				frequencia.setIdPessoa(rs.getInt("idPessoa"));
				frequencia.setIdTurma(rs.getInt("idTurma"));
				frequencia.setData(rs.getDate("data"));
				frequencia.setEstavaFrequente(rs.getBoolean("estavaFrequente"));
				
				frequencias.add(frequencia);
			}
			super.fechar();
			
			return frequencias;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// MÉTODOS AUXILIARES
	
	private String retornarValoresBD(Frequencia p) {
		return
	        p.getIdTurma() + ", " +
	        p.getIdPessoa() + ", " +
	        retornarValorStringBD(p.getData().toString()) + ", " +
	        p.isEstavaFrequente();
	}

	private String returnFieldValuesBD(Frequencia p) {
		StringBuffer buffer = new StringBuffer();
        buffer.append("idTurma=");
        buffer.append(p.getIdTurma());
        buffer.append(", idPessoa=");
        buffer.append(p.getIdPessoa());
        buffer.append(", data=");
        buffer.append(retornarValorStringBD(p.getData().toString()));
        buffer.append(", estavaFrequente=");
        buffer.append(p.isEstavaFrequente());

        return buffer.toString();
	}
	
	protected String retornarCamposBD() {
    	return "idTurma, idPessoa, data, estavaFrequente";
    }
}
