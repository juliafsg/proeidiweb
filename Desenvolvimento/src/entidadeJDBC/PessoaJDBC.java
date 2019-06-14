package entidadeJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Pessoa;

public class PessoaJDBC extends EntidadeJDBC{
	

	public PessoaJDBC(String server, String user, String password) throws SQLException {
		super(server, user, password);
	}


	// MÉTODOS DE CONSULTA
	
	// Atualizar
	public void update(Pessoa pessoa) {
		
        try {
        	super.conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE pessoa SET ");
            buffer.append(returnFieldValuesBD(pessoa));
            buffer.append(" WHERE cpf=");
            buffer.append(pessoa.getCpf());
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

	// Procurar
	public Pessoa search(String cpf) {
		try{
			super.conectar();
			
			String sql = "SELECT * FROM pessoa WHERE idPessoa = " + this.retornarValorStringBD(cpf); 
			
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
	public void insert(Pessoa pessoa) {
		try {	
				super.conectar();
			
		        StringBuffer buffer = new StringBuffer();
		        buffer.append("INSERT INTO pessoa (");
		        buffer.append(this.retornarCamposBD());
		        buffer.append(") VALUES (");
		        buffer.append(retornarValoresBD(pessoa));
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
	public void remove(Pessoa pessoa) {

        try {
        	super.conectar();
    		
    		String sql ="DELETE FROM pessoa WHERE cpf=" + this.retornarValorStringBD(pessoa.getCpf());
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
	public List<Pessoa> retrievePessoas() {
		try {
			super.conectar();
			
			String sql = "SELECT * FROM pessoa";
			ResultSet rs = comando.executeQuery(sql);
			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			
			while (rs.next()){
				Pessoa pessoa = new Pessoa();
				
				pessoa.setIdPessoa(rs.getInt("idPessoa"));
				pessoa.setpNome((rs.getString("pNome")));
				pessoa.setDataNascimento(rs.getDate("dataNascimento"));
				pessoa.setCpf((rs.getString("cpf")));
				pessoa.setpEmail((rs.getString("pEmail")));
				pessoa.setAtivo((rs.getBoolean("ativo")));
				pessoa.setSenha((rs.getString("senha")));
				pessoa.setDataMatricula(rs.getTimestamp("dataMatricula"));
				pessoas.add(pessoa);
			}
			super.fechar();
			
			return pessoas;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

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
    	return "idPessoa, pNome, dataNascimento, cpf, pEmail, ativo, senha, dataMatricula";
    }
	

}
