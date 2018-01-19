package com.iot.test.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSessionFactory {
	private static SqlSessionFactory ssf;
	
	static {
		String resource = "conf/mybatis-conf.xml";
		InputStream inputStream = null;		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			ssf = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {			
			e.printStackTrace();
		}		
			
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return ssf;
		
	}

}
