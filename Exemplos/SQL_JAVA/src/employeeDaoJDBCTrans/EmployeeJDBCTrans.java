package employeeDaoJDBCTrans;

import interfaceDAO.IEmployee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import conexao.ConFactory;

import entidade.Employee;

public class EmployeeJDBCTrans implements IEmployee{

	private String 	URL;
	private String NOME;
	private String SENHA;

	private Connection con;  
    private Statement comando;

	
	public EmployeeJDBCTrans(String server, String user, String password) throws SQLException {
		this.URL = server;
		this.NOME = user;
		this.SENHA = password;
	}
	
	@Override
	public void update(Employee employee) {
			StringBuffer buffer = new StringBuffer();
	        buffer.append("UPDATE EMPLOYEE SET ");
	        buffer.append(returnFieldValuesBD(employee));
	        buffer.append(" WHERE SSN=");
	        buffer.append(employee.getSsn());
	        String sql = buffer.toString();
	        
	    	try {
				conectar();
	    		comando.execute(sql);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        
	}

	@Override
	public void insert(Employee employee) {
			StringBuffer buffer = new StringBuffer();
	        buffer.append("INSERT INTO EMPLOYEE (");
	        buffer.append(this.retornarCamposBD());
	        buffer.append(") VALUES (");
	        buffer.append(this.retornarValoresBD(employee));
	        buffer.append(")");
	        String sql = buffer.toString();

	    	try {
				conectar();
	    		comando.execute(sql);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public Employee search(String ssn) {
        Employee employee = new Employee();

		try {
			conectar();
            String sql = "SELECT * FROM EMPLOYEE WHERE SSN=" + ssn;
                ResultSet rs = comando.executeQuery(sql);
                if (rs.next()) {
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
    				System.out.println(employee.getFname());
                }
            
        } catch (SQLException SQLe) {
            SQLe.printStackTrace();
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return employee;
	}

	@Override
	public void remove(Employee employee) {
        
        	//String sql_1 = "ALTER TABLE company.employee DROP FOREIGN KEY employee_ibfk_1; ";
        	String sql_2 ="DELETE FROM EMPLOYEE WHERE ssn=" + employee.getSsn() + ";";
			//String sql_3 ="ALTER TABLE company.employee ADD CONSTRAINT employee_ibfk_1 " +
			//				"FOREIGN KEY (super_ssn) REFERENCES company.employee (ssn); ";
			
	    	try {
				conectar();
	    		//comando.execute(sql_1);
	    		comando.execute(sql_2);
	    		//comando.execute(sql_3);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public List<Employee> retrieveEmployees() {
		synchronized (this) {
            ResultSet rs = null;
            
	        List<Employee> employees = new Vector<Employee>();
	        try {
	        	conectar();
				
	            try {
	                rs = comando.executeQuery("SELECT * FROM EMPLOYEE");
	                while (rs.next()) {
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
	                    employees.add(employee);
	                }
	            } finally {
        			if (rs != null) {
        				try {
        					rs.close();
        				} catch (SQLException sqlEx) { 
        				} 
        				rs = null;
        			}
        			if (comando != null) {
        				try {
        					comando.close();
        				} catch (SQLException sqlEx) { 
        				}
        				comando = null;
        			}
	            }
	        } catch (SQLException SQLe) {
	            SQLe.printStackTrace();
	        } catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	        return employees;
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
    
    private void conectar() throws ClassNotFoundException, SQLException  {
        con = ConFactory.conexao(URL, NOME, SENHA, ConFactory.MYSQL);  
        con.setAutoCommit(false);
        comando = con.createStatement();  
        System.out.println("Conectado!");     
	}	  

    public void commit() throws Exception {
    	try {
			this.commitTransaction();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
    }
    
	public void cancelTransaction() throws Exception {
	    if (con == null) {
	        throw new Exception("There is no opened connection");
	    }
	    try {
	        con.rollback();
	    } finally {
	        con.close();
	        con = null;
	    }
	}

	public void commitTransaction() throws Exception {
	    if (con == null) {
	        throw new Exception("There is no opened connection");
	    }
	    try {
	        con.commit();
	    } finally {
	        con.close();
	        con = null;
	    }
	}
    
}
