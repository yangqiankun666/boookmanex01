package cn.edu.nyist.bookman.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import cn.edu.nyist.bookman.dao.BookDao;
import cn.edu.nyist.bookman.util.DsUtil;
import cn.edu.nyist.bookman.v0.BookVo;

public class BookDaoJdbcImpl implements BookDao {

	@Override
	public int save(BookVo bookVo) {
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=DsUtil.getconn();
			String sql="insert into t_book(tid,name,descri,photo,price,author,pubDate) values(?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, bookVo.getTid());
            stmt.setString(2, bookVo.getName());
            stmt.setString(3, bookVo.getDescri());
            stmt.setString(4, bookVo.getPhoto() );
            stmt.setDouble(5, bookVo.getPrice());
            stmt.setString(6, bookVo.getAuthor());
            stmt.setDate(7, new java.sql.Date(bookVo.getPubDate().getTime()));
            int ret=stmt.executeUpdate();
            return ret;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DsUtil.free( stmt, conn);
		}
	
		
		
		return 0;
		
	}

}
