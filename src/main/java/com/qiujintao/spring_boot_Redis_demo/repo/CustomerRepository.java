package com.qiujintao.spring_boot_Redis_demo.repo;

import java.util.Map;
import com.qiujintao.spring_boot_Redis_demo.model.Customer;

public interface CustomerRepository {
	
	void save(Customer customer);
	Customer find(Long id);
	Map<Long, Customer> findAll();
	void update(Customer customer);
	void delete(Long id);

}
