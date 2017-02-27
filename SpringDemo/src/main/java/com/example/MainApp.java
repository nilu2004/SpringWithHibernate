package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee emp = context.getBean("employee", Employee.class);
		/*emp.getAddress().setCity("Mumbai");
		Employee emp1 = context.getBean("employee", Employee.class);
		System.out.println(emp1);*/
		
		
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		for (int i = 0; i < 20; i++) {
			emp = context.getBean("employee", Employee.class);
			emp.setEmpName("employee-"+(i+1));
			session.save(emp);
		}
		
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Employee");
		List<Employee> empList = (List<Employee>)query.list();
		for(Employee e : empList){
			System.out.println(e);
		}
		
		
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("empId", 1));
		emp = (Employee)criteria.uniqueResult();
		System.out.println("result using Criteria :: "+emp);
		session.getTransaction().commit();
		session.close();
		
		context.registerShutdownHook();
		context.close();
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernateDB", "root", "root");
			System.out.println("connection established");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

}
