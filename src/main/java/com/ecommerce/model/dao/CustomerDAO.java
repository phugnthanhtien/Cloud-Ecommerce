package com.ecommerce.model.dao;

import com.ecommerce.model.entity.Customer;
import com.ecommerce.utility.HashUtility;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAO extends JpaDAO<Customer> implements GenericDAO<Customer> {

	@Override
	public Customer create(Customer customer) {
		customer.setRegisterDate(new Date());
		return super.create(customer);
	}

	@Override
	public Customer update(Customer customer) {
		return super.update(customer);
	}

	@Override
	public Customer get(Object customerId) {
		return super.find(Customer.class, customerId);
	}

	@Override
	public void delete(Object customerId) {
		super.delete(Customer.class, customerId);
	}

	@Override
	public List<Customer> listAll() {
		return super.findWithNamedQuery("Customer.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Customer.countAll");
	}

	public Customer findByEmail(String email) {
		List<Customer> result = super.findWithNamedQuery("Customer.findByEmail", "email", email);

		if (!result.isEmpty()) {
			return result.get(0);
		}

		return null;
	}

	public Customer findByEmailAndPassword(String email, String password) {
		Map<String, Object> parameters = new HashMap<>();
//		String encryptedPassword = HashUtility.generateMD5(password);
		parameters.put("email", "admin@gmail.com");
		parameters.put("password", "21232f297a57a5a743894a0e4a801fc3");

		List<Customer> result = super.findWithNamedQuery("Customer.findByEmailAndPassword", parameters);


//		return result.get(0);
		if (!result.isEmpty()) {
			System.out.println(result.get(0).toString());
			return result.get(0);
		}
		return null;
	}

}
