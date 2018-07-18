package com.qiujintao.spring_boot_Redis_demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qiujintao.spring_boot_Redis_demo.model.Customer;
import com.qiujintao.spring_boot_Redis_demo.repo.CustomerRepository;

@RestController
public class WebController {
	@Autowired
	private CustomerRepository customerRepository;
	@RequestMapping("/save")
	public String save() {
		customerRepository.save(new Customer(1, "Jack", "Smith"));
		customerRepository.save(new Customer(2, "Adam", "Johnson"));
		customerRepository.save(new Customer(3, "Kim", "Smith"));
		customerRepository.save(new Customer(4, "David", "Williams"));
		customerRepository.save(new Customer(5, "Peter", "Davis"));
		return "Done";
	}
	@RequestMapping("/findall")
	public String findAll() {
		String result = "";
		for(Customer customer : customerRepository.findAll().values()) {
			result += customer.toString()+"<br>";
		}
		return result;
	}
	
	@RequestMapping("/find")
	public String findById(@RequestParam("id") Long id) {
		return customerRepository.find(id).toString();
	}
	
	@RequestMapping("/uppercase")
	public String postCustomer(@RequestParam("id") Long id) {
		Customer customer = customerRepository.find(id);
		customer.setFirstName(customer.getFirstName().toUpperCase());
		customer.setLastName(customer.getLastName().toUpperCase());
		customerRepository.update(customer);
		return customer.toString();
	}
	@RequestMapping("/delete")
	public String deleteById(@RequestParam("id") Long id) {
		customerRepository.delete(id);
		return "Done";
	}

}
