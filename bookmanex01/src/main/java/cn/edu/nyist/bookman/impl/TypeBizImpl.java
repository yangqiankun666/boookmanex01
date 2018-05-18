package cn.edu.nyist.bookman.impl;

import java.util.List;

import cn.edu.nyist.bookman.biz.TypeBiz;
import cn.edu.nyist.bookman.dao.TypeDao;
import cn.edu.nyist.bookman.dao.impl.TypeDaojdbcImpl;
import cn.edu.nyist.bookman.v0.TypeVo;

public class TypeBizImpl implements TypeBiz {

	@Override
	public List<TypeVo> findAllTypes() {
		TypeDao typeDao=new TypeDaojdbcImpl();
		return typeDao.findAll();
	}

}
