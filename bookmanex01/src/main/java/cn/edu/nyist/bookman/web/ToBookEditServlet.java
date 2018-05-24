package cn.edu.nyist.bookman.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nyist.bookman.biz.BookBiz;
import cn.edu.nyist.bookman.impl.BookBizImpl;
import cn.edu.nyist.bookman.v0.BookVo;


@WebServlet("/toBookEdit")
public class ToBookEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ToBookEditServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strid=request.getParameter("id");
		int id=Integer.parseInt(strid);
		BookBiz bookBiz=new BookBizImpl();
	   BookVo bookVo=bookBiz.findBookById(id);
	   request.setAttribute("bookVo", bookVo);
	   request.getRequestDispatcher("bookEdit.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
