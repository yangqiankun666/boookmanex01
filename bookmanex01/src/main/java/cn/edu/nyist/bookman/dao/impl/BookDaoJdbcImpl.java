package cn.edu.nyist.bookman.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.edu.nyist.bookman.dao.BookDao;
import cn.edu.nyist.bookman.util.DsUtil;
import cn.edu.nyist.bookman.util.PageConstant;
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

	@Override
	public List<BookVo> findAll(int pageNo) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=DsUtil.getconn();
			stmt=conn.createStatement();
			//String sql=("select * from t_book limit "+((pageNo-1)*PageConstant.PAGE_SIZE+1-1)+","+PageConstant.PAGE_SIZE);
			rs=stmt.executeQuery("select * from t_book limit "+((pageNo-1)*PageConstant.PAGE_SIZE+1-1)+","+PageConstant.PAGE_SIZE);
			List<BookVo> ls=new ArrayList<>();
			while (rs.next()) {
				BookVo bookVo=new BookVo();
				bookVo.setAuthor(rs.getString("author"));
				bookVo.setDescri(rs.getString("descri"));
				bookVo.setId(rs.getInt("id"));
				bookVo.setName(rs.getString("name"));
				bookVo.setPhoto(rs.getString("photo"));
				bookVo.setPrice(rs.getDouble("price"));
				bookVo.setPubDate(rs.getDate("pubDate"));
				bookVo.setTid(rs.getInt("tid"));
				ls.add(bookVo);
			}
			return ls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DsUtil.free(rs, stmt, conn);
		}
		
		
		
		return null;
	}

	@Override
	public int getTotal() {
		 Connection conn=null;
		    PreparedStatement stmt=null;
		    ResultSet rs=null;
		
		  
			try {
				conn = DsUtil.getconn();
				//����sql��ִ��sql���
				
				String sql="select count(*) from t_book";
				System.out.println(sql);
				stmt =conn.prepareStatement(sql);
				
				rs=stmt.executeQuery();
				if(rs.next()) {
					return rs.getInt(1);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			/*stmt.close();
			conn.close();*/
			finally {
				DsUtil.free(rs,stmt, conn);	
			}
		return 0;
	}

}
