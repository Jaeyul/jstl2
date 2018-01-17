package com.iot.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iot.test.common.DBCon;
import com.iot.test.dao.MenuDAO;
import com.iot.test.test.DBConTest;
import com.iot.test.utils.DBUtil;
import com.iot.test.vo.Menu;

public class MenuDAOImpl implements MenuDAO{

	@Override
	public List<Menu> selectMenuList() {
		List<Menu> menuList = new ArrayList<Menu>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from menu order by mNum";	

		try {
			//con = DBCon.getCon();
			con = DBConTest.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Menu m = new Menu();
				m.setmNum(rs.getInt("mNum"));
				m.setmName(rs.getString("mName"));
				m.setmUrl(rs.getString("mUrl"));
				m.setmDesc(rs.getString("mDesc"));
				menuList.add(m);
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {			
			DBUtil.closeAll(rs, con, ps);			
		}
		 
		
		return menuList;
	}

}
