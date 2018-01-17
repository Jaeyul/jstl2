package com.iot.test.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.iot.test.dao.ClassDAO;
import com.iot.test.dao.impl.ClassDAOImpl;
import com.iot.test.service.ClassService;
import com.iot.test.vo.ClassInfo;

public class ClassServiceImpl implements ClassService {
	ClassDAO cdao = new ClassDAOImpl();
	Gson gs =new Gson();

	@Override
	public void setClassList(HttpServletRequest req) {
		ClassInfo ci = null;
		String json = req.getParameter("param");
		String str = json;
		
		if(json!=null && !json.equals("")) {
			json = "{ciName :" + json + "}";
			ci = gs.fromJson(json, ClassInfo.class);			
			
		}
		req.setAttribute("String", str);
		req.setAttribute("classList", cdao.selectClassList(ci));		
		

	}

}
