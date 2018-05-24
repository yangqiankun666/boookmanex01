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
import cn.edu.nyist.bookman.v0.TypeVo;

@WebServlet("/bookList")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookListServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String strPageNo = request.getParameter("pageNo");
		int pageNo;
		try {
			pageNo = Integer.parseInt(strPageNo);
		} catch (NumberFormatException e) {
			pageNo = 1;
		}

		String name = request.getParameter("name");
		String strTid = request.getParameter("tid");
		int tid = -1;
		try {
			tid = Integer.parseInt(strTid);
		} catch (NumberFormatException e) {

		}

		BookBiz bookBiz = new BookBizImpl();
		List<BookVo> ls = bookBiz.findAllBooks(pageNo, name, tid);
		int total = bookBiz.findTotal(name, tid);
		List<TypeVo> types = bookBiz.findAllTypes();

		if (total % PageConstant.PAGE_SIZE == 0) {
			request.setAttribute("totalPage", total / PageConstant.PAGE_SIZE);
		} else {
			request.setAttribute("totalPage", total / PageConstant.PAGE_SIZE + 1);
		}
		request.setAttribute("types", types);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("ls", ls);
		request.setAttribute("name", name);
		request.setAttribute("tid", tid);
		request.getRequestDispatcher("bookList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
