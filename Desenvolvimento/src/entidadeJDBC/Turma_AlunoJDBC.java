package entidadeJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Turma_Aluno;

public class Turma_AlunoJDBC extends EntidadeJDBC {

	public Turma_AlunoJDBC(String server, String user, String password) throws SQLException {
		super(server, user, password);
		// TODO Auto-generated constructor stub
	}
	// MÉTODOS DE CONSULTA
	
	// Atualizar
	public void update(Turma_Aluno antigo, Turma_Aluno novo) {
		
        try {
        	super.conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE turma_aluno SET ");
            buffer.append(returnFieldValuesBD(novo));
            buffer.append(" WHERE idTurma=");
            buffer.append(antigo.getIdTurma());
            buffer.append(" AND idPessoa=");
            buffer.append(antigo.getIdPessoa());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR em turma_aluno : " + sql);
            
			comando.executeUpdate(sql);
			
			super.fechar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}

	// Procurar
	public Turma_Aluno search(int idPessoa, int idTurma) {
		try{
			super.conectar();
			
			String sql = "SELECT * FROM turma_aluno WHERE idPessoa = " + idPessoa + " AND idTurma = " + idTurma; 
			
			ResultSet rs = comando.executeQuery(sql);
			
			Turma_Aluno turma_aluno = new Turma_Aluno();
			
			if (rs.next()){
				turma_aluno.setIdPessoa(rs.getInt("idPessoa"));
				turma_aluno.setIdTurma((rs.getInt("idTurma")));
			}
			
			System.out.println(turma_aluno.getIdPessoa() + ", " + turma_aluno.getIdTurma());
			super.fechar();
			return turma_aluno;
			
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	// Inserir
	public void insert(Turma_Aluno turma_aluno) {
		try {	
			super.conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO turma_aluno (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(turma_aluno));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR em Turma_Aluno : " + sql);

	        comando.executeUpdate(sql);
	        super.fechar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Remover
	public void remove(Turma_Aluno turma_aluno) {

        try {
        	super.conectar();
    		
    		String sql ="DELETE FROM turma_aluno WHERE idTurma=" + turma_aluno.getIdTurma() + " AND idPessoa=" + turma_aluno.getIdPessoa();
            System.out.println("SQL para REMOVER em turma_aluno : "+sql);
			comando.executeUpdate(sql);

			super.fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	} 
	
	// Listar
	public List<Turma_Aluno> retrieveTurma_Aluno() {
		try {
			super.conectar();
			
			String sql = "SELECT * FROM turma_aluno ";
			ResultSet rs = comando.executeQuery(sql);
			List<Turma_Aluno> turmas_alunos = new ArrayList<Turma_Aluno>();
			
			while (rs.next()){
				Turma_Aluno turma_aluno = new Turma_Aluno();
				
				turma_aluno.setIdPessoa(rs.getInt("idPessoa"));
				turma_aluno.setIdTurma((rs.getInt("idTurma")));
				
				turmas_alunos.add(turma_aluno);
			}
			super.fechar();
			
			return turmas_alunos;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// MÉTODOS AUXILIARES
	
	private String retornarValoresBD(Turma_Aluno p) {
		return
	        p.getIdTurma() + ", " +
	        p.getIdPessoa();
}

	private String returnFieldValuesBD(Turma_Aluno p) {
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
