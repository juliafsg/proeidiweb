package interfaceDAO;

import java.util.List;

import entidade.Employee;




public interface IEmployee {

	 public void update(Employee employee);
	 public void insert(Employee employee);
	 public Employee search(String ssn);
	 public void remove(Employee employee);
	 public List<Employee> retrieveEmployees();
	 
	    
	
}
