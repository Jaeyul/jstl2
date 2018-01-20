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
	public List<Customer> selectCustomerList(String orderStr, Customer cu) {
		List<Customer> customerList = new ArrayList<Customer>();	
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;		
		String sql = "select * from customer";	
	
		if(cu != null) {			
			sql += " where ";
			sql += cu.getSearchType();
			sql += " like ?";					
		}
		
		if(orderStr != null) {
			sql += " order by " + orderStr;			
		}
		System.out.println(sql);
		
		try {
			con = DBCon.getCon();
			ps = con.prepareStatement(sql);
			if(cu!=null) {
				ps.setString(1, "%" + cu.getSearch() + "%");					
			}
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

	@Override
	public int insertCustomer(Customer ct) {
		String sql = "insert into customer(customerName,city,country) ";
		sql += " values(?,?,?)";
		Connection con =null;
		PreparedStatement ps = null;	
		int result = 0;
		
		try {
			con = DBCon.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, ct.getCustomerName());			
			ps.setString(2, ct.getCity());
			ps.setString(3, ct.getCountry());		
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int updateCustomer(Customer ct) {
		String sql = "update customer set customerName=?, city=?, country=? where customerId=?" ;
		Connection con =null;
		PreparedStatement ps = null;	
		int result = 0;
		
		try {
			con = DBCon.getCon();
			ps = con.prepareStatement(sql);	
			ps.setString(1, ct.getCustomerName());			
			ps.setString(2, ct.getCity());
			ps.setString(3, ct.getCountry());
			ps.setInt(4, ct.getCustomerId());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteCustomer(Customer ct) {
		String sql = "delete from customer where customerId=?" ;
		Connection con =null;
		PreparedStatement ps = null;	
		int result = 0;
		
		try {
			con = DBCon.getCon();
			ps = con.prepareStatement(sql);	
			
			ps.setInt(1, ct.getCustomerId());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}

}
