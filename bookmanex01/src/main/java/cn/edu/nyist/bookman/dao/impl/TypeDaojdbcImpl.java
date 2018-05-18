package cn.edu.nyist.bookman.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.edu.nyist.bookman.dao.TypeDao;
import cn.edu.nyist.bookman.util.DsUtil;
import cn.edu.nyist.bookman.v0.TypeVo;

public class TypeDaojdbcImpl implements TypeDao {

	@Override
	public List<TypeVo> findAll() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=DsUtil.getconn();
			stmt=conn.createStatement();
			String sql="select * from t_type";
			rs=stmt.executeQuery(sql);
			List<TypeVo> ls=new ArrayList<>();
			while (rs.next()) {
				TypeVo typeVo=new TypeVo();
				typeVo.setId(rs.getInt("id"));
				typeVo.setName(rs.getString("name"));
				ls.add(typeVo);
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

}
