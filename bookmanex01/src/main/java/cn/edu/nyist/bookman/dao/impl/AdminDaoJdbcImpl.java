package cn.edu.nyist.bookman.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.nyist.bookman.dao.AdminDao;
import cn.edu.nyist.bookman.util.DsUtil;

public class AdminDaoJdbcImpl implements AdminDao {

	@Override
	public boolean get(String name, String pwd) {
		 Connection conn=null;
		    PreparedStatement stmt=null;
		    ResultSet rs=null;
		  boolean ret=false;
		  
			try {
				conn = DsUtil.getconn();
				// ‰»Îsql£¨÷¥––sql”Ôæ‰
				
				String sql="select * from t_admin where name=? and pwd=?";
				System.out.println(sql);
				stmt =conn.prepareStatement(sql);
				stmt.setString(1, name);
				stmt.setString(2, pwd);
				rs=stmt.executeQuery();
				if(rs.next()) {
					ret=true;
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			/*stmt.close();
			conn.close();*/
			finally {
				DsUtil.free(rs,stmt, conn);	
			}
		return ret;
	}

}
