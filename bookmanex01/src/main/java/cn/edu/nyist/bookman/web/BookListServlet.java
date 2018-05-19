package cn.edu.nyist.bookman.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nyist.bookman.biz.BookBiz;
import cn.edu.nyist.bookman.impl.BookBizImpl;
import cn.edu.nyist.bookman.util.PageConstant;
import cn.edu.nyist.bookman.v0.BookVo;


@WebServlet("/bookList")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BookListServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String strPageNo=request.getParameter("pageNo");
	int pageNo;
	try {
		pageNo = Integer.parseInt(strPageNo);
	} catch (NumberFormatException e) {
		pageNo=1;
	}
	
		BookBiz bookBiz=new BookBizImpl();
		List<BookVo> ls=bookBiz.findAllBooks(pageNo);
		int total=bookBiz.findTotal();
		if (total%PageConstant.PAGE_SIZE==0) {
			request.setAttribute("totalPage",total/PageConstant.PAGE_SIZE );
		} else {
			request.setAttribute("totalPage",total/PageConstant.PAGE_SIZE+1 );
		}
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("ls", ls);
request.getRequestDispatcher("bookList.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
