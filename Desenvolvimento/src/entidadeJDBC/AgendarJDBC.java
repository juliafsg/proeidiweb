package entidadeJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Agendar;

public class AgendarJDBC extends EntidadeJDBC{

	public AgendarJDBC(String server, String user, String password) throws SQLException {
		super(server, user, password);
		// TODO Auto-generated constructor stub
	}

	
	// MÉTODOS DE CONSULTA
	
	// Atualizar
	public void update(Agendar agenda) {
		
        try {
        	super.conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE agenda SET ");
            buffer.append(returnFieldValuesBD(agenda));
            buffer.append(" WHERE idAluno=" + agenda.getIdAluno() + 
            					" AND idVoluntario="  + agenda.getIdVoluntario()+ 
            					" AND data=" + agenda.getData() +
            					" AND horario=" + agenda.getHorario());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR em pessoa : " + sql);
            
			comando.executeUpdate(sql);
			
			super.fechar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	// Inserir
	public void insert(Agendar agenda) {
		try {	
				super.conectar();
			
		        StringBuffer buffer = new StringBuffer();
		        buffer.append("INSERT INTO agendar (");
		        buffer.append(this.retornarCamposBD());
		        buffer.append(") VALUES (");
		        buffer.append(retornarValoresBD(agenda));
		        buffer.append(")");
		        String sql = buffer.toString();

		        System.out.println("SQL para INSERIR em agendar : " + sql);

		        comando.executeUpdate(sql);
		        super.fechar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Remover
	public void remove(Agendar agenda) {

        try {
        	super.conectar();
    		
    		String sql ="DELETE FROM agendar WHERE idAluno= " + agenda.getIdAluno()
    											+ " AND idVoluntario="  + agenda.getIdVoluntario()
    											+ " AND data=" + agenda.getData()
    											+ " AND horario=" + agenda.getHorario();
    		
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
	
	public List<Agendar> retrieveAgendamentos() {
		try {
			super.conectar();
			
			String sql = "SELECT * FROM agendar";
			ResultSet rs = comando.executeQuery(sql);
			List<Agendar> agendas = new ArrayList<Agendar>();
			
			while (rs.next()){
				Agendar agenda = new Agendar();
				
				agenda.setIdAluno(rs.getInt("idAluno"));
				agenda.setIdVoluntario((rs.getInt("idVoluntario")));
				agenda.setConfirmado((rs.getBoolean("confirmado")));
				agenda.setData(rs.getDate("data"));
				agenda.setHorario((rs.getString("horario")));
				agendas.add(agenda);
			}
			super.fechar();	
			return agendas;
			
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// MÉTODOS AUXILIARES
	private String retornarValoresBD(Agendar a) {
		return
		        a.getIdAluno()
		        + ", "
		        + a.getIdVoluntario()
		        + ", "
		        + a.isConfirmado()
		        + ", "
		        + retornarValorStringBD(a.getData().toString())
		        + ", "
		        + retornarValorStringBD(a.getHorario());
		   
	}

	private String returnFieldValuesBD(Agendar a) {
		StringBuffer buffer = new StringBuffer();
        buffer.append("idAluno=");
        buffer.append(a.getIdAluno());
        buffer.append(", idVoluntario=");
        buffer.append(a.getIdVoluntario());
        buffer.append(", confirmado=");
        buffer.append(a.isConfirmado());
        buffer.append(", data=");
        buffer.append(retornarValorStringBD(a.getData().toString()));
        buffer.append(", horario=");
        buffer.append(retornarValorStringBD(a.getHorario()));

        return buffer.toString();
	}
	
	protected String retornarCamposBD() {
    	return "idAluno, idVoluntario, confirmado, data, horario";
    }
	
	
}
