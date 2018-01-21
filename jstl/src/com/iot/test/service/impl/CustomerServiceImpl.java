package com.iot.test.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.iot.test.dao.CustomerDAO;
import com.iot.test.dao.impl.CustomerDAOImpl;
import com.iot.test.service.CustomerService;
import com.iot.test.vo.ClassInfo;
import com.iot.test.vo.Customer;
import com.iot.test.vo.UserInfo;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDAO cdao = new CustomerDAOImpl();
	Gson gs =new Gson();
	@Override
	public void setCustomerList(HttpServletRequest req) {
		String orderStr = "customerid asc,customername asc,city asc,country asc";
		String target = req.getParameter("target");
		if(req.getParameter("orderStr") != null) {
			orderStr = req.getParameter("orderStr");
			int fIdx = orderStr.indexOf(target);			
			String orderTarget = orderStr.substring(fIdx);
			int lIdx = orderTarget.indexOf(",");
			if(lIdx != -1) {
				orderTarget = orderTarget.substring(0, lIdx+1);	
				orderStr = orderStr.replace(orderTarget, "");	
			}else {
				orderStr = orderStr.replace(","+orderTarget,"");
				orderTarget = orderTarget + ",";
			}
			
			if(orderTarget.indexOf("asc") != -1) {
				orderTarget = orderTarget.replace("asc", "desc");
			}else {
				orderTarget = orderTarget.replace("desc", "asc");				
			}
			orderStr = orderTarget + orderStr;
		}		
		Customer cu = null;		
		String searchStr = req.getParameter("searchStr");
		String searchType = req.getParameter("searchType");		
		String str = searchStr;		
		if(searchStr!=null && !searchStr.equals("")) {
			searchStr = "{search : " + searchStr + ",searchType : " + searchType +"}";
			cu = gs.fromJson(searchStr, Customer.class);				
		}		
		
		req.setAttribute("String", str);			
		req.setAttribute("orderStr", orderStr);		
		req.setAttribute("customerList", cdao.selectCustomerList(orderStr, cu));
		
	}
	@Override
	public void insertCustomer(HttpServletRequest req) {
		Customer ct = null;		
		
		String customerName = req.getParameter("customerName");
		String city = req.getParameter("city");
		String country = req.getParameter("country");		
		
	
		String json = "{" ;
		
		json += "customerName:" + customerName +",";
		json += "city:" + city +",";
		json += "country:" + country;		
		json += "}";
		
		
		System.out.println(json);
		ct = gs.fromJson(json, Customer.class);		
		int result = cdao.insertCustomer(ct);			
		
		Map<String, String> hm = new HashMap<String, String>();
		hm.put("msg", "회원가입에 실패했습니다.");
		if(result != 0) {
			hm.put("msg", "회원가입되었습니다.");
		}		
		req.setAttribute("msg", hm);			
	}
	
	@Override
	public void updateCustomer(HttpServletRequest req) {
		Customer ct = null;
		String catchValue = req.getParameter("catchValue");
		String[] catchValues = catchValue.split(",");
		
		for(String v : catchValues) {
			System.out.println("실험 : " + v);			
		}
		
		
		String catchType = req.getParameter("catchType");
		String[] catchTypes = catchType.split(",");
		String json = "{";
		for(int i=0; i<catchTypes.length; i++) {
			json += catchTypes[i] + " : " + catchValues[i] ;			
			if(i != catchTypes.length -1) {
				json +=	",";				
			}
		}
		json += "}";
		
		System.out.println(json);
		ct = gs.fromJson(json, Customer.class);		
		int result = cdao.updateCustomer(ct);	
		
		
		
		Map<String, String> hm = new HashMap<String, String>();
		hm.put("msg", "수정에 실패했습니다.");
		if(result != -1) {
			hm.put("msg", "수정되었습니다.");
		}
		
		req.setAttribute("msg", hm);		
		
	}
	@Override
	public void deleteCustomer(HttpServletRequest req) {
		Customer ct = null;
		String catchValue = req.getParameter("catchValue");
		String[] catchValues = catchValue.split(",");			
		String catchType = req.getParameter("catchType");
		String[] catchTypes = catchType.split(",");
		String json = "{";
		for(int i=0; i<catchTypes.length; i++) {
			json += catchTypes[i] + " : " + catchValues[i] ;			
			if(i != catchTypes.length -1) {
				json +=	",";				
			}
		}
		json += "}";
		
		System.out.println(json);
		ct = gs.fromJson(json, Customer.class);		
		int result = cdao.deleteCustomer(ct);	
		
		Map<String, String> hm = new HashMap<String, String>();
		hm.put("msg", "삭제를 실패했습니다.");
		if(result != -1) {
			hm.put("msg", "삭제되었습니다.");
		}		
		req.setAttribute("msg", hm);	
		
	}
}
