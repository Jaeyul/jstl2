package com.iot.test.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.iot.test.dao.UserDAO;
import com.iot.test.dao.impl.UserDAOImpl;
import com.iot.test.service.UserService;
import com.iot.test.vo.UserInfo;

public class UserServiceImpl implements UserService{
	private UserDAO udao = new UserDAOImpl();
	Gson gs = new Gson();

	@Override
	public void getUserList(HttpServletRequest req) {
		
		UserInfo ui = null;
		String searchStr = req.getParameter("searchStr");
		String searchType = req.getParameter("searchType");
		String str = searchStr;
		if(searchStr!=null && !searchStr.equals("")) {
			searchStr = "{search : " + searchStr + ",searchType : " + searchType +"}";
			ui = gs.fromJson(searchStr, UserInfo.class);				
		}
		
		req.setAttribute("String", str);
		req.setAttribute("userList", udao.selectUserList(ui));		
		
	}

	@Override
	public void gerUser(HttpServletRequest req) {
		
		
	}

	@Override
	public void insertUser(HttpServletRequest req) {
		
		
	}

	@Override
	public void updateUser(HttpServletRequest req) {
		UserInfo ui = null;
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
		json = "}";
		
		ui = gs.fromJson(json, UserInfo.class);		
		int result = udao.updateUser(ui);	
		
	}

	@Override
	public void deleteUser(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
