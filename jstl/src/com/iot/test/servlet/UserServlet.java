package com.iot.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iot.test.service.MenuService;
import com.iot.test.service.UserService;
import com.iot.test.service.impl.MenuServiceImpl;
import com.iot.test.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	private UserService us = new UserServiceImpl();
	private MenuService ms = new MenuServiceImpl();	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
		
	}	

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
		
	}
	
	private void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		String uri = req.getRequestURI();
		String root = req.getContextPath();
		
//		System.out.println("URI : " + uri);
//		System.out.println("ContextRoot : " + root);		
		uri = uri.replace(root, "");
		ms.setMenuList(req);
		
		if(uri.indexOf("revise")!= -1) {	
			
			String catchStr = req.getParameter("catch");
			
			System.out.println(catchStr);
			
			if(catchStr.equals("update")) {				
				
			}else {				
				
			}
			System.out.println(catchValue);
			uri = "/user/list";
			
		}
		
		uri = "/WEB-INF/view" + uri + ".jsp";
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);		
		
		
	}
	

}
