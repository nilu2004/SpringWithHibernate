package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee emp = context.getBean("employee", Employee.class);
		emp.getAddress().setCity("Mumbai");
		Employee emp1 = context.getBean("employee", Employee.class);
		System.out.println(emp1);
		
		
		/*SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		session.close();*/
		
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernateDB", "root", "root");
			System.out.println("connection established");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

}
