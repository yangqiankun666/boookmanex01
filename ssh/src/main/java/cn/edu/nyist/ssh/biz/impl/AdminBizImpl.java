package cn.edu.nyist.ssh.biz.impl;

import cn.edu.nyist.ssh.biz.AdminBiz;
import cn.edu.nyist.ssh.dao.AdminDao;
import cn.edu.nyist.ssh.entity.Admin;

public class AdminBizImpl implements AdminBiz {
private AdminDao adminDao;
	public AdminBizImpl() {
		
	}
	

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}


	@Override
	public Admin login(String name, String pwd) {
		
		return adminDao.find(name, pwd);
	}

}
