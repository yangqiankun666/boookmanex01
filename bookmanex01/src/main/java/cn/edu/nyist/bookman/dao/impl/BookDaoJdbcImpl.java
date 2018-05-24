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
	public List<BookVo> findAll(int pageNo,String name,int tid) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=DsUtil.getconn();
			stmt=conn.createStatement();
			String sql="select * from t_book where 2=2";
			if (tid!=-1) {
				sql+=" and tid="+tid;
			}
			if (name!=null&&!name.equals("")) {//注意and前一定要空格
				//sql+=" and name like '% "+name+"%'";注意第一个百分号后不能加空格，不选择类型，错误结果如下
				//加空格的结果会select * from t_book where 2=2 and name like '% j%' limit 0,1
				//影响select
				sql+=" and name like '%"+name+"%'";
			}//注意limit后要空一下格
			sql+=" limit "+((pageNo-1)*PageConstant.PAGE_SIZE+1-1)+","+PageConstant.PAGE_SIZE;
		   System.out.println(sql);//为确保sql语句正确最好每次都把sql打向控制台检查
			rs=stmt.executeQuery(sql);
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
	public int getTotal(String name,int tid) {
		 Connection conn=null;
		    PreparedStatement stmt=null;
		    ResultSet rs=null;
		
		  
			try {
				conn = DsUtil.getconn();
				//锟斤拷锟斤拷sql锟斤拷执锟斤拷sql锟斤拷锟�
				
				String sql="select count(*) from t_book where 1=1";
				if (tid!=-1) {
					sql+=" and tid="+tid;
				}
				if (name!=null&&!name.equals("")) {
					sql+=" and name like'%"+name+"%'";
				}
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

	@Override
	public Boolean dell(int id) {
		 Connection conn=null;
		    PreparedStatement stmt=null;
		   
		  
			try {
				conn = DsUtil.getconn();
				//锟斤拷锟斤拷sql锟斤拷执锟斤拷sql锟斤拷锟�
				
				String sql="delete from t_book where id="+id;
				
				stmt =conn.prepareStatement(sql);
				
				int ret=stmt.executeUpdate();
				if (ret>0) {
					return true;
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			/*stmt.close();
			conn.close();*/
			finally {
				DsUtil.free(stmt, conn);	
			}
		return false;
	}

	@Override
	public BookVo getid(int id) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=DsUtil.getconn();
			stmt=conn.createStatement();
			String sql="select * from t_book where id= "+id;
			
			rs=stmt.executeQuery(sql);
			
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
				return bookVo;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DsUtil.free(rs, stmt, conn);
		}
		return null;
	}

	@Override
	public int edit(BookVo bookVo) {
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=DsUtil.getconn();
			if (bookVo.getPhoto()==null||bookVo.getPhoto().equals("")) {
				String sql=" update t_book set tid=?,name=?,descri=?,price=?,author=?,pubDate=?where id=?";
				stmt=conn.prepareStatement(sql);
				stmt.setInt(1, bookVo.getTid());
	            stmt.setString(2, bookVo.getName());
	            stmt.setString(3, bookVo.getDescri());
	           // stmt.setString(4, bookVo.getPhoto() );
	            stmt.setDouble(4, bookVo.getPrice());
	            stmt.setString(5, bookVo.getAuthor());
	            stmt.setDate(6, new java.sql.Date(bookVo.getPubDate().getTime()));
	            stmt.setInt(7, bookVo.getId());
	            int ret=stmt.executeUpdate();
	            return ret;
			} else {
				String sql=" update t_book set tid=?,name=?,descri=?,photo=?,price=?,author=?,pubDate=?where id=?";
				stmt=conn.prepareStatement(sql);
				stmt.setInt(1, bookVo.getTid());
	            stmt.setString(2, bookVo.getName());
	            stmt.setString(3, bookVo.getDescri());
	            stmt.setString(4, bookVo.getPhoto() );
	            stmt.setDouble(5, bookVo.getPrice());
	            stmt.setString(6, bookVo.getAuthor());
	            stmt.setDate(7, new java.sql.Date(bookVo.getPubDate().getTime()));
	            stmt.setInt(8, bookVo.getId());
	            int ret=stmt.executeUpdate();
	            return ret;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DsUtil.free( stmt, conn);
		}
		return 0;
	}

	

}
