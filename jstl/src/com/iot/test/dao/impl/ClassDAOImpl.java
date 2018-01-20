package com.iot.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iot.test.common.DBCon;
import com.iot.test.dao.ClassDAO;
import com.iot.test.utils.DBUtil;
import com.iot.test.vo.ClassInfo;
import com.iot.test.vo.UserInfo;

public class ClassDAOImpl implements ClassDAO {

	@Override
	public List<ClassInfo> selectClassList(ClassInfo ci) {
		List<ClassInfo> classList = new ArrayList<ClassInfo>();
		String sql = "select * from class_info where 1=1";		
		
		if(ci != null) {
			sql += " and ";
			sql += ci.getSearchType();
			sql += " like ?";					
		}
			
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		try {
			con = DBCon.getCon();
			ps = con.prepareStatement(sql);
			if(ci!=null) {
				ps.setString(1, "%" + ci.getSearch() + "%");					
			}
			rs = ps.executeQuery();
			while(rs.next()) {
				ClassInfo ci2 = new ClassInfo();
				ci2.setCiNo(rs.getInt("cino"));			
				ci2.setCiName(rs.getString("ciname"));
				ci2.setCiDesc(rs.getString("cidesc"));			
				classList.add(ci2);			
			}			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		finally {
			DBUtil.closeAll(rs, con, ps);			
		}				
		return classList;
	}

	@Override
	public int insertClass(ClassInfo ci) {
		String sql = "insert into class_info(ciName,ciDesc) ";
		sql += " values(?,?)";
		Connection con =null;
		PreparedStatement ps = null;	
		int result = 0;
		
		try {
			con = DBCon.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, ci.getCiName());
			ps.setString(2, ci.getCiDesc());			
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int updateClass(ClassInfo ci) {
		String sql = "update class_info set ciName=?, ciDesc=? where ciNo=?" ;
		Connection con =null;
		PreparedStatement ps = null;	
		int result = 0;
		
		try {
			con = DBCon.getCon();
			ps = con.prepareStatement(sql);	
			ps.setString(1, ci.getCiName());			
			ps.setString(2, ci.getCiDesc());
			ps.setInt(3, ci.getCiNo());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteClass(ClassInfo ci) {
		String sql = "delete from class_info where ciNo=?" ;
		Connection con =null;
		PreparedStatement ps = null;	
		int result = 0;
		
		try {
			con = DBCon.getCon();
			ps = con.prepareStatement(sql);	
			
			ps.setInt(1, ci.getCiNo());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}

}
