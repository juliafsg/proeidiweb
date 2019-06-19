package entidadeJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Voluntario;

public class VoluntarioJDBC extends EntidadeJDBC {

	public VoluntarioJDBC(String server, String user, String password) throws SQLException {
		super(server, user, password);
		// TODO Auto-generated constructor stub
	}
	// MÉTODOS DE CONSULTA
	// Atualizar
	public void update(Voluntario voluntario) {
		
        try {
        	super.conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE voluntario SET ");
            buffer.append(returnFieldValuesBD(voluntario));
            buffer.append(" WHERE idPessoa=");
            buffer.append(voluntario.getIdPessoa());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR em voluntario : " + sql);
            
			comando.executeUpdate(sql);
			
			super.fechar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}

	// Procurar
	public Voluntario search(int idPessoa) {
		try{
			super.conectar();
			
			String sql = "SELECT * FROM voluntario WHERE idPessoa =" + idPessoa; 
			
			ResultSet rs = comando.executeQuery(sql);
			
			Voluntario voluntario = new Voluntario();
			
			if (rs.next()){
				voluntario.setIdPessoa(rs.getInt("idPessoa"));
				voluntario.setDDD((rs.getInt("DDD")));
				voluntario.setTelefone(rs.getString("telefone"));
				voluntario.setGerenciador((rs.getBoolean("gerenciador")));
			}
			
			System.out.println(voluntario.getIdPessoa());
			super.fechar();
			return voluntario;
			
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	// Inserir
	public void insert(Voluntario voluntario) {
		try {	
			super.conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO voluntario (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(voluntario));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR em voluntario : " + sql);

	        comando.executeUpdate(sql);
	        super.fechar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Remover
	public void remove(Voluntario voluntario) {

        try {
        	super.conectar();
    		
    		String sql ="DELETE FROM voluntario WHERE idPessoa=" + voluntario.getIdPessoa();
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
	public List<Voluntario> retrieveVoluntarios() {
		try {
			super.conectar();
			
			String sql = "SELECT * FROM pessoa";
			ResultSet rs = comando.executeQuery(sql);
			List<Voluntario> voluntarios = new ArrayList<Voluntario>();
			
			while (rs.next()){
				Voluntario voluntario = new Voluntario();
				
				voluntario.setIdPessoa(rs.getInt("idPessoa"));
				voluntario.setDDD((rs.getInt("DDD")));
				voluntario.setTelefone(rs.getString("telefone"));
				voluntario.setGerenciador((rs.getBoolean("gerenciador")));

				voluntarios.add(voluntario);
			}
			super.fechar();
			
			return voluntarios;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// MÉTODOS AUXILIARES
	
	private String retornarValoresBD(Voluntario v) {
		return
		        v.getIdPessoa() + ", " +
				v.getDDD() + ", " +
		        v.getTelefone() + ", " +
				v.isGerenciador();
	}

	private String returnFieldValuesBD(Voluntario v) {
		StringBuffer buffer = new StringBuffer();
        buffer.append("idPessoa=");
        buffer.append(v.getIdPessoa());
        buffer.append(", DDD=");
        buffer.append(v.getDDD());
        buffer.append(", telefone=");
        buffer.append(retornarValorStringBD(v.getTelefone()));
        buffer.append(", gerenciador=");
        buffer.append(v.isGerenciador());

        return buffer.toString();
	}
	
	protected String retornarCamposBD() {
    	return "idPessoa, DDD, telefone, gerenciador";
    }
}

