package cn.edu.nyist.ssh.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.nyist.ssh.biz.AdminBiz;
import cn.edu.nyist.ssh.entity.Admin;

public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private AdminBiz adminBiz;
	private Admin admin = null;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public void setAdminBiz(AdminBiz adminBiz) {
		this.adminBiz = adminBiz;
	}

	public AdminAction() {
		

	}
	@Override
	public String execute() throws Exception {
		Admin admin1 = adminBiz.login(admin.getName(), admin.getPwd());
		if (admin1!=null) {
			return INPUT;
		}else {
			return SUCCESS;
		}
	}

}
