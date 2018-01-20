package com.iot.test.service;

import javax.servlet.http.HttpServletRequest;

public interface CustomerService {
	
	public void setCustomerList(HttpServletRequest req); 
	public void insertCustomer(HttpServletRequest req);
	public void updateCustomer(HttpServletRequest req);
	public void deleteCustomer(HttpServletRequest req);
}
