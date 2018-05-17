package cn.edu.nyist.bookman.biz;

import cn.edu.nyist.bookman.v0.BookVo;

public interface BookBiz {

	//int saveBook(String name, String descri, double price, String author, int tid, String newFileName, Date pubDate);

	int saveBook(BookVo bookVo);

}
