package com.nareshit.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nareshit.dao.IEmployee;
import com.nareshit.model.Employee;

@Repository
public class EmployeeImpl implements IEmployee {

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public void addEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employee); 
	}

	@Override
	public void deleteEmployee(Long eid) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = session.load(Employee.class, eid);
		if (employee != null) {
			session.remove(employee);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmplyoeeById(Long eid) {
		Session session = sessionFactory.getCurrentSession();
		List<Employee> list = session.createQuery("from Employee where eid = " + eid).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		Session session = sessionFactory.getCurrentSession();
		List<Employee> list = session.createQuery("from Employee").list();
		return list;
	}

}
