package com.iot.test.service;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
	
	public void getUserList(HttpServletRequest req);
	public void gerUser(HttpServletRequest req);
	public void insertUser(HttpServletRequest req);
	public void updateUser(HttpServletRequest req);
	public void deleteUser(HttpServletRequest req);

}
