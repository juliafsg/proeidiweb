package entidadeJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Lista_Espera;

public class Lista_EsperaJDBC extends EntidadeJDBC {

	public Lista_EsperaJDBC(String server, String user, String password) throws SQLException {
		super(server, user, password);
		// TODO Auto-generated constructor stub
	}
	// MÉTODOS DE CONSULTA
	
	// Atualizar
	public void update(Lista_Espera antigo, Lista_Espera novo) {
		
        try {
        	super.conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE lista_espera SET ");
            buffer.append(returnFieldValuesBD(novo));
            buffer.append(" WHERE idAluno=");
            buffer.append(antigo.getIdAluno());
            buffer.append(" AND idCurso=");
            buffer.append(antigo.getIdCurso());
            buffer.append(" AND data=");
            buffer.append(retornarValorStringBD(antigo.getData().toString()));
            buffer.append(" AND confirmado=");
            buffer.append(antigo.isConfirmado());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR em lista_espera : " + sql);
            
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
	public void insert(Lista_Espera lista_espera) {
		try {	
			super.conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO lista_espera (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(lista_espera));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR em lista_espera : " + sql);

	        comando.executeUpdate(sql);
	        super.fechar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Remover
	public void remove(Lista_Espera lista_espera) {

        try {
        	super.conectar();
    		
    		String sql ="DELETE FROM lista_espera WHERE idAluno=" + lista_espera.getIdAluno() +
    				" AND idCurso=" + lista_espera.getIdCurso() +
    				" AND data=" + this.retornarValorStringBD(lista_espera.getData().toString());
            System.out.println("SQL para REMOVER em lista_espera : "+sql);
			comando.executeUpdate(sql);

			super.fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	} 
	
	// Listar
	public List<Lista_Espera> retrieveListas_Espera() {
		try {
			super.conectar();
			
			String sql = "SELECT * FROM lista_espera";
			ResultSet rs = comando.executeQuery(sql);
			List<Lista_Espera> lista_pessoas = new ArrayList<Lista_Espera>();
			
			while (rs.next()){
				Lista_Espera lista_espera = new Lista_Espera();
				
				lista_espera.setIdAluno(rs.getInt("idAluno"));
				lista_espera.setIdCurso(rs.getInt("idCurso"));
				lista_espera.setData(rs.getTimestamp("data"));
				lista_espera.setConfirmado((rs.getBoolean("confirmado")));
				
				lista_pessoas.add(lista_espera);
			}
			super.fechar();
			
			return lista_pessoas;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// MÉTODOS AUXILIARES
	
	private String retornarValoresBD(Lista_Espera p) {
		return
		        p.getIdAluno() + ", " +
		        p.getIdCurso() + ", " +
		        retornarValorStringBD(p.getData().toString()) + ", " +
		        p.isConfirmado();
	}

	private String returnFieldValuesBD(Lista_Espera p) {
		StringBuffer buffer = new StringBuffer();
        buffer.append("idAluno=");
        buffer.append(p.getIdAluno());
        buffer.append("idCurso=");
        buffer.append(p.getIdCurso());
        buffer.append(", data=");
        buffer.append(retornarValorStringBD(p.getData().toString()));
        buffer.append(", confirmado=");
        buffer.append(p.isConfirmado());

        return buffer.toString();
	}
	
	protected String retornarCamposBD() {
    	return "idAluno, idCurso, data, confirmado";
    }
}
