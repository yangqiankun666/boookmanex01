package cn.edu.nyist.bookman.impl;

import cn.edu.nyist.bookman.biz.BookBiz;
import cn.edu.nyist.bookman.dao.BookDao;
import cn.edu.nyist.bookman.dao.impl.BookDaoJdbcImpl;

public class BookBizImpl implements BookBiz {

	@Override
	public int saveBook(String name, String descri, double price, String author, int tid, String newFileName) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.save(name,descri,price,author,tid,newFileName);
	}

}
