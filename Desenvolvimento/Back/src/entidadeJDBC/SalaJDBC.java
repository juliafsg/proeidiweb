package entidadeJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Sala;

public class SalaJDBC extends EntidadeJDBC{

	public SalaJDBC(String server, String user, String password) throws SQLException {
		super(server, user, password);
		// TODO Auto-generated constructor stub
	}

	// MÉTODOS DE CONSULTA
	
	// Atualizar
	public void update(Sala sala) {
		
        try {
        	super.conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE sala SET ");
            buffer.append(returnFieldValuesBD(sala));
            buffer.append(" WHERE idSala=");
            buffer.append(sala.getIdSala());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR em sala : " + sql);
            
			comando.executeUpdate(sql);
			
			super.fechar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}

	// Procurar
	public Sala search(int idSala) {
		try{
			super.conectar();
			
			String sql = "SELECT * FROM sala WHERE idSala = " + idSala; 
			
			ResultSet rs = comando.executeQuery(sql);
			
			Sala sala = new Sala();
			
			if (rs.next()){
				
				sala.setIdSala(rs.getInt("idSala"));
				sala.setsDescricao((rs.getString("cDescricao")));
			}
			
			System.out.println(sala.getsDescricao());
			super.fechar();
			return sala;
			
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	// Inserir
	public void insert(Sala sala) {
		try {	
			super.conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO sala (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(sala));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR em sala : " + sql);

	        comando.executeUpdate(sql);
	        super.fechar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Remover
	public void remove(Sala sala) {

        try {
        	super.conectar();
    		
    		String sql ="DELETE FROM sala WHERE idSala=" + sala.getIdSala();
            System.out.println("SQL para REMOVER em sala : "+sql);
			comando.executeUpdate(sql);

			super.fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	} 
	
	// Listar
	public List<Sala> retrieveSalas() {
		try {
			super.conectar();
			
			String sql = "SELECT * FROM sala";
			ResultSet rs = comando.executeQuery(sql);
			List<Sala> salas = new ArrayList<Sala>();
			
			while (rs.next()){
				Sala sala = new Sala();
				
				sala.setIdSala(rs.getInt("idSala"));
				sala.setsDescricao((rs.getString("sDescricao")));
				
				salas.add(sala);
			}
			super.fechar();
			
			return salas;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// MÉTODOS AUXILIARES
	
	private String retornarValoresBD(Sala s) {
		return
		        s.getIdSala()
		        + ", "
		        + retornarValorStringBD(s.getsDescricao());
	}

	private String returnFieldValuesBD(Sala s) {
		StringBuffer buffer = new StringBuffer();
        buffer.append("idSala=");
        buffer.append(s.getIdSala());
        buffer.append(", sDescricao=");
        buffer.append(retornarValorStringBD(s.getsDescricao()));
        return buffer.toString();
	}
	
	protected String retornarCamposBD() {
    	return "idSala, sDescricao";
    }
	

}
