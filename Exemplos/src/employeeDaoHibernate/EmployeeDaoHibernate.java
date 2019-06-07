package employeeDaoHibernate;


import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;  
import org.hibernate.criterion.Restrictions;
import org.hibernate.Session;
import interfaceDAO.IEmployee;
import entidade.Employee;
      
 public class EmployeeDaoHibernate implements IEmployee{  
 
	 private SessionFactory factory;  
	 
	 public EmployeeDaoHibernate() throws Exception{ 
		  factory = new Configuration().addClass(Employee.class).buildSessionFactory(); 
	 }     

	 
    @Override
	public void update(Employee employee) {
    	Session sessao = factory.openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(employee);
        t.commit();
		sessao.close();
	}

	@Override
	public void insert(Employee employee){
			
		Session sessao = factory.openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(employee);
		t.commit();
		sessao.close();
   }  

	@Override
	public Employee search(String ssn) {

		Session sessao = factory.openSession();
		Criteria crit = sessao.createCriteria(Employee.class);
		crit.add(Restrictions.eq("ssn", ssn));
		List<Employee> employeeList = crit.list();
		sessao.close();
	    return employeeList.get(0);
			
	}

	@Override
	public void remove(Employee employee) {
		
		Session sessao = factory.openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(employee);
	    t.commit();
		sessao.close(); 
		
	}

	@Override
	public List<Employee> retrieveEmployees() {
			
		Session sessao = factory.openSession();
		Criteria crit = sessao.createCriteria(Employee.class);
		List<Employee> employeeList = crit.list();
	    sessao.close();  
	    return employeeList;	
	        
	}  
  }  
