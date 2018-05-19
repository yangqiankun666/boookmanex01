package cn.edu.nyist.bookman.impl;

import java.util.List;

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

	@Override
	public List<BookVo> findAllBooks(int pageNo) {
	BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.findAll(pageNo);
	}

	@Override
	public int findTotal() {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.getTotal();
	}

}
