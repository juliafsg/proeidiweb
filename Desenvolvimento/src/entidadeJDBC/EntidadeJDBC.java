 package entidadeJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import conexao.ConFactory;

public class EntidadeJDBC {

	
		private String URL;
		private String NOME;
		private String SENHA;
		private int BANCO;
		
		private Connection con;  
		protected Statement comando;
		
		public EntidadeJDBC(String server, String user, String password) throws SQLException {
			this.URL = server;
			this.NOME = user;
			this.SENHA = password;
		}
		
		protected String retornarValorStringBD(String valor) {
	        if (valor != null && !"".equals(valor)) {
	            valor = "'" + valor + "'";
	        } else {
	            valor = "'"+"'";
	        }
	        return valor;
	    }
		
		// MÉTODOS CONEXÃO
		protected void conectar() throws ClassNotFoundException, SQLException  {
	        con = ConFactory.conexao(URL, NOME, SENHA, BANCO);  
			comando = con.createStatement();  
	        //System.out.println("Conectado!");     
		}
		
		protected void fechar() {
			try {  
				comando.close();  
				con.close();  
				//System.out.println("Conexao Fechada");  
			} catch (SQLException e) {}  
		}

}
