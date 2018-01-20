package com.iot.test.service.impl;

import java.util.HashMap;
import java.util.Map;

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
		UserInfo ui = null;
		String uiName = req.getParameter("uiName");
		int uiAge = Integer.parseInt(req.getParameter("uiAge"));
		String uiId = req.getParameter("uiId");
		String uiPwd = req.getParameter("uiPwd");
		String address = req.getParameter("address");
		int ciNo = Integer.parseInt(req.getParameter("ciNo"));
		
		
	
		String json = "{" ;
		json += "uiName:" + uiName +",";
		json += "uiAge:" + uiAge +",";
		json += "uiId:" + uiId +",";
		json += "uiPwd:" + uiPwd +",";
		json += "address:" + address +",";
		json += "ciNo:" + ciNo ;
		json += "}";
		
		
		System.out.println(json);
		ui = gs.fromJson(json, UserInfo.class);		
		int result = udao.insertUser(ui);			
		
		Map<String, String> hm = new HashMap<String, String>();
		hm.put("msg", "회원가입에 실패했습니다.");
		if(result != 0) {
			hm.put("msg", "회원가입되었습니다.");
		}		
		req.setAttribute("msg", hm);		
	}

	@Override
	public void updateUser(HttpServletRequest req) {
		UserInfo ui = null;
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
		ui = gs.fromJson(json, UserInfo.class);		
		int result = udao.updateUser(ui);	
		
		
		
		Map<String, String> hm = new HashMap<String, String>();
		hm.put("msg", "수정에 실패했습니다.");
		if(result != 0) {
			hm.put("msg", "수정되었습니다.");
		}
		
		req.setAttribute("msg", hm);		
	}

	@Override
	public void deleteUser(HttpServletRequest req) {
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
		json += "}";
		
		System.out.println(json);
		ui = gs.fromJson(json, UserInfo.class);		
		int result = udao.deleteUser(ui);			
		Map<String, String> hm = new HashMap<String, String>();
		hm.put("msg", "삭제를 실패했습니다.");
		if(result != 0) {
			hm.put("msg", "삭제되었습니다.");
		}		
		req.setAttribute("msg", hm);		
		
	}
	
	
	
}
