package entidadeJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Horario_Disponibilidade;

public class Horario_DisponibilidadeJDBC extends EntidadeJDBC {

	public Horario_DisponibilidadeJDBC(String server, String user, String password) throws SQLException {
		super(server, user, password);
		// TODO Auto-generated constructor stub
	}
	// MÉTODOS DE CONSULTA
	
	// Atualizar
	public void update(Horario_Disponibilidade antigo, Horario_Disponibilidade novo) {
		
        try {
        	super.conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE horario_disponivel SET ");
            buffer.append(returnFieldValuesBD(novo));
            buffer.append(" WHERE idPessoa=");
            buffer.append(antigo.getIdPessoa());
            buffer.append(" WHERE horario_disponibilidade=");
            buffer.append(antigo.getHorarioDisponibilidade());
            buffer.append(" WHERE ano=");
            buffer.append(antigo.getAno());
            buffer.append(" WHERE periodo=");
            buffer.append(antigo.getPeriodo());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR em horario_disponibilidade : " + sql);
            
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
	public void insert(Horario_Disponibilidade horario_disponivel) {
		try {	
			super.conectar();
		
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO horario_disponibilidade (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(retornarValoresBD(horario_disponivel));
	        buffer.append(")");
	        String sql = buffer.toString();

	        System.out.println("SQL para INSERIR em horario_disponibilidade : " + sql);

	        comando.executeUpdate(sql);
	        super.fechar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Remover
	public void remove(Horario_Disponibilidade horario) {

        try {
        	super.conectar();
    		
    		String sql ="DELETE FROM horario_disponibilidade WHERE idPessoa=" + horario.getIdPessoa() + 
    				" AND ano=" + horario.getAno() +
    				" AND periodo=" + horario.getPeriodo();
            System.out.println("SQL para REMOVER em horario_disponivel : "+sql);
			comando.executeUpdate(sql);

			super.fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	} 
	
	// Listar
	public List<Horario_Disponibilidade> retrievePessoas() {
		try {
			super.conectar();
			
			String sql = "SELECT * FROM horario_disponibilidade ORDER BY idPessoa";
			ResultSet rs = comando.executeQuery(sql);
			List<Horario_Disponibilidade> horarios_disponiveis = new ArrayList<Horario_Disponibilidade>();
			
			while (rs.next()){
				Horario_Disponibilidade horario_disponivel = new Horario_Disponibilidade();
				
				horario_disponivel.setIdPessoa(rs.getInt("idPessoa"));
				horario_disponivel.setHorarioDisponibilidade(rs.getString("horario_disponibilidade"));
				horario_disponivel.setAno(rs.getInt("ano"));
				horario_disponivel.setPeriodo((rs.getInt("periodo")));
				
				horarios_disponiveis.add(horario_disponivel);
			}
			super.fechar();
			
			return horarios_disponiveis;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Horario_Disponibilidade> retrievePessoas(int idPessoa, int ano, int periodo) {
		try {
			super.conectar();
			
			String sql = "SELECT * FROM horario_disponibilidade WHERE idPessoa=" + idPessoa +
					" AND ano=" + ano +
					" AND periodo=" + periodo;
			ResultSet rs = comando.executeQuery(sql);
			List<Horario_Disponibilidade> horarios_disponiveis = new ArrayList<Horario_Disponibilidade>();
			
			while (rs.next()){
				Horario_Disponibilidade horario_disponivel = new Horario_Disponibilidade();
				
				horario_disponivel.setIdPessoa(rs.getInt("idPessoa"));
				horario_disponivel.setHorarioDisponibilidade(rs.getString("horario_disponibilidade"));
				horario_disponivel.setAno(rs.getInt("ano"));
				horario_disponivel.setPeriodo((rs.getInt("periodo")));
				
				horarios_disponiveis.add(horario_disponivel);
			}
			super.fechar();
			
			return horarios_disponiveis;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// MÉTODOS AUXILIARES
	
	private String retornarValoresBD(Horario_Disponibilidade p) {
		return
		        p.getIdPessoa() + ", " +
		        retornarValorStringBD(p.getHorarioDisponibilidade()) + ", " +
		        p.getAno() + ", " +
		        p.getPeriodo();
	}

	private String returnFieldValuesBD(Horario_Disponibilidade p) {
		StringBuffer buffer = new StringBuffer();
        buffer.append("idPessoa=");
        buffer.append(p.getIdPessoa());
        buffer.append(", horario_disponibilidade=");
        buffer.append(retornarValorStringBD(p.getHorarioDisponibilidade()));
        buffer.append(", ano=");
        buffer.append(p.getAno());
        buffer.append(", periodo=");
        buffer.append(p.getPeriodo());

        return buffer.toString();
	}
	
	protected String retornarCamposBD() {
    	return "idPessoa, horario_disponibilidade, ano, periodo";
    }}
