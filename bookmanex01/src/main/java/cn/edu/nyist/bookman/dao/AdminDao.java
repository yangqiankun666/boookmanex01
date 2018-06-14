package cn.edu.nyist.bookman.dao;

public interface AdminDao {

	boolean get(String name, String pwd);

	Boolean ins(String name, String pwd);

	Boolean editadmin(String pwd, String pwdcheck);

}
