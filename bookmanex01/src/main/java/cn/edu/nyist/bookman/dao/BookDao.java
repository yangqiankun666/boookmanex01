package cn.edu.nyist.bookman.dao;

import java.util.List;

import cn.edu.nyist.bookman.v0.BookVo;

public interface BookDao {

	//int save(String name, String descri, double price, String author, int tid, String newFileName, Date pubDate);
int save(BookVo bookVo);

List<BookVo> findAll(int pageNo);

int getTotal();
}
