package com.iot.test.dao;

import java.util.List;

import com.iot.test.vo.Customer;

public interface CustomerDAO {
	
	public List<Customer> selectCustomerList(String orderStr, String by);

}
