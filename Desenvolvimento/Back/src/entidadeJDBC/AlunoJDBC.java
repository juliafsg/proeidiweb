package entidadeJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Aluno;

public class AlunoJDBC extends EntidadeJDBC{

	public AlunoJDBC(String server, String user, String password) throws SQLException {
		super(server, user, password);
	}

	// MÉTODOS DE CONSULTA
	
	// Atualizar
	public void update(Aluno aluno) {
		
        try {
        	super.conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE aluno SET ");
            buffer.append(returnFieldValuesBD(aluno));
            buffer.append(" WHERE idPessoa=");
            buffer.append(aluno.getIdPessoa());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR em aluno: " + sql);
            
			comando.executeUpdate(sql);
			
			super.fechar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}

	// Procurar
	public Aluno search(int idPessoa) {
		try{
			super.conectar();
			
			String sql = "SELECT * FROM aluno WHERE idPessoa = " + idPessoa; 
			
			ResultSet rs = comando.executeQuery(sql);
			
			Aluno aluno = new Aluno();
			
			if (rs.next()){
				
				aluno.setIdPessoa(rs.getInt("idPessoa"));
				aluno.setDDD((rs.getInt("DDD")));
				aluno.setTelefone(rs.getString("telefone"));
			}
			
			System.out.println(aluno.getIdPessoa());
			super.fechar();
			return aluno;
			
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	// Inserir
	public void insert(Aluno aluno) {
		try {	
				super.conectar();
			
		        StringBuffer buffer = new StringBuffer();
		        buffer.append("INSERT INTO aluno (");
		        buffer.append(this.retornarCamposBD());
		        buffer.append(") VALUES (");
		        buffer.append(retornarValoresBD(aluno));
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
	public void remove(Aluno aluno) {

        try {
        	super.conectar();
    		
    		String sql ="DELETE FROM aluno WHERE idPessoa=" + aluno.getIdPessoa();
            System.out.println("SQL para REMOVER em aluno : " + sql);
			comando.executeUpdate(sql);

			super.fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	// Listar
	public List<Aluno> retrieveAlunos() {
		try {
			super.conectar();
			
			String sql = "SELECT * FROM pessoa";
			ResultSet rs = comando.executeQuery(sql);
			List<Aluno> alunos= new ArrayList<Aluno>();
			
			while (rs.next()){
				Aluno aluno = new Aluno();
				
				aluno.setIdPessoa(rs.getInt("idPessoa"));
				aluno.setDDD((rs.getInt("DDD")));
				aluno.setTelefone(rs.getString("telefone"));
				
				alunos.add(aluno);
			}
			super.fechar();
			
			return alunos;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	// MÉTODOS AUXILIARES
	private String retornarValoresBD(Aluno a) {
		return
		        a.getIdPessoa() + 
		        ", " + a.getDDD() +
		        ", " + retornarValorStringBD(a.getTelefone());
	}

	private String returnFieldValuesBD(Aluno a) {
		StringBuffer buffer = new StringBuffer();
        buffer.append("idPessoa=");
        buffer.append(a.getIdPessoa());
        buffer.append(", DDD=");
        buffer.append(a.getDDD());
        buffer.append(", telefone=");
        buffer.append(retornarValorStringBD(a.getTelefone()));

        return buffer.toString();
	}
	
	protected String retornarCamposBD() {
    	return "idPessoa, DDD, telefone";
    }

}
