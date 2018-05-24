package cn.edu.nyist.bookman.impl;

import java.util.List;

import cn.edu.nyist.bookman.biz.BookBiz;
import cn.edu.nyist.bookman.dao.BookDao;
import cn.edu.nyist.bookman.dao.TypeDao;
import cn.edu.nyist.bookman.dao.impl.BookDaoJdbcImpl;
import cn.edu.nyist.bookman.dao.impl.TypeDaojdbcImpl;
import cn.edu.nyist.bookman.v0.BookVo;
import cn.edu.nyist.bookman.v0.TypeVo;

public class BookBizImpl implements BookBiz {

	@Override
	public int saveBook(BookVo bookVo) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.save(bookVo);
	}

	@Override
	public List<BookVo> findAllBooks(int pageNo,String name,int tid) {
	BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.findAll(pageNo,name,tid);
	}

	@Override
	public int findTotal(String name,int tid) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.getTotal(name,tid);
	}

	@Override
	public List<TypeVo> findAllTypes() {
		TypeDao typeDao=new TypeDaojdbcImpl();
		
		return typeDao.findAll();
	}

	@Override
	public Boolean delById(int id) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.dell(id);
	}

	@Override
	public BookVo findBookById(int id) {
		BookDao bookDao=new BookDaoJdbcImpl();
		
		return  bookDao.getid(id);
	}

	@Override
	public int editBook(BookVo bookVo) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.edit(bookVo);
	}

}
