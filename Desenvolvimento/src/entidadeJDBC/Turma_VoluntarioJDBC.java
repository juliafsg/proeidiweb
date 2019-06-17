package entidadeJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Turma_Voluntario;

public class Turma_VoluntarioJDBC extends EntidadeJDBC {

	public Turma_VoluntarioJDBC(String server, String user, String password) throws SQLException {
		super(server, user, password);
		// TODO Auto-generated constructor stub
	}
	// MÉTODOS DE CONSULTA
	
	// Atualizar
	public void update(Turma_Voluntario antigo, Turma_Voluntario novo) {
		
        try {
        	super.conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE turma_voluntario SET ");
            buffer.append(returnFieldValuesBD(novo));
            buffer.append(" WHERE idTurma=");
            buffer.append(antigo.getIdTurma());
            buffer.append(" AND idPessoa=");
            buffer.append(antigo.getIdPessoa());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR em turma_voluntario : " + sql);
            
			comando.executeUpdate(sql);
			
			super.fechar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}

	// Procurar
	public Turma_Voluntario search(int idPessoa, int idTurma) {
		try{
			super.conectar();
			
			String sql = "SELECT * FROM turma_voluntario WHERE idPessoa = " + idPessoa + " AND idTurma = " + idTurma; 
			
			ResultSet rs = comando.executeQuery(sql);
			
			Turma_Voluntario turma_voluntario = new Turma_Voluntario();
			
			if (rs.next()){
				turma_voluntario.setIdPessoa(rs.getInt("idPessoa"));
				turma_voluntario.setIdTurma((rs.getInt("idTurma")));
				turma_voluntario.setAno(rs.getInt("ano"));
				turma_voluntario.setSemestre(rs.getInt("semestre"));
			}
			
			System.out.println(turma_voluntario.getIdPessoa() + ", " + turma_voluntario.getIdTurma());
			super.fechar();
			return turma_voluntario;
			
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	// Inserir
	public void insert(Turma_Voluntario turma_voluntario) {
		try {	
			super.conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO turma_voluntario (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(turma_voluntario));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR em Turma_Voluntario : " + sql);

	        comando.executeUpdate(sql);
	        super.fechar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Remover
	public void remove(Turma_Voluntario turma_voluntario) {

        try {
        	super.conectar();
    		
    		String sql ="DELETE FROM turma_voluntario WHERE idTurma=" + turma_voluntario.getIdTurma() + " AND idPessoa=" + turma_voluntario.getIdPessoa();
            System.out.println("SQL para REMOVER em turma_voluntario : "+sql);
			comando.executeUpdate(sql);

			super.fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	} 
	
	// Listar
	public List<Turma_Voluntario> retrieveResponsaveis() {
		try {
			super.conectar();
			
			String sql = "SELECT * FROM turma_voluntario ";
			ResultSet rs = comando.executeQuery(sql);
			List<Turma_Voluntario> turma_voluntarios = new ArrayList<Turma_Voluntario>();
			
			while (rs.next()){
				Turma_Voluntario turma_voluntario = new Turma_Voluntario();
				
				turma_voluntario.setIdPessoa(rs.getInt("idPessoa"));
				turma_voluntario.setIdTurma((rs.getInt("idTurma")));
				turma_voluntario.setAno(rs.getInt("ano"));
				turma_voluntario.setSemestre(rs.getInt("semestre"));
				
				turma_voluntarios.add(turma_voluntario);
			}
			super.fechar();
			
			return turma_voluntarios;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// MÉTODOS AUXILIARES
	
	private String retornarValoresBD(Turma_Voluntario p) {
		return
	        p.getIdTurma() + ", " +
	        p.getIdPessoa() + ", " +
	        p.getAno() + ", " +
	        p.getSemestre();
}

	private String returnFieldValuesBD(Turma_Voluntario p) {
		StringBuffer buffer = new StringBuffer();
        buffer.append("idTurma=");
        buffer.append(p.getIdTurma());
        buffer.append(", idPessoa=");
        buffer.append(p.getIdPessoa());
        buffer.append(", ano=");
        buffer.append(p.getAno());
        buffer.append(", semestre=");
        buffer.append(p.getSemestre());

        return buffer.toString();
	}
	
	protected String retornarCamposBD() {
    	return "idTurma, idPessoa, ano, semestre";
    }
}
