package cn.edu.nyist.bookman.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nyist.bookman.biz.AdminBiz;
import cn.edu.nyist.bookman.biz.BookBiz;
import cn.edu.nyist.bookman.impl.AdminBizimpl;
import cn.edu.nyist.bookman.impl.BookBizImpl;


@WebServlet("/editPwd")
public class EditPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public EditPwdServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		       //解决参数中⽂乱码问题 
				request.setCharacterEncoding("utf-8"); 
				String pwd=request.getParameter("pwd");
				AdminBiz adminBiz=new AdminBizimpl();
				Boolean ret=adminBiz.editpwd(pwd);
				if (ret) {
					request.setAttribute("msg", "修改成功");
					response.sendRedirect("main.jsp");
				} else {
		        request.setAttribute("msg","修改失败" );
		       request.getRequestDispatcher("main.jsp");
				}
				
	}

}
