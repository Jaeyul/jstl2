package com.iot.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iot.test.common.DBCon;
import com.iot.test.dao.CustomerDAO;
import com.iot.test.utils.DBUtil;
import com.iot.test.vo.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public List<Customer> selectCustomerList(String orderStr, String by) {
		List<Customer> customerList = new ArrayList<Customer>();	
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;		
		String sql = "select * from customer ";	
		if(orderStr != null) {
			sql += " order by " + orderStr;			
		}
		if(by != null) {
			sql += " " + by;				 
		}
		try {
			con = DBCon.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Customer c = new Customer();
				c.setCustomerId(rs.getInt("customerId"));
				c.setCustomerName(rs.getString("customerName"));
				c.setCity(rs.getString("city"));
				c.setCountry(rs.getString("country"));
				customerList.add(c);					
			}			
			
		} catch (SQLException e) {
	
			e.printStackTrace();
			
		} finally {
			DBUtil.closeAll(rs, con, ps);
			
		}		
		
		return customerList;
	}

}
