package entidadeJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Turma;

public class TurmaJDBC extends EntidadeJDBC{

	public TurmaJDBC(String server, String user, String password) throws SQLException {
		super(server, user, password);
	}
	
	// MÉTODOS DE CONSULTA
	
	// Atualizar
	public void update(Turma turma) {
		
        try {
        	super.conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE turma SET ");
            buffer.append(returnFieldValuesBD(turma));
            buffer.append(" WHERE idTurma=");
            buffer.append(turma.getIdTurma());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR em turma : " + sql);
            
			comando.executeUpdate(sql);
			
			super.fechar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}

	// Procurar
	public Turma search(int idTurma) {
		try{
			super.conectar();
			
			String sql = "SELECT * FROM turma WHERE idTurma=" + idTurma; 
			
			ResultSet rs = comando.executeQuery(sql);
			
			Turma turma = new Turma();
			
			if (rs.next()){
				
				turma.setIdTurma(rs.getInt("idTurma"));
				turma.settVagas((rs.getInt("tVagas")));
				turma.setIdSala(rs.getInt("idSala"));
				turma.setIdCurso((rs.getInt("idCurso")));
				turma.setConsolidada((rs.getBoolean("consolidada")));
			}
			
			System.out.println(turma.getIdCurso());
			super.fechar();
			return turma;
			
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	// Inserir
	public void insert(Turma turma) {
		try {	
			super.conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO turma (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(turma));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR em turma: " + sql);

	        comando.executeUpdate(sql);
	        super.fechar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Remover
	public void remove(Turma turma) {

        try {
        	super.conectar();
    		
    		String sql ="DELETE FROM turma WHERE idPessoa=" + turma.getIdTurma();
            System.out.println("SQL para REMOVER em pessoa : "+sql);
			comando.executeUpdate(sql);

			super.fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	} 
	
	// Listar
	public List<Turma> retrieveTurmas() {
		try {
			super.conectar();
			
			String sql = "SELECT * FROM turma";
			ResultSet rs = comando.executeQuery(sql);
			List<Turma> turmas = new ArrayList<Turma>();
			
			while (rs.next()){
				Turma turma = new Turma();
				
				turma.setIdTurma(rs.getInt("idTurma"));
				turma.settVagas((rs.getInt("tVagas")));
				turma.setIdSala(rs.getInt("idSala"));
				turma.setIdCurso((rs.getInt("idCurso")));
				turma.setConsolidada((rs.getBoolean("consolidada")));
				turmas.add(turma);
			}
			super.fechar();
			
			return turmas;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// MÉTODOS AUXILIARES
	
	private String retornarValoresBD(Turma t) {
		return
		        t.getIdTurma() + 
		        ", " + t.gettVagas() +
		        ", " + t.getIdSala() + 
		        ", " + t.getIdCurso() + 
		        ", " + t.isConsolidada();
	}

	private String returnFieldValuesBD(Turma t) {
		StringBuffer buffer = new StringBuffer();
        buffer.append("idTurma=");
        buffer.append(t.getIdTurma());
        buffer.append(", tVagas=");
        buffer.append(t.gettVagas());
        buffer.append(", idSala=");
        buffer.append(t.getIdSala());
        buffer.append(", idCurso=");
        buffer.append(t.getIdCurso());
        buffer.append(", consolidada=");
        buffer.append(t.isConsolidada());

        return buffer.toString();
	}
	
	protected String retornarCamposBD() {
    	return "idTurma, tVagas, idSala, idCurso, consolidada";
    }
	
}
