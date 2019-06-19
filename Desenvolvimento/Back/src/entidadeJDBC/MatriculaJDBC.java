package entidadeJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Matricula;

public class MatriculaJDBC extends EntidadeJDBC {

	public MatriculaJDBC(String server, String user, String password) throws SQLException {
		super(server, user, password);
		// TODO Auto-generated constructor stub
	}
	// MÉTODOS DE CONSULTA
	
	// Atualizar
	public void update(Matricula antigo, Matricula novo) {
		
        try {
        	super.conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE matricula SET ");
            buffer.append(returnFieldValuesBD(novo));
            buffer.append(" WHERE idAluno=");
            buffer.append(antigo.getIdAluno());
            buffer.append(" AND idVoluntario=");
            buffer.append(antigo.getIdVoluntario());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR em matricula : " + sql);
            
			comando.executeUpdate(sql);
			
			super.fechar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}

	// Procurar
	public Matricula search(int idPessoa, int idTurma) {
		try{
			super.conectar();
			
			String sql = "SELECT * FROM matricula WHERE idPessoa = " + idPessoa + " AND idTurma = " + idTurma; 
			
			ResultSet rs = comando.executeQuery(sql);
			
			Matricula matricula = new Matricula();
			
			if (rs.next()){
				matricula.setIdAluno(rs.getInt("idPessoa"));
				matricula.setIdVoluntario(rs.getInt("idTurma"));
				matricula.setDataMatricula(rs.getTimestamp("dataMatricula"));
			}
			
			System.out.println(matricula.getIdAluno() + ", " + matricula.getIdVoluntario());
			super.fechar();
			return matricula;
			
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	// Inserir
	public void insert(Matricula matricula) {
		try {	
			super.conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO matricula (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(matricula));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR em Matricula : " + sql);

	        comando.executeUpdate(sql);
	        super.fechar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Remover
	public void remove(Matricula matricula) {

        try {
        	super.conectar();
    		
    		String sql ="DELETE FROM matricula WHERE idAluno=" + matricula.getIdAluno() + " AND idVoluntario=" + matricula.getIdVoluntario();
            System.out.println("SQL para REMOVER em matricula : "+sql);
			comando.executeUpdate(sql);

			super.fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	} 
	
	// Listar
	public List<Matricula> retrieveTurma_Aluno() {
		try {
			super.conectar();
			
			String sql = "SELECT * FROM matricula ";
			ResultSet rs = comando.executeQuery(sql);
			List<Matricula> matriculas = new ArrayList<Matricula>();
			
			while (rs.next()){
				Matricula matricula = new Matricula();
				
				matricula.setIdAluno(rs.getInt("idPessoa"));
				matricula.setIdVoluntario(rs.getInt("idTurma"));
				matricula.setDataMatricula(rs.getTimestamp("dataMatricula"));
				
				matriculas.add(matricula);
			}
			super.fechar();
			
			return matriculas;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// MÉTODOS AUXILIARES
	
	private String retornarValoresBD(Matricula p) {
		return
	        p.getIdAluno() + ", " +
	        p.getIdVoluntario() + ", " +
	        retornarValorStringBD(p.getDataMatricula().toString());
}

	private String returnFieldValuesBD(Matricula p) {
		StringBuffer buffer = new StringBuffer();
        buffer.append("idAluno=");
        buffer.append(p.getIdAluno());
        buffer.append(", idVoluntario=");
        buffer.append(p.getIdVoluntario());
        buffer.append("dataMatricula=");
        buffer.append(retornarValorStringBD(p.getDataMatricula().toString()));

        return buffer.toString();
	}
	
	protected String retornarCamposBD() {
    	return "idAluno, idVoluntario, dataMatricula";
    }
	

}
