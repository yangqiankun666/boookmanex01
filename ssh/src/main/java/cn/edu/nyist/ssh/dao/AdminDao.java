package cn.edu.nyist.ssh.dao;

import cn.edu.nyist.ssh.entity.Admin;

public interface AdminDao {
Admin  find (String name,String pwd);
}
