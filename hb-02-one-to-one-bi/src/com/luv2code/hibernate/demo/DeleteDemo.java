package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get instructor by primary key / id
			int id = 2;
			Instructor instructor = session.get(Instructor.class, id);
			System.out.println("Found instructor: " + instructor);

			// delete the instructor
			if (instructor != null)
				session.delete(instructor);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			sessionFactory.close();
		}

	}

}
