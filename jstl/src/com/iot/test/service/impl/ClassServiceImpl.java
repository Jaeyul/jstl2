package com.iot.test.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.iot.test.dao.ClassDAO;
import com.iot.test.dao.impl.ClassDAOImpl;
import com.iot.test.service.ClassService;
import com.iot.test.vo.ClassInfo;
import com.iot.test.vo.UserInfo;

public class ClassServiceImpl implements ClassService {
	ClassDAO cdao = new ClassDAOImpl();
	Gson gs =new Gson();

	@Override
	public void setClassList(HttpServletRequest req) {
		ClassInfo ci = null;
		String searchStr = req.getParameter("searchStr");
		String searchType = req.getParameter("searchType");
		
		String str = searchStr;
		
		if(searchStr!=null && !searchStr.equals("")) {
			searchStr = "{search : " + searchStr + ",searchType : " + searchType +"}";
			ci = gs.fromJson(searchStr, ClassInfo.class);				
		}		
		
		
		req.setAttribute("String", str);
		req.setAttribute("classList", cdao.selectClassList(ci));		
		

	}

}
