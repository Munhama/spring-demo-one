package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// create a query and sort by last name
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);

		// execute query and get result list
		List<Customer> customers = query.getResultList();

		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {

		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {

		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// retrieve/read from database using the primary key
		Customer customer = session.get(Customer.class, id);

		return customer;
	}

	@Override
	public void deleteCustomer(int id) {

		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// delete object with the primary key
		Query query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomer(String searchName) {

		Session session = sessionFactory.getCurrentSession();

		Query<Customer> query = null;

		if (searchName != null && searchName.trim().length() > 0) {
			query = session.createQuery("from Customer where lower(firstName) like :name or lower(lastName) like :name",
					Customer.class);
			query.setParameter("name", "%" + searchName.toLowerCase() + "%");
		} else {
			query = session.createQuery("from Customer", Customer.class);
		}

		List<Customer> customer = query.getResultList();

		return customer;
	}

}
