package com.employee.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.employee.entity.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	
	
	@Override
	public void saveEmployee(Employee newEmployee) {
		Session currentSession = sessionFactory.getCurrentSession();

			currentSession.saveOrUpdate(newEmployee);
	}

	@Override
	public Employee getById(int employeeId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Employee savedEmployee = currentSession.get(Employee.class, employeeId);
		
		return savedEmployee;
	}

	@Override
	public Employee getByEmail(String email) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Employee> query = currentSession.createQuery
				("from Employee e where e.email =: mail", Employee.class);
		
		query.setParameter("mail", email);
		
		Employee employee = null;
		
		try {
			employee = query.getResultList().get(0);
		}
		catch(RuntimeException re) {
			
			re.printStackTrace();
		}
		return employee;
	}
	
	@Override
	public List<Employee> findAll(){
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("From Employee", Employee.class);
		
		List<Employee> resultList = null;
		
		try {
		resultList = query.getResultList();
		}
		catch(RuntimeException e) {
			e.printStackTrace();
		}
		
		return resultList;
	}

}
