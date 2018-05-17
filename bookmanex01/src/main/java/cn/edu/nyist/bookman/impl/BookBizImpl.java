package cn.edu.nyist.bookman.impl;

import java.util.Date;

import cn.edu.nyist.bookman.biz.BookBiz;
import cn.edu.nyist.bookman.dao.BookDao;
import cn.edu.nyist.bookman.dao.impl.BookDaoJdbcImpl;
import cn.edu.nyist.bookman.v0.BookVo;

public class BookBizImpl implements BookBiz {

	@Override
	public int saveBook(BookVo bookVo) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.save(bookVo);
	}

}
