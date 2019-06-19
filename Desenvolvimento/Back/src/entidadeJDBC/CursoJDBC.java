package entidadeJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Curso;

public class CursoJDBC extends EntidadeJDBC {

	public CursoJDBC(String server, String user, String password) throws SQLException {
		super(server, user, password);
		// TODO Auto-generated constructor stub
	}

	// MÉTODOS DE CONSULTA
	
	// Atualizar
	public void update(Curso curso) {
		
        try {
        	super.conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE curso SET ");
            buffer.append(returnFieldValuesBD(curso));
            buffer.append(" WHERE idCurso=");
            buffer.append(curso.getIdCurso());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR em curso : " + sql);
            
			comando.executeUpdate(sql);
			
			super.fechar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}

	// Procurar
	public Curso search(int idCurso) {
		try{
			super.conectar();
			
			String sql = "SELECT * FROM curso WHERE idCurso = " + idCurso; 
			
			ResultSet rs = comando.executeQuery(sql);
			
			Curso curso = new Curso();
			
			if (rs.next()){
				
				curso.setIdCurso(rs.getInt("idCurso"));
				curso.setcNome((rs.getString("cNome")));
				curso.setcDescricao(rs.getString("cDescricao"));
				curso.setCargaHoraria(rs.getInt("cargaHoraria"));
	
			}
			
			System.out.println(curso.getcNome());
			super.fechar();
			return curso;
			
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	// Inserir
	public void insert(Curso curso) {
		try {	
			super.conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO curso (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(curso));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR em curso : " + sql);

	        comando.executeUpdate(sql);
	        super.fechar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Remover
	public void remove(Curso curso) {

        try {
        	super.conectar();
    		
    		String sql ="DELETE FROM curso WHERE idCurso=" + curso.getIdCurso();
            System.out.println("SQL para REMOVER em curso : "+sql);
			comando.executeUpdate(sql);

			super.fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	} 
	
	// Listar
	public List<Curso> retrieveCursos() {
		try {
			super.conectar();
			
			String sql = "SELECT * FROM curso";
			ResultSet rs = comando.executeQuery(sql);
			List<Curso> cursos = new ArrayList<Curso>();
			
			while (rs.next()){
				Curso curso = new Curso();
				
				curso.setIdCurso(rs.getInt("idCurso"));
				curso.setcNome((rs.getString("cNome")));
				curso.setcDescricao(rs.getString("cDescricao"));
				curso.setCargaHoraria((rs.getInt("cargaHoraria")));
				
				cursos.add(curso);
			}
			super.fechar();
			
			return cursos;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// MÉTODOS AUXILIARES
	
	private String retornarValoresBD(Curso c) {
		return
	        c.getIdCurso() + ", " +
			retornarValorStringBD(c.getcNome()) + ", " +
	        retornarValorStringBD(c.getcDescricao()) + ", " +
			c.getCargaHoraria();
	}

	private String returnFieldValuesBD(Curso c) {
		StringBuffer buffer = new StringBuffer();
        buffer.append("idCurso=");
        buffer.append(c.getIdCurso());
        buffer.append(", cNome=");
        buffer.append(retornarValorStringBD(c.getcNome()));
        buffer.append(", cDescricao=");
        buffer.append(retornarValorStringBD(c.getcDescricao()));
        buffer.append(", cargaHoraria=");
        buffer.append(c.getCargaHoraria());

        return buffer.toString();
	}
	
	protected String retornarCamposBD() {
    	return "idCurso, cNome, cDescricao, cargaHoraria";
    }
	

}
