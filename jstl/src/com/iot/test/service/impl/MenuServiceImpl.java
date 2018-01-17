package com.iot.test.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.dao.MenuDAO;
import com.iot.test.dao.impl.MenuDAOImpl;
import com.iot.test.service.MenuService;

public class MenuServiceImpl implements MenuService {
	private MenuDAO mdao = new MenuDAOImpl();
	

	@Override
	public void setMenuList(HttpServletRequest req) {
		
		req.setAttribute("menuList", mdao.selectMenuList());

	}

}
