package com.iot.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.dao.CustomerDAO;
import com.iot.test.dao.impl.CustomerDAOImpl;
import com.iot.test.service.CustomerService;
import com.iot.test.vo.Customer;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDAO cdao = new CustomerDAOImpl();
	@Override
	public void setCustomerList(HttpServletRequest req) {
		
		String order = req.getParameter("order");
		String by = req.getParameter("by");
		req.setAttribute("by", by);		
		req.setAttribute("customerList", cdao.selectCustomerList(order, by));
		
	}
}
