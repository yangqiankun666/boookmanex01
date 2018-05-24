package cn.edu.nyist.bookman.biz;

import java.util.List;

import cn.edu.nyist.bookman.v0.BookVo;
import cn.edu.nyist.bookman.v0.TypeVo;

public interface BookBiz {

	//int saveBook(String name, String descri, double price, String author, int tid, String newFileName, Date pubDate);

	int saveBook(BookVo bookVo);

	List<BookVo> findAllBooks(int pageNo, String name, int tid);

	int findTotal(String name, int tid);

	List<TypeVo> findAllTypes();

	Boolean delById(int id);

	BookVo findBookById(int id);

	int editBook(BookVo bookVo);

}
