package entidadeJDBC;

import java.sql.SQLException;

import entidades.Pessoa;

public class AlunoJDBC extends EntidadeJDBC{

	public AlunoJDBC(String server, String user, String password) throws SQLException {
		super(server, user, password);
		// TODO Auto-generated constructor stub
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
            buffer.append(aluno.getCpf());
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
	public Pessoa search(int idPessoa) {
		try{
			super.conectar();
			
			String sql = "SELECT * FROM aluno WHERE idPessoa = " + this.retornarValorStringBD(cpf); 
			
			ResultSet rs = comando.executeQuery(sql);
			
			Pessoa pessoa = new Pessoa();
			
			if (rs.next()){
				
				pessoa.setIdPessoa(rs.getInt("idPessoa"));
				pessoa.setpNome((rs.getString("pNome")));
				pessoa.setDataNascimento(rs.getDate("dataNascimento"));
				pessoa.setCpf((rs.getString("cpf")));
				pessoa.setpEmail((rs.getString("pEmail")));
				pessoa.setAtivo((rs.getBoolean("ativo")));
				pessoa.setSenha((rs.getString("senha")));
				pessoa.setDataMatricula(rs.getTimestamp("dataMatricula"));
			}
			
			System.out.println(pessoa.getpNome());
			super.fechar();
			return pessoa;
			
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	// Inserir
		
	// Remover
		
	// Listar
		
	// MÉTODOS AUXILIARES
	private String retornarValoresBD(Pessoa p) {
		return
		        p.getIdPessoa()
		        + ", "
		        + retornarValorStringBD(p.getpNome())
		        + ", "
		        + retornarValorStringBD(p.getDataNascimento().toString())
		        + ", "
		        + retornarValorStringBD(p.getCpf())
		        + ", "
		        + retornarValorStringBD(p.getpEmail())
		        + ", "
		        + p.isAtivo()
		        + ", "
		        + retornarValorStringBD(p.getSenha())
		        + ", "
		        + retornarValorStringBD(p.getDataMatricula().toString());
	}

	private String returnFieldValuesBD(Pessoa p) {
		StringBuffer buffer = new StringBuffer();
        buffer.append("idPessoa=");
        buffer.append(p.getIdPessoa());
        buffer.append(", pNome=");
        buffer.append(retornarValorStringBD(p.getpNome()));
        buffer.append(", dataNascimento=");
        buffer.append(retornarValorStringBD(p.getDataNascimento().toString()));
        buffer.append(", cpf=");
        buffer.append(retornarValorStringBD(p.getCpf()));
        buffer.append(", pEmail=");
        buffer.append(retornarValorStringBD(p.getpEmail()));
        buffer.append(", ativo=");
        buffer.append(p.isAtivo());
        buffer.append(", senha=");
        buffer.append(retornarValorStringBD(p.getSenha()));
        buffer.append(", dataMatricula=");
        buffer.append(retornarValorStringBD(p.getDataMatricula().toString()));

        return buffer.toString();
	}
	
	protected String retornarCamposBD() {
    	return "idPessoa, DDD, telefone";
    }

}
