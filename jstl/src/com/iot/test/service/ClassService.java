package com.iot.test.service;

import javax.servlet.http.HttpServletRequest;

public interface ClassService {
	public void setClassList(HttpServletRequest req);
	public void insertClass(HttpServletRequest req);
	public void updateClass(HttpServletRequest req);
	public void deleteClass(HttpServletRequest req);

}
