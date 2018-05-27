package cn.edu.nyist.bookman.biz;

public interface AdminBiz {

	boolean findAdminByNameAndPwd(String name, String pwd);

	Boolean insertnameandpwd(String name, String pwd);

	Boolean editpwd(String pwd);

}
