package com.iot.test.service.impl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.iot.test.dao.ClassDAO;
import com.iot.test.dao.UserDAO;
import com.iot.test.dao.impl.ClassDAOImpl;
import com.iot.test.dao.impl.UserDAOImpl;
import com.iot.test.service.ClassService;
import com.iot.test.vo.ClassInfo;
import com.iot.test.vo.UserInfo;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class ClassServiceImpl implements ClassService {
	ClassDAO cdao = new ClassDAOImpl();
	UserDAO udao = new UserDAOImpl();
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

	@Override
	public void insertClass(HttpServletRequest req) {
		ClassInfo ci = null;
		String ciName = req.getParameter("ciName");		
		String ciDesc = req.getParameter("ciDesc");
		
	
		String json = "{" ;
		json += "ciName:" + ciName +",";
		json += "ciDesc:" + ciDesc ;
		
		json += "}";
		
		
		System.out.println(json);
		ci = gs.fromJson(json, ClassInfo.class);		
		int result = cdao.insertClass(ci);			
		
		String msg = "반개설에 실패했습니다.";
		if(result != 0) {
			msg = "반개설에 성공했습니다.";			
		}
		
		req.setAttribute("msg", msg);
		
	}

	@Override
	public void updateClass(HttpServletRequest req) {
		ClassInfo ci = null;
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
		ci = gs.fromJson(json, ClassInfo.class);		
		int result = cdao.updateClass(ci);	
		
		String msg = "수정에 실패했습니다.";
		if(result != 0) {
			msg = "수정에 성공했습니다.";			
		}
		
		req.setAttribute("msg", msg);
		
	}

	@Override
	public void deleteClass(HttpServletRequest req) {
		ClassInfo ci = null;
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
		ci = gs.fromJson(json, ClassInfo.class);		
		int result = cdao.deleteClass(ci);			
		String msg = "삭제에 실패했습니다.";
		if(result == 0) {
			UserInfo ui = new UserInfo();
			ui.setCiNo(ci.getCiNo());
			UserInfo ciEqUi = udao.selectUser(ui);
			if(ciEqUi != null) {
				msg = "반에 학생이 있어요. 삭제가 실패했습니다.";				
			}			
		}else {				
			msg = "삭제에 성공했습니다.";	
		}		
		req.setAttribute("msg", msg);		
	}

}
