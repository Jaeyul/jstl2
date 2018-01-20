package com.iot.test.dao;

import java.util.List;

import com.iot.test.vo.ClassInfo;
import com.iot.test.vo.Customer;

public interface CustomerDAO {
	
	public List<Customer> selectCustomerList(String orderStr, Customer cu);
	public int insertCustomer(Customer ct);
	public int updateCustomer(Customer ct);
	public int deleteCustomer(Customer ct);

}
