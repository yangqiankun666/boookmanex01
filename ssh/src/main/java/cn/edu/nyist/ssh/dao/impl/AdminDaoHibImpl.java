package cn.edu.nyist.ssh.dao.impl;
 
import java.util.Iterator;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.nyist.ssh.dao.AdminDao;
import cn.edu.nyist.ssh.entity.Admin;

public class AdminDaoHibImpl extends HibernateDaoSupport implements AdminDao {

	public AdminDaoHibImpl() {
		
	}

	@Override
	public Admin find(String name, String pwd) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Admin.class);
		criteria.add(Restrictions.eq("name", name)).add(Restrictions.eq("pwd", pwd));
		Iterator<Admin> it=(Iterator<Admin>) getHibernateTemplate().findByCriteria(criteria).iterator();
		if (it.hasNext()) {
			return it.next();
		}
		return null;
	}

}
