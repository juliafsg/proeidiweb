package main;

import interfaceDAO.IEmployee;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.type.DateType;

import conexao.ConFactory;
import employeeDaoHibernate.EmployeeDaoHibernate;
import employeeDaoJDBC.EmployeeJDBC;
import employeeDaoJDBCTrans.EmployeeJDBCTrans;
import entidade.Employee;

public class MainDao {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");  
		java.sql.Date data = new java.sql.Date(format.parse("2012-09-13").getTime()); 
		
		//System.out.println(data);
		Employee employee = new Employee("Marcel", "V", "Oliveira",  "000555000", data, "Logo Ali", "M", 50000,  "123456789", 1);
		
		IEmployee empDao = new EmployeeJDBC("jdbc:postgresql://localhost/company","postgres","dim0541",ConFactory.POSTGRES);
		//IEmployee empDao = new EmployeeJDBC("jdbc:mysql://localhost/company","root","dim0541",ConFactory.MYSQL);
		//IEmployee empDao = new EmployeeDaoHibernate();
		//IEmployee empDao = new EmployeeJDBCTrans("jdbc:mysql://localhost/company","root","dim0541");

		//empDao.insert(employee);
		
		Employee e = empDao.search("123456789");
		System.out.println("Achei "+e.getSsn());
		//e.setFname("Tchau Querida");
		//empDao.update(e);
		
		empDao.remove(employee);
		//((EmployeeJDBCTrans)empDao).commit();
		
		
		List<Employee> listemployee = empDao.retrieveEmployees();
		for (Employee ep : listemployee) {
			System.out.println(ep.getSsn() + " " + ep.getFname());
		}

	}
}

