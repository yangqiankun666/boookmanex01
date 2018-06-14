package cn.edu.nyist.bookman.impl;

import cn.edu.nyist.bookman.biz.AdminBiz;
import cn.edu.nyist.bookman.dao.AdminDao;
import cn.edu.nyist.bookman.dao.impl.AdminDaoJdbcImpl;

public class AdminBizimpl implements AdminBiz{

	@Override
	public boolean findAdminByNameAndPwd(String name, String pwd) {
		AdminDao adminDao=new AdminDaoJdbcImpl();
		return adminDao.get(name,pwd);
	}

	@Override
	public Boolean insertnameandpwd(String name, String pwd) {
		AdminDao adminDao=new AdminDaoJdbcImpl();
		return adminDao.ins(name,pwd);
	}

	@Override
	public Boolean editpwd(String pwd,String pwdcheck ) {
		AdminDao adminDao=new AdminDaoJdbcImpl();
		return adminDao.editadmin(pwd,pwdcheck);
	}

}
