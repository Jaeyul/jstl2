package com.iot.test.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iot.test.service.ClassService;
import com.iot.test.service.CustomerService;
import com.iot.test.service.MenuService;
import com.iot.test.service.UserService;
import com.iot.test.service.impl.ClassServiceImpl;
import com.iot.test.service.impl.CustomerServiceImpl;
import com.iot.test.service.impl.MenuServiceImpl;
import com.iot.test.service.impl.UserServiceImpl;
import com.iot.test.vo.Customer;

//@WebServlet("/view/*")
//@WebServlet(name="JspServlet", urlPatterns= {"/view/*"})
public class JspServlet extends HttpServlet {	
	private UserService us = new UserServiceImpl();
	private MenuService ms = new MenuServiceImpl();
	private ClassService cs = new ClassServiceImpl();
	
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
		
		System.out.println("URI : " + uri);
		System.out.println("ContextRoot : " + root);		
		uri = uri.replace(root, "");
		ms.setMenuList(req);
		if(uri.indexOf("/user/list")!= -1) {			
			us.getUserList(req);			
		}
		else if(uri.indexOf("/user/search")!= -1) {			
			us.getUserList(req);
			uri = "/view/user/list";
		}
		else if(uri.indexOf("/class/list")!= -1) {			
			cs.setClassList(req);
			
		}
		else if(uri.indexOf("/class/search")!= -1) {			
			cs.setClassList(req);
			uri = "/view/class/list";
		}
		else if(uri.indexOf("/customer/list")!= -1) {
			CustomerService cs = new CustomerServiceImpl();
			cs.setCustomerList(req);
		}		
		
		
		System.out.println("최종 URI : " + uri);
		uri = "/WEB-INF" + uri + ".jsp";
		RequestDispatcher rd = req.getRequestDispatcher(uri);
//		req.setAttribute("test", "나도 보이나요?");
		rd.forward(req, res);
		
		
		
		
		
		
		
		
	}

	
	
	
}
