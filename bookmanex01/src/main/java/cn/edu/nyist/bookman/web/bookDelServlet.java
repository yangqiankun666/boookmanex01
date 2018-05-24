package cn.edu.nyist.bookman.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nyist.bookman.biz.BookBiz;
import cn.edu.nyist.bookman.impl.BookBizImpl;


@WebServlet("/bookDel")
public class bookDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public bookDelServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strid=request.getParameter("id");
		int id=Integer.parseInt(strid);
		BookBiz bookBiz=new BookBizImpl();
	    Boolean ret=bookBiz.delById(id);
	    if (!ret) {
			request.setAttribute("msg", "ɾ��ʧ��");
		}else {
			request.getRequestDispatcher("bookList").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
