package com.iot.test.dao;

import java.util.List;

import com.iot.test.vo.ClassInfo;
import com.iot.test.vo.UserInfo;


public interface ClassDAO {
	
	public List<ClassInfo> selectClassList(ClassInfo ci);
	public int insertClass(ClassInfo ci);
	public int updateClass(ClassInfo ci);
	public int deleteClass(ClassInfo ci);
}
