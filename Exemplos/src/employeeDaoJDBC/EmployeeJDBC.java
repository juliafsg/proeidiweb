package employeeDaoJDBC;

import interfaceDAO.IEmployee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexao.ConFactory;

import entidade.Employee;


public class EmployeeJDBC implements IEmployee{

	
	private String URL;
	private String NOME;
	private String SENHA;
	private int BANCO;
	
	private Connection con;  
	private Statement comando;
	
	public EmployeeJDBC(String server, String user, String password, int banco) throws SQLException {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
		this.BANCO = banco;
	}

	@Override
	public void update(Employee employee) {
		
        try {
        	conectar();
        	StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE EMPLOYEE SET ");
            buffer.append(returnFieldValuesBD(employee));
            buffer.append(" WHERE SSN=");
            buffer.append(employee.getSsn());
            String sql = buffer.toString();
            
            System.out.println("SQL para ATUALIZAR que fica no EMPLOYEE : " + sql);
            
			comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void insert(Employee employee) {
		try {
			
				conectar();
			
		        StringBuffer buffer = new StringBuffer();
		        buffer.append("INSERT INTO EMPLOYEE (");
		        buffer.append(this.retornarCamposBD());
		        buffer.append(") VALUES (");
		        buffer.append(retornarValoresBD(employee));
		        buffer.append(")");
		        String sql = buffer.toString();

		        System.out.println("SQL para INSERIR que fica no EMPLOYEE : " + sql);

		        comando.executeUpdate(sql);
		        fechar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Employee search(String ssn) {
		try{
			conectar();
			String sql = "SELECT * FROM EMPLOYEE WHERE ssn = " + this.retornarValorStringBD(ssn); 
			ResultSet rs = comando.executeQuery(sql);
			Employee employee = new Employee();
			if (rs.next()){
				
				employee.setFname(rs.getString("fname"));
				employee.setMinit(rs.getString("minit"));
				employee.setLname(rs.getString("lname"));
				employee.setSsn(rs.getString("ssn"));
				employee.setBdate(rs.getDate("bdate"));
				employee.setAddress(rs.getString("address"));
				employee.setSex(rs.getString("sex"));
				employee.setSalary(rs.getDouble("salary"));
				employee.setSuperssn(rs.getString("super_ssn"));
				employee.setDno(rs.getInt("dno"));
			}
			System.out.println(employee.getFname());
			fechar();
			return employee;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}

	@Override
	public void remove(Employee employee) {

        try {
        	conectar();
    		//String sql = "ALTER TABLE company.employee DROP FOREIGN KEY employee_ibfk_1; ";
    		//comando.executeUpdate(sql);
    		
    		String sql ="DELETE FROM EMPLOYEE WHERE ssn=" + this.retornarValorStringBD(employee.getSsn());
            System.out.println("SQL para REMOVER que fica no EMPLOYEE : "+sql);
			comando.executeUpdate(sql);
			
			//sql = "ALTER TABLE company.employee ADD CONSTRAINT employee_ibfk_1 " +
			//		"FOREIGN KEY (super_ssn) REFERENCES company.employee (ssn); ";
    		//comando.executeUpdate(sql);
			fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Employee> retrieveEmployees() {
		try {
			conectar();
			String sql = "SELECT * FROM EMPLOYEE";
			ResultSet rs = comando.executeQuery(sql);
			List<Employee> emps = new ArrayList<Employee>();
			while (rs.next()){
				Employee employee = new Employee();
				
				employee.setFname(rs.getString("fname"));
				employee.setMinit(rs.getString("minit"));
				employee.setLname(rs.getString("lname"));
				employee.setSsn(rs.getString("ssn"));
				employee.setBdate(rs.getDate("bdate"));
				employee.setAddress(rs.getString("address"));
				employee.setSex(rs.getString("sex"));
				employee.setSalary(rs.getDouble("salary"));
				employee.setSuperssn(rs.getString("super_ssn"));
				employee.setDno(rs.getInt("dno"));
				emps.add(employee);
			}
			fechar();
			return emps;
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void conectar() throws ClassNotFoundException, SQLException  {
        con = ConFactory.conexao(URL, NOME, SENHA, BANCO);  
		comando = con.createStatement();  
        System.out.println("Conectado!");     
	}	  
	
	private void fechar() {  
		try {  
			comando.close();  
			con.close();  
			System.out.println("Conexão Fechada");  
		} catch (SQLException e) {  
		}  
	}

	protected String retornarCamposBD() {
    	return "fname, minit, lname, ssn, bdate, address, sex, salary, super_ssn, dno";
    }
    
    protected String returnFieldValuesBD(Employee e) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("fname=");
        buffer.append(retornarValorStringBD(e.getFname()));
        buffer.append(", minit=");
        buffer.append(retornarValorStringBD(e.getMinit()));
        buffer.append(", lname=");
        buffer.append(retornarValorStringBD(e.getLname()));
        buffer.append(", ssn=");
        buffer.append(retornarValorStringBD(e.getSsn()));
        buffer.append(", bdate=");
        buffer.append(retornarValorStringBD(e.getBdate().toString()));
        buffer.append(", address=");
        buffer.append(retornarValorStringBD(e.getAddress()));
        buffer.append(", sex=");
        buffer.append(retornarValorStringBD(e.getSex()));
        buffer.append(", salary=");
        buffer.append(e.getSalary());
        buffer.append(", super_ssn=");
        buffer.append(retornarValorStringBD(e.getSuperssn()));
        buffer.append(", dno=");
        buffer.append(e.getDno());

        return buffer.toString();
    }
    
    protected String retornarValoresBD(Employee e) {
    	return
	        retornarValorStringBD(e.getFname())
	        + ", "
	        + retornarValorStringBD(e.getMinit())
	        + ", "
	        + retornarValorStringBD(e.getLname())
	        + ", "
	        + retornarValorStringBD(e.getSsn())
	        + ", "
	        + retornarValorStringBD(e.getBdate().toString())
	        + ", "
	        + retornarValorStringBD(e.getAddress())
	        + ", "
	        + retornarValorStringBD(e.getSex())
	        + ", "
	        + e.getSalary()
	        + ", "
	        + retornarValorStringBD(e.getSuperssn())
	        + ", "
	        + e.getDno();
    }
    
    private String retornarValorStringBD(String valor) {
        if (valor != null && !"".equals(valor)) {
            valor = "'" + valor + "'";
        } else {
            valor = "'"+"'";
        }
        return valor;
    }
}
