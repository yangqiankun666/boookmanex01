package cn.edu.nyist.bookman.dao;

public interface BookDao {

	int save(String name, String descri, double price, String author, int tid, String newFileName);

}
