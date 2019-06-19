package entidadeJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Horario;

public class HorarioJDBC extends EntidadeJDBC {

	public HorarioJDBC(String server, String user, String password) throws SQLException {
		super(server, user, password);
		// TODO Auto-generated constructor stub
	}

	// MÉTODOS DE CONSULTA
	
	// Atualizar
	public void update(Horario horarioAntigo, Horario horarioNovo) {
		
        try {
        	super.conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE horario SET ");
            buffer.append(returnFieldValuesBD(horarioNovo));
            buffer.append(" WHERE idTurma=");
            buffer.append(horarioAntigo.getIdTurma());
            buffer.append(" AND data=");
            buffer.append(horarioAntigo.getData());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR em horario : " + sql);
            
			comando.executeUpdate(sql);
			
			super.fechar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}

	// Procurar
	public Horario search(int idTurma) {
		try{
			super.conectar();
			
			String sql = "SELECT * FROM horario WHERE idHorario = " + idTurma; 
			
			ResultSet rs = comando.executeQuery(sql);
			
			Horario horario = new Horario();
			
			if (rs.next()){
				
				horario.setIdTurma(rs.getInt("idTurma"));
				horario.setHoraInicio((rs.getTime("horaInicio")));
				horario.setHoraFim(rs.getTime("horaFim"));
				horario.setData((rs.getDate("data")));
			}
			
			System.out.println(horario.getIdTurma());
			super.fechar();
			return horario;
			
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	// Inserir
	public void insert(Horario horario) {
		try {	
			super.conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO horario (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(horario));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR em horario : " + sql);

	        comando.executeUpdate(sql);
	        super.fechar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Remover
	public void remove(Horario horario) {

        try {
        	super.conectar();
    		
    		String sql ="DELETE FROM horario WHERE idTurma=" + horario.getIdTurma() + " AND data=" + horario.getData();
            System.out.println("SQL para REMOVER em horario : "+sql);
			comando.executeUpdate(sql);

			super.fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	} 
	
	// Listar
	public List<Horario> retrieveHorarios() {
		try {
			super.conectar();
			
			String sql = "SELECT * FROM horario";
			ResultSet rs = comando.executeQuery(sql);
			List<Horario> horarios = new ArrayList<Horario>();
			
			while (rs.next()){
				Horario horario = new Horario();
				
				horario.setIdTurma(rs.getInt("idTurma"));
				horario.setHoraInicio((rs.getTime("horaInicio")));
				horario.setHoraFim(rs.getTime("horaFim"));
				horario.setData((rs.getDate("data")));
				
				horarios.add(horario);
			}
			super.fechar();
			
			return horarios;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// MÉTODOS AUXILIARES
	private String retornarValoresBD(Horario p) {
		return
		        p.getIdTurma() + ", " +
		        retornarValorStringBD(p.getHoraInicio().toString()) + ", " +
		        retornarValorStringBD(p.getHoraFim().toString()) + ", " +
				retornarValorStringBD(p.getData().toString());
	}

	private String returnFieldValuesBD(Horario p) {
		StringBuffer buffer = new StringBuffer();
        buffer.append("idTurma=");
        buffer.append(p.getIdTurma());
        buffer.append(", data=");
        buffer.append(retornarValorStringBD(p.getData().toString()));
        buffer.append(", horaInicio=");
        buffer.append(retornarValorStringBD(p.getHoraInicio().toString()));
        buffer.append(", horaFim=");
        buffer.append(retornarValorStringBD(p.getHoraFim().toString()));

        return buffer.toString();
	}
	
	protected String retornarCamposBD() {
    	return "idTurma, horaInicio, horaFim, data";
    }
	

}
